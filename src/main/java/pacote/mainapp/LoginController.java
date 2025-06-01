package pacote.mainapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

public class LoginController extends MainController {

    //widgets FXML UNSPLogin
    @FXML private TextField username;
    @FXML private PasswordField password;


    //Metodo para ir para a tela de login dos usuarios
    public void goToUserLogin(ActionEvent event) throws IOException {
        setNextStage("UNSPLogin.fxml");     //a variavel NextStage armazena o nome do arquivo da proxima page
        setStage(event);                    //função da classe MainCrontroller que altera para a tela referente a variavel NextStage
    }

    //Metodo para ir para a tela de cadastro de usuario
    public void goToCadastro(ActionEvent event) throws IOException {
        setNextStage("Cadastro.fxml");  //a variavel NextStage armazena o nome do arquivo da proxima page
        setStage(event);                //função da classe MainCrontroller que altera para a tela referente a variavel NextStage
    }


    //Metodo que realiza a verificação do usuario e senha
    public void loginValider(ActionEvent event) throws IOException {
        if(username.getText().equals("abacaxi") && password.getText().equals("1234")){
            setNextStage("UNSPDashboard.fxml");
            setStage(event);
        }
    }
}
