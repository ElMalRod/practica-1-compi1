package Objetos;

import androidx.annotation.NonNull;

public class Pie extends Grafica {


    private int Itemsdec = 0;
    private int Totaldec = 0;
    private int Valoresdec = 0;
    private int Tipodec = 0; // 0 -> Cantidad, 1 -> Porcentaje
    private int Extradec = 0;
    private String tipoPie;
    private String[] etiquetas;
    private Double[] valores;
    private Double total;
    private String extra;

    public Pie() {
    }

    public Pie(String tipoPie, String[] etiquetas, Double[] valores, Double total, String extra) {
        this.tipoPie = tipoPie;
        this.etiquetas = etiquetas;
        this.valores = valores;
        this.total = total;
        this.extra = extra;
    }

    public int getItemsdec() {
        return Itemsdec;
    }

    public void setItemsdec(int itemsdec) {
        this.Itemsdec = itemsdec;
    }

    public int getTotaldec() {
        return Totaldec;
    }

    public void setTotaldec(int totaldec) {
        this.Totaldec = totaldec;
    }

    public String getBarGraphicType() {
        return tipoPie;
    }

    public void setTipoPie(String tipoPie) {
        this.tipoPie = tipoPie;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Double[] getValores() {
        return valores;
    }

    public void setValores(Double[] valores) {
        this.valores = valores;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getValoresdec() {
        return Valoresdec;
    }

    public void setValoresdec(int valoresdec) {
        this.Valoresdec = valoresdec;
    }

    public int getTipodec() {
        return Tipodec;
    }

    public void setTipodec(int tipodec) {
        this.Tipodec = tipodec;
    }

    public int getExtradec() {
        return Extradec;
    }

    public void setExtradec(int extradec) {
        this.Extradec = extradec;
    }

    @Override
    public boolean GraficaValida() {
        if (this.errores > 0) {
            return false;
        } if(this.tipoPie.equals("Porcentaje") && this.Tipodec > 0) {
            return false;
        }
        return (this.titulodec == 1 && Tipodec == 1 && Itemsdec == 1 && Valoresdec == 1
                && this.Totaldec <= 1 && this.unirdec == 1 && this.Extradec <= 1);
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nPieGrafica valid: ").append(GraficaValida());
        result.append("\nErrores: ").append(this.errores);
        result.append("\nTitulo: ").append(this.titulo);
        result.append("\nTipo: ").append(tipoPie);
        result.append("\nEtiquetas: ");
        for (String etiquetas : etiquetas) {
            result.append("\n\t").append(etiquetas);
        }
        result.append("\nValores: ");
        for (Double valores : valores) {
            result.append("\n\t").append(valores);
        }
        result.append("\nTotal: ").append(total);
        result.append("\nExtra: ").append(extra);
        result.append("\nUnir: ");
        for (int[] unir : itemunir) {
            result.append("\n\t{").append(unir[0]).append(",").append(unir[1]).append("}");
        }
        result.append("\nDECLARATIONS:");
        result.append("\n\tTags: ").append(Itemsdec);
        result.append("\n\tTotal: ").append(Totaldec);
        result.append("\n\tValues: ").append(Valoresdec);
        result.append("\n\tPieType: ").append(Tipodec);
        result.append("\n\tExtra: ").append(Extradec);
        result.append("\n\tTitle: ").append(titulodec);
        return result.toString();
    }
}
