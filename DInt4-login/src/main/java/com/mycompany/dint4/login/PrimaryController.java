/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint4.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.User;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField textArea1;
    @FXML
    private TextField textArea2;
    @FXML
    private Button logIn;
    @FXML
    private ImageView imgV;
    @FXML
    private Label txtMsgError;
    
    Image img;
    String imagen = "images/perfil.png";
    User user = new User();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        img = new Image (imagen);
        imgV.setImage(img);
        txtMsgError.setVisible(false);
        user.setNick("Ane");
        user.setPassword("Ane123");
        
        textArea1.focusedProperty().addListener((ObservableValue<? extends Boolean>
        observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue){
            txtMsgError.setVisible(false);
            }
        });
    }    

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        if(user.getNick().equals(textArea1.getText()) && user.getPassword().equals(textArea2.getText())){
            App.setRoot("secondary");
        }else{txtMsgError.setVisible(true);}
        
    }  
}
