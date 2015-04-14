package Squad_Fitness.Java;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Skin;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 * Created by Kyle on 3/26/2015.
 */
public class Register extends Application implements Initializable {
    Scene registerScene;
    static Stage window;
    Connection connection;
    String strUserName, strPassword, strName, strGender, strEmail;
    int weight, age;
    int dbResponse = -1;
    Random intUserID = new Random();
    int userID;

    @FXML
    private TextField tfWeight;
    @FXML
    private TextField tfPassword;
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
    {   /*
         * Logic to make sure there are no blank fields
         */
        lbInvalidAge.setVisible(false);
        if(tfUsername.getText().equals("") || tfPassword.getText().equals("") || tfName.getText().equals("") ||
                tfEmail.getText().equals("") || ddSex.getValue().toString().equals("") || tfAge.getText().equals("")
                || tfWeight.getText().equals(""))
        {
            Skin<?> red=null;
            if(tfUsername.getText().equals("")) {
                tfUsername.setStyle("-fx-text-box-border: red ;");
            }
            if(tfPassword.getText().equals("")){
                tfPassword.setStyle("-fx-text-box-border: red ;");
            }
            if(tfName.getText().equals("")){
                tfName.setStyle("-fx-text-box-border: red ;");
            }
            if (tfEmail.getText().equals("")) {
                tfEmail.setStyle("-fx-text-box-border: red ;");
            }
            if (ddSex.getValue().toString().equals("")){
                ddSex.setStyle("-fx-text-box-border: red ;");
            }
            if (tfAge.getText().equals("")){
                tfAge.setStyle(" -fx-text-box-border: red ;");
            }
            if(tfWeight.getText().equals("")){
                tfWeight.setStyle("-fx-text-box-border: red ;");
            }
        }
        else{
            strUserName = tfUsername.getText();
            strPassword = tfPassword.getText();
            strName = tfName.getText();
            strEmail = tfEmail.getText();
            strGender = ddSex.getValue().toString();
            age = Integer.parseInt(tfAge.getText());
            weight = Integer.parseInt(tfWeight.getText());

            if(age <= 100)
            {
                try
                {
                    /**
                     * Fancy db stored procedures. Insert into database
                     */
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                    Statement state = connection.createStatement();
                    dbResponse = state.executeUpdate("INSERT INTO user (userID, username, password, name, age, sex, weight, email) VALUES ('" + userID + "', '" + strUserName + "', '"
                            + strPassword + "', '" + strName + "', " + age + ", '" + strGender + "', "
                            + weight + ", '" + strEmail + "');");
                } catch (Exception x)
                {
                    System.out.println("Error: " + x);
                }
                User currentUser = new User(strUserName, strPassword, userID, strName, age, strGender, weight, strEmail);
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
                    lbInvalidAge.setVisible(true);
            }


        }

    }

    public static void main(String[] args) {
        launch(args);
    }


}