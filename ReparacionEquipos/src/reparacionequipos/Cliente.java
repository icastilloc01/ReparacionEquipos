/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

/**
 *
 * @author Rxndy
 */
public class Cliente {
    private long id;
    private String nombre;
    private String nif;
    private String direccion;
    private String telefono;
    private String tarjetaCredito;
    private String cuentaCorriente;

    
    //constructor por defecto
    public Cliente() {
    }

    
    
    
    //constructor parámetros
    public Cliente(long id, String nombre, String nif, String direccion, String telefono, String tarjetaCredito, String cuentaCorriente) {
        this.id = id;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjetaCredito = tarjetaCredito;
        this.cuentaCorriente = cuentaCorriente;
    }
    
    //constructor copia
    private Cliente(Cliente c){
        this.id = c.id;
        this.nombre = c.nombre;
        this.nif = c.nif;
        this.direccion = c.direccion;
        this.telefono = c.telefono;
        this.tarjetaCredito = c.tarjetaCredito;
        this.cuentaCorriente = c.cuentaCorriente;
    }
    
    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(String cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    
}
