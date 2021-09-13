/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distribuciones;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * @author sebastian
 */
public interface Modulo {
    public static final int INFINITO = Integer.MAX_VALUE;
    public static final double E = Math.E;
    
    public static BigInteger factorial(int n){
        BigInteger res = new BigInteger("1");
        if (n==0) {
            return res;
        }else{            
            for (int i = 1; i <= n; i++) {
                res = res.multiply(BigInteger.valueOf(i));
            }
        }       
        
        return res;
    }
    
    public static BigDecimal factorialD(int n){
        BigDecimal res = new BigDecimal("1");
        if (n==0) {
            return res;
        }else{            
            for (int i = 1; i <= n; i++) {
                res = res.multiply(BigDecimal.valueOf(i));
            }
        }       
        
        return res;
    }
    
    
    public static BigDecimal combinatoria(int n, int x){   
        BigDecimal numerador = new BigDecimal(factorial(n));
        BigDecimal den1 = new BigDecimal(factorial(x));
        BigDecimal den2 = new BigDecimal(factorial(n-x));
        
        BigDecimal resultado = numerador.divide(den1.multiply(den2),5,RoundingMode.HALF_UP);               
        return resultado;
    } 
    
    
    
    public static BigDecimal potencia(double base, double exp){
        return new BigDecimal(Math.pow(base,exp));
    }  
    
    public static BigDecimal fBinomial(double p, int n, int x){
        BigDecimal b1 = combinatoria(n, x);
        BigDecimal b2 = potencia(p, x);
        BigDecimal b3 = potencia((1-p), (n - x));
        BigDecimal resultado = b1.multiply(b2.multiply(b3));
        return resultado;
    }
    
    public static BigDecimal fHiperGeometrica(int R, int Ntotal, int n, int x){
        BigDecimal b1 = combinatoria((Ntotal-R), (n-x));
        BigDecimal b2 = combinatoria(R, x);
        BigDecimal b3 = combinatoria(Ntotal, n);
        BigDecimal resultado = b1.multiply(b2).divide(b3,RoundingMode.HALF_EVEN);        
        
        return resultado;
    }
    
    public static BigDecimal fPoisson(double lamda, int x){
        BigDecimal b1 = potencia(lamda, x);
        BigDecimal b2 = potencia(E, -lamda);
        BigDecimal b3 = factorialD(x);
        
        BigDecimal resultado = b1.multiply(b2).divide(b3,RoundingMode.HALF_EVEN);                   
        
        return resultado;
    }
    
    public abstract double media();
    public abstract double varianza();
    public abstract double desviacionEstandar();
    
}
