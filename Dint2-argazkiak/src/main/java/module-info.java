module com.mycompany.dint2.argazkiak {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.dint2.argazkiak to javafx.fxml;
    exports com.mycompany.dint2.argazkiak;
}
