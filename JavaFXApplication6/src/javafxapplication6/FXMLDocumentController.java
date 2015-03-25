/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Jae
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
      Stage stage; 
     Parent root;
        
            stage=(Stage)button1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        
     
     
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
