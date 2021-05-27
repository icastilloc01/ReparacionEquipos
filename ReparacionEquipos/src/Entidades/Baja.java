/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author icasc
 */
public class Baja {

    private long id;
    private Date fechainicio;
    private Date fechafin;
    private String motivo;
    private Empleado empleado;

    public Baja() {
    }

    public Baja(long id, Date fechainicio, Date fechafin, String motivo, Empleado empleado) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.motivo = motivo;
        this.empleado = empleado;
    }

    public Baja(Baja b) {
        this.id = b.id;
        this.fechainicio = b.fechainicio;
        this.fechafin = b.fechafin;
        this.motivo = b.motivo;
        this.empleado = b.empleado;
    }

    public long getId() {
        return id;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public static long nextIdBaja() {
        long ret = 0;
        for (Baja b : Utilidades.BAJAS) {
            if (b.getId() > ret) {
                ret = b.getId();
            }
        }
        return ret;
    }

    public static Baja nuevaBaja() {
        Baja nuevaBaja = new Baja();
        Scanner in = new Scanner(System.in);
        nuevaBaja.setId(nextIdBaja());
        System.out.print("Introduzca la fecha de inicio de la baja: ");
        nuevaBaja.fechainicio = Utilidades.introducirFecha();
        do {
            System.out.println("Introduzca el motivo de la baja: ");
            nuevaBaja.motivo = in.nextLine();
            if (nuevaBaja.motivo.length() > 100) {
                System.out.println("El motivo introducido esta vacio o es demasiado largo");
            }
        } while (nuevaBaja.motivo.length() > 100 || nuevaBaja.motivo.length() == 0);
        return nuevaBaja;
    }

    public static ArrayList<Baja> convertir(Baja[] array) {
        ArrayList<Baja> ret = new ArrayList<Baja>();
        for (Baja b : array) {
            ret.add((Baja) b);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Baja{" + "id=" + id + ", fechainicio=" + fechainicio + ", fechafin=" + fechafin + ", motivo=" + motivo + '}';
    }

}
