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
public class Compra {
    private long idCompra;
    private double precioTotal;
    private char metodoPago;

    public Compra(long idCompra, double precioTotal, char metodoPago) {
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
    }

    public Compra(Compra c){
        this.idCompra = c.getIdCompra();
        this.metodoPago = c.getMetodoPago();
        this.precioTotal = c.getPrecioTotal();
    }
    
    public Compra(){}

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
    
    
    
}
