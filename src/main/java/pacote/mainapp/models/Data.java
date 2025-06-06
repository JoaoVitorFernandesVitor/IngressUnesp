package pacote.mainapp.models;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    //Construtor
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    //Geters e Seters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDiaMes(){
        return getDia() + "/" + getMes();
    }

    //Metodos
    public String toString(){
        return getDia() + "/" + getMes() + "/" + getAno();
    }
}
