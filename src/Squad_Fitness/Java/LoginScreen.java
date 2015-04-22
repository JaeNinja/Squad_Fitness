package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.*;
import java.text.DateFormat;
import java.util.Calendar;

/*
 * Created by Kyle on 3/24/2015.
 * Kyle hold deez nuts
 */

public class LoginScreen extends Application  implements Initializable {
    Scene loginScene;
    static Stage window;
    String strUserName = "";
    String strPassword = "";
    int dbResponse = -1;
    Connection connection;
    ResultSet loginDatabaseResponse;
    User currentUser;
    String jsonUser;


    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label laInvalid;
    @FXML
    private Label laConnection;
    @FXML
    private Label lbClock;
    @FXML
    private ProgressIndicator loading;
    @FXML
    private CheckBox chkRememberMe;


    public void initialize(java.net.URL location, java.util.ResourceBundle resources)
    {
        DateFormat format = DateFormat.getInstance();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Calendar cal = Calendar.getInstance();
                lbClock.setText(format.format(cal.getTime()));
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/loginScreen.fxml"));
        loginScene = new Scene(root, 1000, 850);
        window.setScene(loginScene);
        window.setTitle("Enter Login Information");
        window.show();

    }


    public void goToRegistration() {
        loading.setVisible(true);
            try{
                new Register().start(window);
            } catch (Exception e) {}
    }

    public void goToMyProfile() throws SQLException {

        loading.setVisible(true);
        Boolean rememberMe = chkRememberMe.isSelected();

        if(tfUserName.getText().equals("") || tfPassword.getText().equals(""))
        {
            /**
             * No Blank textfields
             */
            System.out.println("No blank fields allowed");
            loading.setVisible(false);
        }
        else
        {
            strUserName = tfUserName.getText();
            strPassword = tfPassword.getText();
            try
            {
                /**
                 * Fancy db stored procedures. Insert into database
                 */
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                } catch (Exception e) {
                    e.printStackTrace();
                    laInvalid.setVisible(false);
                    loading.setVisible(false);
                    laConnection.setVisible(true);
                }
                Statement state = connection.createStatement();
                loginDatabaseResponse = state.executeQuery("SELECT * FROM user WHERE username='" + strUserName + "'AND password='" + strPassword + "'");
            } catch (Exception x)
            {
                System.out.println("Error 1: " + x);
                loading.setVisible(false);
            }
            if (loginDatabaseResponse.next()) {
                currentUser = new User(loginDatabaseResponse.getString("username"),
                        loginDatabaseResponse.getString("password"),
                        loginDatabaseResponse.getInt("userID"),
                        loginDatabaseResponse.getString("name"),
                        loginDatabaseResponse.getInt("age"),
                        loginDatabaseResponse.getString("sex"),
                        loginDatabaseResponse.getInt("weight"),
                        loginDatabaseResponse.getInt("height"),
                        loginDatabaseResponse.getString("email"), rememberMe);
                LoginScreen.setCurrentUser(currentUser);
                if(rememberMe)
                {
                    currentUser.putUserInPreferences(currentUser);
                } else {
                    try{
                        currentUser.clearUserPreferences(currentUser);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                try{
                    new MyProfile().start(window);
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
            else {
                System.out.println("Invalid username or password");
                laConnection.setVisible(false);
                loading.setVisible(false);
                laInvalid.setVisible(true);
            }
        }
    }

    public static void setCurrentUser(User user) {
        User.setUser(user);
    }

    public static void main(String[] args) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();

        launch(args);
    }
}
