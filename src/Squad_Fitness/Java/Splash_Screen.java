package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class Splash_Screen extends Application implements Initializable {

    //Stage is the entire window
    Stage window;
    //Scenes are the containers within stages
    Scene scene1;


    Preferences preferences;
    User storedUser;

    Boolean rememberMe;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        LoginScreen login = new LoginScreen();


    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Button button1;
        button1 = new Button("BEGIN");

        preferences = Preferences.systemNodeForPackage(this.getClass());
        storedUser = new User();
        storedUser = storedUser.getUserFromPreferences(storedUser);
        rememberMe = storedUser.getRememberMe();
        System.out.print(storedUser.getName());
        if(rememberMe)
        {
            button1.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try{
                        String file = (this.getClass().getClassLoader().getResource("Squad_Fitness/Resources/Squad.wav")).toString();
                        Media media = new Media(file);
                        MediaPlayer mp = new MediaPlayer(media);
                        mp.play();
                        new MyProfile().start(window);
                        System.out.println("Something saved.");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

        } else {
            button1.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {
                    try{
                        String file = (this.getClass().getClassLoader().getResource("Squad_Fitness/Resources/Squad.wav")).toString();
                        Media media = new Media(file);
                        MediaPlayer mp = new MediaPlayer(media);
                        mp.play();
                        new LoginScreen().start(window);
                        System.out.println("It's connected");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }


        button1.setLayoutX(400);
        button1.setLayoutY(600);

        //Button2
        Button button2 = new Button("Uh");
        button2.setOnAction(e -> window.setScene(scene1));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BOTTOM_CENTER);
        grid.setHgap(1);
        grid.setVgap(1);
        //VBox layout1= new VBox(20);
        /*layout1.getChildren().addAll(button1);*/
        scene1 = new Scene(grid, 1000,850);
        scene1.getStylesheets().add("Squad_Fitness/CSS/Start_Screen.css");
        HBox hbBtn = new HBox(1);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(button1);
        grid.add(hbBtn, 1, 1);
        window.setScene(scene1);
        window.setTitle("Welcome to the SQUAD!");
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
