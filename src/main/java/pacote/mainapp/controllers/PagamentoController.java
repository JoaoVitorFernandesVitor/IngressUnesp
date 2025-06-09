package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import pacote.mainapp.models.*;
import java.io.IOException;

public class PagamentoController {

    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField cardNameField;
    @FXML
    private TextField expiryField;
    @FXML
    private TextField cvvField;

    @FXML
    private Label precoTotalLabel;

    private String eventoTitulo;
    private int quantidade;
    private double precoTotal;


    @FXML
    private void confirmarPagamento() {

        //Criação do Ingresso
        try{//Garante que o evento tenha o cast adequado
            EventoMusical evento = (EventoMusical) DatabaseManager.buscarEvento(eventoTitulo);

            StageLogado stage = (StageLogado) precoTotalLabel.getScene().getWindow();
            Cliente usuario = (Cliente) stage.getUsuario();

            for (int i = 0; i < quantidade; i++) {

                IngressoUnico novoIngresso = new IngressoUnico(evento);
                novoIngresso.setPreco(evento.getPreco());

                usuario.incluirIngresso(novoIngresso);
            }
        }
        catch (ClassCastException e){

            EventoAcademico evento = (EventoAcademico) DatabaseManager.buscarEvento(eventoTitulo);

            StageLogado stage = (StageLogado) precoTotalLabel.getScene().getWindow();
            Cliente usuario = (Cliente) stage.getUsuario();

            for (int i = 0; i < quantidade; i++) {

                IngressoUnico novoIngresso = new IngressoUnico(evento);
                novoIngresso.setPreco(evento.getPreco());

                usuario.incluirIngresso(novoIngresso);
            }
        }

    }

    public void setDetalhesPagamento(String titulo, int quantidade, double precoTotal) {
        this.eventoTitulo = titulo;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;

        // Atualiza o label com o preço formatado
        precoTotalLabel.setText(String.format("Total: R$ %.2f", precoTotal));
    }

    @FXML
    private void goToEventos(ActionEvent event) {
        try {
            NavigationController.goToEventos((Node) event.getSource(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
;

}
