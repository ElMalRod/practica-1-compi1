package Herramientas;

public class SyntaxError {

    private int line;
    private int col;
    private String errorType;
    private String message;
    private String lexeme;

    public SyntaxError() {
    }

    public SyntaxError(int line, int col, String errorType) {
        this.line = line;
        this.col = col;
        this.errorType = errorType;
    }

    public SyntaxError(int line, int col, String errorType, String message, String lexeme) {
        this.line = line;
        this.col = col;
        this.errorType = errorType;
        this.message = message;
        this.lexeme = lexeme;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

}