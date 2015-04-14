
package Squad_Fitness.Java;

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
    int UserID;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        button1 = new Button("BEGIN");

        LoginScreen login = new LoginScreen();

        preferences = Preferences.systemNodeForPackage(this.getClass());
        /**
         * If the UserID is greater than 0 that means the user opted for us to save their credentials and for the program
         * to go straight to my profile instead of logging in.
         */
        UserID = preferences.getInt("UserID", -1);
        if(UserID > 0)
        {
            button1.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                try{
                    new MyProfile().start(window);
                    System.out.println("Something saved.");

                } catch (Exception e) {}

            }
        });

        } else {
            button1.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {
                    try{
                        new LoginScreen().start(window);
                        System.out.println("It's connected");

                    } catch (Exception e) {}

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
        scene1.getStylesheets().add("Squad_Fitness/Start_Screen.css");

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
