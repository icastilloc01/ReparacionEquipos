/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public class Grupo {

    private long id;
    private ArrayList<Reparacion> reparaciones = new ArrayList<>();
    private ArrayList<Detaller> detalleres = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Grupo() {
    }

    public Grupo(long id) {
        this.id = id;
    }

    public Grupo(Grupo g) {
        this.id = g.id;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public ArrayList<Detaller> getDetalleres() {
        return detalleres;
    }

    public void setDetalleres(ArrayList<Detaller> detalleres) {
        this.detalleres = detalleres;
    }

}
