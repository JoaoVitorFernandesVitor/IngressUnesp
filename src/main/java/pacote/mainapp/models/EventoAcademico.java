package pacote.mainapp.models;

/**
 * Representa um evento acadêmico, que é uma especialização da classe Evento.
 * Contém informações adicionais específicas para eventos acadêmicos,
 * como palestrante e tópico do evento.
 */
public class EventoAcademico extends Evento {

    private String palestrante;
    private String topico;

    /**
     * Construtor padrão que cria um evento acadêmico vazio.
     */
    public EventoAcademico() {
        super();
    }

    /**
     * Construtor completo para criar um evento acadêmico com todas as informações.
     *
     * @param titulo Título do evento.
     * @param descricao Descrição do evento.
     * @param local Endereço onde o evento ocorrerá.
     * @param data_inicio Data de início do evento.
     * @param data_fim Data de término do evento.
     * @param preco Preço do evento.
     * @param tipo Tipo do evento.
     * @param palestrante Nome do palestrante.
     * @param topico Tópico abordado no evento.
     */
    public EventoAcademico(String titulo, String descricao, Endereco local, String data_inicio, String data_fim,
                           double preco, String tipo, String palestrante, String topico) {
        super(titulo, descricao, local, data_inicio, data_fim, preco, tipo);
        this.palestrante = palestrante;
        this.topico = topico;
    }

    /**
     * Obtém o nome do palestrante do evento acadêmico.
     *
     * @return nome do palestrante.
     */
    public String getPalestrante() {
        return palestrante;
    }

    /**
     * Define o nome do palestrante do evento acadêmico.
     *
     * @param palestrante nome a ser definido.
     */
    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    /**
     * Obtém o tópico do evento acadêmico.
     *
     * @return tópico do evento.
     */
    public String getTopico() {
        return topico;
    }

    /**
     * Define o tópico do evento acadêmico.
     *
     * @param topico tópico a ser definido.
     */
    public void setTopico(String topico) {
        this.topico = topico;
    }

    /**
     * Retorna uma representação em string do evento acadêmico,
     * incluindo título, palestrante, tópico, endereço e descrição.
     *
     * @return String formatada com os detalhes do evento acadêmico.
     */
    @Override
    public String toString() {
        return getTitulo() + ":" + getPalestrante() + "(" + getTopico() + ")" + "\n" + local.toString() + "\n" + getDescricao();
    }
}
