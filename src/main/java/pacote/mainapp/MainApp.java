package pacote.mainapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pacote.mainapp.models.DatabaseInicializador;
import pacote.mainapp.models.DatabaseManager;
import pacote.mainapp.models.StageLogado;


import java.util.Objects;

public class
MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage = new StageLogado();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pacote/mainapp/fxml/MenuInicial.fxml")));

        Scene scene = new Scene(root, 990, 660);

        primaryStage.setTitle("IngressUnesp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        DatabaseInicializador.criarBancoSeNaoExistir();
        new DatabaseManager();
        launch(args);//Abre a aplicação
    }
}