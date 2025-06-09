package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import pacote.mainapp.models.*;

import java.io.IOException;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class PagamentoController2 {


    @FXML
    private Pane pix_Panel;
    @FXML
    private GridPane credito_Pane;
    @FXML
    private Button btn_Cartao;
    @FXML
    private Button btn_Pix;
    @FXML
    private Button btn_ConfimarCompra;
    @FXML
    private Button btn_Cancelar;
    @FXML
    private Label alert_Label;
    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField cardNameField;
    @FXML
    private TextField expiryField;
    @FXML
    private TextField cvvField;
    @FXML
    private Label preco_Label;
    @FXML
    private Label   quantidade_Label;

    private Evento evento;
    private int quantidade;
    private double precoTotal;

    @FXML
    private void confirmarPagamento(ActionEvent event) {
        if(cardNumberField.getText().equals("") || cardNameField.getText().equals("") || cvvField.getText().equals("")||expiryField.getText().equals("")) {
            alert_Label.setText("Dados incompletos");
            alert_Label.setVisible(true);
        }
        alert_Label.setText("Pagamento efetuado com sucesso");
        alert_Label.setVisible(true);
    }

    @FXML
    private void show_Pix(ActionEvent event) {
        credito_Pane.setVisible(false);
        credito_Pane.setDisable(true);

        pix_Panel.setDisable(false);
        pix_Panel.setVisible(true);
    }

    @FXML
    private void show_Credito(ActionEvent event) {
        pix_Panel.setVisible(false);
        pix_Panel.setDisable(true);

        credito_Pane.setDisable(false);
        credito_Pane.setVisible(true);
    }


    @FXML
    private void goToEventos(ActionEvent event) {
        try {
            NavigationController.goToEventos((Node) event.getSource(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDetalhesPagamento(Evento evento, int quantidade, double precoTotal) {
        this.evento = evento;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;

        // Atualiza o label com o preço formatado
        quantidade_Label.setText(quantidade+"");
        preco_Label.setText(String.format("%.2f", precoTotal));
    }

}
