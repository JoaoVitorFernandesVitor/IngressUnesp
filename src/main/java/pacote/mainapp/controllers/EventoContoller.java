package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class EventoContoller {

    @FXML
    private VBox eventsContainer;
    @FXML
    private Button btnLogout;


    public void createEventCard() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacote/mainapp/fxml/EventCard.fxml"));
        Node widget = loader.load();

        eventsContainer.getChildren().add(widget);  //adiciona o EventCard no container
    }

    @FXML
    private void addEventCard(ActionEvent event) throws IOException {
        createEventCard();
    }
}
