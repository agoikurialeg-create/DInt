package com.mycompany.dint7.tablacrud;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Pertsona;

public class PrimaryController implements Initializable {

    @FXML
    private Button sortu;
    @FXML
    private Button aldatu;
    @FXML
    private Button ezabatu;
    @FXML
    private TableView<Pertsona> tabla;
    @FXML
    private TableColumn<Pertsona, String> izena;
    @FXML
    private TableColumn<Pertsona, String> abizena;
    @FXML
    private TableColumn<Pertsona, Integer> adina;

    private ObservableList<Pertsona> pertsonak;
    private String aukera;
    private Pertsona p;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pertsonak = FXCollections.observableArrayList();
        izena.setCellValueFactory(new PropertyValueFactory<>("izena"));
        abizena.setCellValueFactory(new PropertyValueFactory<>("abizena"));
        adina.setCellValueFactory(new PropertyValueFactory<>("adina"));
        tabla.setItems(pertsonak);
    }

    private void lehioaAldatu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();
            SecondaryController cont = loader.getController();

            if (aukera.equals("sortu")) {
                cont.initAttributes(pertsonak);
            }

            if (aukera.equals("aldatu")) {
                p = this.tabla.getSelectionModel().getSelectedItem();
                if (p != null) {
                    cont.initAttributes(pertsonak, p);
                } else {
                    error("AUKERATU PERTSONA");
                    return;
                }
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Pertsona pAux = cont.getPertsona();
            if (pAux != null) {
                switch (aukera) {
                    case "sortu":
                        this.pertsonak.add(pAux);
                        this.tabla.setItems(pertsonak);
                        break;
                    case "aldatu":
                        tabla.refresh();
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sortu(ActionEvent event) {
        aukera = "sortu";
        lehioaAldatu();
    }

    @FXML
    private void aldatu(ActionEvent event) {
        aukera = "aldatu";
        Pertsona p = this.tabla.getSelectionModel().getSelectedItem();
        if (p != null) {
            lehioaAldatu();
        } else {
            error("AUKERATU PERTSONA");
        }
    }

    @FXML
    private void ezabatu(ActionEvent event) {
        Pertsona p = this.tabla.getSelectionModel().getSelectedItem();
        if (p != null) {
            this.pertsonak.remove(p);
            this.tabla.refresh();
        } else {
            error("AUKERATU PERTSONA");
        }
    }

    private void error(String mez) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROREA");
        alert.setContentText(mez);
        alert.showAndWait();
    }
}
