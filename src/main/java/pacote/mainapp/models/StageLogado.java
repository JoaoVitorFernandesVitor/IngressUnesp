package pacote.mainapp.models;

import javafx.stage.Stage;

/**
 * Extensão da classe {@link Stage} do JavaFX que mantém uma referência ao usuário logado.
 * Útil para associar dados do usuário à janela da aplicação.
 */
public class StageLogado extends Stage {

    private Usuario usuario;

    /**
     * Construtor padrão que inicializa a janela.
     */
    public StageLogado() {
        super();
    }

    /**
     * Retorna o usuário associado a esta janela.
     *
     * @return o usuário logado.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Define o usuário associado a esta janela.
     *
     * @param usuario o usuário logado a ser definido.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
