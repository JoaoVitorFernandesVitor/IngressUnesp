package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import pacote.mainapp.models.*;

public class CadastroEventoController {

    public StackPane rootPane;
    public Label lblMensagem;

    @FXML private TextField txtTitulo;
    @FXML private TextArea txtDescricao;
    @FXML private TextField txtDataInicio;
    @FXML private TextField txtDataFim;
    @FXML private TextField txtPreco;

    // Endereço
    @FXML private TextField txtNomeLocal;
    @FXML private TextField txtLogradouro;
    @FXML private TextField txtNumero;
    @FXML private TextField txtComplemento;
    @FXML private TextField txtCidade;
    @FXML private TextField txtEstado;
    @FXML private TextField txtCep;

    // Tipo de evento
    @FXML private RadioButton rbMusical;
    @FXML private RadioButton rbAcademico;

    // Campos específicos
    @FXML private TextField txtEstiloMusical;
    @FXML private TextField txtBanda;
    @FXML private TextField txtPalestrante;
    @FXML private TextField txtTopico;

    @FXML
    private void toggleTipoEvento(ActionEvent event) {
        boolean isMusical = rbMusical.isSelected();
        txtEstiloMusical.setVisible(isMusical);
        txtBanda.setVisible(isMusical);

        txtPalestrante.setVisible(!isMusical);
        txtTopico.setVisible(!isMusical);
    }

    @FXML
    private void cadastrarEvento(ActionEvent event) {
        try {
            // Criar endereço
            Endereco local = new Endereco(
                    txtLogradouro.getText(),
                    txtNumero.getText(),
                    txtComplemento.getText(),
                    txtCidade.getText(),
                    txtEstado.getText(),
                    txtCep.getText()
            );

            Evento novoEvento;
            String tipoEvento;

            if (rbMusical.isSelected()) {
                EventoMusical musical = new EventoMusical();
                musical.setEstiloMusical(txtEstiloMusical.getText());
                musical.setBanda(txtBanda.getText());
                novoEvento = musical;
                tipoEvento = "musical";
            } else {
                EventoAcademico academico = new EventoAcademico();
                academico.setPalestrante(txtPalestrante.getText());
                academico.setTopico(txtTopico.getText());
                novoEvento = academico;
                tipoEvento = "academico";
            }

            // Preencher dados comuns
            novoEvento.setTitulo(txtTitulo.getText());
            novoEvento.setDescricao(txtDescricao.getText());
            novoEvento.setData_inicio(txtDataInicio.getText());
            novoEvento.setData_fim(txtDataFim.getText());
            novoEvento.setPreco(Double.parseDouble(txtPreco.getText()));
            novoEvento.setLocal(local);

            // Salvar no banco
            if (DatabaseManager.cadastrarEvento(novoEvento, tipoEvento)) {
                lblMensagem.setText("Evento cadastrado com sucesso!");
                NavigationController.goToMenuInicial((Node) event.getSource());
                limparCampos();
            } else {
                lblMensagem.setText("Erro ao cadastrar evento.");
            }

        } catch (Exception e) {
            lblMensagem.setText("Erro no formulário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        txtTitulo.clear();
        txtDescricao.clear();
        txtDataInicio.clear();
        txtDataFim.clear();
        txtPreco.clear();

        txtNomeLocal.clear();
        txtLogradouro.clear();
        txtNumero.clear();
        txtComplemento.clear();
        txtCidade.clear();
        txtEstado.clear();
        txtCep.clear();

        txtEstiloMusical.clear();
        txtBanda.clear();
        txtPalestrante.clear();
        txtTopico.clear();
    }

    @FXML
    private void goToMenuInicial(ActionEvent event) {
        try {
            NavigationController.goToMenuInicial((Node) event.getSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
