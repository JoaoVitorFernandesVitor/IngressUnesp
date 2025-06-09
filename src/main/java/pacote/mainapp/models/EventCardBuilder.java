package pacote.mainapp.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import pacote.mainapp.controllers.EventCardController;
import pacote.mainapp.controllers.EventoDetalhadoController;
import pacote.mainapp.controllers.IngressoCardController;
import pacote.mainapp.controllers.NavigationController;

import java.io.IOException;
import java.util.Objects;

/**
 * Classe que cria cards visuais para eventos e ingressos, estendendo VBox.
 * Fornece métodos para construir cards personalizados com dados e estilos.
 */
public class EventCardBuilder extends VBox {

    // Estilos CSS usados nos labels
    private final String styleEventPrice = "-fx-font-size: 15px; -fx-text-fill: #485255;";
    private final String styleEventDetail = "-fx-font-size: 15px; -fx-text-fill: #485255;";
    private final String styleEventTitle = "-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;";

    private Usuario usuario;

    /**
     * Obtém o usuário associado ao card builder.
     * @return Usuário atual.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Define o usuário para associar ao card builder.
     * @param usuario Usuário a ser definido.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Cria um card visual (Node) para exibir informações do evento.
     * O card inclui título, data e preço, além de uma imagem conforme o tipo do evento.
     *
     * @param evento Evento cujas informações serão exibidas.
     * @return Node representando o card do evento.
     * @throws IOException Caso ocorra erro ao carregar o arquivo FXML.
     */
    public Node buildCard(Evento evento) throws IOException {
        Label nomeEvento = new Label(evento.getTitulo());
        Label dataEvento = new Label("Data: "+ evento.getData_inicio());
        Label precoEvento = new Label("Preço: R$ "+ evento.getPreco());

        nomeEvento.setStyle(styleEventTitle);
        dataEvento.setStyle(styleEventDetail);
        precoEvento.setStyle(styleEventPrice);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacote/mainapp/fxml/EventCard.fxml"));
        Node eventCard = loader.load();

        ImageView imageView = (ImageView) eventCard.lookup("#imageView");

        String tipo = evento.getTipo();
        String imagePath = switch (tipo) {
            case "academico" -> "/pacote/mainapp/img/academico.png";
            case "musical" -> "/pacote/mainapp/img/musical.png";
            default -> "/pacote/mainapp/img/unespLogo.png";
        };
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        imageView.setImage(image);

        EventCardController controller = loader.getController();
        controller.getLabelContainer().getChildren().addAll(nomeEvento, dataEvento, precoEvento);

        controller.getBtnBuy().setOnAction(e -> {
            try {
                buildEventWindow(evento, (Node) e.getSource());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        return eventCard;
    }

    /**
     * Abre a janela de detalhes do evento.
     *
     * @param evento Evento a ser exibido detalhadamente.
     * @param source Node que disparou a ação (usado para navegação).
     * @throws IOException Caso ocorra erro ao carregar a interface FXML.
     */
    private void buildEventWindow(Evento evento, Node source) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/pacote/mainapp/fxml/EventoDetalhado.fxml")));
        Parent root = loader.load();

        EventoDetalhadoController controller = loader.getController();
        controller.setEvento(evento);
        controller.setUsuario(getUsuario());

        Scene eventScene = new Scene(root);
        NavigationController.goTo(source, eventScene);
    }

    /**
     * Cria um card visual (Node) para exibir informações do ingresso.
     * O card inclui título do evento, data e preço, e imagem conforme o tipo do evento.
     *
     * @param ingresso Ingresso cujas informações serão exibidas.
     * @return Node representando o card do ingresso.
     * @throws IOException Caso ocorra erro ao carregar o arquivo FXML.
     */
    public Node buildIngressoCard(Ingresso ingresso) throws IOException {
        Label nomeEvento = new Label(ingresso.refEvento.getTitulo());
        Label dataEvento = new Label("Data: "+ingresso.refEvento.getData_inicio());
        Label precoEvento = new Label("Preço: R$ " + ingresso.getPreco());

        nomeEvento.setStyle(styleEventTitle);
        dataEvento.setStyle(styleEventDetail);
        precoEvento.setStyle(styleEventPrice);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacote/mainapp/fxml/IngressoCard.fxml"));
        Node ingressoCard = loader.load();

        ImageView imageView = (ImageView) ingressoCard.lookup("#imageView");

        String tipo = ingresso.refEvento.getTipo();
        String imagePath = switch (tipo) {
            case "academico" -> "/pacote/mainapp/img/academico.png";
            case "musical" -> "/pacote/mainapp/img/musical.png";
            default -> "/pacote/mainapp/img/unespLogo.png";
        };
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        imageView.setImage(image);

        IngressoCardController controller = loader.getController();
        controller.getLabelContainer().getChildren().addAll(nomeEvento, dataEvento, precoEvento);

        return ingressoCard;
    }
}
