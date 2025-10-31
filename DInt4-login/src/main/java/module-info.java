module com.mycompany.dint4.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    opens modelo;
    opens com.mycompany.dint4.login to javafx.fxml;
    exports com.mycompany.dint4.login;
}
