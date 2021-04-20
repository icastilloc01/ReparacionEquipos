/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.util.ArrayList;
import reparacionequipos.Equipo;

/**
 *
 * @author Rxndy
 */
public class LoteException extends RuntimeException{
    
    public LoteException(){}
    
    public LoteException(String message){
    
        super(message);
    
    }
    
   public static boolean comprobarId(long id){
   
       return id>0;
   }
   
   public static boolean comprobarDescuento(int descuento){
   
       return descuento>0;
   }
   
   public static boolean comprobarArrayListEquipos(ArrayList <Equipo> Equipos){
    
        return Equipos.isEmpty();
    }
}
