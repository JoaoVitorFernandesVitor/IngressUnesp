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

public class MeusIngressosContoller implements Initializable {


    @FXML
    private VBox eventsContainer;
    @FXML
    private Label lblWelcome;
    private Usuario usuario;

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
        Platform.runLater(() -> {
            StageLogado stage = (StageLogado) eventsContainer.getScene().getWindow();
            this.usuario = stage.getUsuario();
            lblWelcome.setText("Bem vindo," + stage.getUsuario().getNome());
            carregarEventos();
        });

    }
}
