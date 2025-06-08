package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

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

    private double precoUnitario;

    @FXML
    public void initialize() {
        // Configura o Spinner para aceitar valores mínimos e máximos (exemplo 1 a 10 ingressos)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        quantidadeSpinner.setValueFactory(valueFactory);

        // Listener para atualizar o preço toda vez que a quantidade mudar
        quantidadeSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            atualizarPreco(newValue);
        });
    }

    // Setters para atualizar a interface com os dados do evento
    public void setEventoTitulo(String titulo) {
        eventoTitulo.setText(titulo);
    }

    public void setEventoDescricao(String descricao) {
        eventoDescricao.setText(descricao);
    }

    public void setEventoPreco(Object preco) {
        this.precoUnitario = parsePreco(preco);
        eventoPreco.setText(String.format("R$ %.2f", precoUnitario));
    }


    public void setEventoImagem(Image imagem) {
        eventoImagem.setImage(imagem);
    }

    // Getter para quantidade selecionada (caso precise)
    public int getQuantidadeSelecionada() {
        return quantidadeSpinner.getValue();
    }

    public Button getComprarButton() {
        return comprarButton;
    }

    @FXML
    private void goToEventos(ActionEvent event) {
        try {
            NavigationController.goToEventos((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        // Caso o preço esteja em outro formato, retorna 0
        return 0.0;
    }

}
