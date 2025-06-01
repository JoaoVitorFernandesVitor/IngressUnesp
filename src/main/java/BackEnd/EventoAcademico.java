package BackEnd;

public class EventoAcademico extends Evento {

    private String palestrante;
    private String topico;

    //Construtor
    public EventoAcademico(String titulo, String descricao, Endereco local, PeriodoEvento periodoDoEvento, String palestrante, String topico) {
        super(titulo, descricao, local, periodoDoEvento);
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
        return getTitulo() + ":" + getPalestrante() + "(" + getTopico() + ")" + "\n" + periodoDoEvento.toString() + " - " + local.toString() + "\n" + getDescricao();
    }
}
