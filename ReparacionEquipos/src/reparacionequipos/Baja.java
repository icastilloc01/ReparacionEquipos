/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.sql.Date;

/**
 *
 * @author icasc
 */
public class Baja{
    private long id;
    private Date fechainicio;
    private Date fechafin;
    private String motivo;

    public Baja() {
    }
    
    public Baja(long id, Date fechainicio, Date fechafin, String motivo) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.motivo = motivo;
    }
    
    public Baja(Baja b){
        this.id= b.id;
        this.fechainicio = b.fechainicio;
        this.fechafin = b.fechafin;
        this.motivo = b.motivo;
    }

    public long getId() {
        return id;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}

