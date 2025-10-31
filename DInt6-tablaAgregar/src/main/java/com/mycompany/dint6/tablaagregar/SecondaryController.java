package com.mycompany.dint6.tablaagregar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pertsona;

public class SecondaryController implements Initializable{
    
    private ObservableList<Pertsona> pertsonaList;
    private ObservableList<Pertsona> erantzunaList;
    
    @FXML
    private TextField fieldIzena;
    @FXML
    private TextField fieldAbizena;
    @FXML
    private TextField fieldAdina;
    @FXML
    private Button btnGorde;
    
    void initAttributes(ObservableList<Pertsona> pertsonak){
        this.pertsonaList = pertsonak;
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        //App.setRoot("primary");
        try{
            String izena = this.fieldIzena.getText();
            String abizena = this.fieldAbizena.getText();
            int adina = Integer.parseInt(this.fieldAdina.getText());
            Pertsona p = new Pertsona(izena, abizena, adina);
            
            if(!errepikatutaDago(pertsonaList, p)){
                System.out.println("Ez dago errepikatuta");
                this.pertsonaList.add(p);
                setErantzunaList(pertsonaList);
                Stage stage = (Stage) this.btnGorde.getScene().getWindow();
                stage.close();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROREA");
                alert.setContentText("PERTSONA EXISTITZEN DA");
                alert.showAndWait();
            }
            
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setTitle("ERROREA");
            alert.setContentText("FORMATU ERROREA");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ObservableList<Pertsona> getErantzunaList() {
        return erantzunaList;
    }

    public void setErantzunaList(ObservableList<Pertsona> erantzunaList) {
        this.erantzunaList = erantzunaList;
    }
    
    private boolean errepikatutaDago(ObservableList<Pertsona> pertsonaList, Pertsona p){
        boolean erantzuna = false; 
        for(Pertsona perts : pertsonaList){
            if(perts.getAbizena().equals(p.getAbizena()) && perts.getIzena().equals(p.getIzena()) && perts.getAdina() == p.getAdina() ){
                erantzuna = true ; 
                break;
            }
        }
        return erantzuna;
    }
    
}