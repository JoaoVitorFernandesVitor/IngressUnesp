package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Controller para o cartão de evento (EventCard.fxml).
 * Responsável por gerenciar a interface do cartão, incluindo imagem, rótulos e botão de compra.
 */
public class EventCardController {

    @FXML
    private ImageView imageView;

    @FXML
    private VBox labelContainer;

    @FXML
    private Button btnBuy;

    /**
     * Retorna o container que contém os rótulos do cartão do evento.
     *
     * @return VBox que contém os Labels do cartão.
     */
    public VBox getLabelContainer() {
        return labelContainer;
    }

    /**
     * Retorna o botão de compra do cartão do evento.
     *
     * @return Botão de compra.
     */
    public Button getBtnBuy() {
        return btnBuy;
    }
}
