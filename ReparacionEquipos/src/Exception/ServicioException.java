/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.util.ArrayList;
import java.util.Date;
import Entidades.Cliente;

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
   public static boolean comprobarId(long id){
   
       return id>0;
   }
   
   public static boolean comprobarArrayListClientes(ArrayList <Cliente> Clientes){
    
        return Clientes.isEmpty();
    }
}
