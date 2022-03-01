package Herramientas;

import java.util.ArrayList;

import Objetos.*;

public class PieGraficador {

    public boolean declararTitulo(String titulo, Pie graficapie) {
        // add message to errors and set error to object
        graficapie.setTitulodec(graficapie.getTitulodec() + 1); // title decs ++
        if (graficapie.getTitulodec() <= 1) {
            // save info for execution
            graficapie.setTitulo(titulo.substring(1, titulo.length() - 1)); // save info
            return true;
        }
        return false;
    }

    public boolean declararTipo(int tipo, Pie graficapie) {
        // save data
        graficapie.setTipodec(graficapie.getTipodec() + 1);
        if (graficapie.getTipodec() <= 1) {
            // save info for execution
            String tipos = tipo == 0 ? "Cantidad" : "Porcentaje";
            graficapie.setTipoPie(tipos);
            return true;
        }
        return false;
    }

    boolean declararEtiquetas(String items, Pie graficapie) {
        // split item with \n for files
        String[] itemsSplit = items.split("\n");
        graficapie.setItemsdec(graficapie.getItemsdec() + 1);
        // validate lenght > 0
        if (graficapie.getItemsdec() <= 1 && itemsSplit.length > 0) {
            graficapie.setEtiquetas(itemsSplit);
            return true;
        }
        return false;
    }

    boolean declararValores (String items, Pie graficapie) {
        String[] itemsSplit = items.split("\n");
        Double[] numbers = new Double[itemsSplit.length];
        // cast to double
        for (int i = 0; i < itemsSplit.length; i++) {
            numbers[i] = Double.valueOf(itemsSplit[i]);
        }
        graficapie.setValoresdec(graficapie.getValoresdec() + 1);
        if (graficapie.getValoresdec() <= 1 && numbers.length > 0) {
            graficapie.setValores(numbers);
            return true;
        }
        return false;
    }

    boolean declararTotal(Double num, Pie graficapie) {
        graficapie.setTotaldec(graficapie.getTotaldec() + 1);
        if (graficapie.getTotaldec() <= 1) {
            graficapie.setTotal(num);
            return true;

        }

        return false;
    }

    boolean declararUnir(ArrayList<int[]> unirs, Pie graficapie) {
        graficapie.setUnirdec(graficapie.getUnirdec() + 1);
        if (graficapie.getUnirdec() <= 1 && unirs.size() > 0) {
            graficapie.setItemunir(unirs);
            return true;
        }
        return false;
    }

    boolean declararExtra(String extra, Pie graficapie) {
        graficapie.setExtradec(graficapie.getExtradec() + 1);
        if (graficapie.getExtradec() <= 1) {
            graficapie.setExtra(extra);
            return true;
        }
        return false;
    }
}
