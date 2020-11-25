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
    private double ptrcioTotal;
    private double coste;
    private String lugar;
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    private ArrayList<Repartidor> repartidores = new ArrayList<Repartidor>();

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
        return ptrcioTotal;
    }

    public void setPtrcioTotal(double ptrcioTotal) {
        this.ptrcioTotal = ptrcioTotal;
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

    public Envio() {
    }

}
