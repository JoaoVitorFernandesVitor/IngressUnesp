package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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

    @FXML
    public void initialize() {
        // Define o spinner para valores entre 1 e 10 por padrão
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        quantidadeSpinner.setValueFactory(valueFactory);
    }

    // Setters para atualizar a interface com os dados do evento
    public void setEventoTitulo(String titulo) {
        eventoTitulo.setText(titulo);
    }

    public void setEventoDescricao(String descricao) {
        eventoDescricao.setText(descricao);
    }

    public void setEventoPreco(String preco) {
        eventoPreco.setText("R$ " + preco);
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
}
