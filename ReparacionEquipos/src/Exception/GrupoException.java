/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.util.ArrayList;
import Entidades.Detaller;
import Entidades.Reparacion;

/**
 *
 * @author aitor
 */
public class GrupoException extends RuntimeException{
     public GrupoException(String message) {
        super(message);
    }
     
     
     public static long idreparacion(long idgrupo){
        if(idgrupo<=0){
            System.out.println("Valor no valido");
        }
        return idgrupo;
    }
     
     public static boolean comprobarReparacionesArrayList(ArrayList <Reparacion> reparaciones){
     
         boolean resultado=false;
         if(reparaciones.isEmpty()){
             resultado=false;
             System.out.println("El arraylist de reparaciones se inicializa a un array vacío");
             
         }
         else{
             resultado=true;
             System.out.println("El array contiene "+reparaciones);
             
         }
         return resultado;
     }


    public static boolean comprobarDeTalleresArrayList(ArrayList <Detaller> DeTalleres){
     
         boolean resultado=false;
         if(DeTalleres.isEmpty()){
             resultado=false;
             System.out.println("El arraylist de reparaciones se inicializa a un array vacío");
             
         }
         else{
             resultado=true;
             System.out.println("El array contiene "+DeTalleres);
             
         }
         return resultado;
     }




}
