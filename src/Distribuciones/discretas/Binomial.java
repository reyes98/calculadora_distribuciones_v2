package Distribuciones.discretas;

import Distribuciones.Modulo;

/**
 *
 * @author sebastian
 */
public class Binomial implements Modulo {

    //Atributos de clase
    private int n;
    private double p;
    //-------------------------

    //constructor    
    public Binomial(int n, double p) {
        this.n = n;
        this.p = p;
    }
    //---------------------------

    //Getters and setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }
    //----------------------------------

    //método que retorna la probabilidad de p(X=x)
    public double funcionProbabilidad(int x) {
        double q = 1 - p;
        //formula        
        double resultado = Modulo.fBinomial(p, n, x).doubleValue();
        
        return resultado;
    }
    //------------------------------------------------

    //Método que retorna la probabilidad acumulada en un intervalo
    public double funcionDistribucion(int i, int f) {
        double resultado = 0.0;

        for (int x = i; x <= f; x++) {
            resultado += funcionProbabilidad(x);
        }

        return resultado;
    }
    //---------------------------------------

    //Indicadores
    @Override
    public double media() {
        return n * p;
    }

    @Override
    public double varianza() {
        return media() * (1 - p);
    }

    @Override
    public double desviacionEstandar() {
        return Math.pow(varianza(), (1 / 2));
    }
    //----------------------------------------------------

}
