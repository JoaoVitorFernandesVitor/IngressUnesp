module pacote.mainapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens pacote.mainapp to javafx.fxml;
    exports pacote.mainapp;

}