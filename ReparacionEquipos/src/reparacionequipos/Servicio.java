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
 * @author Rxndy
 */
public class Servicio {

    protected long id;
    protected Date fechaServicio;
    protected String nota;
    protected ArrayList<Cliente> clientes = new ArrayList<>();

    public Servicio(long id, Date fechaServicio, String nota) {
        this.id = id;
        this.fechaServicio = fechaServicio;
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Servicio(Servicio se) {
        this.fechaServicio = se.getFechaServicio();
        this.id = se.getId();
        this.nota = se.getNota();
    }

    public Servicio() {
    }
}
