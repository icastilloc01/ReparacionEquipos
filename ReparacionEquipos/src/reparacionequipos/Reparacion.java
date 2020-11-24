/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

/**
 *
 * @author aitor
 */
public class Reparacion {
    
    private long id;
    private int duraciontotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuraciontotal() {
        return duraciontotal;
    }

    public void setDuraciontotal(int duraciontotal) {
        this.duraciontotal = duraciontotal;
    }

    public Reparacion() {
    }

    public Reparacion(long id, int duraciontotal) {
        this.id = id;
        this.duraciontotal = duraciontotal;
    }
    
    
    
    
    
}
