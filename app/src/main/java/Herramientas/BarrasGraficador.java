package Herramientas;

import java.util.ArrayList;

import Objetos.*;

public class BarrasGraficador {

    public boolean declararTitulo(String titulo, Barras graficabarras) {
        graficabarras.setTitulodec(graficabarras.getTitulodec() + 1);
        if (graficabarras.getTitulodec() <= 1) {

            graficabarras.setTitulo(titulo.substring(1, titulo.length() - 1));
            return true;
        }
        return false;
    }

    public boolean declararEjex(String items, Barras graficabarras) {

        graficabarras.setEjexdec(graficabarras.getEjexdec() + 1);
        String[] itemsSplit = items.split("\n");

        if (graficabarras.getEjexdec() <= 1 && itemsSplit.length > 0) {
            graficabarras.setEjexitem(itemsSplit); // save info
            return true;
        }
        return false;
    }


    public boolean declararEjey(String items, Barras graficabarras) {
        String[] itemsSplit = items.split("\n");
        Double[] numbers = new Double[itemsSplit.length];

        graficabarras.setEjeydec(graficabarras.getEjeydec() + 1);
        for (int i = 0; i < itemsSplit.length; i++) {
            numbers[i] = Double.valueOf(itemsSplit[i]);
        }

        if (graficabarras.getEjeydec() <= 1 && items.length() > 0) {
            graficabarras.setEjeyitem(numbers);
            return true;
        }
        return false;
    }

    public boolean declararUnir(ArrayList<int[]> unirCoordenada, Barras graficabarras) {
        graficabarras.setUnirdec(graficabarras.getUnirdec() + 1);
        if (graficabarras.getUnirdec() <= 1 && unirCoordenada.size() > 0) {
            graficabarras.setItemunir(unirCoordenada);
            return true;
        }
        return false;
    }
}
