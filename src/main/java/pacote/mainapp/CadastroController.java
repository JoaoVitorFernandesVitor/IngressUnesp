package pacote.mainapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CadastroController extends MainController {

    @FXML private TextField txtNomeCliente;
    @FXML private TextField txtCpfCliente;
    @FXML private TextField txtTelefoneCliente;
    @FXML private TextField txtEmailCliente;
    @FXML private PasswordField txtSenhaCliente;
    @FXML private PasswordField txtConfirmSenhaCliente;
    @FXML private Label errorLabel;
    private String ErrorMensage;

    public void cadastrarCliente(ActionEvent event)
    {
        errorLabel.setText(""); //limpa o conteudo da label
        if (txtNomeCliente.getText().isBlank() || txtCpfCliente.getText().isBlank() || txtEmailCliente.getText().isBlank()
        || txtSenhaCliente.getText().isBlank() || txtConfirmSenhaCliente.getText().isBlank() || txtTelefoneCliente.getText().isBlank()){
            //esse if verifica se as entradas das entrys estão em branco, caso tenha alguma ela gera a mensagem para o usuario
            ErrorMensage = "Não é permitido campos em branco";
            errorLabel.setText(ErrorMensage);
        }
        else{
            //continuar o cadastramento do usuario
        }

    }

    //Metodo para ir para a tela de cadastro de usuario
    public void goToMenuInicial(ActionEvent event) throws IOException {
        setNextStage("MenuInicial.fxml");  //a variavel NextStage armazena o nome do arquivo da proxima page
        setStage(event);                //função da classe MainCrontroller que altera para a tela referente a variavel NextStage
    }


}
