/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rxndy
 */
@Entity
@Table(name = "baja", catalog = "reparacion_equipos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Baja.findAll", query = "SELECT b FROM Baja b")
    , @NamedQuery(name = "Baja.findById", query = "SELECT b FROM Baja b WHERE b.id = :id")
    , @NamedQuery(name = "Baja.findByFechaInicio", query = "SELECT b FROM Baja b WHERE b.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Baja.findByFechaFin", query = "SELECT b FROM Baja b WHERE b.fechaFin = :fechaFin")
    , @NamedQuery(name = "Baja.findByMotivo", query = "SELECT b FROM Baja b WHERE b.motivo = :motivo")})
public class Baja implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;

    public Baja() {
    }

    public Baja(Integer id) {
        this.id = id;
    }

    public Baja(Integer id, Date fechaInicio, String motivo) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.motivo = motivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        Date oldFechaInicio = this.fechaInicio;
        this.fechaInicio = fechaInicio;
        changeSupport.firePropertyChange("fechaInicio", oldFechaInicio, fechaInicio);
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        Date oldFechaFin = this.fechaFin;
        this.fechaFin = fechaFin;
        changeSupport.firePropertyChange("fechaFin", oldFechaFin, fechaFin);
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        String oldMotivo = this.motivo;
        this.motivo = motivo;
        changeSupport.firePropertyChange("motivo", oldMotivo, motivo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baja)) {
            return false;
        }
        Baja other = (Baja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Baja[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
