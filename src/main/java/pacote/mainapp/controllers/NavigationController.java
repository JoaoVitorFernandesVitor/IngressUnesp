// NavigationController.java
package pacote.mainapp.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NavigationController {

    public static void goToMenuInicial(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/MenuInicial.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void goToCadastro(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/Cadastro.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}