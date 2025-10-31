module com.mycompany.dint5.transferenciadat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.dint5.transferenciadat to javafx.fxml;
    exports com.mycompany.dint5.transferenciadat;
}
