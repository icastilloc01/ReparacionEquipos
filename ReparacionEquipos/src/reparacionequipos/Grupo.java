/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Scanner;

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

    public static Grupo nuevigrupo() {
        Reparacion r2 = Reparacion.nuevoreparacion();
        Grupo nuevogrupo = new Grupo();
        Scanner sc = new Scanner(System.in);
        // System.out.println(" Este es tu id :" + Grupo.thenextid());
        //Los dos arrays de Reparaciones y Detaller, se inicializan a dos arrays vacíos.
        return nuevogrupo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", reparaciones=" + reparaciones + ", detalleres=" + detalleres ;
    }

}
