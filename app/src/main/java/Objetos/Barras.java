package Objetos;

public class Barras extends Grafica {

    private int Ejexdec = 0;
    private int Ejeydec = 0;

    // data
    private String[] ejexitem;
    private Double[] ejeyitem;

    public Barras() {
    }

    @Override
    public boolean GraficaValida() {
        System.out.println("ERRORES: " + errores);
        if (this.errores > 0) {
            return false;
        }
        return this.Ejexdec == 1 && this.Ejeydec == 1
                && this.titulodec == 1 && this.unirdec <= 1 && this.titulo != null
                && !this.titulo.isEmpty();
    }

    public int getEjexdec() {
        return Ejexdec;
    }

    public void setEjexdec(int ejexdec) {
        this.Ejexdec = ejexdec;
    }

    public int getEjeydec() {
        return Ejeydec;
    }

    public void setEjeydec(int ejeydec) {
        this.Ejeydec = ejeydec;
    }

    public String[] getEjexitem() {
        return ejexitem;
    }

    public void setEjexitem(String[] ejexitem) {
        this.ejexitem = ejexitem;
    }

    public Double[] getEjeyitem() {
        return ejeyitem;
    }

    public void setEjeyitem(Double[] ejeyitem) {
        this.ejeyitem = ejeyitem;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nBarras valid: ").append(GraficaValida());
        result.append("\nErrores: ").append(this.errores);
        result.append("\nTitulo: ").append(this.titulo);
        result.append("\nEjex: ");
        for (String Items : ejexitem) {
            result.append("\n\t").append(Items);
        }
        result.append("\nEjey: ");
        for (Double Nums : ejeyitem) {
            result.append("\n\t").append(Nums);
        }
        result.append("\nUnir: ");
        for (int[] Union : itemunir) {
            result.append("\n\t{").append(Union[0]).append(",").append(Union[1]).append("}");
        }
        result.append("\nDeclaraciones:");
        result.append("\n\tEjey: ").append(Ejeydec);
        result.append("\n\tEjex: ").append(Ejeydec);
        result.append("\n\tUnir: ").append(unirdec);
        result.append("\n\tTitulo: ").append(titulodec);
        return result.toString();
    }
}
