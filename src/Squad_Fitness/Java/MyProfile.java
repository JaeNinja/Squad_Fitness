package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by Kyle on 3/26/2015.
 */
public class MyProfile extends Application {
    Scene loginScene;
    static Stage window;
    User currentUser;

    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/My_Profile.fxml"));
        loginScene = new Scene(root, 1000, 850);
        window.setScene(loginScene);
        window.setTitle("Get Swole");
        window.show();
        //Get login screen so that we have access to the user.
        LoginScreen screen = new LoginScreen();
        currentUser = screen.getUser();
        System.out.print(currentUser.FullName);

    }

    public void goToRegistration()
    {
        System.out.println("It's connected");

       /* btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    new Register().start(window);
                } catch (Exception e) {}

            }
        });
        */
        try{
            new Register().start(window);
        } catch (Exception e) {}
    }

    public void goToMyProfile()
    {
        System.out.println("It's connected");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
