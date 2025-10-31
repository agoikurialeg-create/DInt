module com.mycompany.dint6.tablaagregar {
    requires javafx.controls;
    requires javafx.fxml;
    opens model;
    opens com.mycompany.dint6.tablaagregar to javafx.fxml;
    exports com.mycompany.dint6.tablaagregar;
}
