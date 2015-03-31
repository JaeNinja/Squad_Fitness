package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Kyle on 3/26/2015.
 */
public class Register extends Application {
    Scene registerScene;
    static Stage window;
    static User objUser;

    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/Register.fxml"));
        registerScene = new Scene(root, 1000, 850);
        window.setScene(registerScene);
        window.setTitle("Enter Information");
        window.show();

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
