package Herramientas;
import java.util.ArrayList;

import Objetos.*;

public class Graficador {

    private ArrayList<Barras> barras;
    private ArrayList<Pie> pies;
    private final BarrasGraficador bga;
    private final PieGraficador pga;
    private Barras GraficaBarras;
    private Pie GraficaPie;

    public Graficador() {
        this.barras = new ArrayList<>();
        this.pies = new ArrayList<>();
        this.GraficaBarras = new Barras();
        this.GraficaPie = new Pie();
        this.bga = new BarrasGraficador();
        this.pga = new PieGraficador();
    }

    public void guardarBarras() {

        this.barras.add(GraficaBarras);
        this.GraficaBarras = new Barras();
    }

    public void guardarPie() {
        this.pies.add(GraficaPie);
        this.GraficaPie = new Pie();
    }

    public void registTitulo(int line, int col, String title, int graphType) {

        boolean done = graphType == 0 ? bga.declararTitulo(title, this.GraficaBarras) : this.pga.declararTitulo(title, this.GraficaPie);

        if (!done) {
            regsitErrorOnGraph(graphType);
        }
    }

    public void registEjex(int line, int col, String items) {

        if (!this.bga.declararEjex(items, this.GraficaBarras)) {
            regsitErrorOnGraph(0);
        }
    }

    public void registEjey(int line, int col, String items) {
        if (!this.bga.declararEjey(items, this.GraficaBarras)) {
            regsitErrorOnGraph(0);
        }
    }

   public void registUnir(int line, int col, ArrayList<int[]> mergeCoordenates, int graphType) {
        boolean done = graphType == 0 ? this.bga.declararUnir(mergeCoordenates, this.GraficaBarras) : this.pga.declararUnir(mergeCoordenates, this.GraficaPie);
        if (!done) {
            regsitErrorOnGraph(graphType);
        }
    }

    public void registTipo(int line, int col, int type) {
        if (!this.pga.declararTipo(type, this.GraficaPie)) {
            regsitErrorOnGraph(1);
        }
    }


    public void registEtiqueta(int line, int col, String items) {
        if (!this.pga.declararEtiquetas(items, this.GraficaPie)) {
            regsitErrorOnGraph(1);
        }
    }

    public void regisExtra(int line, int col, String extra) {
        if (!this.pga.declararExtra(extra, this.GraficaPie)) {
            regsitErrorOnGraph(1);
        }
    }


    public void registValores(int line, int col, String numbers) {
        if (!this.pga.declararValores(numbers, this.GraficaPie)) {
            regsitErrorOnGraph(1);
        }
    }

    public void registTotal(int line, int col, Double number) {
        if (!this.pga.declararTotal(number, this.GraficaPie)) {
            regsitErrorOnGraph(1);
        }
    }


    public void regsitErrorOnGraph(int type) {
        if (type == 0) {
            this.GraficaBarras.setErrores(this.GraficaBarras.getErrores() + 1);
        } else {
            this.GraficaPie.setErrores(this.GraficaPie.getErrores() + 1);
        }
    }

    // getters and setters

    public ArrayList<Barras> getBarras() {
        return barras;
    }

    public ArrayList<Pie> getPies() {
        return pies;
    }

    public void setPies(ArrayList<Pie> pies) {
        this.pies = pies;
    }

    public void setBarras(ArrayList<Barras> barras) {
        this.barras = barras;
    }

}