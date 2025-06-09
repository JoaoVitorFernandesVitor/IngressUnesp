package pacote.mainapp.models;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pacote.mainapp.controllers.EventCardController;
import pacote.mainapp.controllers.EventoDetalhadoController;
import pacote.mainapp.controllers.NavigationController;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

public class EventCardBuilder extends VBox {

    //Variaveis de Stylo Css
    private final String styleEventPrice = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
    private final String styleEventDetail = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
    private final String styleEventTitle = "-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;";

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Node buildCard(Evento evento, String path) throws IOException {

        Label nomeEvento = new Label(evento.getTitulo());
        Label dataEvento = new Label(evento.getData_inicio());
        Label precoEvento = new Label("R$ " + evento.getPreco());

        nomeEvento.setStyle(styleEventTitle);
        dataEvento.setStyle(styleEventDetail);
        precoEvento.setStyle(styleEventPrice);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacote/mainapp/fxml/EventCard.fxml"));
        Node eventCard = loader.load();

        ImageView imageView = (ImageView) eventCard.lookup("#imageView");

        String tipo = evento.getTipo();
        String imagePath = switch (tipo) {
            case "academico" -> "/pacote/mainapp/img/academico.png";
            case "musical" -> "/pacote/mainapp/img/musical.jpg";
            default -> "/pacote/mainapp/img/unespLogo.png";
        };
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        imageView.setImage(image);

        EventCardController controller = loader.getController();
        controller.getLabelContainer().getChildren().addAll(nomeEvento, dataEvento, precoEvento);

        // Define o listener do botão para abrir o evento detalhado correto
        controller.getBtnBuy().setOnAction(e -> {
            try {
                buildEventWindow(evento, (Node) e.getSource());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        return eventCard;
    }


    private void buildEventWindow(Evento evento, Node source) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/pacote/mainapp/fxml/EventoDetalhado.fxml")));
        Parent root = loader.load();

        EventoDetalhadoController controller = loader.getController();
        controller.setEvento(evento); // Passa o evento inteiro aqui
        controller.setUsuario(getUsuario());
        Scene eventScene = new Scene(root);
        NavigationController.goTo(source, eventScene);
    }



}
