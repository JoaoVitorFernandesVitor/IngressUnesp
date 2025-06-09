package pacote.mainapp.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados SQLite.
 */
public class DatabaseConnection {

    /**
     * URL do banco de dados SQLite.
     */
    private static final String URL = "jdbc:sqlite:database/sistema.db";

    /**
     * Retorna uma conexão ativa com o banco de dados.
     *
     * @return Uma instância de {@link Connection} conectada ao banco de dados.
     * @throws SQLException Caso ocorra algum erro ao tentar conectar.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
