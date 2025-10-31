/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint9.json6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Pertsona;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class PrimaryController implements Initializable {

    @FXML
    private TableView<Pertsona> taula;
    @FXML
    private TableColumn<Pertsona, String> izenaCol;
    @FXML
    private TableColumn<Pertsona, String> abizenaCol;
    @FXML
    private TableColumn<Pertsona, Integer> adinaCol;
    @FXML
    private Button aldatuPertsona;
    @FXML
    private Button sortuPertsona;
    @FXML
    private Button ezabatuPertsona;
    @FXML
    private Button jsonZabaldu;
    @FXML
    private Button jsonGorde;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToSecondary(ActionEvent event) {
    }

    @FXML
    private void ezabatu(ActionEvent event) {
    }

    @FXML
    private void zabaldu(ActionEvent event) {
    }

    @FXML
    private void gorde(ActionEvent event) {
    }

    
}
