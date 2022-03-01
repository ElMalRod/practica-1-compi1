package Objetos;

import java.util.ArrayList;

public class Grafica {

    protected int titulodec = 0;
    protected int unirdec = 0;
    protected int errores = 0;
    protected String titulo;
    protected ArrayList<int[]> itemunir;

    public Grafica() {
    }


    public boolean GraficaValida() {
        return errores > 0;
    }

    public int getTitulodec() {
        return titulodec;
    }

    public void setTitulodec(int titulodec) {
        this.titulodec = titulodec;
    }

    public int getUnirdec() {
        return unirdec;
    }

    public void setUnirdec(int unirdec) {
        this.unirdec = unirdec;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<int[]> getItemunir() {
        return itemunir;
    }

    public void setItemunir(ArrayList<int[]> itemunir) {
        this.itemunir = itemunir;
    }

}