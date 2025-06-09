package pacote.mainapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Classe responsável por inicializar o banco de dados da aplicação.
 * Verifica se o banco existe e o cria, caso necessário.
 * Utiliza conexão SQLite.
 *
 * @author Miguel
 * @author João Vitor
 */
public class DatabaseInicializador {

    /**
     * Cria o banco de dados caso ele ainda não exista.
     * Estabelece uma conexão SQLite e imprime uma mensagem ao iniciar.
     */
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
