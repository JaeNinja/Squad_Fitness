package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Kyle on 3/26/2015.
 */
    public class MyProfile extends Application implements Initializable {

    Scene loginScene;
    static Stage window;
    User currentUser;

    @FXML
    private TextField tfUsername, tfName, tfAge, tfWeight, tfSex, tfEmail;

    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        currentUser = MyProfile.getCurrentUser();
        tfUsername.setText(currentUser.getUsername());
        tfName.setText(currentUser.getName());
        tfAge.setText(Integer.toString(currentUser.getAge()));
        tfSex.setText(currentUser.getSex());
        tfWeight.setText(Integer.toString(currentUser.getWeight()));
        tfEmail.setText(currentUser.getEmail());
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/My_Profile.fxml"));
        loginScene = new Scene(root, 1000, 850);
        window.setScene(loginScene);
        window.setTitle("Get swole!");
        window.show();
    }

    public static User getCurrentUser() {
        return User.currentUser;
    }

    public void goToRegistration() {
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
        } catch (Exception ignored) {}
    }

    public void logout() {
        try {
            new LoginScreen().start(window);
        } catch (Exception ignored) {}
        User.clearUser();
    }

    public void goToMyProfile() {
        System.out.println("It's connected");
    }
    public static void main(String[] args) {
        launch(args);
    }

}
