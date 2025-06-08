package pacote.mainapp.models;

public class EventoMusical extends Evento{

    private String banda;
    private String estiloMusical;

    //Constutor
    public EventoMusical(String titulo, String descricao, Endereco local, String data_inicio, String data_fim, String preco, String banda, String estiloMusical) {
        super(titulo, descricao, local, data_inicio, data_fim, preco);
        this.banda = banda;
        this.estiloMusical = estiloMusical;
    }

    public EventoMusical() {
        super();
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
        return getTitulo() + ":" + getBanda() + "(" + getEstiloMusical() + ")" + "\n" + local.toString() + "\n" + getDescricao();
    }
}
