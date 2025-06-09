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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @FXML
    public void initialize() {
        // Configura spinner (1 a 10 ingressos)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        quantidadeSpinner.setValueFactory(valueFactory);

        // Atualiza preço quando quantidade muda
        quantidadeSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            atualizarPreco(newValue);
        });
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
        atualizarCampos();
    }

    private void atualizarCampos() {
        if (evento == null) return;

        eventoTitulo.setText(evento.getTitulo());
        eventoDescricao.setText(evento.getDescricao());

        precoUnitario = parsePreco(evento.getPreco());
        atualizarPreco(quantidadeSpinner.getValue());

        // Define imagem conforme tipo
        String tipo = evento.getTipo() != null ? evento.getTipo().toLowerCase(Locale.ROOT) : "";
        String imagePath = switch (tipo) {
            case "academico" -> "/pacote/mainapp/img/academico.png";
            case "musical" -> "/pacote/mainapp/img/musical.png";
            default -> "/pacote/mainapp/img/unespLogo.png";
        };

        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        eventoImagem.setImage(image);
    }

    private void atualizarPreco(int quantidade) {
        double precoTotal = precoUnitario * quantidade;
        eventoPreco.setText(String.format("R$ %.2f", precoTotal));
    }

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

    @FXML
    private void goToEventos(ActionEvent event) {
        try {
            NavigationController.goToEventos((Node) event.getSource(), getUsuario());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
