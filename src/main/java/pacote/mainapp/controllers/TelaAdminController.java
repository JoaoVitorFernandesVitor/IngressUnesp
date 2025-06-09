package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pacote.mainapp.models.DatabaseManager;
import pacote.mainapp.models.Usuario;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaAdminController {

    public Label labelOlaUsuario;
    private String emailUsuario;
    private Stage stage;
    private Scene scene;

    public void setEmailUsuario(String email) {
        this.emailUsuario = email;
    }

    @FXML
    private void goToCadastro(ActionEvent event) {
        try {
            NavigationController.goToCadastro((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToCadastroEvento(ActionEvent event) {
        try {
            NavigationController.goToCadastroEvento((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarSaudacao() {
        if (emailUsuario != null) {
            Usuario usuario = DatabaseManager.buscarUsuarioPorEmail(emailUsuario);
            if (usuario != null) {
                labelOlaUsuario.setText("Olá, " + usuario.getNome() + "!");
            }
        }
    }
}
