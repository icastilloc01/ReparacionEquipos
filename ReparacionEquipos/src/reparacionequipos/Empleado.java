/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

/**
 *
 * @author icasc
 */
public class Empleado {
    protected long id;
    protected String nombre;
    protected String teléfono;
    protected String nif;
    protected String apellidos;
    protected String dirección;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String teléfono, String nif, String apellidos, String dirección) {
        this.id = id;
        this.nombre = nombre;
        this.teléfono = teléfono;
        this.nif = nif;
        this.apellidos = apellidos;
        this.dirección = dirección;
    }
    
    public Empleado (Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.teléfono = e.teléfono;
        this.nif = e.nif;
        this.apellidos = e.apellidos;
        this.dirección = e.dirección;
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

    public String getApellidos() {
        return apellidos;
    }

    public String getDirección() {
        return dirección;
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

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
    
    
}
