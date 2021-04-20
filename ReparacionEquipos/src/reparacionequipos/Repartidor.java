/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;



/**
 *
 * @author icasc
 */
public class Repartidor extends Empleado {

    public Repartidor() {
        super();
    }

    public Repartidor(long id, String nombre, String telefono, String nif, String apellido, String dirección) {
        super(id, nombre, telefono, nif, apellido, dirección);
    }

    public Repartidor(Empleado e) {
        super(e);
    }
    
    public static Repartidor nuevoRepartidor() throws EmpleadoException {
        Empleado e = Empleado.nuevoEmpleado();
        Repartidor nuevoRepartidor = new Repartidor();
        nuevoRepartidor.setId(e.getId());
        nuevoRepartidor.setNombre(e.getNombre());
        nuevoRepartidor.setTelefono(e.getTelefono());
        nuevoRepartidor.setNif(e.getNif());
        nuevoRepartidor.setApellido(e.getApellido());
        nuevoRepartidor.setDireccion(e.getDireccion());
        return nuevoRepartidor;
    }
    
    public static ArrayList<Repartidor> convertir(Repartidor[] array) {
        ArrayList<Repartidor> ret = new ArrayList<Repartidor>();
        for (Repartidor r : array) {
            ret.add((Repartidor) r);
        }
        return ret;
    }
    
    public static ArrayList<Repartidor> arrayde(ArrayList<Repartidor> lista, int[] ids) {
        ArrayList<Repartidor> ret = new ArrayList<Repartidor>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Repartidor) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return super.id + ". " + super.nombre + ". " + super.telefono + ". " + super.nif + ". " + super.apellido + ". " + super.direccion;
    }
}
