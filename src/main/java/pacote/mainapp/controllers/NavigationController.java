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

/**
 * Classe utilitária responsável pela navegação entre as diferentes telas da aplicação JavaFX.
 * Todos os métodos recebem um Node de origem para acessar o Stage atual e trocar a cena.
 */
public class NavigationController {

    /**
     * Navega para a tela inicial (MenuInicial.fxml), removendo usuário logado do stage.
     *
     * @param sourceNode Node origem do evento (usado para obter a Stage)
     * @throws IOException caso o FXML não seja encontrado ou carregado
     */
    public static void goToMenuInicial(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/MenuInicial.fxml")));
        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        stage.setUsuario(null);
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela de cadastro de usuário padrão (Cadastro.fxml).
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToCadastro(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/Cadastro.fxml")));
        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela de cadastro de administrador (CadastroAdmin.fxml).
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToCadastroAdmin(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/CadastroAdmin.fxml")));
        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela de login de usuário comum (UserLogin.fxml).
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToUserLogin(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/UserLogin.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela de login de administrador (AdminLogin.fxml).
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToAdminLogin(Node sourceNode) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/AdminLogin.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para o dashboard da aplicação (UNSPDashboard.fxml).
     *
     * @param sourceNode Node origem do evento
     * @param usuario Usuario logado (atualmente não usado na navegação)
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToDashboard(Node sourceNode, Usuario usuario) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/UNSPDashboard.fxml")));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela de eventos (Eventos.fxml) e atribui o usuário logado ao StageLogado.
     *
     * @param sourceNode Node origem do evento
     * @param usuario Usuario logado, pode ser null
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToEventos(Node sourceNode, Usuario usuario) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/Eventos.fxml")));
        Parent root = loader.load();

        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        if (usuario != null) {
            stage.setUsuario(usuario);
        }
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Método genérico para trocar a cena atual para a passada como parâmetro.
     *
     * @param sourceNode Node origem do evento
     * @param scene Cena a ser exibida
     * @throws IOException caso algum erro ocorra
     */
    public static void goTo(Node sourceNode, Scene scene) throws IOException {
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(scene);

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela de cadastro de evento comum (CadastroEvento.fxml).
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToCadastroEvento(Node sourceNode) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/CadastroEvento.fxml")));
        Parent root = loader.load();

        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela de cadastro de evento para administrador (CadastroEventoAdmin.fxml).
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToCadastroEventoAdmin(Node sourceNode) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/CadastroEventoAdmin.fxml")));
        Parent root = loader.load();

        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Navega para a tela administrativa (TelaAdmin.fxml) e configura o controller.
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     * @throws SQLException em caso de erro relacionado ao banco de dados
     */
    public static void goToTelaAdmin(Node sourceNode) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(NavigationController.class.getResource("/pacote/mainapp/fxml/TelaAdmin.fxml"));
        Parent root = loader.load();

        TelaAdminController controller = loader.getController();

        Stage stage = (Stage) sourceNode.getScene().getWindow();

        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setScene(new Scene(root));
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show();
    }

    /**
     * Navega para a tela dos ingressos do usuário logado (MeusIngressos.fxml).
     *
     * @param sourceNode Node origem do evento
     * @throws IOException em caso de erro no carregamento do FXML
     */
    public static void goToMeusIngressos(Node sourceNode) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(NavigationController.class.getResource("/pacote/mainapp/fxml/MeusIngressos.fxml")));
        Parent root = loader.load();

        StageLogado stage = (StageLogado) sourceNode.getScene().getWindow();
        stage.setScene(new Scene(root));

        ajustarTamanho(stage);
        stage.show();
    }

    /**
     * Ajusta o tamanho da janela para manter a largura e altura atuais.
     *
     * @param stage Stage atual da aplicação
     */
    private static void ajustarTamanho(Stage stage) {
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);
    }
}
