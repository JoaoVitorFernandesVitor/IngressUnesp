package pacote.mainapp.models;

import javafx.stage.Stage;

public class StageLogado extends Stage {

    private Usuario usuario;

    public StageLogado() {
        super();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
