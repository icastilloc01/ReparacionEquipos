/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author aitor
 */
public class Reparacion extends Servicio {

    private long idreparacion;
    private int duraciontotal;
    private Mantenimiento mantenimiento;

    public void setDuraciontotal(int duraciontotal) {
        this.duraciontotal = duraciontotal;
    }

    public Reparacion() {
        super();
    }

    public Reparacion(long idreparacion, int duraciontotal, Mantenimiento mantenimiento, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        super(id, fechaServicio, nota, clientes);
        this.idreparacion = idreparacion;
        this.duraciontotal = duraciontotal;
        this.mantenimiento = mantenimiento;
    }

    public Reparacion(long idreparacion, int duraciontotal, Mantenimiento mantenimiento, Servicio se) {
        super(se);
        this.idreparacion = idreparacion;
        this.duraciontotal = duraciontotal;
        this.mantenimiento = mantenimiento;
    }

    public Reparacion(Reparacion e) {
        this.idreparacion = e.idreparacion;
        this.duraciontotal = e.duraciontotal;
        this.mantenimiento = e.mantenimiento;
    }

    public long getIdreparacion() {
        return idreparacion;
    }

    public void setIdreparacion(long idreparacion) {
        this.idreparacion = idreparacion;
    }

    public int getDuraciontotal() {
        return duraciontotal;
    }

    public static Reparacion nuevaReparacion() {
        Reparacion r = new Reparacion();
        Scanner in = new Scanner(System.in);
        boolean salir;
        do {
            System.out.println("Introduzca el id de la reparación:");
            long id = in.nextLong();
            r.setId(id);
            System.out.println("Introduzca la duración de la reparación:");
            int duracion = in.nextInt();
            r.setDuraciontotal(duracion);
            System.out.println("Son correctos los siguientes datos?(s/n):");
            System.out.println("id:" + id);
            System.out.println("duracion:" + duracion);
            salir = Utilidades.leerBoolean();
        } while (salir);

        return r;

    }

    @Override
    public String toString() {
        return "Reparacion{" + "id=" + id + ", duraciontotal=" + duraciontotal + '}';
    }

    public Reparacion(long id, int duraciontotal, Mantenimiento mantenimiento) {
        this.id = id;
        this.duraciontotal = duraciontotal;
        this.mantenimiento = mantenimiento;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public static ArrayList<Reparacion> arrayde(ArrayList<Reparacion> lista, int[] ids) {
        ArrayList<Reparacion> ret = new ArrayList<Reparacion>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Reparacion) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Reparacion> convertir(Reparacion[] array) {
        ArrayList<Reparacion> ret = new ArrayList<Reparacion>();
        for (Reparacion s : array) {
            ret.add((Reparacion) s);
        }
        return ret;

    }

    public static long nextIdReparacion() {
        long ret = 0;
        for (Reparacion r : Utilidades.REPARACIONES) {
            if (r.getIdreparacion() > ret) {
                ret = r.getIdreparacion();
            }
        }
        return ret + 1;
    }

    public static Reparacion nuevoreparacion() {
        Servicio se = Servicio.nuevoServicio();
        Mantenimiento m = Mantenimiento.nuevomantenimiento();
        Scanner sc = new Scanner(System.in);
        Reparacion nuevoreparacion = new Reparacion();
        nuevoreparacion.idreparacion = nextIdReparacion();
        System.out.println(" Muestráme las horas que has trabajado :");
        do {
            int duraciontotal = sc.nextInt();
            if (duraciontotal > 0) {
                System.out.println("Los datos son validos");

            } else {
                System.out.println("Los datos no son validos");
            }
        } while (nuevoreparacion.duraciontotal <= 0);
        System.out.println("Vuelve a esribir de manera correcta las horas por favor");
        int duraciontotal = sc.nextInt();
        nuevoreparacion.setDuraciontotal(duraciontotal);
        System.out.println("Esta reparacion se ha asignado a un grupo");

        return nuevoreparacion;

    }

}
