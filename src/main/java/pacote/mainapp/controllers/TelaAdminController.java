package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import pacote.mainapp.models.StageLogado;
import pacote.mainapp.models.Usuario;

import java.io.IOException;

/**
 * Controller da tela administrativa.
 * Responsável por gerenciar ações da interface de administração,
 * como navegação para cadastro de usuários e eventos,
 * além da saudação ao usuário administrador logado.
 */
public class TelaAdminController {

    /**
     * Label que exibe a saudação ao usuário logado.
     */
    public Label labelOlaUsuario;

    /**
     * Navega para a tela de cadastro de administradores.
     *
     * @param event evento de ação (ex: clique no botão)
     */
    @FXML
    private void goToCadastro(ActionEvent event) {
        try {
            NavigationController.goToCadastroAdmin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navega para a tela de cadastro de eventos para administradores.
     *
     * @param event evento de ação
     */
    @FXML
    private void goToCadastroEvento(ActionEvent event) {
        try {
            NavigationController.goToCadastroEventoAdmin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Atualiza o texto de saudação exibido na label, usando o nome do usuário logado.
     */
    public void atualizarSaudacao() {
        StageLogado stage = (StageLogado) labelOlaUsuario.getScene().getWindow();
        Usuario usuario = stage.getUsuario();
        labelOlaUsuario.setText("Olá, " + usuario.getNome() + "!");
    }

    /**
     * Navega para a tela inicial do aplicativo.
     *
     * @param event evento de ação
     */
    @FXML
    private void goToMenuInicial(ActionEvent event) {
        try {
            NavigationController.goToMenuInicial((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
