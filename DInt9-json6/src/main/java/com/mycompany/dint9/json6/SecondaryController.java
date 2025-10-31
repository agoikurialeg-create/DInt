package com.mycompany.dint9.json6;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private TextField fieldIzena;
    @FXML
    private TextField fieldAbizena;
    @FXML
    private TextField fieldAdina;
    @FXML
    private Button btnGorde;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}