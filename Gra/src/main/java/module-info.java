module com.example.gra {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.json;

    opens com.example.gra to javafx.fxml;
    exports com.example.gra;
}