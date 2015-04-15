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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

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
        private int currentExercise = 1001;
        private int ID;
        int dbResponse = -1;
        Connection connection;
        ResultSet workout, bodyPartName;

        @FXML
        private TextArea description, tips;
        @FXML
        private Label bodyPart, exerciseType, equipmentNeeded;
        @FXML
        private Text workoutName;


        public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
            //currentUser = User.getUser();
            //currentExercise = BodyPart.getCurrentExercise();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                } catch (Exception e) {
                    System.out.println("Exception 1 " + e);
                }
                Statement state1 = connection.createStatement();
                Statement state2 = connection.createStatement();
                workout = state1.executeQuery("SELECT * FROM exercise WHERE exerciseID=" + currentExercise);
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

        public void start(Stage primaryStage) throws Exception {
            window = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/Workout.fxml"));
            workoutScene = new Scene(root, 1000, 850);
            window.setScene(workoutScene);
            window.setTitle("Put in work!");
            window.show();

        }

}
