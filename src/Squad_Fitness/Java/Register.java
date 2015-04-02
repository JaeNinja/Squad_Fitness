package Squad_Fitness.Java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.activation.DataSource;

/**
 * Created by Kyle on 3/26/2015.
 */
public class Register extends Application {
    Scene registerScene;
    static Stage window;
    static User objUser;
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

    public void goToMyProfile() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        try {
            new MyProfile().start(window);
        } catch (Exception e) {
        }
        System.out.println("It's connected");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DataSource data;
            Connection user = data.getConnection("jdbc:mysql://localhost:3306/SQUAD", "root", "root");
            Statement state = user.createStatement();
            state.executeUpdate("INSERT INTO user (username, password, name, age, sex, weight, email) VALUES (" + tfUsername + ", " + tfPassword + ", " + tfName + ", " + tfAge + ", " + ddSex + ", " + tfWeight + ", " + tfEmail + ");");
        } catch (Exception x) {
            System.out.println("Error: " + x);
        }
    }

    public void newUser() throws SQLException
    {
        Connection user = DriverManager.getConnection("jdbc:mysql://localhost:3306/SQUAD", "root", "root");
        Statement state = user.createStatement();
        int execute = state.executeUpdate("INSERT INTO user (username, password, name, age, sex, weight, email) VALUES (" + tfUsername + ", x, x, x, x, x, x);");

    }

    public static void main(String[] args) {
        launch(args);
    }
}