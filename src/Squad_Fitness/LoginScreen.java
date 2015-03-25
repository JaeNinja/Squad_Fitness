package Squad_Fitness;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Created by Kyle on 3/24/2015.
 */
public class LoginScreen extends Application {
    Scene loginScene;

    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/loginScreen.fxml"));
        loginScene = new Scene(root, 1000, 850);
        // primaryStage.setScene(loginScene);
        //primaryStage.setTitle("Enter Login Information");
        //primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
