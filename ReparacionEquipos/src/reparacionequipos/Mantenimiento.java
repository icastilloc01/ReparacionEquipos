/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author aitor
 */
public class Mantenimiento extends Servicio {

    private int horastrabajadas;
    private ArrayList<Reparacion> reparaciones = new ArrayList<>();

    public Mantenimiento() {
        super();
    }

    public Mantenimiento(int horastrabajadas, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        super(id, fechaServicio, nota, clientes);
        this.horastrabajadas = horastrabajadas;
    }

    public Mantenimiento(Mantenimiento m) {
        super(m);
        this.horastrabajadas = m.horastrabajadas;
    }

    public int getHorastrabajadas() {
        return horastrabajadas;
    }

    public void setHorastrabajadas(int horastrabajadas) {
        this.horastrabajadas = horastrabajadas;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }
    
       
     public static Mantenimiento nuevomantenimiento() {

        Servicio nuevoservicio = Servicio.nuevoServicio();
        
        
        for (int i = 0; i < Utilidades.CLIENTES.length; i++) {
            Cliente s = Utilidades.CLIENTES[i];
            System.out.println(" Servicio " + s.getId() + ",nombre " + s.getNombre());
        }
        Mantenimiento nuevomantenimiento = new Mantenimiento();
        Scanner sc = new Scanner(System.in);

        int horastrabajadas = 0;
        //Long id = Mantenimiento.thenextid();

        do {
            System.out.println("Dame las horas trabajadas que has trabajado");
            horastrabajadas = sc.nextInt();
            if (horastrabajadas >= 0) {

                System.out.println("Los datos introducidos son válidos");

            } else {
                System.out.println("Los datos introducidos no son válidos,por favor,introduzca a continuación los datos de forma correcta.");
            }
        } while (horastrabajadas < 0);
        nuevomantenimiento.setHorastrabajadas(horastrabajadas);
        //El campo de REPARACIONES se inicializa a un ArrayList vacío.
        return nuevomantenimiento;
    }
     

    @Override
    public String toString() {
        return "Mantenimiento{" + "horastrabajadas=" + horastrabajadas + ", reparaciones=" + reparaciones + '}';
    }

}
