
package Squad_Fitness.Java;

import Squad_Fitness.Model.User;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.prefs.Preferences;

public class Splash_Screen extends Application  {

    //Stage is the entire window
    Stage window;
    //Scenes are the containers within stages
    Scene scene1;
    Button button1;
    Preferences preferences;
    User storedUser;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        button1 = new Button("BEGIN");

        LoginScreen login = new LoginScreen();

        preferences = Preferences.systemNodeForPackage(this.getClass());
        storedUser = new User();
        storedUser = storedUser.getUserFromPreferences(storedUser);
        System.out.print(storedUser.getName());

        if(storedUser.getRememberMe())
        {
            button1.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                try{
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

        VBox layout1= new VBox(20);
        layout1.getChildren().addAll(button1);
        scene1 = new Scene(layout1, 1000,850);
        scene1.getStylesheets().add("Squad_Fitness/CSS/Start_Screen.css");

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
