package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * Created by Kyle on 3/26/2015.
 */
    public class MyProfile extends Application implements Initializable {

    Scene loginScene;
    static Stage window;
    User currentUser = new User();

    @FXML
    private TextField tfUsername, tfName, tfAge, tfWeight, tfSex, tfEmail;
    @FXML
    private ImageView imgProfile;
    @FXML
    private Button btnChangeProfile;

    public void initialize(java.net.URL location, java.util.ResourceBundle resources)
    {
        if(currentUser.getRememberMeFromPreferences())
        {
            currentUser = currentUser.getUserFromPreferences(currentUser);
        } else {
            currentUser = MyProfile.getCurrentUser();
        }
        //Image img = new Image("/Squad_Fitness/CSS/workout.jpg");
        //imgProfile.
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

        User testUser = new User();
        testUser = testUser.getUserFromPreferences(testUser);
        System.out.print(testUser.getName());
    }

    public static User getCurrentUser() {
        return User.currentUser;
    }

    public void goToRegistration() {
        System.out.println("It's connected");
        try{
            new Register().start(window);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void logout() {
        try {
            new LoginScreen().start(window);
        } catch (Exception ignored) {}
        User.clearUser();
        currentUser.clearRememberMeFromPreferences();
    }

    public void changeProfilePicture() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        //fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(window);
        System.out.print(file.getAbsolutePath());
        imgProfile.setImage(new Image(file.toURI().toString()));

    }

    public void goToMyProfile() {
        System.out.println("It's connected");
    }

    public void goToBodyMap() {
        try {
            new BodyMap().start(window);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
