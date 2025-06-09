package pacote.mainapp.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pacote.mainapp.models.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller responsável por gerenciar a tela que exibe a lista de eventos.
 * Realiza o carregamento dos eventos do banco, criação dos cartões de evento e
 * navegação para outras telas.
 */
public class EventoContoller implements Initializable {

    @FXML
    private VBox eventsContainer;

    @FXML
    private Label lblWelcome;

    /**
     * Carrega os eventos do banco de dados e adiciona os cartões correspondentes
     * ao container visual na interface.
     */
    public void carregarEventos() {
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

    /**
     * Navega para o menu de ingressos do usuário.
     *
     * @param event Evento da ação de clique.
     */
    @FXML
    private void gotoMenuIngressos(ActionEvent event) {
        try {
            NavigationController.goToMeusIngressos((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega para o menu inicial da aplicação.
     *
     * @param event Evento da ação de clique.
     */
    @FXML
    private void goToMenuInicial(ActionEvent event) {
        try {
            NavigationController.goToMenuInicial((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método chamado automaticamente após o carregamento do FXML.
     * Inicializa a lista de eventos e configura a mensagem de boas-vindas ao usuário.
     *
     * @param url            URL do recurso.
     * @param resourceBundle Bundle de recursos.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarEventos();
        Platform.runLater(() -> {
            StageLogado stage = (StageLogado) eventsContainer.getScene().getWindow();
            lblWelcome.setText("Bem vindo, " + stage.getUsuario().getNome());
        });
    }
}
