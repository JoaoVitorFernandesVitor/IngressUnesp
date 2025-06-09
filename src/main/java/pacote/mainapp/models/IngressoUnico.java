package pacote.mainapp.models;

public class IngressoUnico extends Ingresso {


    public IngressoUnico() {

    }

    @Override
    public double calcularValor() {
        return this.getPreco();
    }
}
