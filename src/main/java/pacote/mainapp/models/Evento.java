package pacote.mainapp.models;

public class Evento {
    protected String titulo;
    protected String descricao;
    protected Endereco local;
    protected String data_inicio;
    protected String data_fim;
    protected String preco;

    //Construtor
    public Evento() {}

    public Evento(String titulo, String descricao, Endereco local, String data_inicio, String data_fim, String preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.preco = preco;
    }

    public Evento(String titulo, String descricao, String dataInicio, String preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data_inicio = dataInicio;
        this.preco = preco;
    }

    //Geters e Seters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public Endereco getLocal() {
        return local;
    }

    public void setLocal(Endereco local) {
        this.local = local;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
