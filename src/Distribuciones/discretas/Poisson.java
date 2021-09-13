/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distribuciones.discretas;

import Distribuciones.Modulo;

/**
 *
 * @author sebastian
 */
public class Poisson implements Modulo{
     //Atributos de clase
    private double lamda;
    //-------------------------

    //constructor    
    public Poisson(double lamda) {
        this.lamda = lamda;
    }
    public Poisson(int n, double p) {
        this.lamda = n*p;
    }
    //---------------------------
    

    //Getters and setters
    public double getLamda() {
        return lamda;
    }
    public void setLamda(double lamda) {
        this.lamda = lamda;
    }
    //----------------------------------
    
    //método que retorna la probabilidad de p(X=x)
    public double funcionProbabilidad(int x) {        
        //formula
        double resultado = Modulo.fPoisson(lamda, x).doubleValue();

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
        return lamda;
    }

    @Override
    public double varianza() {
        return lamda;
    }

    @Override
    public double desviacionEstandar() {
        return Math.pow(lamda, (1 / 2));
    }
    //----------------------------------------------------
    
}
