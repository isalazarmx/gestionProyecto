/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Jesus
 */
public class ControllerCuentas {
    
    public double gananciaIndividual(double cantidad, double incremento){
        return cantidad*(incremento);
    }
    
    public double gananciaTotal(double gananciaIndividual,double unidades){
        return unidades*gananciaIndividual;
    }
    
    public double precioVenta(double cantidad,double incremento){
        return cantidad*(1+incremento);
    }
    
    public double cantidadInvertida(double unidades,double cantidad){
        return unidades*cantidad;
    }
    
    public String formatoNumero(String cant){
        String temp = "";
        int posDot = cant.indexOf(".");
        int aux = cant.length() - posDot;
        if(aux >= 3){
            int posEnd = posDot + 3;
            temp = cant.substring(0, posEnd);
        }else if(aux == 2){
            temp = ""+cant+"0";
        }
        return temp;
    }
}
