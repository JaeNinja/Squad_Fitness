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
    String typeOfExercises = "";
    String equipmentNeeded = " AND equipmentNeeded=0";
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
    private CheckBox chkStretch;
    @FXML
    private CheckBox chkBulk;
    @FXML
    private CheckBox chkCooldown;
    @FXML
    private CheckBox chkEquipment;
    @FXML
    private ImageView imgAbs;
    @FXML
    private ImageView imgBack;
    @FXML
    private ImageView imgBiceps;
    @FXML
    private ImageView imgCalves;
    @FXML
    private ImageView imgChest;
    @FXML
    private ImageView imgForearms;
    @FXML
    private ImageView imgGlutes;
    @FXML
    private ImageView imgNeck;
    @FXML
    private ImageView imgObliques;
    @FXML
    private ImageView imgShoulders;
    @FXML
    private ImageView imgThighs;
    @FXML
    private ImageView imgTriceps;

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
        if(chkNeck.isSelected())
        {
            listOfExercise.add(1);
        }

        if(chkBiceps.isSelected())
        {
            listOfExercise.add(2);
        }

        if(chkTriceps.isSelected())
        {
            listOfExercise.add(3);
        }

        if(chkChest.isSelected())
        {
            listOfExercise.add(4);
        }

        if(chkBack.isSelected())
        {
            listOfExercise.add(5);
        }

        if(chkAbs.isSelected())
        {
            listOfExercise.add(6);
        }

        if(chkObliques.isSelected())
        {
            listOfExercise.add(7);
        }

        if(chkHamstrings.isSelected())
        {
            listOfExercise.add(8);
        }

        if(chkThighs.isSelected())
        {
            listOfExercise.add(9);
        }

        if(chkCalves.isSelected())
        {
            listOfExercise.add(10);
        }

        if(chkGlutes.isSelected())
        {
            listOfExercise.add(11);
        }

        if(chkForearms.isSelected())
        {
            listOfExercise.add(12);
        }

        if(chkShoulders.isSelected())
        {
            listOfExercise.add(13);
        }

        if (listOfExercise.size() == 0) {
            exerciseArray = new int[1];
            exerciseArray[0] = 999;
        }

        else {

            for (int i = 0; i < listOfExercise.size(); i++) {
                strListOfExerciseNames += listOfExercise.get(i) + " OR bodyPart = ";
            }
            strListOfExerciseNames = strListOfExerciseNames.substring(0, strListOfExerciseNames.length() - 14);
            /**
             * Fancy db stored procedures. Insert into database
             */
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                Statement state = connection.createStatement();
                String sqlQuery = "SELECT exerciseID FROM exercise WHERE bodyPart=" + strListOfExerciseNames + typeOfExercises + equipmentNeeded;
                rsExerciseIDs = state.executeQuery(sqlQuery);
                /**
                 * Result set returns 1 column but multiple rows... Iterate through those rows and add each exerciseID to
                 * the array list.
                 */
                if (!rsExerciseIDs.next()) {
                    exerciseArray = new int[1];
                    exerciseArray[0] = 999;
                }
                else {
                    rsExerciseIDs.previous();

                    while (rsExerciseIDs.next()) {
                        int exerciseID = rsExerciseIDs.getInt(1);
                        listExerciseIDs.add(exerciseID);
                    }


                    exerciseArray = new int[listExerciseIDs.size()];

                    for (int i = 0; i < listExerciseIDs.size(); i++) {
                        exerciseArray[i] = listExerciseIDs.get(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();

            }

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
        if(chkNeck.isSelected())
        {
            imgNeck.setVisible(true);
        }
        else
        {
            imgNeck.setVisible(false);
        }

        if(chkBiceps.isSelected())
        {
            imgBiceps.setVisible(true);
        }
        else
        {
            imgBiceps.setVisible(false);
        }

        if(chkTriceps.isSelected())
        {
            imgTriceps.setVisible(true);
        }
        else
        {
            imgTriceps.setVisible(false);
        }

        if(chkChest.isSelected())
        {
            imgChest.setVisible(true);
        }
        else
        {
            imgChest.setVisible(false);
        }

        if(chkBack.isSelected())
        {
            imgBack.setVisible(true);
        }
        else
        {
            imgBack.setVisible(false);
        }

        if(chkAbs.isSelected())
        {
            imgAbs.setVisible(true);
        }
        else
        {
            imgAbs.setVisible(false);
        }

        if(chkObliques.isSelected())
        {
            imgObliques.setVisible(true);
        }
        else
        {
            imgObliques.setVisible(false);
        }

        if(chkThighs.isSelected())
        {
            imgThighs.setVisible(true);
        }
        else
        {
            imgThighs.setVisible(false);
        }

        if(chkCalves.isSelected() || chkHamstrings.isSelected())
        {
            imgCalves.setVisible(true);
        }
        else
        {
            imgCalves.setVisible(false);
        }

        if(chkGlutes.isSelected())
        {
            imgGlutes.setVisible(true);
        }
        else
        {
            imgGlutes.setVisible(false);
        }

        if(chkForearms.isSelected())
        {
            imgForearms.setVisible(true);
        }
        else
        {
            imgForearms.setVisible(false);
        }

        if(chkShoulders.isSelected())
        {
            imgShoulders.setVisible(true);
        }
        else
        {
            imgShoulders.setVisible(false);
        }
    }

    public void typeOfWorkout() {
        String stretch, bulk, cooldown;
        int intStretch, intBulk, intCooldown;
        int sum = 0;
        int current = 0;
        String[] types = new String[3];
        String or = " OR ";
        if (chkStretch.isSelected())
        {
            stretch = "type='Stretch'";
            intStretch = 1;
        }
        else
        {
            stretch = "";
            intStretch = 0;
        }
        if (chkBulk.isSelected())
        {
            bulk = "type='Bulk'";
            intBulk = 1;
        }
        else
        {
            bulk = "";
            intBulk = 0;
        }
        if (chkCooldown.isSelected())
        {
            cooldown = "type='Cooldown'";
            intCooldown = 1;
        }
        else
        {
            cooldown = "";
            intCooldown = 0;
        }
        sum = intStretch + intBulk + intCooldown;
        if (sum > 0)
        {
            if (intStretch == 1)
            {
                types[current] = stretch;
                current += 1;
            }
            if (intBulk == 1)
            {
                types[current] = bulk;
                current += 1;
            }
            if (intCooldown == 1)
            {
                types[current] = cooldown;
            }
            typeOfExercises = " AND (";
            current = 0;
            do {
                typeOfExercises += types[current];
                typeOfExercises += " OR ";
                current += 1;
            } while (current < sum);
            typeOfExercises = typeOfExercises.substring(0, typeOfExercises.length()-4);
            typeOfExercises += ")";
        }
        else
        {
            typeOfExercises = "";
        }
    }

    public void equipment() {
        if (chkEquipment.isSelected())
            equipmentNeeded = "";
        else
            equipmentNeeded = " AND equipmentNeeded=0";
    }
}
