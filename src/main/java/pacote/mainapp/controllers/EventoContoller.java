package pacote.mainapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pacote.mainapp.models.Evento;
import pacote.mainapp.models.EventoAcademico;

import java.io.IOException;

public class EventoContoller {

    @FXML
    private VBox eventsContainer;
    private ObservableList<Evento> eventos = FXCollections.observableArrayList();

    public void createEventCard() throws IOException {

        Evento evento1 = new EventoAcademico();
        eventos.add(evento1);

        //Variaveis de Stylo Css
        String styleEventPrice = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
        String styleEventDetail = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
        String styleEventTitle = "-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;";

        //Carregando o FXML Padrao do EventCad
        FXMLLoader loader = new FXMLLoader(EventoContoller.class.getResource("/pacote/mainapp/fxml/EventCard.fxml"));
        Node widget = loader.load();
        EventCardController controller = loader.getController();

        for (Evento evento : eventos) {
            Label nomeEvento = new Label(evento.getTitulo());
            Label dataEvento = new Label("Data");
            Label localEvento = new Label("Local");
            Label ticketsEvento = new Label("Tickets");
            Label precoEvento = new Label("Preco");

            //setando Styles das Labels

            dataEvento.setStyle(styleEventDetail);
            localEvento.setStyle(styleEventDetail);
            ticketsEvento.setStyle(styleEventDetail);
            precoEvento.setStyle(styleEventPrice);

            //Adding Labels no Vbox
            controller.getLabelContainer().getChildren().addAll(dataEvento, localEvento, ticketsEvento, precoEvento);

        }

        eventsContainer.getChildren().add(widget);  //adiciona o EventCard no container
    }

    @FXML
    private void addEventCard(ActionEvent event) throws IOException {
        createEventCard();
    }
}
