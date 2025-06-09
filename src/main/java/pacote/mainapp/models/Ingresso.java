package pacote.mainapp.models;

/**
 * Representa um ingresso genérico para um evento.
 * Esta classe é abstrata e deve ser estendida por tipos específicos de ingresso.
 */
public abstract class Ingresso {
    protected int id;
    protected Evento refEvento;
    protected double preco;

    /**
     * Obtém o identificador único do ingresso.
     *
     * @return o ID do ingresso.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do ingresso.
     *
     * @param id o ID a ser definido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o evento associado a este ingresso.
     *
     * @return o evento referenciado.
     */
    public Evento getRefEvento() {
        return refEvento;
    }

    /**
     * Define o evento associado a este ingresso.
     *
     * @param refEvento o evento a ser referenciado.
     */
    public void setRefEvento(Evento refEvento) {
        this.refEvento = refEvento;
    }

    /**
     * Obtém o preço do ingresso.
     *
     * @return o preço do ingresso.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do ingresso.
     *
     * @param preco o preço a ser definido.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
