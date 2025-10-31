/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint5.transferenciadat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class SecondaryController implements Initializable {


    @FXML
    private Button secondaryButton;
    @FXML
    private Label titulo;
    @FXML
    private TextField seleccion;
    private String respuesta;
    @FXML
    private ImageView imagen;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToPrimary(ActionEvent event) {
        String aux = seleccion.getText();
        setRespuesta(aux);
        
        Stage stage = (Stage) this.secondaryButton.getScene().getWindow();
        stage.close();
    }
    
    void initAttributes(String opcion, String imagen){
        titulo.setText(opcion);
        Image image = new Image(getClass().getResource(imagen).toExternalForm());
        this.imagen.setImage(image);
        
    }

}
