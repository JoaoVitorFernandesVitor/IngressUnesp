package pacote.mainapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class UNSPEventoController {

    @FXML private Label eventoTitulo;
    @FXML private Text eventoDescricao;
    @FXML private Label eventoPreco;

    public void setEventoDescricao(String descricao) {
        this.eventoDescricao.setText(descricao);
    }

    public void setEventoPreco(String preco) {
        this.eventoPreco.setText(preco);
    }

    public void setEventoTitulo(String titulo) {
        this.eventoTitulo.setText(titulo);
    }
}
