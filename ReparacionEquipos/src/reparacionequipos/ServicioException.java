/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.Date;

/**
 *
 * @author Rxndy
 */
public class ServicioException extends RuntimeException{
    
    public ServicioException(){}
    
    public ServicioException(String message){
    
        super(message);
    
    }
    
   public static boolean comprobarNota(String nota){
   
       return !nota.isEmpty();
   }
   
   /*public static boolean comprobarFecha(Date fecha){
       return fecha.before(fecha)
   
   }*/
    
}
