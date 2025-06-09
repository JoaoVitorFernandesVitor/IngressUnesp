package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import pacote.mainapp.models.*;

import java.io.IOException;
import java.util.Objects;

/**
 * Controller responsável pelo processamento do pagamento dos ingressos.
 * Controla os campos de entrada dos dados do cartão e realiza o cadastro dos ingressos no banco.
 */
public class PagamentoController {


    @FXML
    private Pane pix_Panel;//Painel do Wigets de pix
    @FXML
    private GridPane credito_Pane;//Painel do Wigets de credito
    @FXML
    private Button btn_Cartao;//Botao para ativar os  Wigets de credito
    @FXML
    private Button btn_Pix;//Botao para ativar os  Wigets de pix
    @FXML
    private Button btn_ConfimarCompra;//Botao para cancelar a compra
    @FXML
    private Button btn_Cancelar; //Botao para cancelar a compra
    @FXML
    private Label alert_Label;// Campo para mensagens de alerta
    @FXML
    private TextField cardNumberField; // Campo para número do cartão

    @FXML
    private TextField cardNameField; // Campo para nome no cartão

    @FXML
    private TextField expiryField; // Campo para validade do cartão

    @FXML
    private TextField cvvField;// Campo para código CVV do cartão
    @FXML
    private Label preco_Label;// Label que exibe o preço total da compra
    @FXML
    private Label   quantidade_Label;// Label que exibe quantidade de ingressos total da compra

    private Evento evento;// Objeto do evento para o qual o ingresso será comprado
    private int quantidade;// Quantidade de ingressos a comprar
    private double precoTotal; // Preço total da compra

    /**
     * Confirma o pagamento e cadastra os ingressos no banco.
     * Realiza um cast para identificar o tipo do evento (musical ou acadêmico)
     * e insere a quantidade de ingressos especificada para o usuário logado.
     */
    @FXML
    private void confirmarPagamento(ActionEvent event) {
        if(cardNumberField.getText().equals("") || cardNameField.getText().equals("") || cvvField.getText().equals("")||expiryField.getText().equals("")) {
            alert_Label.setText("Dados incompletos");
            alert_Label.setVisible(true);
        }
        else{
            //Criação do Ingresso
            try{    //Garante que o evento tenha o cast adequado
                EventoMusical evento = (EventoMusical) DatabaseManager.buscarEvento(this.evento.getTitulo());

                StageLogado stage = (StageLogado) preco_Label.getScene().getWindow();
                Cliente usuario = (Cliente) stage.getUsuario();

                for (int i = 0; i < quantidade; i++) {
                    DatabaseManager.cadastrarIngresso(Objects.requireNonNull(evento).getId(), usuario.getEmail(), "Pista");
                }
            }
            catch (ClassCastException e){

                EventoAcademico evento = (EventoAcademico) DatabaseManager.buscarEvento(this.evento.getTitulo());

                StageLogado stage = (StageLogado) preco_Label.getScene().getWindow();
                Cliente usuario = (Cliente) stage.getUsuario();

                for (int i = 0; i < quantidade; i++) {
                    DatabaseManager.cadastrarIngresso(evento.getId(),usuario.getEmail(),"Pista");
                }
            }

            alert_Label.setText("Pagamento efetuado com sucesso");
            alert_Label.setVisible(true);
        }

    }
    /**
     * Aterna os widgets de paragemento da aba Pagemento
     * desativando os widgets de credito e habilitando o de Pix
     *
     */
    @FXML
    private void show_Pix(ActionEvent event) {
        credito_Pane.setVisible(false);
        credito_Pane.setDisable(true);

        pix_Panel.setDisable(false);
        pix_Panel.setVisible(true);
    }

    /**
     * Define os detalhes do pagamento, atualizando o título do evento, quantidade de ingressos
     * e preço total a ser exibido na tela.
     *
     * @param evento Objeto do evento
     * @param quantidade Quantidade de ingressos a comprar
     * @param precoTotal Preço total da compra
     */

    public void setDetalhesPagamento(Evento evento, int quantidade, double precoTotal) {
        this.evento = evento;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;

        // Atualiza o label com o preço formatado
        quantidade_Label.setText(quantidade+"");
        preco_Label.setText(String.format("%.2f", precoTotal));
    }
    /**
     * Aterna os widgets de paragemento da aba Pagemento
     * desativando os widgets de Pix e habilitando o de Credito
     *
     */
        @FXML
    private void show_Credito(ActionEvent event) {
        pix_Panel.setVisible(false);
        pix_Panel.setDisable(true);

        credito_Pane.setDisable(false);
        credito_Pane.setVisible(true);
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
