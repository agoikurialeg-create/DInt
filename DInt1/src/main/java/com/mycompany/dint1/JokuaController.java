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

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class JokuaController implements Initializable {


    @FXML
    private Button up;
    @FXML
    private Button down;
    @FXML
    private Button left;
    @FXML
    private Button right;
    @FXML
    private GridPane gridPane;
    @FXML
    private Circle bola;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void goUp(ActionEvent event) {
        int y = gridPane.getRowIndex(bola)-1;
        if(y>=0){
        gridPane.setRowIndex(bola, y);
        }
    }

    @FXML
    private void goDown(ActionEvent event) {
        int y = gridPane.getRowIndex(bola)+1;
        if(y<5){
        gridPane.setRowIndex(bola, y);
        }
    }

    @FXML
    private void goLeft(ActionEvent event) {
        int x = gridPane.getColumnIndex(bola)-1;
        if(x>=0){
        gridPane.setColumnIndex(bola, x);
        }
    }

    @FXML
    private void goRight(ActionEvent event) {
        int x = gridPane.getColumnIndex(bola)+1;
        if(x<5){
        gridPane.setColumnIndex(bola, x);
        }
    }

}
