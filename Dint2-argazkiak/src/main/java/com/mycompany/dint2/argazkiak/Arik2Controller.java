/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint2.argazkiak;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class Arik2Controller implements Initializable {

    @FXML
    private ImageView carrousel;
    @FXML
    private Button btn2;
    @FXML
    private Button btn1;
    
    int kont = 0;
            
    
    String[] imagenes ={"images/ajolote.png","images/aye_aye.png","images/cangrejoYeti.png",
      "images/chauliodus.png","images/diablilloespinoso.png","images/dragonMarino.png",
      "images/gusanoCalamar.png","images/mixini.png","images/petaurodelazucar.png",
      "images/pezmancha.png","images/pezsapopeludo.png","images/picozapato.png", 
      "images/pulpoDumbo.png","images/ratonLemur.png","images/solenodonte.png","images/tardigrado.png"};

    Image imageIni= new Image (imagenes[0]);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carrousel.setImage(imageIni);
    }    

    @FXML
    private void atzera(ActionEvent event) {
        kont--;
        if(kont<0){
        kont=0;}
        Image image = new Image(imagenes[kont]);
        carrousel.setImage(image);
    }

    @FXML
    private void aurrera(ActionEvent event) {
        kont++;
        if(kont==16){
        kont=0;
        }
        Image image = new Image(imagenes[kont]);
        carrousel.setImage(image);
        
    }
    
}
