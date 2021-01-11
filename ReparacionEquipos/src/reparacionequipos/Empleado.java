/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author icasc
 */
public class Empleado {

    protected long id;                  //no puede ser menor de 0
    protected String nombre;
    protected String teléfono;          //debe ser una sucesión de 9 números
    protected String nif;               //debe ser una sucesión de 8 números y 1 letra
    protected String apellido;
    protected String direccion;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String teléfono, String nif, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.teléfono = teléfono;
        this.nif = nif;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.teléfono = e.teléfono;
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

    public String getTeléfono() {
        return teléfono;
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

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
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

    public static Empleado nuevoEmpleado() {
        Empleado nuevoEmpleado = new Empleado();
        Scanner in = new Scanner(System.in);
        System.out.print("Introduzca el id del nuevo empleado: ");
        nuevoEmpleado.id = in.nextInt();
        System.out.println("El caracter que ha introducido no no es un Número");
        nuevoEmpleado.nombre = in.nextLine();
        nuevoEmpleado.nombre = in.nextLine();
        System.out.print("Introduzca el nombre del nuevo empleado: ");
        nuevoEmpleado.nombre = in.nextLine();
        System.out.print("Introduzca el teléfono del nuevo empleado: ");
        nuevoEmpleado.teléfono = in.nextLine();
        System.out.print("Introduzca el nif del nuevo empleado: ");
        nuevoEmpleado.nif = in.nextLine();
        System.out.print("Introduzca el apellido del nuevo empleado: ");
        nuevoEmpleado.apellido = in.nextLine();
        System.out.print("Introduzca la direccion del nuevo empleado: ");
        nuevoEmpleado.direccion = in.nextLine();
        return nuevoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", tel\u00e9fono=" + teléfono + ", nif=" + nif + ", apellido=" + apellido + ", direcci\u00f3n=" + direccion + '}';
    }

}
