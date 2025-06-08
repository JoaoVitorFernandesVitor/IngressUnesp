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
        Evento evento2 = new EventoAcademico();
        eventos.addAll(evento1, evento2);
        String[] paths = {"/pacote/mainapp/fxml/UNSPDashboard.fxml", "/pacote/mainapp/fxml/Cadastros.fxml"};
        //Variaveis de Stylo Css
        String styleEventPrice = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
        String styleEventDetail = "-fx-font-size: 14px; -fx-text-fill: #7f8c8d;";
        String styleEventTitle = "-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;";



        //para cada evento na lista cria os labels
        for (Evento evento : eventos) {
            int i = 0;
            Label nomeEvento = new Label(evento.getTitulo());
            Label dataEvento = new Label("Data");
            Label localEvento = new Label("Local");
            Label ticketsEvento = new Label("Tickets");
            Label precoEvento = new Label("Preco");


            //Carregando o FXML Padrao do EventCad
            FXMLLoader loader = new FXMLLoader(EventoContoller.class.getResource("/pacote/mainapp/fxml/EventCard.fxml"));
            Node widget = loader.load();

            EventCardController controller = loader.getController();

            //seta o caminho para o botao de buy
            controller.setPath(paths[i]);
            i++;
            //setando Styles das Labels

            dataEvento.setStyle(styleEventDetail);
            localEvento.setStyle(styleEventDetail);
            ticketsEvento.setStyle(styleEventDetail);
            precoEvento.setStyle(styleEventPrice);

            //Adding Labels no Vbox
            controller.getLabelContainer().getChildren().addAll(nomeEvento,dataEvento, localEvento, ticketsEvento, precoEvento);
            controller.getBtnBuy().setOnAction(EventCardController::BuyBtn);

            //adiciona o EventCard no container
            eventsContainer.getChildren().add(widget);
        }


    }



    @FXML
    private void addEventCard(ActionEvent event) throws IOException {
        createEventCard();
    }
}
