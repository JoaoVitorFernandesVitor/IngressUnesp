package pacote.mainapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pacote.mainapp.models.EventCardBuilder;
import pacote.mainapp.models.Evento;
import pacote.mainapp.models.EventoAcademico;

import java.io.IOException;

public class EventoContoller {


    @FXML
    private VBox eventsContainer;
    private ObservableList<Evento> eventos = FXCollections.observableArrayList();


    public Node createEventCard() throws IOException {

        Evento evento1 = new EventoAcademico();
        Evento evento2 = new EventoAcademico();

        evento2.setTitulo("Evento de Academico");
        eventos.addAll(evento1, evento2);
        String[] paths = {"/pacote/mainapp/fxml/UNSPDashboard.fxml", "/pacote/mainapp/fxml/Cadastro.fxml"};
        int i = 0;
        //para cada evento na lista cria os labels
        for (Evento evento : eventos) {
            //adiciona o EventCard no container
            eventsContainer.getChildren().add(new EventCardBuilder().buildCard(evento, paths[i]));
            i++;
        }


        return null;
    }

    @FXML
    private void addEventCard(ActionEvent event) throws IOException {
        createEventCard();
    }
}
