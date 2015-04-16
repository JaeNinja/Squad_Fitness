package Squad_Fitness.Java;

import Squad_Fitness.Model.BodyPart;
import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by Jonathan Blair on 4/15/2015.
 */
public class Workout extends Application implements Initializable {

        Scene workoutScene;
        static Stage window;
        User currentUser = new User();
        private int currentExercise, array, max;
        private int[] currentExercises;
        private int ID;
        int dbResponse = -1;
        Connection connection;
        ResultSet workout, bodyPartName;
        private Image img;
        private String path;


        @FXML
        private TextArea description, tips;
        @FXML
        private Label bodyPart, exerciseType, equipmentNeeded;
        @FXML
        private Text workoutName;
        @FXML
        private ImageView workoutImage;


        public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
            currentUser = User.getUser();
            currentExercises = BodyMap.exerciseArray;
            array = 0;
            currentExercise = currentExercises[array];
            max = currentExercises.length;
            newExercise();
        }

        public void start(Stage primaryStage) throws Exception {
            window = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/Workout.fxml"));
            workoutScene = new Scene(root, 1000, 850);
            window.setScene(workoutScene);
            window.setTitle("Put in work!");
            window.show();

        }

        public void previousExercise() {
            if (array == 0) {
                array = max-1;
            } else {
                array -= 1;
            }
            newExercise();
        }

        public void nextExercise() {
            if (array == max-1) {
                array = 0;
            } else {
                array += 1;
            }
            newExercise();
        }

        public void newExercise() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                } catch (Exception e) {
                    System.out.println("Exception 1 " + e);
                }
                Statement state1 = connection.createStatement();
                Statement state2 = connection.createStatement();
                workout = state1.executeQuery("SELECT * FROM exercise WHERE exerciseID=" + currentExercises[array]);
                if (workout.next()) {
                    ID = workout.getInt("bodyPart");
                }
                bodyPartName = state2.executeQuery("SELECT name FROM bodyPart WHERE bodyPartID=" + ID);
            } catch (Exception e) {
                System.out.println("Exception 2 " + e);
            }
            try {
                workoutName.setText(workout.getString("exerciseName"));
                exerciseType.setText(workout.getString("type"));
                description.setText(workout.getString("description"));
                tips.setText(workout.getString("tips"));
                path = workout.getString("imageURL");
                img = new Image(path);
                workoutImage.setImage(img);
                if (workout.getBoolean("equipmentNeeded")) {
                    equipmentNeeded.setText("Yes");
                } else {
                    equipmentNeeded.setText("No");
                }
                if (bodyPartName.next()) {
                    bodyPart.setText(bodyPartName.getString("name"));
                }
            } catch (SQLException e) {
                System.out.println("Exception 3 " + e);
            }
        }

        public void goBack() {
            try {
                new BodyMap().start(window);
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

}
