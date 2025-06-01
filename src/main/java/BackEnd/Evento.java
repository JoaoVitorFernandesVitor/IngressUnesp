package BackEnd;

public class Evento {
    protected String titulo;
    protected String descricao;
    protected Endereco local;
    protected PeriodoEvento periodoDoEvento;

    //Construtor
    public Evento(String titulo, String descricao, Endereco local, PeriodoEvento periodoDoEvento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.local = local;
        this.periodoDoEvento = periodoDoEvento;
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

    public PeriodoEvento getPeriodoDoEvento() {
        return periodoDoEvento;
    }

    public void setPeriodoDoEvento(PeriodoEvento periodoDoEvento) {
        this.periodoDoEvento = periodoDoEvento;
    }

    public Endereco getLocal() {
        return local;
    }

    public void setLocal(Endereco local) {
        this.local = local;
    }

    //Metodos

}
