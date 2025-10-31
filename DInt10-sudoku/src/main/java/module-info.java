module com.mycompany.dint10.sudoku {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.base;
    opens Model;
    opens com.mycompany.dint10.sudoku to javafx.fxml;
    exports com.mycompany.dint10.sudoku;
}
