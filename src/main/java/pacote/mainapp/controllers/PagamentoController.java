package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pacote.mainapp.models.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Controller responsável pelo processamento do pagamento dos ingressos.
 * Controla os campos de entrada dos dados do cartão e realiza o cadastro dos ingressos no banco.
 */
public class PagamentoController {

    @FXML
    private TextField cardNumberField; // Campo para número do cartão

    @FXML
    private TextField cardNameField; // Campo para nome no cartão

    @FXML
    private TextField expiryField; // Campo para validade do cartão

    @FXML
    private TextField cvvField; // Campo para código CVV do cartão

    @FXML
    private Label precoTotalLabel; // Label que exibe o preço total da compra

    private String eventoTitulo; // Título do evento para o qual o ingresso será comprado
    private int quantidade; // Quantidade de ingressos a comprar
    private double precoTotal; // Preço total da compra

    /**
     * Confirma o pagamento e cadastra os ingressos no banco.
     * Realiza um cast para identificar o tipo do evento (musical ou acadêmico)
     * e insere a quantidade de ingressos especificada para o usuário logado.
     */
    @FXML
    private void confirmarPagamento() {
        try {
            // Tenta tratar o evento como EventoMusical
            EventoMusical evento = (EventoMusical) DatabaseManager.buscarEvento(eventoTitulo);

            StageLogado stage = (StageLogado) precoTotalLabel.getScene().getWindow();
            Cliente usuario = (Cliente) stage.getUsuario();

            for (int i = 0; i < quantidade; i++) {
                DatabaseManager.cadastrarIngresso(Objects.requireNonNull(evento).getId(), usuario.getEmail(), "Pista");
            }
        } catch (ClassCastException e) {
            // Caso não seja EventoMusical, trata como EventoAcademico
            EventoAcademico evento = (EventoAcademico) DatabaseManager.buscarEvento(eventoTitulo);

            StageLogado stage = (StageLogado) precoTotalLabel.getScene().getWindow();
            Cliente usuario = (Cliente) stage.getUsuario();

            for (int i = 0; i < quantidade; i++) {
                DatabaseManager.cadastrarIngresso(evento.getId(), usuario.getEmail(), "Pista");
            }
        }
    }

    /**
     * Define os detalhes do pagamento, atualizando o título do evento, quantidade de ingressos
     * e preço total a ser exibido na tela.
     *
     * @param titulo Título do evento
     * @param quantidade Quantidade de ingressos a comprar
     * @param precoTotal Preço total da compra
     */
    public void setDetalhesPagamento(String titulo, int quantidade, double precoTotal) {
        this.eventoTitulo = titulo;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;

        precoTotalLabel.setText(String.format("Total: R$ %.2f", precoTotal));
    }

    /**
     * Navega de volta para a tela de eventos.
     *
     * @param event Evento acionado (botão ou ação de navegação)
     */
    @FXML
    private void goToEventos(ActionEvent event) {
        try {
            NavigationController.goToEventos((Node) event.getSource(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
