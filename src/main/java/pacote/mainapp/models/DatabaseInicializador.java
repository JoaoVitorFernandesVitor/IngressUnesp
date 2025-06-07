package pacote.mainapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInicializador {

    public static void criarBancoSeNaoExistir() {
        String url = "jdbc:sqlite:database/sistema.db";



        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            System.out.println("Banco de dados inicializado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
