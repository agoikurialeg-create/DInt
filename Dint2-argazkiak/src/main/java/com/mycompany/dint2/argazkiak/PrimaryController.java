/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint2.argazkiak;

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
    private Button asrik2;
    @FXML
    private Button arik3;
    @FXML
    private Button arik4;
    @FXML
    private Button arik5;
    @FXML
    private Button arik6;
    @FXML
    private Button arik7;

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
    private void switchToArik2(ActionEvent event) throws IOException{
        App.setRoot("primary");
    }

    @FXML
    private void switchToArik3(ActionEvent event) throws IOException{
        App.setRoot("primary");
    }

    @FXML
    private void switchToArik4(ActionEvent event) throws IOException{
        App.setRoot("primary");
    }

    @FXML
    private void switchToArik5(ActionEvent event) throws IOException{
        App.setRoot("primary");
    }

    @FXML
    private void switchToArik6(ActionEvent event) throws IOException{
        App.setRoot("primary");
    }

    @FXML
    private void switchToArik7(ActionEvent event) throws IOException{
        App.setRoot("secondary");
    }
    
}
