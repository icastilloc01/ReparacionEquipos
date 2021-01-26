/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

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
    private ArrayList<Sustituto> sustitutos = new ArrayList<Sustituto>();

    public Baja() {
    }

    public Baja(long id, Date fechainicio, Date fechafin, String motivo, ArrayList<Sustituto> sustitutos) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.motivo = motivo;
        this.sustitutos = sustitutos;
    }

    public Baja(Baja b) {
        this.id = b.id;
        this.fechainicio = b.fechainicio;
        this.fechafin = b.fechafin;
        this.motivo = b.motivo;
        this.sustitutos = b.sustitutos;
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

    public static Baja nuevaBaja() {
        Baja nuevaBaja = new Baja();
        Scanner in = new Scanner(System.in);
        System.out.print("Introduzca el id de la baja: ");
        nuevaBaja.id = in.nextLong();
        nuevaBaja.motivo = in.nextLine(); //esta linea es para que no se salte el proximo nextLine
        System.out.print("Introduzca la fecha de inicio de la baja: ");
        nuevaBaja.fechainicio = Utilidades.introducirFecha();
        System.out.print("Introduzca la fecha de fin de la baja: ");
        nuevaBaja.fechafin = Utilidades.introducirFecha();
        System.out.println("Introduzca el motivo de la baja: ");
        nuevaBaja.motivo = in.nextLine();
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
