module com.mycompany.dint3.css {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.dint3.css to javafx.fxml;
    exports com.mycompany.dint3.css;
}
