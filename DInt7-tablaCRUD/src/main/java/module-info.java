module com.mycompany.dint7.tablacrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    opens modelo;
    opens com.mycompany.dint7.tablacrud to javafx.fxml;
    exports com.mycompany.dint7.tablacrud;
}
