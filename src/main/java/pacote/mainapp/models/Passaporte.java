package pacote.mainapp.models;

public class Passaporte extends Ingresso {

    private PeriodoEvento periodoDoEvento;

    public Passaporte() {

    }

    @Override
    public double calcularValor() {
        //implementar diferença
        return 100;
    }
}
