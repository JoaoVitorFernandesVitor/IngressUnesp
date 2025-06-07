package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import pacote.mainapp.models.*;

import java.io.IOException;


public class CadastroController {

    public StackPane rootPane;
    public Label errorLabel;
    public Button btnRegister;
    public Button btnBack;

    @FXML private TextField txtNome;
    @FXML private TextField txtEmail;
    @FXML private TextField txtCpf;
    @FXML private TextField txtTelefone;
    @FXML private PasswordField txtSenha;
    @FXML private PasswordField txtConfirmarSenha;

    // Campos de endereço
    @FXML private TextField txtLogradouro;
    @FXML private TextField txtNumero;
    @FXML private TextField txtComplemento;
    @FXML private TextField txtCidade;
    @FXML private TextField txtEstado;
    @FXML private TextField txtCep;
    @FXML private RadioButton rbCliente;
    @FXML private RadioButton rbAdministrador;
    @FXML private TextField txtNivelAcesso;

    @FXML private Label lblMensagem;

    public CadastroController() {

    }

    public CadastroController(Label lblMensagem) {
        this.lblMensagem = lblMensagem;
    }




    @FXML
    private void cadastrarUsuario(ActionEvent event) {
        // Validação básica
        if (!txtSenha.getText().equals(txtConfirmarSenha.getText())) {
            lblMensagem.setText("As senhas não coincidem!");
            return;
        }

        try {
            // Criar endereço
            Endereco endereco = new Endereco(
                    txtLogradouro.getText(),
                    txtNumero.getText(),
                    txtComplemento.getText(),
                    txtCidade.getText(),
                    txtEstado.getText(),
                    txtCep.getText()
            );

            Usuario novoUsuario;
            String tipoUsuario;

            if (rbCliente.isSelected()) {
                novoUsuario = new Cliente();
                tipoUsuario = "cliente";
            } else {
                Administrador admin = new Administrador();
                admin.setNivelAcesso(txtNivelAcesso.getText());
                novoUsuario = admin;
                tipoUsuario = "admin";
            }

            // Criar usuário (usando classe anônima já que Usuario é abstrata)
            novoUsuario.setNome(txtNome.getText());
            novoUsuario.setEmail(txtEmail.getText());
            novoUsuario.setCpf(txtCpf.getText());
            novoUsuario.setTelefone(txtTelefone.getText());
            novoUsuario.setSenha(txtSenha.getText());
            novoUsuario.setEndereco(endereco);

            // Persistir no banco
            if (DatabaseManager.cadastrarUsuario(novoUsuario, tipoUsuario)) {
                lblMensagem.setText("Cadastro realizado com sucesso!");
                NavigationController.goToMenuInicial((Node) event.getSource());
                limparCampos();
            } else {
                lblMensagem.setText("Erro ao cadastrar. Tente novamente.");
            }
        } catch (Exception e) {
            lblMensagem.setText("Erro no formulário: " + e.getMessage());
        }
    }

    @FXML
    private void toggleTipoUsuario(ActionEvent event) {
        txtNivelAcesso.setVisible(rbAdministrador.isSelected());
    }

    private void limparCampos() {
        txtNome.clear();
        txtEmail.clear();
        txtCpf.clear();
        txtTelefone.clear();
        txtSenha.clear();
        txtConfirmarSenha.clear();
        txtLogradouro.clear();
        txtNumero.clear();
        txtComplemento.clear();
        txtCidade.clear();
        txtEstado.clear();
        txtCep.clear();
    }

    @FXML
    private void goToMenuInicial(ActionEvent event) {
        try {
            NavigationController.goToMenuInicial((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}