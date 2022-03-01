package Reportes;

import java.io.Serializable;

import Analizadores.Token;


public class ErrorToken extends Token implements Serializable  {
    private String descripcion;
    private String tipo;


    public ErrorToken(String lexeme, int line, int column, String descripcion, String tipo) {
        super(lexeme, line, column);
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }


}
