package pacote.mainapp.models;

public class IngressoUnico extends Ingresso {

    private String nivel_acesso;

    public IngressoUnico() {

    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    @Override
    public double calcularValor() {
        return this.getPreco();
    }
}
