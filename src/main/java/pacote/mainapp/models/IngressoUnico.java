package pacote.mainapp.models;

/**
 * Representa um ingresso único para um evento, com um nível de acesso específico.
 * Esta classe estende a classe abstrata {@link Ingresso}.
 */
public class IngressoUnico extends Ingresso {

    private String nivel_acesso;

    /**
     * Construtor padrão para criar um ingresso único sem inicializar campos.
     */
    public IngressoUnico() {
    }

    /**
     * Obtém o nível de acesso associado a este ingresso.
     *
     * @return o nível de acesso do ingresso.
     */
    public String getNivel_acesso() {
        return nivel_acesso;
    }

    /**
     * Define o nível de acesso deste ingresso.
     *
     * @param nivel_acesso o nível de acesso a ser definido.
     */
    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
}
