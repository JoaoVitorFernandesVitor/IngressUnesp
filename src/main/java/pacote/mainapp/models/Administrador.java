package pacote.mainapp.models;

public class Administrador extends Usuario {
    private String nivelAcesso;

    // Construtor
    public Administrador() {
        super();
    }

    // Getter e Setter específico
    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}