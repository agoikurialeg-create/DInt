package com.mycompany.dint6.tablaagregar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Pertsona;

public class PrimaryController implements Initializable{

    @FXML
    private TableView<Pertsona> taula;
    @FXML
    private TableColumn tIzena;
    @FXML
    private TableColumn tAbizena;
    @FXML
    private TableColumn tAdina;
    @FXML
    private Button primaryButton;
    
    private ObservableList<Pertsona> pertsonak;

    @FXML
    private void switchToSecondary() throws IOException {
        //App.setRoot("secondary");
        Pertsona p = null;
        lehioaAldatu(p);
            
    }
    
    private void lehioaAldatu(Pertsona p){
    try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();
        SecondaryController cont = loader.getController();
        
        cont.initAttributes(pertsonak);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        
        System.out.println(cont.getErantzunaList());
        if(cont.getErantzunaList() != null){
            pertsonak = cont.getErantzunaList();
        }
        
    }catch(IOException ex){}
    }
    
    
    public void initialize(URL url, ResourceBundle rb){
        pertsonak = FXCollections.observableArrayList(
            new Pertsona("Sofia", "Cañabate", 23),
            new Pertsona("Jons", "Zabala", 32),
            new Pertsona("Pablo", "Perucha", 38),
            new Pertsona ("Joni", "Aguirre", 20)
        );
        tIzena.setCellValueFactory(new PropertyValueFactory("Izena"));
        tAbizena.setCellValueFactory(new PropertyValueFactory("Abizena"));
        tAdina.setCellValueFactory(new PropertyValueFactory("Adina"));
        taula.setItems(pertsonak);
        System.out.println(pertsonak.toString());
    }
}