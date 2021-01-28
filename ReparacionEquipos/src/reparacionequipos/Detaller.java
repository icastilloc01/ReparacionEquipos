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
 * @author icasc
 */
public class Detaller extends Empleado {

    private boolean senior = false;

    public Detaller() {
        super();
    }

    public Detaller(boolean senior, Empleado e) {
        super(e);
        this.senior = false;
    }

    public Detaller(boolean senior, long id, String nombre, String telefono, String nif, String apellido, String direccion) {
        super(id, nombre, telefono, nif, apellido, direccion);
        this.senior = false;
    }

    public Detaller(boolean senior) {
        this.senior = false;
    }

    public Detaller(Detaller d) {
        this.senior = d.senior;
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

    public static Detaller nuevoDetaller() {
        Detaller nuevoDetaller = new Detaller();
        Empleado e = Empleado.nuevoEmpleado();
        nuevoDetaller.setId(e.getId());
        nuevoDetaller.setNombre(e.getNombre());
        nuevoDetaller.setTelefono(e.getTelefono());
        nuevoDetaller.setNif(e.getNif());
        nuevoDetaller.setApellido(e.getApellido());
        nuevoDetaller.setDireccion(e.getDireccion());
        System.out.println("¿Es senior? s/n: ");
        nuevoDetaller.senior = Utilidades.leerBoolean();
        return nuevoDetaller;
    }
    
    public static ArrayList<Detaller> convertir(Detaller[] array) {
        ArrayList<Detaller> ret = new ArrayList<Detaller>();
        for (Detaller d : array) {
            ret.add((Detaller) d);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Detaller{" + "senior=" + senior + '}';
    }

}
