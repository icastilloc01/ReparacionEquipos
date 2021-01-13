/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.Scanner;

/**
 *
 * @author aitor
 */
public class Reparacion {

    private long id;
    private int duraciontotal;

    public void setDuraciontotal(int duraciontotal) {
        this.duraciontotal = duraciontotal;
    }

    public Reparacion() {
    }

    public Reparacion(long id, int duraciontotal) {
        
        if(id>=0){
            System.out.println("Datos validos");
        }
        else{
            System.out.println("Datos invalidos");
        }
        this.id = id;
        
        if(duraciontotal>=0){
            System.out.println("Datos validos");
        
        }
        else{
            System.out.println("Datos invalidos");
        
        }
        this.duraciontotal = duraciontotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuraciontotal() {
        return duraciontotal;
    }

    public static Reparacion nuevoreparacion() {

        Reparacion nuevoreparacion = new Reparacion();
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame tu id");
        long id = sc.nextLong();
        nuevoreparacion.setId(id);
        int duracionhoras = sc.nextInt();
        nuevoreparacion.setDuraciontotal(duracionhoras);

        return nuevoreparacion;

    }

    @Override
    public String toString() {
        return "Hay trabajadores con el id :"+id+"y han trabajado estas horas"+duraciontotal;
    }
    
    

}
