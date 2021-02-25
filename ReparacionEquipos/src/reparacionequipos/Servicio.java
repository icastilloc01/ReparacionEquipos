/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.text.ParseException;
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
        this.clientes = clientes;
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
    
    public static long nextIdServicio() {
        long ret = 0;
        for (Servicio s : Utilidades.SERVICIOS) {
            if (s.getId() > ret) {
                ret = s.getId();
            }
        }
        for (Reparacion r : Utilidades.REPARACIONES) {
            if (r.getId() > ret) {
                ret = r.getId();
            }
        }
        for (Envio e : Utilidades.ENVIOS) {
            if (e.getId() > ret) {
                ret = e.getId();
            }
        }
        for (Compra c : Utilidades.COMPRAS) {
            if (c.getId() > ret) {
                ret = c.getId();
            }
        }
        return ret + 1;
    }

    public static Servicio nuevoServicio() throws ServicioException {
        Servicio s = new Servicio();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        do {
            s.setId(nextIdServicio());
            System.out.println("Introduzca nota de servicio:");
            String nota = sc.nextLine();
            s.setNota(nota);
            System.out.println("Introduzca fecha del servicio:");
            Date fecha = Utilidades.introducirFecha();
            System.out.println("Quiere Introducir un nuevo Cliente? s/n ");
            boolean p;
            p = Utilidades.leerBoolean();
            while (p) {
                s.clientes.add(Cliente.nuevoCliente());
                System.out.println("Quiere Introducir otro Cliente? s/n ");
                p = Utilidades.leerBoolean();
            }

            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("fecha:" + fecha);
            System.out.println("nota" + nota);
            salir = Utilidades.leerBoolean();
        } while (salir = false);
        if(!ServicioException.comprobarNota(s.getNota())){
            throw new ServicioException("La nota no es valida");}
        return s;
    }

    public static ArrayList<Servicio> arraydeServicio(ArrayList<Servicio> lista, int[] ids) {
        ArrayList<Servicio> ret = new ArrayList<Servicio>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Servicio) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Servicio> convertir(Servicio[] array) {
        ArrayList<Servicio> ret = new ArrayList<Servicio>();
        for (Servicio s : array) {
            ret.add((Servicio) s);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id=" + id + ", fechaServicio=" + fechaServicio + ", nota=" + nota + ", clientes=" + clientes + '}';
    }

}
