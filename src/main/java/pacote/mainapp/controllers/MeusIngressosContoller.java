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
 * Controller responsável pela tela de visualização dos ingressos do usuário logado.
 * Implementa Initializable para carregar os ingressos assim que a tela é inicializada.
 */
public class MeusIngressosContoller implements Initializable {

    /** Container onde os cards dos ingressos são adicionados dinamicamente */
    @FXML
    private VBox eventsContainer;

    /** Label que exibe a mensagem de boas-vindas ao usuário */
    @FXML
    private Label lblWelcome;

    /** Usuário logado que está visualizando seus ingressos */
    private Usuario usuario;

    /**
     * Carrega os ingressos do usuário e adiciona os cards correspondentes no container da interface.
     */
    public void carregarEventos() {
        List<Ingresso> listaIngressos = DatabaseManager.getIngressosPorUsuario(usuario.getEmail());
        EventCardBuilder builder = new EventCardBuilder();

        for (Ingresso ingresso : listaIngressos) {
            try {
                Node ingressoCard = builder.buildIngressoCard(ingresso);
                eventsContainer.getChildren().add(ingressoCard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Recarrega a tela de ingressos do usuário.
     *
     * @param event Evento de ação associado à navegação
     */
    @FXML
    private void gotoMenuIngressos(ActionEvent event) {
        try {
            NavigationController.goToMeusIngressos((Node)event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega para a tela de listagem de eventos disponíveis.
     *
     * @param event Evento de ação associado à navegação
     */
    @FXML
    private void goToEventos(ActionEvent event) {
        try {
            NavigationController.goToEventos((Node)event.getSource(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega para a tela inicial do sistema.
     *
     * @param event Evento de ação associado à navegação
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
     * Inicializa a tela carregando o usuário logado e seus ingressos.
     *
     * @param url URL usada para carregar recursos (não utilizada)
     * @param resourceBundle Recursos locais para internacionalização (não utilizado)
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            StageLogado stage = (StageLogado) eventsContainer.getScene().getWindow();
            this.usuario = stage.getUsuario();
            lblWelcome.setText("Bem vindo, " + stage.getUsuario().getNome());
            carregarEventos();
        });
    }
}
