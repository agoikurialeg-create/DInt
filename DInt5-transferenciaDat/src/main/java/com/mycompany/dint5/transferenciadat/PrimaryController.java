/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint5.transferenciadat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class PrimaryController implements Initializable {


    @FXML
    private ImageView imgAnim;
    @FXML
    private ImageView imgLand;
    @FXML
    private TextField emaitza;
    @FXML
    private Button btn;
    Image img1 = new Image("/images/arbol.png");
    Image img2 = new Image("/images/topoNarizEstrella.png");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        imgAnim.setImage(img2);
        imgLand.setImage(img1);
    }    
    
    @FXML
    private void landareaView(MouseEvent event) {
        String opcion = "Landareak";
        String imagen = "/images/arbol.png";
        cargarOpcion(opcion, imagen);
    }

    @FXML
    private void animaliaView(MouseEvent event) {
        String opcion = "Animaliak";
        String imagen = "/images/topoNarizEstrella.png";
        cargarOpcion(opcion, imagen);
    }

    @FXML
    private void switchToSecondary(ActionEvent event) {
        String opcion = "Animaliak";
        String imagen = "/images/ajolote.png";
        cargarOpcion(opcion, imagen);
    }
    private void cargarOpcion(String opcion, String imagen){
        System.out.println(opcion + imagen);
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();
            SecondaryController controlador = loader.getController();
            controlador.initAttributes(opcion, imagen);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            String emaitza = controlador.getRespuesta();
            this.emaitza.setText(emaitza);
            
            
        }catch(IOException ex){
        }
    }

}
