package pacote.mainapp.models;

/**
 * Representa um administrador do sistema.
 * Herda as informações de um usuário e adiciona o nível de acesso.
 *
 * @author Miguel
 * @author João Vitor
 */
public class Administrador extends Usuario {

    /** Define o nível de acesso do administrador no sistema. */
    private String nivelAcesso;

    /**
     * Construtor padrão que inicializa o administrador.
     */
    public Administrador() {
        super();
    }


    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
