package tarea8_progdawdam1;

/**
 *
 * @author luis
 */
public class Premio {
    
    private String descripcion;
    private String patrocinador;

    public Premio() {
    }

    public Premio(String descripcion, String patrocinador) {
        this.descripcion = descripcion;
        this.patrocinador = patrocinador;
    }
    
    public Premio(Premio p) {
        this.descripcion = p.getDescripcion();
        this.patrocinador = p.getPatrocinador();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    @Override
    public String toString() {
        return descripcion + " patrocinado por " + patrocinador + '.';
    }
    
    
    
}
