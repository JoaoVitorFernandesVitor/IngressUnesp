package pacote.mainapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pacote.mainapp.models.DatabaseInicializador;


import java.util.Objects;

public class
MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/pacote/mainapp/fxml/MenuInicial.fxml")));

        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("IngresUnesp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        DatabaseInicializador.criarBancoSeNaoExistir();
        launch(args);//Abre a aplicação
    }
}