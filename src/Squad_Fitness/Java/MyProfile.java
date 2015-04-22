package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Calendar;


/**
 * Created by Kyle on 3/26/2015.
 */
    public class MyProfile extends Application implements Initializable {

    Scene loginScene;
    static Stage window;
    User currentUser = new User();
    Connection connection;
    int dbResponse = -1;
    String newWeight = "";
    String newMiles = "";
    String newPress = "";

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfWeight;
    @FXML
    private TextField tfHeight;
    @FXML
    private TextField tfSex;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfBMI;
    @FXML
    private TextField tfMaxPress;
    @FXML
    private TextField tfTargetWeight;
    @FXML
    private TextField tfMileTime;
    @FXML
    private PasswordField pfPassword1;
    @FXML
    private PasswordField pfPassword2;
    @FXML
    private Label lbSaveError;
    @FXML
    private Label lbPassword1;
    @FXML
    private Label lbPassword2;
    @FXML
    private Label lbClock;
    @FXML
    private Label lbClock2;
    @FXML
    private Label lbClock3;
    @FXML
    private ImageView imgProfile;
    @FXML
    private ImageView imgBMIChart;
    @FXML
    private Button btnChangeProfile;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnUpdateGoals;
    @FXML
    private Button btnSaveGoals;

    public void initialize(java.net.URL location, java.util.ResourceBundle resources)
    {
        if(currentUser.getRememberMeFromPreferences())
        {
            currentUser = currentUser.getUserFromPreferences(currentUser);
        } else {
            currentUser = MyProfile.getCurrentUser();
        }
        tfUsername.setText(currentUser.getUsername());
        tfName.setText(currentUser.getName());
        tfAge.setText(Integer.toString(currentUser.getAge()));
        tfSex.setText(currentUser.getSex());
        tfWeight.setText(Integer.toString(currentUser.getWeight()));
        tfHeight.setText(Integer.toString(currentUser.getHeight()));
        tfEmail.setText(currentUser.getEmail());
        tfMaxPress.setText(Integer.toString(195));
        tfTargetWeight.setText(String.valueOf(currentUser.getWeight()));
        tfMileTime.setText("6:00");

        DateFormat format = DateFormat.getInstance();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Calendar cal = Calendar.getInstance();
                lbClock.setText(format.format(cal.getTime()));
                lbClock2.setText(format.format(cal.getTime()));
                lbClock3.setText(format.format(cal.getTime()));
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
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
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
        User.clearUser();
        currentUser.clearRememberMeFromPreferences();
    }

    public void calculateBMI()
    {
        int userWeight = currentUser.getWeight();
        int userHeight = currentUser.getHeight();
        double BMI = (userWeight * 703)/ (userHeight * userHeight);
        tfBMI.setText(String.valueOf(BMI));
    }
    public void editGoals()
    {
        btnSaveGoals.setVisible(true);
        btnUpdateGoals.setVisible(false);
        tfWeight.setEditable(true);
        tfMileTime.setEditable(true);
        tfMaxPress.setEditable(true);
    }

    public void updateGoals()
    {
        newWeight = tfWeight.getText();
        newMiles = tfMileTime.getText();
        newPress = tfMaxPress.getText();
        currentUser.setWeight(Integer.valueOf(newWeight));
        tfWeight.setEditable(false);
        tfMileTime.setEditable(false);
        tfMaxPress.setEditable(false);
        btnUpdateGoals.setVisible(true);
        btnSaveGoals.setVisible(false);
    }
    public void editMyProfile()
    {
        tfUsername.setEditable(true);
        tfName.setEditable(true);
        tfAge.setEditable(true);
        tfEmail.setEditable(true);
        tfWeight.setEditable(true);
        tfHeight.setEditable(true);
        pfPassword1.setVisible(true);
        pfPassword2.setVisible(true);
        lbPassword1.setVisible(true);
        lbPassword2.setVisible(true);
        btnSave.setVisible(true);
        btnCancel.setVisible(true);

    }

    public void saveInformation() {

        lbSaveError.setVisible(false);

        String newUsername = tfUsername.getText();
        String newName = tfName.getText();
        int newAge = Integer.parseInt(tfAge.getText());
        String newEmail = tfEmail.getText();
        int newWeight = Integer.parseInt(tfWeight.getText());
        int newHeight = Integer.parseInt(tfHeight.getText());
        int userID = currentUser.getUserID();
        String password1 = pfPassword1.getText();
        String password2 = pfPassword2.getText();
        String newPassword;

        /**
         * Validate for length greater than 0 and same string
         */

        if (password1.equals(password2) && ((password1.length() > 0) || (password2.length() > 0)))
            newPassword = password1;
        else
            newPassword = currentUser.getPassword();
        if((newHeight > 48 && newHeight < 90) && (newAge <= 100 && newAge > 0) && (newWeight > 60 && newWeight < 725))
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://23.229.201.1:3306/Squadd", "Squadd", "deeptoot");
                Statement state = connection.createStatement();
                String sqlQuery = "UPDATE user SET username='" + newUsername + "', password='" + newPassword + "' , name='" + newName + "', age=" + newAge +
                        ", weight=" + newWeight + ", height=" + newHeight + ", email='" + newEmail + "' WHERE userID=" + userID + ";";
                dbResponse = state.executeUpdate(sqlQuery);
            } catch (Exception x) {
                System.out.println("Error: " + x);
            }

            /**
             * Successfully saved stuff
             */
            if (dbResponse == 1) {
                tfUsername.setText(newUsername);
                tfName.setText(newName);
                tfAge.setText(String.valueOf(newAge));
                tfEmail.setText(newEmail);
                tfWeight.setText(String.valueOf(newWeight));
                tfHeight.setText(String.valueOf(newHeight));

                btnCancel.setVisible(false);
                btnSave.setVisible(false);

                tfUsername.setEditable(false);
                tfName.setEditable(false);
                tfAge.setEditable(false);
                tfEmail.setEditable(false);
                tfWeight.setEditable(false);
                tfHeight.setEditable(false);
                pfPassword1.setVisible(false);
                pfPassword2.setVisible(false);
                lbPassword1.setVisible(false);
                lbPassword2.setVisible(false);
            } else {
                lbSaveError.setVisible(true);
            }

            if (currentUser.getRememberMe()){
                currentUser = currentUser.updateUser(currentUser, newUsername, newName, newAge, newWeight, newHeight, newEmail);
                currentUser.putUserInPreferences(currentUser);
            }else
                currentUser = currentUser.updateUser(currentUser, newUsername, newName,newAge, newWeight, newHeight, newEmail);

        } else {
            lbSaveError.setVisible(true);
        }

    }

    public void cancelSaveInformation()
    {
        btnCancel.setVisible(false);
        btnSave.setVisible(false);

        tfUsername.setEditable(false);
        tfName.setEditable(false);
        tfAge.setEditable(false);
        tfEmail.setEditable(false);
        tfWeight.setEditable(false);
        tfHeight.setEditable(false);
        pfPassword1.setVisible(false);
        pfPassword2.setVisible(false);
        lbPassword1.setVisible(false);
        lbPassword2.setVisible(false);
        lbSaveError.setVisible(false);
    }

    public void changeProfilePicture() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
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
