
package javafxapplication6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class JavaFXApplication6 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Welcome to the SQUAD");
        stage.setScene(scene);
        stage.show();
    }
    
  
//
//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
