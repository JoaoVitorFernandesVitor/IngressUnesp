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
import pacote.mainapp.models.StageLogado;
import pacote.mainapp.models.Usuario;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaAdminController {

    public Label labelOlaUsuario;



    @FXML
    private void goToCadastro(ActionEvent event) {
        try {
            NavigationController.goToCadastroAdmin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToCadastroEvento(ActionEvent event) {
        try {
            NavigationController.goToCadastroEventoAdmin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarSaudacao() {
        StageLogado stage = (StageLogado)labelOlaUsuario.getScene().getWindow();
        Usuario usuario = stage.getUsuario();
        labelOlaUsuario.setText("Olá, " + usuario.getNome() + "!");
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
