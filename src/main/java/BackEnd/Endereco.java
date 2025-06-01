package BackEnd;

public class Endereco {
    private String nome;
    private String rua;
    private String numero;
    private String Bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;

    //Construtor
    public Endereco(String rua, String numero, String bairro, String complemento, String cep, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.Bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    //Get e Seters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Metodos
    public String toString(){
        return getNome() + ":" +getRua() +","+  getNumero() + getBairro() + "," + getCidade() + "-" + getEstado();
    }


}
