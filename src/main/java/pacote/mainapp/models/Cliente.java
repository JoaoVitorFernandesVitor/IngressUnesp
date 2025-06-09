package pacote.mainapp.models;

import java.util.LinkedList;

/**
 * Representa um cliente do sistema.
 * Herda os dados de um usuário e possui uma carteira e uma lista de ingressos.
 *
 * @author Miguel
 * @author João Vitor
 */
public class Cliente extends Usuario {

    /** Estado atual da carteira do cliente (ex: saldo ou status). */
    private String carteira;

    /** Lista de ingressos adquiridos pelo cliente. */
    private LinkedList<Ingresso> ListaDeIngressos;

    /**
     * Construtor que inicializa um cliente com os dados informados.
     *
     * @param nome Nome do cliente
     * @param email E-mail do cliente
     * @param cpf CPF do cliente
     * @param endereco Endereço do cliente
     * @param senha Senha do cliente
     */
    public Cliente(String nome, String email, String cpf, Endereco endereco, String senha) {
        setNome(nome);
        setEmail(email);
        setCpf(cpf);
        setEndereco(endereco);
        setSenha(senha);
        this.carteira = "Vazia";
        this.ListaDeIngressos = new LinkedList<Ingresso>();
    }

    /**
     * Contrutor padrão que inicializa um cliente com carteira vazia
     * e lista de ingressos vazia.
     */
    public Cliente() {
        super();
        this.carteira = "Vazia";
        this.ListaDeIngressos = new LinkedList<Ingresso>();
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public LinkedList<Ingresso> getListaDeIngressos() {
        return ListaDeIngressos;
    }

    public void setListaDeIngressos(LinkedList<Ingresso> listaDeIngressos) {
        ListaDeIngressos = listaDeIngressos;
    }

}
