package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import pacote.mainapp.models.Evento;
import pacote.mainapp.models.Usuario;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

/**
 * Controller para a tela de detalhes do evento.
 * Exibe informações do evento, permite seleção da quantidade de ingressos,
 * mostra o preço total e navega para a tela de pagamento.
 */
public class EventoDetalhadoController {

    @FXML
    private Label eventoTitulo;

    @FXML
    private Text eventoDescricao;

    @FXML
    private Label eventoPreco;

    @FXML
    private Spinner<Integer> quantidadeSpinner;

    @FXML
    private Button comprarButton;

    @FXML
    private ImageView eventoImagem;

    private Evento evento;
    private Usuario usuario;
    private double precoUnitario;

    /**
     * Obtém o usuário atual.
     * @return usuário logado
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Define o usuário atual.
     * @param usuario usuário logado
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Inicializa o controlador.
     * Configura o spinner de quantidade (1 a 10) e atualiza o preço conforme o valor selecionado.
     */
    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        quantidadeSpinner.setValueFactory(valueFactory);

        quantidadeSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            atualizarPreco(newValue);
        });
    }

    /**
     * Define o evento cujos detalhes serão exibidos.
     * Atualiza os campos da tela com os dados do evento.
     * @param evento evento selecionado
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
        atualizarCampos();
    }

    /**
     * Atualiza os campos da interface com os dados do evento.
     * Exibe título, descrição, preço e imagem adequada ao tipo do evento.
     */
    private void atualizarCampos() {
        if (evento == null) return;

        eventoTitulo.setText(evento.getTitulo());
        eventoDescricao.setText(evento.getDescricao());

        precoUnitario = parsePreco(evento.getPreco());
        atualizarPreco(quantidadeSpinner.getValue());

        String tipo = evento.getTipo() != null ? evento.getTipo().toLowerCase(Locale.ROOT) : "";
        String imagePath = switch (tipo) {
            case "academico" -> "/pacote/mainapp/img/academico.png";
            case "musical" -> "/pacote/mainapp/img/musical.png";
            default -> "/pacote/mainapp/img/unespLogo.png";
        };

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        eventoImagem.setImage(image);
    }

    /**
     * Atualiza o label do preço total conforme a quantidade selecionada.
     * @param quantidade quantidade de ingressos selecionada
     */
    private void atualizarPreco(int quantidade) {
        double precoTotal = precoUnitario * quantidade;
        eventoPreco.setText(String.format("R$ %.2f", precoTotal));
    }

    /**
     * Converte o valor do preço para double, aceitando objetos Number ou Strings.
     * Retorna 0.0 se não for possível converter.
     * @param preco objeto que representa o preço
     * @return valor numérico do preço
     */
    private double parsePreco(Object preco) {
        if (preco == null) return 0.0;

        if (preco instanceof Number) {
            return ((Number) preco).doubleValue();
        }

        if (preco instanceof String) {
            try {
                return Double.parseDouble(((String) preco).replace(",", "."));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0.0;
            }
        }
        return 0.0;
    }

    /**
     * Abre a tela de pagamento, passando detalhes do evento e preço total.
     */
    @FXML
    private void abrirTelaPagamento() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pacote/mainapp/fxml/Pagemento.fxml"));
            Parent root = loader.load();

            PagamentoController pagamentoController = loader.getController();

            int quantidade = quantidadeSpinner.getValue();
            double precoTotal = precoUnitario * quantidade;

            pagamentoController.setDetalhesPagamento(evento, quantidade, precoTotal);

            Scene scene = new Scene(root);
            Stage stage = (Stage) comprarButton.getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Navega de volta para a tela de eventos, passando o usuário atual.
     * @param event evento da ação de clique
     */
    @FXML
    private void goToEventos(ActionEvent event) {
        try {
            NavigationController.goToEventos((Node) event.getSource(), getUsuario());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
