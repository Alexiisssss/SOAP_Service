package org.example;

public class SolveResponse {
    private String formula;
    private double D;
    private Double x1;
    private Double x2;

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public double getD() {
        return D;
    }

    public void setD(double d) {
        D = d;
    }
}
