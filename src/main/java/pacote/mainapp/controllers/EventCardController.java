package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pacote.mainapp.models.EventCardBuilder;

import java.io.IOException;
public class EventCardController {

    private String path;
    @FXML private VBox LabelContainer;
    @FXML private Button btnBuy;

    public VBox getLabelContainer() {
        return LabelContainer;
    }

    public Button getBtnBuy() {
        return btnBuy;
    }

    public void setPath(String newpath) {
        path = newpath;
    }

    private  String getPath(){
        return path;
    }

}
