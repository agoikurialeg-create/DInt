package com.mycompany.dint8.json;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Langileak;

public class PrimaryController implements Initializable {

    @FXML
    private Button primaryButton;
    @FXML
    private TableView<Langileak> tabla;
    @FXML
    private TableColumn<Langileak, Integer> id;
    @FXML
    private TableColumn<Langileak, String> izena;
    @FXML
    private TableColumn<Langileak, String> enpresa;
    @FXML
    private ComboBox<Langileak> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String fitxategiBidea = "C:\\Users\\2AM3-3\\Documents\\JSON\\langileak.json";

        try {
            Type langileListaMota = new TypeToken<List<Langileak>>(){}.getType();
            List<Langileak> langileak = new Gson().fromJson(new FileReader(fitxategiBidea), langileListaMota);

            id.setCellValueFactory(new PropertyValueFactory<>("Id"));
            izena.setCellValueFactory(new PropertyValueFactory<>("Izena"));
            enpresa.setCellValueFactory(new PropertyValueFactory<>("Enpresa"));

            ObservableList<Langileak> obLista = FXCollections.observableList(langileak);
            tabla.setItems(obLista);

            ObservableList<Langileak> comboLista = FXCollections.observableArrayList(langileak);
            comboBox.setItems(comboLista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void switchToSecondary(ActionEvent event) {
    }

    @FXML
    private void showLangileak(ActionEvent event) {
        Langileak aukeratua = comboBox.getSelectionModel().getSelectedItem();
        System.out.println("Aukeratutako langilea: " + aukeratua);
    }
}
