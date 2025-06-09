package pacote.mainapp.models;

import pacote.mainapp.controllers.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            criarTabelaIngresso();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void criarTabelaIngresso() throws SQLException {
        String sqlIngressos = "CREATE TABLE IF NOT EXISTS ingressos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "refEvent INTEGER NOT NULL," +     //ref ao evento
                "refUsuario INTEGER NOT NULL," +  // ref ao usuário
                "nivel_acesso TEXT," +
                "FOREIGN KEY (refEvent) REFERENCES eventos(id) ON DELETE CASCADE," +
                "FOREIGN KEY (refUsuario) REFERENCES usuarios(id) ON DELETE CASCADE" +
                ")";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON");
            stmt.execute(sqlIngressos);
        }
    }
    private static void criarTabelas() throws SQLException {
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "nome TEXT NOT NULL," +
                "email TEXT PRIMARY KEY ," +
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
            stmt.execute("PRAGMA foreign_keys = ON");
            stmt.execute(sqlUsuarios);
        }
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
            stmt.execute("PRAGMA foreign_keys = ON");
            stmt.execute(sqlEventos);
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
                if(rs.getString("tipo").equals("cliente")){
                    Cliente usuario = new Cliente();
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
                else if(rs.getString("tipo").equals("administrador")){
                    Administrador usuario = new Administrador() ;
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
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return null;
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
            pstmt.setDouble(5, evento.getPreco());

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
    public static Evento buscarEvento(String titulo) {
        System.out.println("Buscando evento: " + titulo);
        String sql = "SELECT * FROM eventos WHERE titulo = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getString("tipo").equals("musical")) {
                    //Criando o evento musical
                    EventoMusical eventoMusical = new EventoMusical();
                    eventoMusical.setId(rs.getInt("id"));
                    eventoMusical.setTitulo(rs.getString("titulo"));
                    eventoMusical.setDescricao(rs.getString("descricao"));
                    eventoMusical.setData_inicio(rs.getString("data_inicio"));
                    eventoMusical.setData_fim(rs.getString("data_fim"));
                    eventoMusical.setPreco(rs.getDouble("preco"));
                    eventoMusical.setTipo(rs.getString("tipo"));
                    eventoMusical.setEstiloMusical(rs.getString("estilo_musical"));
                    eventoMusical.setBanda(rs.getString("banda"));

                    return eventoMusical;
                }
                else if (rs.getString("tipo").equals("academico")) {
                    //Criando o evento Academico
                    EventoAcademico eventoAcademico = new EventoAcademico();
                    eventoAcademico.setId(rs.getInt("id"));
                    eventoAcademico.setTitulo(rs.getString("titulo"));
                    eventoAcademico.setDescricao(rs.getString("descricao"));
                    eventoAcademico.setData_inicio(rs.getString("data_inicio"));
                    eventoAcademico.setData_fim(rs.getString("data_fim"));
                    eventoAcademico.setPreco(rs.getDouble("preco"));
                    eventoAcademico.setTipo(rs.getString("tipo"));
                    eventoAcademico.setPalestrante(rs.getString("palestrante"));
                    eventoAcademico.setTopico(rs.getString("topico"));

                    return eventoAcademico;
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return null;
    }
    public static List<Evento> buscarEventos() {
        List<Evento> eventos = new ArrayList<>();

        String sql = "SELECT titulo, descricao, data_inicio, preco, tipo FROM eventos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                String data_inicio = rs.getString("data_inicio");
                double preco = rs.getDouble("preco");
                String tipo = rs.getString("tipo");

                Evento evento = new Evento(titulo, descricao, data_inicio, preco, tipo);
                eventos.add(evento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }

    public static boolean cadastrarIngresso(int refEvent, int refUsuario, String nivelAcesso) throws SQLException {
        String sql = "INSERT INTO ingressos (refEvent, refUsuario, nivel_acesso) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, refEvent);
            stmt.setInt(2, refUsuario);
            stmt.setString(3, nivelAcesso);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
}