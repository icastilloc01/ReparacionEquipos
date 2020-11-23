/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

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
    
    public Detaller (Detaller c) {
        this.senior = c.senior;
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
}
