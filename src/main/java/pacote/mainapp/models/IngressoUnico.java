package pacote.mainapp.models;

public class IngressoUnico extends Ingresso {


    public IngressoUnico(Evento evento) {
        setRefEvento(evento);
    }

    @Override
    public double calcularValor() {
        return this.getPreco();
    }
}
