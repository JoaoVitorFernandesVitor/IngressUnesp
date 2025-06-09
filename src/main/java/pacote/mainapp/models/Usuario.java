package pacote.mainapp.models;

/**
 * Classe abstrata que representa um usuário do sistema.
 * Pode ser estendida por classes como Cliente ou Administrador.
 * Contém informações pessoais e de autenticação.
 *
 * @author Miguel
 * @author João Vitor
 */
public abstract class Usuario {

    /** Nome completo do usuário. */
    private String nome;

    /** Endereço de e-mail do usuário. */
    private String email;

    /** CPF do usuário. */
    private String cpf;

    /** Endereço associado ao usuário. */
    private Endereco endereco;

    /** Número de telefone para contato. */
    private String telefone;

    /** Senha usada para autenticação. */
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
