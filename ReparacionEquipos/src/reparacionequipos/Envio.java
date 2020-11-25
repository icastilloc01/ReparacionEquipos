/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PC_Alba
 */
public class Envio {

    private long id;
    private Date fechaSalida;
    private int precioDeReparto;
    private double precioTotal;
    private double coste;
    private String lugar;
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Repartidor> repartidores = new ArrayList<>();

    
    public Envio() {
    }

    public Envio(long id, Date fechaSalida, int precioDeReparto, double precioTotal, double coste, String lugar) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.precioDeReparto = precioDeReparto;
        this.precioTotal = precioTotal;
        this.coste = coste;
        this.lugar = lugar;
    }
    
    public Envio(Envio en) {
        this.id = en.id;
        this.fechaSalida = en.fechaSalida;
        this.precioDeReparto = en.precioDeReparto;
        this.precioTotal = en.precioTotal;
        this.coste = en.coste;
        this.lugar = en.lugar;       
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPrecioDeReparto() {
        return precioDeReparto;
    }

    public void setPrecioDeReparto(int precioDeReparto) {
        this.precioDeReparto = precioDeReparto;
    }

    public double getPtrcioTotal() {
        return precioTotal;
    }

    public void setPtrcioTotal(double ptrcioTotal) {
        this.precioTotal = ptrcioTotal;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void setRepartidores(ArrayList<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

}
