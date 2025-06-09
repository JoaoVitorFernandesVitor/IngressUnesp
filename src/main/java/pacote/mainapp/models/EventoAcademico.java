package pacote.mainapp.models;

public class EventoAcademico extends Evento {

    private String palestrante;
    private String topico;

    //Construtor
    public EventoAcademico() {
        super();
    }

    public EventoAcademico(String titulo, String descricao, Endereco local, String data_inicio, String data_fim, double preco, String tipo, String palestrante, String topico) {
        super(titulo, descricao, local, data_inicio, data_fim, preco, tipo);
        this.palestrante = palestrante;
        this.topico = topico;
    }

    //Geters e Seters

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    //Metodos
    public String toString() {
        return getTitulo() + ":" + getPalestrante() + "(" + getTopico() + ")" + "\n" + local.toString() + "\n" + getDescricao();
    }
}
