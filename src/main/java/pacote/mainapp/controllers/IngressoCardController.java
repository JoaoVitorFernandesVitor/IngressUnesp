package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Controller para o card de ingresso.
 * Controla os elementos visuais do card, como imagem e container de labels.
 */
public class IngressoCardController {

    @FXML
    private ImageView imageView;

    @FXML
    private VBox labelContainer;

    /**
     * Obtém o container que contém os labels do card.
     * @return VBox que agrupa os labels do ingresso
     */
    public VBox getLabelContainer() {
        return labelContainer;
    }

}
