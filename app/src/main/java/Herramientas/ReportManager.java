package Herramientas;

import java.util.ArrayList;

public class ReportManager {

    private ArrayList<SyntaxError> errors;
    private ArrayList<String[]> mathOperators;
    private int barGraphicsCounter;
    private int pieGraphicsCounter;

    public ReportManager() {
        this.errors = new ArrayList<>();
        this.mathOperators = new ArrayList<>();
        this.barGraphicsCounter = 0;
        this.pieGraphicsCounter = 0;
    }

    public ArrayList<SyntaxError> getErrors() {
        return errors;
    }

    public ArrayList<String[]> getMathOperators() {
        return mathOperators;
    }

    public int getBarGraphicsCounter() {
        return barGraphicsCounter;
    }

    public int getPieGraphicsCounter() {
        return pieGraphicsCounter;
    }

    public void increasePieGraphicsCounter() {
        this.pieGraphicsCounter++;
    }

    public void increaseBarGraphicsCounter() {
        this.barGraphicsCounter++;
    }


    public void addError(int line, int col, String lexeme, String message, int errorType) {
        String errType = errorType == 0 ? "lexico" : "sintactico";
        this.errors.add(new SyntaxError(line, col, errType, message, lexeme));
    }

    public void addMathSymbolsReport(String previousTkn, String actualTkn, String nextTokn) {
        this.mathOperators.add(new String[]{previousTkn, actualTkn, nextTokn});
    }
}
