package pacote.mainapp.models;

public class IngressoUnico extends Ingresso {

    private Data data;

    public IngressoUnico(Data data) {
        this.data = data;

    }

    @Override
    public double calcularValor() {
        //implementar diferença
        return 80;
    }
}
