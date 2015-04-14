package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Jonathan Blair on 4/14/2015.
 */
public class BodyMap extends Application {
    Scene bodyMapScene;
    static Stage window;
    User currentUser;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/Body_part.fxml"));
        bodyMapScene = new Scene(root, 1000, 850);
        window.setScene(bodyMapScene);
        window.setTitle("Interactive Body Map");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
