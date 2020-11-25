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
public class Lote {
    private long idLote;
    private int descuento;
    private ArrayList<Equipo> equipos = new ArrayList<>();

    public Lote(long idLote, int descuento) {
        this.idLote = idLote;
        this.descuento = descuento;
    }
    
    public Lote (Lote l){
        this.idLote = l.getIdLote();
        this.descuento = l.getDescuento();
    }
    
    public Lote(){}
    
    public long getIdLote() {
        return idLote;
    }

    public void setIdLote(long idLote) {
        this.idLote = idLote;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    
    
}
