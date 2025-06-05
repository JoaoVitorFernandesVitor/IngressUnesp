package pacote.mainapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import BackEnd.*;

public class
MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MenuInicial.fxml"));

        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("IngresUnesp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        //Criando Dados manualmente

        Endereco ender1 = new Endereco("Lino graciano", "123","Sao Marcos", "casa 150", "15056710","Rio Preto","SP");
        Endereco ender2 = new Endereco("Avenida Paulista", "1000", "Bela Vista", "apto 45A", "01310920", "São Paulo", "SP");
        Endereco ender3 = new Endereco("Rua da Praia", "789", "Praia do Canto", "bloco B", "29055330", "Vitória", "ES");
        Endereco ender4 = new Endereco("Praça da Liberdade", "25", "Savassi", "sala 302", "30140910", "Belo Horizonte", "MG");
        Endereco ender5 = new Endereco("Orla do Guaíba", "200", "Moinhos de Vento", "lote 5", "91920000", "Porto Alegre", "RS");

        Cliente cliente1 = new Cliente("joao", "23423423423", "joao@gmail.com", ender1, "Abacaxi");

        PeriodoEvento periodoEvento1 = new PeriodoEvento();

        EventoAcademico evento1 = new EventoAcademico("Festa do Abacaxi", "Muito abacaxi e pouca boca",ender2 ,periodoEvento1, "Abacate da Silva", "bacaxis");
        EventoMusical evento2 = new EventoMusical("Show do Abacate", "Muito abacaxi e pouca boca",ender2 ,periodoEvento1, "Abacatinho da Vila", "Samba");
        EventoAcademico evento3 = new EventoAcademico("O sucesso do Abacatinho", "sal e agua",ender2 ,periodoEvento1, "Abacate Mello", "o segrado do sucesso");



        launch(args);//Abre a aplicação
    }

}