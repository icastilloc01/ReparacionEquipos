package tarea8_progdawdam1;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author luis
 */
public class Carrera implements Comparable<Carrera> {

    private String nombre;
    private String ciudad;
    private Date fecha;
    private LinkedList<Premio> premios = new LinkedList<Premio>();
    private LinkedHashSet<Atleta> clasificacion = new LinkedHashSet<Atleta>();
    private LinkedHashMap<Atleta, Integer> dorsales = new LinkedHashMap<Atleta, Integer>();

    public Carrera() {
    }

    public Carrera(String nombre, String ciudad, Date fecha, LinkedList<Premio> premios, LinkedHashSet<Atleta> clasificacion, LinkedHashMap<Atleta, Integer> dorsales) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.premios = premios;
        this.clasificacion = clasificacion;
        this.dorsales = dorsales;
    }

    public Carrera(String nombre, String ciudad, Date fecha) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LinkedList<Premio> getPremios() {
        return premios;
    }

    public void setPremios(LinkedList<Premio> premios) {
        this.premios = premios;
    }

    public LinkedHashSet<Atleta> getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(LinkedHashSet<Atleta> clasificacion) {
        this.clasificacion = clasificacion;
    }

    public LinkedHashMap<Atleta, Integer> getDorsales() {
        return dorsales;
    }

    public void setDorsales(LinkedHashMap<Atleta, Integer> dorsales) {
        this.dorsales = dorsales;
    }

    @Override
    public String toString() {
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ret = "";
        ret += nombre + ", que tuvo lugar en " + ciudad + " el " + fecha.toLocalDate().format(dateFormatter);
        ret += "\nLa clasificación fue la siguiente:\n";
        String clasificacion = "";
        Iterator<Atleta> it_clasificacion = this.getClasificacion().iterator();
        Iterator<Premio> it_premios = premios.iterator();
        int posicion = 1;
        while (it_clasificacion.hasNext()) {
            Atleta a = it_clasificacion.next();
            Integer dorsal = dorsales.get(a);
            clasificacion += posicion + "º: " + a.getNombre() + "(" + a.getDni() + ")" + " con dorsal " + dorsal;
            if (it_premios.hasNext()) {
                Premio p = it_premios.next();
                clasificacion += " --> " + p;
            }
            posicion++;
            clasificacion += "\n";
        }
        ret += clasificacion + "\n";
        return ret;
    }

    /**
     * *
     *
     * @param c Carrera con la que se pretende comparar
     * @return 0 si las carreras se celebraron en la misma fecha, -1 si la fecha
     * de esta carrera es anterior a la de la carrera c y 1 en caso contrario
     */
    @Override
    public int compareTo(Carrera c) {
        return this.getFecha().compareTo(c.getFecha());
    }

    /**
     * *
     * Apartado 2.	Incluir en la clase Carrera un nuevo método void
     * imprimirDatosInscripcion()
     *
     * Función que muestra por la salida estándar los datos de la inscripción de
     * la carrera, a partir del atributo dorsales de tipo
     * LinkedHashMap<Atleta, Integer>
     * La función recorre mediante un iterador esa colección y muestra por la
     * pantalla el nombre del atleta y su dorsal.
     */
    public void imprimirDatosInscripcion() {
        Set s = dorsales.keySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Atleta aux = (Atleta) it.next();
            System.out.println(aux + " : " + dorsales.get(aux));
        }
    }

    /**
     * *
     * Apartado 4.	Incluir en la clase Carrera un nuevo método int
     * inscripcionAtleta(Atleta a)
     *
     * @param a Atleta a inscribir en esta carrera
     * @return -1 en caso de que el Atleta a ya esté inscrito en la carrera o un
     * número entero para el dorsal, que está comprendido entre 100 y 400, y no
     * está ya en la lista de dorsales de esta carrera
     */
    public int inscripcionAtleta(Atleta a) {
        if (!this.dorsales.containsKey(a)) {
            Set s = dorsales.keySet();
            Iterator it = s.iterator();
            int numeroDorsal = 100;
            while (it.hasNext()) {
                if (!this.dorsales.containsValue(numeroDorsal)) {
                    this.dorsales.put(a, numeroDorsal);
                    return numeroDorsal;
                }
                numeroDorsal++;
            }
            return -1;
        } else {
            return -1;
        }
    }
}
