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

        //cria as Labels do EventCard
        Label nomeEvento = new Label(evento.getTitulo());
        Label dataEvento = new Label("14/06/25");
        Label localEvento = new Label("Chacarra Magri");
        Label precoEvento = new Label("R$100,00");

        //Setando os Styles dos Labels
        nomeEvento.setStyle(styleEventTitle);
        dataEvento.setStyle(styleEventDetail);
        localEvento.setStyle(styleEventDetail);
        precoEvento.setStyle(styleEventPrice);

        //Carregando o FXML Padrao do EventCad
        FXMLLoader loader = new FXMLLoader(EventoContoller.class.getResource("/pacote/mainapp/fxml/EventCard.fxml"));
        Node eventCard = loader.load();

        EventCardController controller = loader.getController(); //Captura o Controllador: EventCardController

        controller.getLabelContainer().getChildren().addAll(nomeEvento,dataEvento, localEvento, precoEvento); //Adding Labels no Vbox

        controller.getBtnBuy().setOnAction(this::BuyBtn);

        //janela do interna do Evento
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
        controller.setEventoPreco("1000,00");

        System.out.println();

        setEventScene(new Scene(rooter));
    }

}
