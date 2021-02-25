/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public class ReparacionException extends RuntimeException {

    public ReparacionException(String message) {
        super(message);
    }
    
    public static int idreparacion(int idreparacion){
        if(idreparacion<=0){
            System.out.println("Valor no valido");
        }
        return idreparacion;
    }
    
     public static int duraciontotal(int duracion){
        if(duracion<=0){
            System.out.println("Valor no valido");
        }
        return duracion;
    }
     
     
}
