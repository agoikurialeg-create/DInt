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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class BatuketaController implements Initializable {

    @FXML
    private TextField zen1;
    @FXML
    private TextField zen2;
    @FXML
    private Button batu;
    @FXML
    private TextField emaitza;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void batu(ActionEvent event) {
        String zenbakia1 = zen1.getText();
        String zenbakia2 = zen2.getText();
        int z1 = Integer.parseInt(zenbakia1);
        int z2 = Integer.parseInt(zenbakia2);
        int batuketa = z1 + z2;
        String batu = String.valueOf(batuketa);
        emaitza.setText(batu);
    }
    
}
