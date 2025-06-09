package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import pacote.mainapp.models.Usuario;

public class EventCardController {

    @FXML private ImageView imageView;
    @FXML private VBox labelContainer;
    @FXML private Button btnBuy;


    public VBox getLabelContainer() {
        return labelContainer;
    }

    public Button getBtnBuy() {
        return btnBuy;
    }

}
