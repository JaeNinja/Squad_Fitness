package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

/*
 * Created by Kyle on 3/24/2015.
 * Kyle hold deez nuts
 */

public class LoginScreen extends Application {
    Scene loginScene;
    static Stage window;
    String strUserName, strPassword;
    int dbResponse = -1;
    Connection connection;
    ResultSet login;
    User currentUser;

    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btnLogin;


    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/loginScreen.fxml"));
        loginScene = new Scene(root, 1000, 850);
        window.setScene(loginScene);
        window.setTitle("Enter Login Information");
        window.show();

    }

    public void goToRegistration()
    {
            try{
                new Register().start(window);
            } catch (Exception e) {}
    }

    public void goToMyProfile() throws SQLException {

        if(tfUserName.getText().equals("") || tfPassword.getText().equals(""))
        {
            /**
             * Make error messages pop up here
             */
            System.out.println("No blank fields allowed");
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
                connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                Statement state = connection.createStatement();
                login = state.executeQuery("SELECT * FROM user where username='" + strUserName + "'AND password='" + strPassword + "'");
            } catch (Exception x)
            {
                System.out.println("Error 1: " + x);
            }
            if (login.next()) {
                currentUser = new User(login.getString("username"), login.getString("password"), login.getInt("userID"), login.getString("name"), login.getInt("age"), login.getString("sex"), login.getInt("weight"), login.getString("email"));
                LoginScreen.setCurrentUser(currentUser);
                try{
                    new MyProfile().start(window);
                } catch (Exception ignored) {}
            }
            else
                System.out.println("Invalid username or password.");
        }
    }

    public static void setCurrentUser(User user) {
        User.setUser(user);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
