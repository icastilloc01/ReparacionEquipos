/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;
/**
 *
 * @author Rxndy
 */
public class EquipoException extends RuntimeException {


public EquipoException(){}

public EquipoException(String message){

    super(message);
}

public static boolean comprobarModeloEquipo(String modelo){
    return !modelo.isEmpty();

}
    
public static boolean comprobarId(long id){

    return id>0;

}


 public static boolean validarPrecioEquipo (double precio){
        
        return precio>0.0;
    
    }

}

