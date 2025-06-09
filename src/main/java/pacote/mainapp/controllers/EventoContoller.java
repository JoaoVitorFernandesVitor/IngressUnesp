package pacote.mainapp.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pacote.mainapp.models.*;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EventoContoller implements Initializable {


    @FXML
    private VBox eventsContainer;
    @FXML private Label lblWelcome;

    public void carregarEventos() {

        ;
        List<Evento> eventos = DatabaseManager.buscarEventos();
        EventCardBuilder builder = new EventCardBuilder();

        for (Evento evento : eventos) {
            try {
                Node card = builder.buildCard(evento);
                eventsContainer.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    @FXML
    private void gotoMenuIngressos(ActionEvent event) {
        try {
            NavigationController.goToMeusIngressos((Node)event.getSource());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void goToMenuInicial(ActionEvent event) {
        try {
            NavigationController.goToMenuInicial((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarEventos();
        Platform.runLater(() -> {
            StageLogado stage = (StageLogado) eventsContainer.getScene().getWindow();
            lblWelcome.setText("Bem vindo," + stage.getUsuario().getNome());
        });

    }
}
