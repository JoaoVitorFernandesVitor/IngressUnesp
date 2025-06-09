package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class IngressoCardController {

    @FXML private ImageView imageView;
    @FXML private VBox labelContainer;


    public VBox getLabelContainer() {
        return labelContainer;
    }


}
