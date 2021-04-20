/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author aitor
 */
public class MantenimientoException extends RuntimeException {

    public MantenimientoException(String message) {
        super(message);
    }
    
    public static int comprobarhoras(int horas){
        if(horas<0){
            System.out.println("El valor introducido es incorrecto");
        }
       
       return horas;
    }
}


