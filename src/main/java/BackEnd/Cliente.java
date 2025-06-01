package BackEnd;

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

    //Get e Sets


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
