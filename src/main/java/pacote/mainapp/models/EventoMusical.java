package pacote.mainapp.models;

/**
 * Representa um evento musical, que é uma especialização da classe Evento.
 * Contém informações específicas sobre eventos musicais,
 * como banda e estilo musical.
 */
public class EventoMusical extends Evento {

    private String banda;
    private String estiloMusical;

    /**
     * Construtor padrão que cria um evento musical vazio.
     */
    public EventoMusical() {
        super();
    }

    /**
     * Construtor completo para criar um evento musical com todas as informações.
     *
     * @param titulo Título do evento.
     * @param descricao Descrição do evento.
     * @param local Endereço onde o evento ocorrerá.
     * @param data_inicio Data de início do evento.
     * @param data_fim Data de término do evento.
     * @param preco Preço do evento.
     * @param tipo Tipo do evento.
     * @param banda Nome da banda que irá se apresentar.
     * @param estiloMusical Estilo musical do evento.
     */
    public EventoMusical(String titulo, String descricao, Endereco local, String data_inicio, String data_fim,
                         double preco, String tipo, String banda, String estiloMusical) {
        super(titulo, descricao, local, data_inicio, data_fim, preco, tipo);
        this.banda = banda;
        this.estiloMusical = estiloMusical;
    }

    /**
     * Obtém o nome da banda do evento musical.
     *
     * @return nome da banda.
     */
    public String getBanda() {
        return banda;
    }

    /**
     * Define o nome da banda do evento musical.
     *
     * @param banda nome a ser definido.
     */
    public void setBanda(String banda) {
        this.banda = banda;
    }

    /**
     * Obtém o estilo musical do evento.
     *
     * @return estilo musical.
     */
    public String getEstiloMusical() {
        return estiloMusical;
    }

    /**
     * Define o estilo musical do evento.
     *
     * @param estiloMusical estilo a ser definido.
     */
    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    /**
     * Retorna uma representação em string do evento musical,
     * incluindo título, banda, estilo musical, endereço e descrição.
     *
     * @return String formatada com os detalhes do evento musical.
     */
    @Override
    public String toString() {
        return getTitulo() + ":" + getBanda() + "(" + getEstiloMusical() + ")" + "\n" + local.toString() + "\n" + getDescricao();
    }
}
