package pacote.mainapp.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;


import java.io.IOException;

public class LoginController extends MainController {

    public Button btnRegister;
    public StackPane rootPane;
    public Button btnAdminLogin;
    public Button btnUserLogin;
    //widgets FXML UNSPLogin
    @FXML private TextField username;
    @FXML private PasswordField password;


    //Metodo para ir para a tela de login dos usuarios
    public void goToUserLogin(ActionEvent event) throws IOException {
        setNextStage("UserLogin.fxml");     //a variavel NextStage armazena o nome do arquivo da proxima page
        setStage(event);                    //função da classe MainCrontroller que altera para a tela referente a variavel NextStage
    }


    //Metodo que realiza a verificação do usuario e senha
    public void loginValider(ActionEvent event) throws IOException {
        if(username.getText().equals("abacaxi") && password.getText().equals("1234")){
            setNextStage("UNSPDashboard.fxml");
            setStage(event);
        }
    }
}
