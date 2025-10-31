/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint3.css;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button arik1;
    @FXML
    private Button arik2;
    @FXML
    private Button arik3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void switchToArik1(ActionEvent event) throws IOException{
        App.setRoot("arik1");
    }

    @FXML
    private void switchToArik2(ActionEvent event)throws IOException {
        App.setRoot("arik2");
    }

    @FXML
    private void switchToArik3(ActionEvent event)throws IOException {
        App.setRoot("secondary");
    }
    
}
