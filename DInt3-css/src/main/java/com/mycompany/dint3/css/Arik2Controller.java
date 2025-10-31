/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint3.css;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class Arik2Controller implements Initializable {

    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void firstStyle(ActionEvent event) {
        pane.getStylesheets().clear();
        pane.getStylesheets().add("/css/style1.css");
    }

    @FXML
    private void secondStyle(ActionEvent event) {
        pane.getStylesheets().clear();
        pane.getStylesheets().add("/css/style2.css");
    }

    @FXML
    private void thirdStyle(ActionEvent event) {
        pane.getStylesheets().clear();
        pane.getStylesheets().add("/css/style3.css");
    }

    @FXML
    private void reset(ActionEvent event) {
        pane.getStylesheets().clear();
        pane.getStylesheets().add("/css/style1.css");
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }
    
}
