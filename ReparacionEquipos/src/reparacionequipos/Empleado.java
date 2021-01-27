/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author icasc
 */
public class Empleado {

    protected long id;                  //no puede ser menor de 0
    protected String nombre;
    protected String telefono;          //debe ser una sucesión de 9 números
    protected String nif;               //debe ser una sucesión de 8 números y 1 letra
    protected String apellido;
    protected String direccion;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String teléfono, String nif, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = teléfono;
        this.nif = nif;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.telefono = e.telefono;
        this.nif = e.nif;
        this.apellido = e.apellido;
        this.direccion = e.direccion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNif() {
        return nif;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static long nextIdEmpleado() {
        long ret = 0;
        for (Empleado e : Utilidades.EMPLEADOS) {
            if (e.getId() > ret) {
                ret = e.getId();
            }
        }
        for (Repartidor r : Utilidades.REPARTIDORES) {
            if (r.getId() > ret) {
                ret = r.getId();
            }
        }
        for (Sustituto s : Utilidades.SUSTITUTOS) {
            if (s.getId() > ret) {
                ret = s.getId();
            }
        }
        for (Detaller s : Utilidades.DETALLERES) {
            if (s.getId() > ret) {
                ret = s.getId();
            }
        }
        return ret + 1;
    }

    public static Empleado nuevoEmpleado() {
        Empleado nuevoEmpleado = new Empleado();
        Scanner in = new Scanner(System.in);
        nuevoEmpleado.id = nextIdEmpleado();
        System.out.print("Introduzca el nombre del nuevo empleado: ");
        nuevoEmpleado.nombre = in.nextLine();
        System.out.print("Introduzca el teléfono del nuevo empleado: ");
        nuevoEmpleado.telefono = in.nextLine();
        System.out.print("Introduzca el nif del nuevo empleado: ");
        nuevoEmpleado.nif = in.nextLine();
        System.out.print("Introduzca el apellido del nuevo empleado: ");
        nuevoEmpleado.apellido = in.nextLine();
        System.out.print("Introduzca la direccion del nuevo empleado: ");
        nuevoEmpleado.direccion = in.nextLine();
        return nuevoEmpleado;
    }

    public static void verEmpleado(ArrayList<Empleado> empleados) {
        System.out.println("En el sistema estan registrados los siguientes empleados:");
        for (Empleado e : empleados) {
            System.out.println(e.getId() + ". " + e.getNombre() + ". " + e.getApellido() + ". " + e.getTelefono() + ". " + e.getNif() + ". " + e.getDireccion() + ". (" + e.getClass().getSimpleName() + ")");
        }
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", nif=" + nif + ", apellido=" + apellido + ", direccion=" + direccion + '}';
    }

}
