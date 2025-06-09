package pacote.mainapp.models;

public abstract class Ingresso{
    protected int id;
    protected Evento refEvento;
    protected double preco;


    //Get e Sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getRefEvento() {
        return refEvento;
    }

    public void setRefEvento(Evento refEvento) {
        this.refEvento = refEvento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
