package BackEnd;

import java.util.LinkedList;

public class PeriodoEvento {
    private LinkedList<Data> Datas;
    private Data inicio;
    private Data termino;

    //Construtor
    public PeriodoEvento() {
        this.Datas = new LinkedList<Data>();
    }

    //Get e Sets
    public LinkedList<Data> getDatas() {
        return Datas;
    }

    public void setDatas(LinkedList<Data> datas) {
        Datas = datas;
    }

    public Data getInicio() {
        return inicio;
    }

    public void setInicio(Data inicio) {
        this.inicio = inicio;
    }

    public Data getTermino() {
        return termino;
    }

    public void setTermino(Data termino) {
        this.termino = termino;
    }

    //Metodos

    public String toString(){
        return "Inicio: " + getInicio() + "\nTermino: " + getTermino();
    }

    public void incluirData(Data data){
        Datas.add(data);
    }

    public void incluirDatas(LinkedList<Data> listaDatas){
        for (Data data : listaDatas){
            Datas.add(data);
        }
    }




}
