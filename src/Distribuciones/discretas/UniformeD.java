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
public class UniformeD implements Modulo{
    //Atributos de clase
    private int n;
    //-------------------------

    //constructor    
    public UniformeD(int n) {        
        this.n = n;
    }
    //---------------------------
    //Getters and setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }    
    //----------------------------------
    
    //método que retorna la probabilidad de p(X=x)
    public double funcionProbabilidad(int x) {        
        //formula        
        double resultado = (1/(double)n);

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
        double acumuador = 0.0;
        for (int i = 1; i <= n; i++) {
            acumuador += i;
        }
        return (1/(double)n)*acumuador;
    }

    @Override
    public double varianza() {
        double acumuador = 0.0;
        for (int i = 1; i <= n; i++) {
            acumuador += Math.pow((i-media()),2);
        }
        return (1/(double)n)*acumuador;
    }

    @Override
    public double desviacionEstandar() {
        return Math.pow(varianza(), (1 / 2));
    }
    //----------------------------------------------------
    
}
