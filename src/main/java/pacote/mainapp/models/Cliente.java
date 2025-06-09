package pacote.mainapp.models;

import java.util.LinkedList;

public class Cliente extends Usuario {

    private String carteira;
    private LinkedList<Ingresso> ListaDeIngressos;

    //Construtor
    public Cliente(String nome, String email, String cpf, Endereco endereco, String senha) {
        setNome(nome);
        setEmail(email);
        setCpf(cpf);
        setEndereco(endereco);
        setSenha(senha);
        this.carteira = "Vazia";
        this.ListaDeIngressos = new LinkedList<Ingresso>();
    }

    public Cliente() {
        super();
        this.carteira = "Vazia";
        this.ListaDeIngressos = new LinkedList<Ingresso>();
    }

    //Get e Sets
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

    //Metodos
    public void incluirIngresso(Ingresso ingresso) {
        this.ListaDeIngressos.add(ingresso);
    }
    public void incluirIngressos(LinkedList<Ingresso> ingressos){
        this.ListaDeIngressos.addAll(ingressos);
    }
    public void excluirIngresso(Ingresso ingresso) {
        this.ListaDeIngressos.remove(ingresso);
    }

}
