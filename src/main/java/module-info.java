module pacote.mainapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens pacote.mainapp to javafx.fxml;
    opens pacote.mainapp.controllers to javafx.fxml;
    opens pacote.mainapp.models to javafx.fxml;
    opens pacote.mainapp.fxml to javafx.fxml;

    exports pacote.mainapp;
    exports pacote.mainapp.controllers;
    exports pacote.mainapp.models;
}