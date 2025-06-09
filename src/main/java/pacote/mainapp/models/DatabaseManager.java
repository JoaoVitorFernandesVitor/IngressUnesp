package pacote.mainapp.models;

import pacote.mainapp.controllers.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela gestão do banco de dados da aplicação.
 * Realiza a criação das tabelas e manipulação de dados como usuários, eventos e ingressos.
 * Utiliza conexão SQLite.
 *
 * @author Miguel
 * @author João Vitor
 */
public class DatabaseManager {

    /** URL de conexão com o banco de dados SQLite. */
    private static final String DB_URL = "jdbc:sqlite:database/sistema.db";

    /** Conexão única com o banco de dados. */
    private static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            criarTabelas();
            criarTabelaEvento();
            criarTabelaIngresso();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Cria a tabela de usuários, se não existir.
     */
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
                "tipo TEXT NOT NULL," +
                "nivel_acesso TEXT)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sqlUsuarios);
        }
    }

    /**
     * Cria a tabela de eventos, se não existir.
     */
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

    /**
     * Cria a tabela de ingressos, se não existir.
     */
    private static void criarTabelaIngresso() throws SQLException {
        String sqlIngressos = "CREATE TABLE IF NOT EXISTS ingressos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "refEvent INTEGER NOT NULL," +
                "refUsuario TEXT NOT NULL," +
                "nivel_acesso TEXT," +
                "FOREIGN KEY (refEvent) REFERENCES eventos(id) ON DELETE CASCADE," +
                "FOREIGN KEY (refUsuario) REFERENCES usuarios(email) ON DELETE CASCADE)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sqlIngressos);
        }
    }

    /**
     * Cadastra um novo usuário no banco de dados.
     *
     * @param usuario      Objeto do tipo Usuario a ser cadastrado
     * @param tipoUsuario  Tipo do usuário: "cliente" ou "administrador"
     * @return true se o cadastro for bem-sucedido, false caso contrário
     */
    public static boolean cadastrarUsuario(Usuario usuario, String tipoUsuario) throws SQLException {
        String sql = "INSERT INTO usuarios(nome, email, cpf, telefone, senha, " +
                "logradouro, numero, complemento, cidade, estado, cep, tipo) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
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
            pstmt.setString(12, tipoUsuario);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    /**
     * Busca um usuário pelo e-mail no banco de dados.
     *
     * @param email E-mail do usuário a ser buscado
     * @return Instância de Cliente ou Administrador se encontrado, null caso contrário
     */
    public static Usuario buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getString("tipo").equals("cliente")) {
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
                } else if (rs.getString("tipo").equals("administrador")) {
                    Administrador usuario = new Administrador();
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

    /**
     * Cadastra um ingresso no banco de dados.
     *
     * @param refEvent     ID do evento associado
     * @param refUsuario   E-mail do usuário associado
     * @param nivelAcesso  Nível de acesso do ingresso
     * @return true se o ingresso for cadastrado com sucesso
     */
    public static boolean cadastrarIngresso(int refEvent, String refUsuario, String nivelAcesso) {
        String sql = "INSERT INTO ingressos (refEvent, refUsuario, nivel_acesso) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, refEvent);
            stmt.setString(2, refUsuario);
            stmt.setString(3, nivelAcesso);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro detalhado ao cadastrar ingresso: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cadastra um evento no banco de dados.
     *
     * @param evento      Objeto do tipo Evento a ser cadastrado
     * @param tipoEvento  Tipo do evento: "musical" ou "academico"
     * @return true se o evento for cadastrado com sucesso
     */
    public static boolean cadastrarEvento(Evento evento, String tipoEvento) throws SQLException {
        String sql = "INSERT INTO eventos(titulo, descricao, data_inicio, data_fim, " +
                "preco, logradouro, numero, complemento, cidade, estado, cep, tipo, " +
                "estilo_musical, banda, palestrante, topico) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
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

    /**
     * Busca um evento pelo título.
     *
     * @param titulo Título do evento a ser buscado
     * @return Objeto EventoMusical ou EventoAcademico se encontrado, null caso contrário
     */
    public static Evento buscarEvento(String titulo) {
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

    /** Busca eventos
     *
     * @return
     */
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

    /** Extrai Ingressos por usuário do banco de dados
     *
     * @param usuarioEmail
     * @return
     */
    public static List<Ingresso> getIngressosPorUsuario(String usuarioEmail) {
        List<Ingresso> ingressos = new ArrayList<>();

        String sql = "SELECT i.id, i.nivel_acesso, e.titulo, e.data_inicio, e.data_fim, e.preco, e.tipo " +
                "FROM ingressos i " +
                "JOIN eventos e ON i.refEvent = e.id " +
                "WHERE i.refUsuario = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuarioEmail);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                IngressoUnico newIngressoUnico = new IngressoUnico();
                newIngressoUnico.setId(rs.getInt("id"));
                newIngressoUnico.setRefEvento(buscarEvento(rs.getString("titulo")));
                newIngressoUnico.setPreco(rs.getDouble("preco"));
                newIngressoUnico.setNivel_acesso(rs.getString("nivel_acesso"));

                ingressos.add(newIngressoUnico);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar ingressos: " + e.getMessage());
        }

        return ingressos;
    }

}


