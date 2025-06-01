package BackEnd;

import java.io.Serializable;

public class Passaporte extends Ingresso implements Pagavel {

    private PeriodoEvento periodoDoEvento;

    public Passaporte() {

    }

    @Override
    public double calcularValor() {
        return 100;
    }
}
