package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


import java.io.IOException;


public class MainController {

    public Button btnUserLogin;
    public Button btnAdminLogin;
    public Button btnRegister;
    public StackPane rootPane;

    @FXML
    private void goToCadastro(ActionEvent event) {
        try {
            NavigationController.goToCadastro((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToUserLogin(ActionEvent event) {
        try {
            NavigationController.goToUserLogin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToAdminLogin(ActionEvent event) {
        try {
            NavigationController.goToAdminLogin((Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}