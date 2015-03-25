
package Squad_Fitness;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Splash_Screen extends Application {
    Stage window;
    Scene scene1, scene2;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        
        Button button1= new Button("BEGIN");
        button1.setOnAction(e -> window.setScene(scene2));
        button1.setLayoutX(400);
        button1.setLayoutY(600);
        
        
        VBox layout1= new VBox(20);
        layout1.getChildren().addAll(button1);
        scene1 = new Scene(layout1, 1000,850);
        scene1.getStylesheets().add("Squad_Fitness/Start_Screen.css");
       
        //Button2
        Button button2 = new Button("Uh");
        button2.setOnAction(e -> window.setScene(scene1));
        
        //Layout 2
        StackPane layout2= new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 1000, 850);
        
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
