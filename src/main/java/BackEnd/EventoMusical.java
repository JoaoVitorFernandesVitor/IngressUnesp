package BackEnd;

public class EventoMusical extends Evento{

    private String banda;
    private String estiloMusical;

    //Constutor
    public EventoMusical(String titulo, String descricao, Endereco local, PeriodoEvento periodoDoEvento, String banda, String estiloMusical) {
        super(titulo, descricao, local, periodoDoEvento);
        this.banda = banda;
        this.estiloMusical = estiloMusical;
    }

    //Gets e Sets
    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    //Metodos

    public String toString() {
        return getTitulo() + ":" + getBanda() + "(" + getEstiloMusical() + ")" + "\n" + periodoDoEvento.toString() + " - " + local.toString() + "\n" + getDescricao();
    }
}
