package tarea8_progdawdam1;

import java.util.TreeSet;

/**
 *
 * @author luis
 */
public class Competicion {
    
    private String nombre;
    private int anio;
    private double premio;
    private TreeSet<Carrera> carreras = new TreeSet<Carrera>();

    public Competicion() {
    }
    
    public Competicion(String nombre, int anio, double premio){
        this.nombre = nombre;
        this.anio = anio;
        this.premio = premio;
    }

    public Competicion(String nombre, int anio, double premio, TreeSet<Carrera> carreras) {
        this.nombre = nombre;
        this.anio = anio;
        this.premio = premio;
        this.carreras = carreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public TreeSet<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(TreeSet<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return "Gran premio " + nombre + " del año " + anio + ", dotado con un premio de " + premio + "$ y compuesto de las siguientes carreras:\n\n" + carreras;
    }
    
    
    
}
