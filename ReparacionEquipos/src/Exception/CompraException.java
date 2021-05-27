/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.util.ArrayList;
import Entidades.Equipo;
import Entidades.Lote;

/**
 *
 * @author Rxndy
 */
public class CompraException extends RuntimeException {
    
    public CompraException(){}
    
     public CompraException(String message) {
        super(message);
    }
     
    public static boolean validarMetodoPago(char metodoPago){

    
        return metodoPago=='E' || metodoPago=='T' || metodoPago=='B' ;
        
    }
    
    public static boolean validarPrecioTotal (double precio){
        
        return precio>0.0;
    
    }
    
    public static boolean validarId(long id){
        
        return id>0;
    }
    
    
    public static boolean comprobarArrayListEquipos(ArrayList <Equipo> Equipos){
    
        return Equipos.isEmpty();
    }
    
    public static boolean comprobarArrayListLotes(ArrayList <Lote> Lotes){
    
        return Lotes.isEmpty();
    }
    
}
