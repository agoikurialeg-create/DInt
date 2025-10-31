/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dint2.argazkiak;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author 2AM3-3
 */
public class Arik3Controller implements Initializable {

    @FXML
    private GridPane gPane;
    String[] imagenes ={"images/ajolote.png","images/cangrejoYeti.png",
      "images/chauliodus.png","images/diablilloespinoso.png","images/dragonMarino.png",
      "images/gusanoCalamar.png","images/mixini.png","images/petaurodelazucar.png",
      "images/pezmancha.png","images/pezsapopeludo.png","images/picozapato.png", 
      "images/pulpoDumbo.png","images/ratonLemur.png","images/solenodonte.png","images/tardigrado.png"};
    int columna = 0;
    int fila = 0;
    ImageView imgV;
    Image img;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columna = 0;
        fila = 0;
        
        for (String imagen : imagenes) {
            System.out.println(imagen);
            img = new Image(imagen);
            imgV = new ImageView();
            imgV.setFitHeight(100);
            imgV.setFitWidth(100);
            imgV.setImage(img);
            

            gPane.add(imgV, columna, fila);

            columna++;
            if (columna > 4) {
                columna = 0;
                fila++;
            }
        }
    }    
}
