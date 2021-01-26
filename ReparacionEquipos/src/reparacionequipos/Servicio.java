/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rxndy
 */
public class Servicio {

    protected long id;//valores validos: números positivos mayores que 0 - valor invalido: números menores o iguales que 0
    protected Date fechaServicio;//valores validos: fechas con numeros de dia >0 y <31, meses >0 y <13 y año >1900 y <2021
    protected String nota;// valores validos: cadena de caracteres con minimo de 4 letras - valor invalido: longitud de cadena menor de 4 letras
    protected ArrayList<Cliente> clientes = new ArrayList<>();

    public Servicio(long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        this.id = id;
        this.fechaServicio = fechaServicio;
        this.nota = nota;
        this.clientes = new ArrayList<Cliente>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Servicio(Servicio se) {
        this.fechaServicio = se.getFechaServicio();
        this.id = se.getId();
        this.nota = se.getNota();
    }

    public Servicio() {
    }

    public static Servicio nuevoServicio() {
        Servicio s = new Servicio();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        char d;
        do {
            System.out.println("Introduzca id del servicio:");
            Long id = sc.nextLong();
            s.setId(id);
            System.out.println("Introduzca nota de servicio:");
            String nota = sc.nextLine();
            s.setNota(nota);
            System.out.println("Introduzca fecha del servicio:");
            Date fecha = Utilidades.introducirFecha();
            System.out.println("Quiere Introducir un nuevo Cliente? s/n ");
            d = sc.next().charAt(0);

            while (d == 's') {
                s.clientes.add(Cliente.nuevoCliente());

                System.out.println("Quiere Introducir otro Cliente? s/n ");
                d = sc.next().charAt(0);
            }

            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("id:" + id);
            System.out.println("fecha:" + fecha);
            System.out.println("nota" + nota);
            salir = Utilidades.leerBoolean();
        } while (salir);
        return s;
    }

    public static ArrayList<Cliente> arrayde(ArrayList<Cliente> lista, int[] ids) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cliente) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Cliente> convertir(Cliente[] array) {
        return new Gen<Cliente>().convertir(array);
    }

    @Override
    public String toString() {
        return "Servicio{" + "id=" + id + ", fechaServicio=" + fechaServicio + ", nota=" + nota + ", clientes=" + clientes + '}';
    }

}
