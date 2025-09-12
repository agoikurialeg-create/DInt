/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class AlertController implements Initializable {

    @FXML
    private Button alert1;
    @FXML
    private Button alert2;
    @FXML
    private Button alert3;
    @FXML
    private Button alert4;
    @FXML
    private Button alert5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void alert1(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("confirmo");
        alert.show();
    }

    @FXML
    private void alert2(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Error");
        alert.show();
    }

    @FXML
    private void alert3(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("informacion");
        alert.show();
    }

    @FXML
    private void alert4(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.NONE);
        alert.setContentText("nada");
        alert.show();
    }

    @FXML
    private void alert5(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.WARNING);
        alert.setContentText("warning");
        alert.show();
    }
    
}
