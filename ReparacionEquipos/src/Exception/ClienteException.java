/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.util.ArrayList;
import Entidades.Servicio;

/**
 *
 * @author Rxndy
 */
public class ClienteException extends RuntimeException{
    
    
    public ClienteException(){}
    
    public ClienteException(String message) {
        super(message);
    }
    
    public static boolean comprobarTelefono(String telefono){
        return telefono.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d");
    }
    
    public static boolean comprobarNombre(String nombre){
        return !nombre.isEmpty();
    }
    
    public static boolean comprobarNif(String nif){
        return nif.matches("\\d\\d\\d\\d\\d\\d\\d\\.");
    
    }
    
     public static boolean comprobarDireccion(String direccion){
        return !direccion.isEmpty();
    }
     
    public static boolean comprobarTarjetaCredito(String credito){
        return credito.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d");
    }
    
    public static boolean comprobarCuentaCorriente(String credito){
        return credito.matches(".\\.\\d\\d\\d\\d\\d\\d\\d\\d\\d");
    }
     
    public static boolean comprobarArrayListServicios(ArrayList <Servicio> Servicios){
    
        return Servicios.isEmpty();
    }
    
    public static boolean comprobarId(long id){
    
        return id>0;
    }
    
    
}
