package pacote.mainapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:database/sistema.db";
    private static Connection connection;

    static {
        try {
            // Registrar driver e criar conexão
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            criarTabelas();
            criarTabelaEvento();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void criarTabelas() throws SQLException {
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "cpf TEXT UNIQUE NOT NULL," +
                "telefone TEXT NOT NULL," +
                "senha TEXT NOT NULL," +
                "logradouro TEXT," +
                "numero TEXT," +
                "complemento TEXT," +
                "cidade TEXT," +
                "estado TEXT," +
                "cep TEXT," +
                "tipo TEXT NOT NULL," +  // 'cliente' ou 'admin'
                "nivel_acesso TEXT)";    // apenas para administradores

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sqlUsuarios);
        }
    }
    public static boolean cadastrarUsuario(Usuario usuario, String tipoUsuario) throws SQLException {
        String sql = "INSERT INTO usuarios(nome, email, cpf, telefone, senha, " +
                "logradouro, numero, complemento, cidade, estado, cep, tipo) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Campos comuns
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getCpf());
            pstmt.setString(4, usuario.getTelefone());
            pstmt.setString(5, usuario.getSenha());

            Endereco endereco = usuario.getEndereco();
            pstmt.setString(6, endereco.getLogradouro());
            pstmt.setString(7, endereco.getNumero());
            pstmt.setString(8, endereco.getComplemento());
            pstmt.setString(9, endereco.getCidade());
            pstmt.setString(10, endereco.getEstado());
            pstmt.setString(11, endereco.getCep());

            // Campo específico para tipo de usuário
            pstmt.setString(12, tipoUsuario);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    public static Usuario buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario() {};
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setSenha(rs.getString("senha"));

                Endereco endereco = new Endereco(
                        rs.getString("logradouro"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep"));
                usuario.setEndereco(endereco);

                return usuario;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return null;
    }

    private static void criarTabelaEvento() throws SQLException {
        String sqlEventos = "CREATE TABLE IF NOT EXISTS eventos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "descricao TEXT UNIQUE NOT NULL," +
                "data_inicio TEXT NOT NULL," +
                "data_fim TEXT NOT NULL," +
                "preco REAL NOT NULL," +
                "logradouro TEXT," +
                "numero TEXT," +
                "complemento TEXT," +
                "cidade TEXT," +
                "estado TEXT," +
                "cep TEXT," +
                "estilo_musical TEXT," +
                "banda TEXT," +
                "palestrante TEXT," +
                "topico TEXT," +
                "tipo TEXT NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sqlEventos);
        }
    }

    public static boolean cadastrarEvento(Evento evento, String tipoEvento) throws SQLException {
        String sql = "INSERT INTO eventos(titulo, descricao, data_inicio, data_fim, " +
                "preco, logradouro, numero, complemento, cidade, estado, cep, tipo, " +
                "estilo_musical, banda, palestrante, topico) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Campos comuns
            pstmt.setString(1, evento.getTitulo());
            pstmt.setString(2, evento.getDescricao());
            pstmt.setString(3, evento.getData_inicio());
            pstmt.setString(4, evento.getData_fim());
            pstmt.setString(5, evento.getPreco());

            Endereco endereco = evento.getLocal();
            pstmt.setString(6, endereco.getLogradouro());
            pstmt.setString(7, endereco.getNumero());
            pstmt.setString(8, endereco.getComplemento());
            pstmt.setString(9, endereco.getCidade());
            pstmt.setString(10, endereco.getEstado());
            pstmt.setString(11, endereco.getCep());

            // Campo específico para tipo de evento
            pstmt.setString(12, tipoEvento);

            if (evento instanceof EventoMusical musical) {
                pstmt.setString(13, musical.getEstiloMusical());
                pstmt.setString(14, musical.getBanda());
            } else if (evento instanceof EventoAcademico academico) {
                pstmt.setString(15, academico.getPalestrante());
                pstmt.setString(16, academico.getTopico());
            }

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar evento: " + e.getMessage());
            return false;
        }
    }

}