module com.mycompany.dint9.json4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.google.gson;
    opens model;

    opens com.mycompany.dint9.json4 to javafx.fxml;
    exports com.mycompany.dint9.json4;
    
}
