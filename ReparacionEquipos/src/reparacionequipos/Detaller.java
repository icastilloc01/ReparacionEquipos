/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.Scanner;

/**
 *
 * @author icasc
 */
public class Detaller extends Empleado {
    private boolean senior;

    public Detaller() {
        super();
    }
    
    public Detaller (boolean senior) {
        this.senior = senior;
    }
    
    public Detaller (Detaller d) {
        this.senior = d.senior;
    }
    /**
     *
     * @return
     */
    
    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }
    
    public static Detaller nuevoDetaller(){
        Detaller nuevoDetaller = new Detaller();
        Scanner in = new Scanner(System.in);
        System.out.println("¿Es senior?");
        nuevoDetaller.senior = in.nextBoolean();
        return nuevoDetaller;
    }

    @Override
    public String toString() {
        return "Detaller{" + "senior=" + senior + '}';
    }
    
}
