/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author aitor
 */
public class Grupo {

    private long idgrupo;
    private ArrayList<Reparacion> reparaciones = new ArrayList<>();
    private ArrayList<Detaller> detalleres = new ArrayList<>();

    public long getId() {
        return idgrupo;
    }

    public void setId(long id) {
        this.idgrupo = id;
    }

    public Grupo() {
    }

    public Grupo(long id) {
        this.idgrupo = id;
    }

    public Grupo(Grupo g) {
        this.idgrupo = g.idgrupo;
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

    public static Grupo nuevogrupo() {
        Reparacion r2 = Reparacion.listareparaciones();
        Grupo nuevogrupo = new Grupo();
        Scanner sc = new Scanner(System.in);
        //Muestro el día y la hora
        SimpleDateFormat sdf = new SimpleDateFormat(" EEEE dd MMMM yyyy(hh:mm:ss)");
        System.out.println("Ahora es el día y la hora : " + sdf.format(new Date()));
        //System.out.println(" Este es tu id :" + Grupo.thenextid());
        if (nuevogrupo.getId() <= 0) {
            throw new GrupoException("Valor no valido");
        }
        if (nuevogrupo.getReparaciones().isEmpty()) {
            throw new GrupoException("Este ArrayList es un ArrayList vacío");
        } else {
            StringBuffer sb = new StringBuffer("Estos son los datos del arraydeReparaciones:" + nuevogrupo.getReparaciones());
            sb.insert(sb.indexOf(" . "), " Adios");
            System.out.println(sb);

        }

        if (nuevogrupo.getDetalleres().isEmpty()) {
            throw new GrupoException("Este ArrayList es un ArrayList vacío");
        } else {
            StringBuffer sb = new StringBuffer("Estos son los datos del arraydeReparaciones:" + nuevogrupo.getDetalleres());
            sb.insert(sb.indexOf(" . "), " Adios");
            System.out.println(sb);

        }

        //Los dos arrays de Reparaciones y Detaller, se inicializan a dos arrays vacíos.
        return nuevogrupo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + idgrupo + ", reparaciones=" + reparaciones + ", detalleres=" + detalleres;
    }

}
