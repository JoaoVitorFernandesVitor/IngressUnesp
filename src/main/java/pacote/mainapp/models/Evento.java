package pacote.mainapp.models;

/**
 * Representa um evento com informações como título, descrição, local, datas, preço e tipo.
 */
public class Evento {
    protected int id;
    protected String titulo;
    protected String descricao;
    protected Endereco local;
    protected String data_inicio;
    protected String data_fim;
    protected double preco;
    protected String tipo;

    /**
     * Construtor padrão, cria um evento vazio.
     */
    public Evento() {}

    /**
     * Construtor completo para criar um evento com todas as informações.
     *
     * @param titulo Título do evento.
     * @param descricao Descrição do evento.
     * @param local Endereço onde o evento ocorrerá.
     * @param data_inicio Data de início do evento (formato String).
     * @param data_fim Data de término do evento (formato String).
     * @param preco Preço do ingresso ou participação no evento.
     * @param tipo Tipo do evento (ex: acadêmico, musical, etc).
     */
    public Evento(String titulo, String descricao, Endereco local, String data_inicio, String data_fim, double preco, String tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.preco = preco;
        this.tipo = tipo;
    }

    /**
     * Construtor simplificado para eventos sem endereço e data de término.
     *
     * @param titulo Título do evento.
     * @param descricao Descrição do evento.
     * @param dataInicio Data de início do evento.
     * @param preco Preço do ingresso ou participação.
     * @param tipo Tipo do evento.
     */
    public Evento(String titulo, String descricao, String dataInicio, double preco, String tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_inicio = dataInicio;
        this.preco = preco;
        this.tipo = tipo;
    }

    // Getters e Setters

    /**
     * Obtém o identificador do evento.
     * @return id do evento.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do evento.
     * @param id Id a ser definido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o título do evento.
     * @return título.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do evento.
     * @param titulo título a ser definido.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém a descrição do evento.
     * @return descrição.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do evento.
     * @param descricao descrição a ser definida.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o endereço do evento.
     * @return endereço.
     */
    public Endereco getLocal() {
        return local;
    }

    /**
     * Define o endereço do evento.
     * @param local endereço a ser definido.
     */
    public void setLocal(Endereco local) {
        this.local = local;
    }

    /**
     * Obtém a data de início do evento.
     * @return data de início.
     */
    public String getData_inicio() {
        return data_inicio;
    }

    /**
     * Define a data de início do evento.
     * @param data_inicio data a ser definida.
     */
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * Obtém a data de término do evento.
     * @return data de término.
     */
    public String getData_fim() {
        return data_fim;
    }

    /**
     * Define a data de término do evento.
     * @param data_fim data a ser definida.
     */
    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    /**
     * Obtém o preço do evento.
     * @return preço.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do evento.
     * @param preco preço a ser definido.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obtém o tipo do evento.
     * @return tipo (ex: acadêmico, musical).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do evento.
     * @param tipo tipo a ser definido.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
