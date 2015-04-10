package Squad_Fitness.Java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
 * Created by Kyle on 3/24/2015.
 * Kyle hold deez nuts
 */

public class LoginScreen extends Application {
    Scene loginScene;
    static Stage window;


    Button btnRegister;
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
        System.out.println("It's connected");

        try{
            new Register().start(window);
        } catch (Exception e) {}
    }

    public void goToMyProfile()
    {
        try{
            new MyProfile().start(window);
        } catch (Exception e) {}
        System.out.println("It's connected");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
