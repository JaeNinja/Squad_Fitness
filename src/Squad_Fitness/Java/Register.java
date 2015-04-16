package Squad_Fitness.Java;
import java.net.URL;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.prefs.Preferences;

/**
 * Created by Kyle on 3/26/2015.
 */
public class Register extends Application implements Initializable {
    Scene registerScene;
    static Stage window;
    Connection connection;
    String strUserName, strPassword, strPassword2, strName, strGender, strEmail;
    int weight, height, age;
    int dbResponse = -1;
    Random intUserID = new Random();
    int userID;
    ResultSet checkUserID;
    Preferences pref;

    @FXML
    private TextField tfWeight;
    @FXML
    private TextField tfHeight;
    @FXML
    private PasswordField pfPassword1;
    @FXML
    private PasswordField pfPassword2;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfName;
    @FXML
    private ChoiceBox<?> ddSex;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfAge;
    @FXML
    private Label lbInvalidAge;
    @FXML
    private Label lbInvalidPassword;
    @FXML
    private Label lbInvalidWeight;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userID = intUserID.nextInt(999999999);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/Register.fxml"));
        registerScene = new Scene(root, 1000, 850);
        window.setScene(registerScene);
        window.setTitle("Enter Information");
        window.show();
    }

    public void goToMyProfile() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        lbInvalidAge.setVisible(false);
        lbInvalidPassword.setVisible(false);
        lbInvalidWeight.setVisible(false);
        /*
         * Logic to make sure there are no blank fields
         */
        if(tfUsername.getText().equals("") || pfPassword1.getText().equals("") || pfPassword2.getText().equals("") ||tfName.getText().equals("") ||
                tfEmail.getText().equals("") || ddSex.getValue().toString().equals("") || tfAge.getText().equals("")
                || tfWeight.getText().equals("")|| tfHeight.getText().equals(""))
        {
            if(tfUsername.getText().equals("")) {
                tfUsername.setStyle("  -fx-control-inner-background: red");
            }
            if(pfPassword1.getText().equals("")){
                pfPassword1.setStyle("  -fx-control-inner-background: red");
            }
            if(tfName.getText().equals("")){
                tfName.setStyle("  -fx-control-inner-background: red");
            }
            if (tfEmail.getText().equals("")) {
                tfEmail.setStyle("  -fx-control-inner-background: red");
            }
            if (ddSex.getValue().toString().equals("")){
                ddSex.setStyle("  -fx-control-inner-background: red");
            }
            if (tfAge.getText().equals("")){
                tfAge.setStyle("  -fx-control-inner-background: red");
            }
            if(tfWeight.getText().equals("")){
                tfWeight.setStyle("  -fx-control-inner-background: red");
            }
            if(tfHeight.getText().equals("")){
                tfHeight.setStyle("  -fx-control-inner-background: red");
            }
        }
        else {
            strUserName = tfUsername.getText();
            strPassword = pfPassword1.getText();
            strPassword2 = pfPassword2.getText();
            strName = tfName.getText();
            strEmail = tfEmail.getText();
            strGender = ddSex.getValue().toString();
            age = Integer.parseInt(tfAge.getText());
            weight = Integer.parseInt(tfWeight.getText());
            height = Integer.parseInt(tfHeight.getText());

        }
        if(strPassword.equals(strPassword2))
        {
            if(age <= 100 && age > 0)
            {
                if(weight > 60 && weight < 725)
                {
                    try {
                        pref = Preferences.systemNodeForPackage(this.getClass());
                        /**
                         * Fancy db stored procedures. Insert into database and what not
                         */
                        Class.forName("com.mysql.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                        Statement state = connection.createStatement();

                        //checks to see if random userID is already in use, if it is a new number is generated
                        checkUserID = state.executeQuery("SELECT * FROM user WHERE userID='" + userID + "'");
                        while (checkUserID.last()) {
                            userID = intUserID.nextInt(999999999);
                            checkUserID = state.executeQuery("SELECT * FROM user WHERE userID='" + userID + "'");
                        }
                        //Save the UserID so that we can skip log in screen next time
                        pref.putInt("UserID", userID);
                        dbResponse = state.executeUpdate("INSERT INTO user (userID, username, password, name, age, sex, weight, height, email, rememberMe) VALUES ('" + userID + "', '" + strUserName + "', '"
                                + strPassword + "', '" + strName + "', " + age + ", '" + strGender + "', "
                                + weight + ", " + height + ", '" + strEmail + "', " + false +  ");");
                    } catch (Exception x)
                    {
                        System.out.println("Error: " + x);
                    }
                    User currentUser = new User(strUserName, strPassword, userID, strName, age, strGender, weight, height, strEmail, false);
                    User.setUser(currentUser);
                    /**
                     * A response of 1 means that 1 successful row was added to the database
                     */
                    if(dbResponse > 0 ) {
                        try {
                            new MyProfile().start(window);
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        try {
                            if (connection != null)
                            {
                                connection.close();
                                System.out.println("Connection closed");
                            }

                        } catch (Exception e) {
                            System.out.println("Error - Unable to close connection: " + e);
                        }
                    }
                } else {
                    lbInvalidWeight.setVisible(true);
                }
            } else {
                lbInvalidAge.setVisible(true);

            }

        }
        else
        {
            lbInvalidPassword.setVisible(true);
        }


    }

    public void goBack() {
        try {
            new LoginScreen().start(window);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}