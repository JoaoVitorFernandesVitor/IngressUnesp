package pacote.mainapp.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import pacote.mainapp.models.DatabaseManager;
import pacote.mainapp.models.Usuario;


import java.io.IOException;

public class LoginController extends MainController {


    public StackPane rootPane;
    public Button loginButton;
    public Button cancelButton;

    @FXML private TextField txtLoginEmail;
    @FXML private PasswordField password;
    @FXML private Label lblLoginMensagem;


    @FXML
    private void validarAdminLogin(ActionEvent event) {
        String email = txtLoginEmail.getText();
        String senha = password.getText();

        if (email.isEmpty() || senha.isEmpty()) {
            lblLoginMensagem.setText("Email e senha são obrigatórios.");
            return;
        }

        try {
            Usuario usuario = DatabaseManager.buscarUsuarioPorEmail(email);

            if (usuario != null && usuario.getSenha().equals(senha)){
                lblLoginMensagem.setText("Login realizado com sucesso!");
                NavigationController.goToTelaAdmin((Node) event.getSource(), email);
            } else {
                lblLoginMensagem.setText("Email ou senha inválidos.");
            }
        } catch (Exception e) {
            lblLoginMensagem.setText("Erro ao realizar login: " + e.getMessage());
        }
    }

    @FXML
    private void validarLogin(ActionEvent event) {
        String email = txtLoginEmail.getText();
        String senha = password.getText();

        if (email.isEmpty() || senha.isEmpty()) {
            lblLoginMensagem.setText("Email e senha são obrigatórios.");
            return;
        }

        try {
            Usuario usuario = DatabaseManager.buscarUsuarioPorEmail(email);

            if (usuario != null && usuario.getSenha().equals(senha)) {
                lblLoginMensagem.setText("Login realizado com sucesso!");

                NavigationController.goToEventos((Node) event.getSource(), usuario);
            } else {
                lblLoginMensagem.setText("Email ou senha inválidos.");
            }
        } catch (Exception e) {
            lblLoginMensagem.setText("Erro ao realizar login: " + e.getMessage());
        }
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
