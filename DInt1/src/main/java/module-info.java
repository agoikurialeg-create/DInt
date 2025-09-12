module com.mycompany.dint1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.dint1 to javafx.fxml;
    exports com.mycompany.dint1;
}
