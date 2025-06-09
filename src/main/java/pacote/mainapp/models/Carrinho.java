package pacote.mainapp.models;

import java.util.LinkedList;

/**
 * Representa o carrinho de compras de um cliente.
 * Armazena a lista de ingressos adicionados e o cliente associado.
 *
 * @author Miguel
 * @author João Vitor
 */
public class Carrinho {

    /** Lista de ingressos adicionados ao carrinho. */
    private LinkedList<Ingresso> listaDeIngressos;

    /** Cliente que possui este carrinho. */
    private Cliente cliente;

    /**
     * Construtor que inicializa o carrinho para um cliente específico.
     *
     * @param cliente Cliente que será associado ao carrinho
     */
    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        listaDeIngressos = new LinkedList<Ingresso>();
    }
}
