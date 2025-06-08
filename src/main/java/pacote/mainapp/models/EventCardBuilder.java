package pacote.mainapp.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pacote.mainapp.controllers.EventCardController;
import pacote.mainapp.controllers.EventoContoller;
import pacote.mainapp.controllers.NavigationController;
import pacote.mainapp.controllers.UNSPEventoController;

import java.io.IOException;
import java.util.Objects;

public class EventCardBuilder extends VBox {

    //Variaveis de Stylo Css
    private final String styleEventPrice = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
    private final String styleEventDetail = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
    private final String styleEventTitle = "-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;";
    private String path;
    private Scene eventScene;

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public Scene getEventScene() {
        return eventScene;
    }

    public void setEventScene(Scene eventScene) {
        this.eventScene = eventScene;
    }

    public Node buildCard(Evento evento, String path) throws IOException {

        Label nomeEvento = new Label(evento.getTitulo());
        Label dataEvento = new Label(evento.getData_inicio());
        Label precoEvento = new Label("R$ " + evento.getPreco());


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacote/mainapp/fxml/EventCard.fxml"));
        Node eventCard = loader.load();

        EventCardController controller = loader.getController();
        controller.getLabelContainer().getChildren().addAll(nomeEvento, dataEvento, precoEvento);
        controller.getBtnBuy().setOnAction(this::BuyBtn);

        buildEventWindow(evento);

        return eventCard;
    }



    public void BuyBtn(ActionEvent event) {
        try {

            NavigationController.goTo((Node) event.getSource(), getEventScene());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildEventWindow(Evento evento) throws IOException {
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/UNSPEvento.fxml")));
        Parent rooter = root.load();
        UNSPEventoController controller = root.getController();

        controller.setEventoTitulo(evento.getTitulo());
        controller.setEventoDescricao(evento.getDescricao());
        controller.setEventoPreco(evento.getPreco());

        System.out.println();

        setEventScene(new Scene(rooter));
    }

}
