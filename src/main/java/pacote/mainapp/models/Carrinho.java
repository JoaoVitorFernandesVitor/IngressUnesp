package pacote.mainapp.models;

import java.util.LinkedList;

public class Carrinho {
    private LinkedList<Ingresso> listaDeIngressos;
    private Cliente cliente;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        listaDeIngressos = new LinkedList<Ingresso>();
    }
}
