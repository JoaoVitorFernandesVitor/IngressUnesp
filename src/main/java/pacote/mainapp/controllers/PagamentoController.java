package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import pacote.mainapp.models.Evento;

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
        // Aqui você pode validar os campos e processar o pagamento (simulado)

        if (cardNumberField.getText().isEmpty() || cardNameField.getText().isEmpty() ||
                expiryField.getText().isEmpty() || cvvField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Por favor, preencha todos os campos.");
            alert.showAndWait();
            return;
        }

        // Simula pagamento aprovado
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Pagamento aprovado!\nEvento: " + eventoTitulo + "\nQuantidade: " + quantidade + "\nTotal: R$ " + String.format("%.2f", precoTotal));
        alert.showAndWait();

        // Voltar para tela principal, ou tela de eventos
        Stage stage = (Stage) cardNumberField.getScene().getWindow();
        stage.close(); // Ou redirecionar para outra tela
    }

    @FXML
    private void cancelarPagamento() {
        // Fecha janela ou volta para tela anterior
        Stage stage = (Stage) cardNumberField.getScene().getWindow();
        stage.close();
    }


    public void setDetalhesPagamento(String titulo, int quantidade, double precoTotal) {
        this.eventoTitulo = titulo;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;

        // Atualiza o label com o preço formatado
        precoTotalLabel.setText(String.format("Total: R$ %.2f", precoTotal));
    }

}
