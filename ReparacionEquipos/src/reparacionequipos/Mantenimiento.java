/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aitor
 */
public class Mantenimiento extends Servicio {

    private int horastrabajadas;
    private ArrayList<Reparacion> reparaciones = new ArrayList<>();

    public Mantenimiento() {
        super();
    }

    public Mantenimiento(int horastrabajadas, long id, Date fechaServicio, String nota) {
        super(id, fechaServicio, nota);
        this.horastrabajadas = horastrabajadas;
    }

    public Mantenimiento(Mantenimiento m) {
        super(m);
        this.horastrabajadas = m.horastrabajadas;
    }

    public int getHorastrabajadas() {
        return horastrabajadas;
    }

    public void setHorastrabajadas(int horastrabajadas) {
        this.horastrabajadas = horastrabajadas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    @Override
    public String toString() {
        return "Mantenimiento{" + "horastrabajadas=" + horastrabajadas + ", reparaciones=" + reparaciones + '}';
    }
    
    
    
}
