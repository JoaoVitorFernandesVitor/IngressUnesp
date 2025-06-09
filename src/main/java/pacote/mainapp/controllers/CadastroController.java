package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;


/**
 * Controller responsável pelo cadastro de usuários no sistema.
 * Controla a interface gráfica para registrar clientes ou administradores.
 */
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

    /**
     * Construtor padrão do controller.
     */
    public CadastroController() {}

    /**
     * Construtor que recebe uma Label para exibir mensagens.
     *
     * @param lblMensagem Label para mostrar mensagens de feedback ao usuário.
     */
    public CadastroController(Label lblMensagem) {
        this.lblMensagem = lblMensagem;
    }

    /**
     * Método acionado ao clicar no botão de cadastro.
     * Valida os campos, cria objeto Usuario (Cliente ou Administrador),
     * persiste no banco e navega para tela administrativa em caso de sucesso.
     *
     * @param event Evento de ação do botão.
     */
    @FXML
    private void cadastrarUsuario(ActionEvent event) {
        // validação e cadastro...
    }

    /**
     * Alterna a visibilidade do campo de nível de acesso dependendo do tipo de usuário selecionado.
     *
     * @param event Evento de ação dos RadioButtons.
     */
    @FXML
    private void toggleTipoUsuario(ActionEvent event) {
        // alterna visibilidade txtNivelAcesso
    }

    /**
     * Limpa todos os campos do formulário.
     */
    private void limparCampos() {
        // limpa os campos
    }

    /**
     * Navega para a tela inicial.
     *
     * @param event Evento de ação para voltar ao menu inicial.
     */
    @FXML
    private void goToMenuInicial(ActionEvent event) {
        // navega para menu inicial
    }

    /**
     * Navega para a tela administrativa.
     *
     * @param event Evento de ação para ir à tela administrativa.
     */
    @FXML
    private void goToAdminMenu(ActionEvent event) {
        // navega para tela admin
    }
}
