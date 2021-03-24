package tarea8_progdawdam1;

/**
 *
 * @author luis
 */
public class Atleta implements Comparable<Atleta> {

    private String nombre;
    private int podios = 0;
    private String dni;

    public Atleta() {
    }

    public Atleta(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Atleta(String nombre, String dni, int npodios) {
        this.nombre = nombre;
        this.dni = dni;
        this.podios = npodios;
    }

    public Atleta(Atleta a) {
        this.nombre = a.getNombre();
        this.dni = a.getDni();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPodios() {
        return podios;
    }

    public void setPodios(int podios) {
        this.podios = podios;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + "(" + dni + ") podios=" + podios;
    }

    /**
     * *
     * Apartado 3.	Modificar la clase Atleta para que implemente la interfaz
     * Comparable
     *
     * @param a Atleta con el que se pretende comparar
     * @return 0 si los atletas tienen los mismos podios, -1 si el nº de podios
     * de este Atleta es inferior a la del Atleta a y 1 en caso contrario
     */
    @Override
    public int compareTo(Atleta a) {
        if (a.getPodios() == this.podios) {
            return 0;
        }
        else if (a.getPodios() > this.podios) {
            return -1;
        }
        else {
            return 1;
        }  //a.getPodios() < this.podios
    }
}
