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
 * @author icasc
 */
public class Envio {
    private long id;
    private Date fechaSalida;
    private int preciodereparto;
    private double preciototal;
    private double coste;
    private String lugar;
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Repartidor> repartidores = new ArrayList<>();
    
    public Envio() {
        
    }

    public Envio(long id, Date fechaSalida, int preciodereparto, double preciototal, double coste, String lugar) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.preciodereparto = preciodereparto;
        this.preciototal = preciototal;
        this.coste = coste;
        this.lugar = lugar;
    }
    
    public Envio(Envio en){
        this.id = en.id;
        this.fechaSalida = en.fechaSalida;
        this.preciototal = en.preciototal;
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

    public int getPreciodereparto() {
        return preciodereparto;
    }

    public void setPreciodereparto(int preciodereparto) {
        this.preciodereparto = preciodereparto;
    }

    public double getPrecioTotal() {
        return preciototal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.preciototal = precioTotal;
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

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void setRepartidores(ArrayList<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }
    
}
