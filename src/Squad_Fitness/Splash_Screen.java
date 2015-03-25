
package Squad_Fitness;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Splash_Screen extends Application  {
    //Stage is the entire window
    Stage window;
    //Scenes are the containers within stages
    Scene scene1, scene2;
    Button button1;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        button1 = new Button("BEGIN");

        LoginScreen login = new LoginScreen();


        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    new LoginScreen().start(window);
                } catch (Exception e) {}

            }
        });

        button1.setLayoutX(400);
        button1.setLayoutY(600);

        //Button2
        Button button2 = new Button("Uh");
        button2.setOnAction(e -> window.setScene(scene1));

        VBox layout1= new VBox(20);
        layout1.getChildren().addAll(button1);
        scene1 = new Scene(layout1, 1000,850);
        scene1.getStylesheets().add("Squad_Fitness/Start_Screen.css");

        //Layout 2
        //VBox layout2= new VBox();
        //Line line1 = new Line(50, 25, 150, 25);
        //layout2.getChildren().addAll(button2, line1);
        //Parent root = FXMLLoader.load(getClass().getResource("/FXML/loginScreen.fxml"));
        //scene2 = new Scene(root, 1000, 850);

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
