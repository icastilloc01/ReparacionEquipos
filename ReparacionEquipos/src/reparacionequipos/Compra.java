/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;

/**
 *
 * @author Rxndy
 */
public class Compra extends Servicio {

    private long idCompra;
    private double precioTotal;
    private char metodoPago;
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Lote> lotes = new ArrayList<>();

    public Compra(long idCompra, double precioTotal, char metodoPago) {
        super();
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
    }

    public Compra(Compra c) {
        super();
        this.idCompra = c.getIdCompra();
        this.metodoPago = c.getMetodoPago();
        this.precioTotal = c.getPrecioTotal();
    }

    public Compra() {
        super();
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public char getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(char metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }

}
