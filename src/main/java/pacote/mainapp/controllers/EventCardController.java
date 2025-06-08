package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class EventCardController {

    @FXML private ImageView imageView;
    @FXML private VBox labelContainer;
    @FXML private Button btnBuy;

    private String path;

    public VBox getLabelContainer() {
        return labelContainer;
    }

    public Button getBtnBuy() {
        return btnBuy;
    }

    public void setPath(String newPath) {
        this.path = newPath;
    }

    public String getPath() {
        return path;
    }
}
