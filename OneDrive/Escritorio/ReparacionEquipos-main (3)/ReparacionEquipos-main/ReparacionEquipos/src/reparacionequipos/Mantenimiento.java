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

    public Mantenimiento(int horastrabajadas, long id, Date fechaServicio, String nota) {
        super(id, fechaServicio, nota);
        this.horastrabajadas = horastrabajadas;
    }

    public Mantenimiento(Mantenimiento m) {
        super(m);
        if (horastrabajadas >= 0) {
            System.out.println("Los datos son validos");

        } else {
            System.out.println("Los datos no son validos");
        }
        this.horastrabajadas = m.horastrabajadas;
    }

    public int getHorastrabajadas() {
        return horastrabajadas;
    }

    public void setHorastrabajadas(int horastrabajadas) {
        this.horastrabajadas = horastrabajadas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public static Mantenimiento nuevomantenimiento() {

        Mantenimiento nuevomantenimiento = new Mantenimiento();
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame las horas trabajadas que has trabajado");
        int horastrabajadas = sc.nextInt();
        nuevomantenimiento.setHorastrabajadas(horastrabajadas);
        System.out.println("Dime si tienes reparaciones pendientes");
        String Reparaciones = sc.nextLine();
        nuevomantenimiento.setReparaciones(Reparaciones);
        return nuevomantenimiento;

    }

    @Override
    public String toString() {
        return "el trabajador ha trabajado" + horastrabajadas + "y tiene reparaciones" + reparaciones;
    }

    private void setReparaciones(String Reparaciones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
