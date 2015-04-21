package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan Blair on 4/14/2015.
 */
public class BodyMap extends Application {
    Scene bodyMapScene;
    static Stage window;
    User currentUser;
    Connection connection;
    ResultSet rsExerciseIDs;
    ArrayList<Integer> listExerciseIDs = new ArrayList<>();
    String strListOfExerciseNames ="";
    static int[] exerciseArray;

    @FXML
    private Button btnNext;

    @FXML
    private CheckBox chkObliques;
    @FXML
    private CheckBox chkHamstrings;
    @FXML
    private CheckBox chkGlutes;
    @FXML
    private CheckBox chkChest;
    @FXML
    private CheckBox chkBack;
    @FXML
    private CheckBox chkNeck;
    @FXML
    private CheckBox chkThighs;
    @FXML
    private CheckBox chkTriceps;
    @FXML
    private CheckBox chkBiceps;
    @FXML
    private CheckBox chkForearms;
    @FXML
    private CheckBox chkAbs;
    @FXML
    private CheckBox chkCalves;
    @FXML
    private CheckBox chkShoulders;
    @FXML
    private ImageView imgAbs, imgBack, imgBiceps, imgCalves, imgChest, imgForearms, imgGlutes, imgNeck, imgObliques, imgShoulders, imgThighs, imgTriceps;


    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/Body_part.fxml"));
        bodyMapScene = new Scene(root, 1000, 850);
        window.setScene(bodyMapScene);
        window.setTitle("Interactive Body Map");
        window.show();
        currentUser = User.getUser();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public void goToWorkOut()
    {
        List<Integer> listOfExercise = new ArrayList<>();
        if(chkNeck.isSelected()) {
            listOfExercise.add(1);
        }

        if(chkBiceps.isSelected()) {
            listOfExercise.add(2);
        }

        if(chkTriceps.isSelected()) {
            listOfExercise.add(3);
        }

        if(chkChest.isSelected()) {
            listOfExercise.add(4);
        }

        if(chkBack.isSelected()) {
            listOfExercise.add(5);
        }

        if(chkAbs.isSelected()) {
            listOfExercise.add(6);
        }

        if(chkObliques.isSelected()) {
            listOfExercise.add(7);
        }

        if(chkHamstrings.isSelected()) {
            listOfExercise.add(8);
        }

        if(chkThighs.isSelected()) {
            listOfExercise.add(9);
        }

        if(chkCalves.isSelected()) {
            listOfExercise.add(10);
        }

        if(chkGlutes.isSelected()) {
            listOfExercise.add(11);
        }

        if(chkForearms.isSelected()) {
            listOfExercise.add(12);
        }

        if(chkShoulders.isSelected()) {
            listOfExercise.add(13);
        }

        for(int i= 0; i < listOfExercise.size(); i ++)
        {
            strListOfExerciseNames += listOfExercise.get(i) + " OR bodyPart = ";
        }
        strListOfExerciseNames = strListOfExerciseNames.substring(0, strListOfExerciseNames.length()-14);
            /**
             * Fancy db stored procedures. Insert into database
             */
           try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                Statement state = connection.createStatement();
                String sqlQuery = "SELECT exerciseID FROM exercise WHERE bodyPart=" + strListOfExerciseNames;
                rsExerciseIDs = state.executeQuery(sqlQuery);
               /**
                * Result set returns 1 column but multiple rows... Iterate through those rows and add each exerciseID to
                * the array list.
                 */
               while(rsExerciseIDs.next())
               {
                   int exerciseID = rsExerciseIDs.getInt(1);
                   listExerciseIDs.add(exerciseID);
               }

               exerciseArray = new int[listExerciseIDs.size()];

               for(int i= 0; i < listExerciseIDs.size(); i ++)
               {
                   exerciseArray[i] = listExerciseIDs.get(i);
               }
            } catch (Exception e) {
                e.printStackTrace();

            }


        try {
            new Workout().start(window);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void goBack() {
        try {
            new MyProfile().start(window);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void logout() {
        try {
            new LoginScreen().start(window);
        } catch (Exception ignored) {}
        User.clearUser();
        if(!currentUser.getName().equals("") || !currentUser.getName().isEmpty() )
            currentUser.clearRememberMeFromPreferences();
    }

    public void swapVisible() {
        if(chkNeck.isSelected()) {
            imgNeck.setVisible(true);
        }
        else imgNeck.setVisible(false);

        if(chkBiceps.isSelected()) {
            imgBiceps.setVisible(true);
        }
        else imgBiceps.setVisible(false);

        if(chkTriceps.isSelected()) {
            imgTriceps.setVisible(true);
        }
        else imgTriceps.setVisible(false);

        if(chkChest.isSelected()) {
            imgChest.setVisible(true);
        }
        else imgChest.setVisible(false);

        if(chkBack.isSelected()) {
            imgBack.setVisible(true);
        }
        else imgBack.setVisible(false);

        if(chkAbs.isSelected()) {
            imgAbs.setVisible(true);
        }
        else imgAbs.setVisible(false);

        if(chkObliques.isSelected()) {
            imgObliques.setVisible(true);
        }
        else imgObliques.setVisible(false);

        if(chkThighs.isSelected()) {
            imgThighs.setVisible(true);
        }
        else imgThighs.setVisible(false);

        if(chkCalves.isSelected() || chkHamstrings.isSelected()) {
            imgCalves.setVisible(true);
        }
        else imgCalves.setVisible(false);

        if(chkGlutes.isSelected()) {
            imgGlutes.setVisible(true);
        }
        else imgGlutes.setVisible(false);

        if(chkForearms.isSelected()) {
            imgForearms.setVisible(true);
        }
        else imgForearms.setVisible(false);

        if(chkShoulders.isSelected()) {
            imgShoulders.setVisible(true);
        }
        else imgShoulders.setVisible(false);
    }
}
