module com.mycompany.dint8.json {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.base;
    opens model;

    opens com.mycompany.dint8.json to javafx.fxml;
    exports com.mycompany.dint8.json;
    
}
