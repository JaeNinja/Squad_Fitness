package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    String strListOfExerciseNames ="";

    @FXML
    private Button btnNext;

    @FXML
    private CheckBox chkObliques;
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


    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/Squad_Fitness/FXML/Body_part.fxml"));
        bodyMapScene = new Scene(root, 1000, 850);
        window.setScene(bodyMapScene);
        window.setTitle("Interactive Body Map");
        window.show();
        currentUser = MyProfile.getCurrentUser();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public void goToWorkOut()
    {
        List<Integer> listOfExercise = new ArrayList<>();
        if(chkNeck.isSelected())
            listOfExercise.add(1);
        if(chkBiceps.isSelected())
            listOfExercise.add(2);
        if(chkTriceps.isSelected())
            listOfExercise.add(3);
        if(chkChest.isSelected())
            listOfExercise.add(4);
        if(chkBack.isSelected())
            listOfExercise.add(5);
        if(chkAbs.isSelected())
            listOfExercise.add(6);
        if(chkObliques.isSelected())
            listOfExercise.add(7);
        //Missing Hamstrings
        if(chkThighs.isSelected())
            listOfExercise.add(9);
        if(chkCalves.isSelected())
            listOfExercise.add(10);
        if(chkGlutes.isSelected())
            listOfExercise.add(11);
        if(chkForearms.isSelected())
            listOfExercise.add(12);
        /*
        if(chkShoulders.isSelected())
            listOfExercise.add(chkShoulders.getText());
            */
        for(int i= 0; i < listOfExercise.size(); i ++)
        {
            strListOfExerciseNames += listOfExercise.get(i) + " OR ";
        }
        strListOfExerciseNames = strListOfExerciseNames.substring(0, strListOfExerciseNames.length()-4);
        System.out.print(strListOfExerciseNames);

            /**
             * Fancy db stored procedures. Insert into database
             */
           try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                Statement state = connection.createStatement();
                String sqlQuery = "SELECT exerciseID FROM exercise WHERE bodyPart=" + strListOfExerciseNames;
                rsExerciseIDs = state.executeQuery(sqlQuery);

               if(rsExerciseIDs.next())
               {
                   rsExerciseIDs.getArray(1);
                   System.out.print("\n" + rsExerciseIDs.getInt(1));
                   System.out.print("\n" + rsExerciseIDs.getInt(2));

               }
            } catch (Exception e) {
                e.printStackTrace();

            }

        /*try {
            new Workout().start(window);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }*/
    }



}
