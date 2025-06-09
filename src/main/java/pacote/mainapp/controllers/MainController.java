package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Controller da tela principal da aplicação,
 * iniciais como cadastro, login de usuário e login de administrador.
 */
public class MainController {

    /** Botão para acesso à tela de login de usuário */
    public Button btnUserLogin;

    /** Botão para acesso à tela de login de administrador */
    public Button btnAdminLogin;

    /** Botão para acesso à tela de cadastro */
    public Button btnRegister;

    /** Pane raiz da interface, utilizado para gerenciar a exibição das telas */
    public StackPane rootPane;

    /**
     * Navega para a tela de cadastro de usuário.
     *
     * @param event Evento gerado ao clicar no botão de cadastro
     */
    @FXML
    private void goToCadastro(ActionEvent event) {
        try {
            NavigationController.goToCadastro((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega para a tela de login de usuário comum.
     *
     * @param event Evento gerado ao clicar no botão de login de usuário
     */
    @FXML
    private void goToUserLogin(ActionEvent event) {
        try {
            NavigationController.goToUserLogin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega para a tela de login de administrador.
     *
     * @param event Evento gerado ao clicar no botão de login de administrador
     */
    @FXML
    private void goToAdminLogin(ActionEvent event) {
        try {
            NavigationController.goToAdminLogin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
