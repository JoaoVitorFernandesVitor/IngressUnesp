package pacote.mainapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pacote.mainapp.models.EventCardBuilder;
import pacote.mainapp.models.Evento;
import pacote.mainapp.models.EventoAcademico;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EventoContoller implements Initializable {


    @FXML
    private VBox eventsContainer;
    private ObservableList<Evento> eventos = FXCollections.observableArrayList();



    private void carregarEventos() {
        List<Evento> eventos = buscarEventos();

        EventCardBuilder builder = new EventCardBuilder();

        for (Evento evento : eventos) {
            try {
                Node card = builder.buildCard(evento, null);
                eventsContainer.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarEventos();
    }

    public List<Evento> buscarEventos() {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT titulo, descricao, data_inicio, preco FROM eventos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                String data_inicio = rs.getString("data_inicio");
                String preco = rs.getString("preco");

                Evento evento = new Evento(titulo, descricao, data_inicio, preco);
                eventos.add(evento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Aqui você pode lançar uma exceção ou logar o erro conforme o caso
        }

        return eventos;
    }

    @FXML
    private void goToMenuInicial(ActionEvent event) {
        try {
            NavigationController.goToMenuInicial((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
