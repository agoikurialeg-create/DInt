package com.mycompany.dint7.tablacrud;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Pertsona;

public class SecondaryController {

    @FXML
    private TextField fieldIzena;
    @FXML
    private TextField fieldAbizena;
    @FXML
    private TextField fieldAdina;
    @FXML
    private Button btnGorde;
    
    private ObservableList<Pertsona> pertsonak;
    private ObservableList<Pertsona> erantzunaList;
    Pertsona pertsona;
    

    @FXML
    private void switchToPrimary() throws IOException {
        try{
            String izena = this.fieldIzena.getText();
            String abizena = this.fieldAbizena.getText();
            int adina = Integer.parseInt(this.fieldAdina.getText());
            Pertsona paux = new Pertsona (izena, abizena, adina);
            
            if(!errepikatutaDago(pertsonak, paux)){
                
                if(this.pertsona != null){
                    this.pertsona.setIzena(izena);
                    this.pertsona.setAbizena(abizena);
                    this.pertsona.setAdina(adina);
                }else{
                    setPertsona(paux);
                }
                Stage stage = (Stage) this.btnGorde.getScene().getWindow();
                stage.close(); 
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("FORMATO INCORRECTO");
                alert.showAndWait();
            }
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("FORMATO INCORRECTO");
            alert.showAndWait();
        }
        
    }
    
    public void initAttributes(ObservableList<Pertsona> pertsonak){
        this.pertsonak = pertsonak;
    }
    public void initAttributes(ObservableList<Pertsona> pertsonak, Pertsona p){
        System.out.println(p);
        this.fieldIzena.setText(p.getIzena());
        this.fieldAbizena.setText(p.getAbizena());
        this.fieldAdina.setText(p.getAdina() + "");
        this.pertsonak = pertsonak;
        this.pertsona = p;
    }

    public Pertsona getPertsona() {
        return pertsona;
    }

    public void setPertsona(Pertsona pertsona) {
        this.pertsona = pertsona;
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