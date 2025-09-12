package com.mycompany.dint1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button hbox;
    @FXML
    private Button vbox;
    @FXML
    private Button gridpane;
    @FXML
    private Button jokua;

    @FXML
    private void switchToHbox() throws IOException {
        App.setRoot("hbox");
    }
    
    
    @FXML
    private void switchToVbox() throws IOException {
        App.setRoot("vbox");
    }
    
    @FXML
    private void switchToGridPane() throws IOException {
        App.setRoot("gridpane");
    }
    
    @FXML
    private void switchToBatuketa() throws IOException {
        App.setRoot("batuketa");
    }
    
    @FXML
    private void switchToJokua() throws IOException {
        App.setRoot("jokua");
    }
    
    @FXML
    private void switchToAlert() throws IOException {
        App.setRoot("alert");
    }
}
  