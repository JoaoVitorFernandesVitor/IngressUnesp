package BackEnd;

import java.io.Serializable;

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
