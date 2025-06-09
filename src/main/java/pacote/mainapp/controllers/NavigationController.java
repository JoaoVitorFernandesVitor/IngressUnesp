package pacote.mainapp.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pacote.mainapp.models.StageLogado;
import pacote.mainapp.models.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class NavigationController {

    public static void goToMenuInicial(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/MenuInicial.fxml")));
        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        stage.setUsuario(null);
        stage.setScene(new Scene(root));


        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goToCadastro(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/Cadastro.fxml")));
        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goToUserLogin(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/UserLogin.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goToAdminLogin(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/AdminLogin.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goToDashboard(Node sourceNode, Usuario usuario) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/UNSPDashboard.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goToEventos (Node sourceNode, Usuario usuario) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/Eventos.fxml")));
        Parent root = loader.load();


        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        if(usuario != null) {stage.setUsuario(usuario);} //garante que nao seja alocado um usuario vazio
        stage.setScene(new Scene(root));

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goTo (Node sourceNode, Scene scene) throws IOException {


        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(scene);

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);


        stage.show();


    }

    public static void goToCadastroEvento(Node sourceNode) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/CadastroEvento.fxml")));
        Parent root = loader.load();


        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goToTelaAdmin(Node sourceNode, String email) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(NavigationController.class.getResource("/pacote/mainapp/fxml/TelaAdmin.fxml"));
        Parent root = loader.load();

        // Pega o controller da tela carregada
        TelaAdminController controller = loader.getController();
        controller.setEmailUsuario(email);
        controller.atualizarSaudacao();

        Stage stage = (Stage) sourceNode.getScene().getWindow();

        // Mantém o tamanho atual da janela
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setScene(new Scene(root));
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    public static void goToMeusIngressos(Node sourceNode) throws IOException {

    }
}