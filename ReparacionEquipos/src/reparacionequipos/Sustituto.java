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
public class Sustituto extends Empleado {

    private String edad;
    private boolean exclusiónsocial;

    public Sustituto() {
        super();
    }

    public Sustituto(String edad, boolean exclusiónsocial, long id, String nombre, String telefono, String nif, String apellido, String direccion) {
        super(id, nombre, telefono, nif, apellido, direccion);
        this.edad = edad;
        this.exclusiónsocial = exclusiónsocial;
    }

    public Sustituto(String edad, boolean exclusiónsocial, Empleado e) {
        super(e);
        this.edad = edad;
        this.exclusiónsocial = exclusiónsocial;
    }

    public Sustituto(String edad, boolean exclusiónsocial) {
        this.edad = edad;
        this.exclusiónsocial = exclusiónsocial;
    }

    public Sustituto(Sustituto s) {
        this.edad = s.edad;
        this.exclusiónsocial = s.exclusiónsocial;
    }

    public String getEdad() {
        return edad;
    }

    public boolean isExclusiónsocial() {
        return exclusiónsocial;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setExclusiónsocial(boolean exclusiónsocial) {
        this.exclusiónsocial = exclusiónsocial;
    }

    public static ArrayList<Sustituto> arrayde(ArrayList<Sustituto> lista, int[] ids) {
        ArrayList<Sustituto> ret = new ArrayList<Sustituto>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Sustituto) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Sustituto> convertir(Sustituto[] array) {
        ArrayList<Sustituto> ret = new ArrayList<Sustituto>();
        for (Sustituto s : array) {
            ret.add((Sustituto) s);
        }
        return ret;
    }

    public static Sustituto nuevoSustituto() {
        Sustituto nuevoSustituto = new Sustituto();
        Empleado e = Empleado.nuevoEmpleado();
        nuevoSustituto.setId(e.getId());
        nuevoSustituto.setNombre(e.getNombre());
        nuevoSustituto.setTelefono(e.getTelefono());
        nuevoSustituto.setNif(e.getNif());
        nuevoSustituto.setApellido(e.getApellido());
        nuevoSustituto.setDireccion(e.getDireccion());
        Scanner in = new Scanner(System.in);
        System.out.print("Introduzca la edad del nuevo sustituto: ");
        nuevoSustituto.edad = in.nextLine();
        System.out.print("¿Tiene exclusión social? S/N");
        nuevoSustituto.exclusiónsocial = in.nextBoolean();
        return nuevoSustituto;
    }

    @Override
    public String toString() {
        return "Sustituto{" + "edad=" + edad + ", exclusi\u00f3nsocial=" + exclusiónsocial + '}';
    }

}
