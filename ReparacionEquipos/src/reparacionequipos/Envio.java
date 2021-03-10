/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author PC_Alba
 */
public class Envio extends Servicio {

    private long idEnvio;
    private Date fechaSalida;
    private int precioDeReparto;
    private double precioTotal;
    private double coste;
    private String lugar;
    private ArrayList<Repartidor> repartidores = new ArrayList<>();

    //constructor por defecto
    public Envio() {
        super();
    }

    //constructor por atributos
    public Envio(long idEnvio, Date fechaSalida, int precioDeReparto, double precioTotal, double coste, String lugar, ArrayList<Repartidor> repartidores, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        super(id, fechaServicio, nota, clientes);
        this.idEnvio = idEnvio;
        this.fechaSalida = fechaSalida;
        this.precioDeReparto = precioDeReparto;
        this.precioTotal = precioTotal;
        this.coste = coste;
        this.lugar = lugar;
        this.repartidores = repartidores;
    }

    public Envio(long idEnvio, Date fechaSalida, int precioDeReparto, double precioTotal, double coste, String lugar, ArrayList<Repartidor> repartidores, Servicio se) {
        super(se);
        this.idEnvio = idEnvio;
        this.fechaSalida = fechaSalida;
        this.precioDeReparto = precioDeReparto;
        this.precioTotal = precioTotal;
        this.coste = coste;
        this.lugar = lugar;
        this.repartidores = repartidores;
    }

    //constructor de copia
    public Envio(Envio en) {
        this.idEnvio = en.idEnvio;
        this.fechaSalida = en.fechaSalida;
        this.precioDeReparto = en.precioDeReparto;
        this.precioTotal = en.precioTotal;
        this.coste = en.coste;
        this.lugar = en.lugar;
        this.repartidores = en.repartidores;
    }

    //geters y seters
    public long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPrecioDeReparto() {
        return precioDeReparto;
    }

    public void setPrecioDeReparto(int precioDeReparto) {
        this.precioDeReparto = precioDeReparto;
    }

    public double getPtrcioTotal() {
        return precioTotal;
    }

    public void setPtrcioTotal(double ptrcioTotal) {
        this.precioTotal = ptrcioTotal;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void setRepartidores(ArrayList<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }

    public static long nextIdEnvio() {
        long ret = 0;
        for (Envio e : Utilidades.ENVIOS) {
            if (e.getIdEnvio() > ret) {
                ret = e.getIdEnvio();
            }
        }
        return ret + 1;
    }

    public static Envio nuevoEnvio() {
        Envio nuevoEnvio = new Envio();
        Scanner in = new Scanner(System.in);
        try {
            nuevoEnvio.idEnvio = nextIdEnvio();
            System.out.println("Introduzca la fecha de salidad del envio");
            nuevoEnvio.fechaSalida = Utilidades.introducirFecha();
            do {
                System.out.println("introduzca el precio del reparto");
                nuevoEnvio.precioDeReparto = Integer.parseInt(in.nextLine());
                if (nuevoEnvio.precioDeReparto < 1) {
                    System.out.println("el precio de reparto introducido es menor o igual a 0");
                }
            } while (nuevoEnvio.precioDeReparto < 1);
            do {
                System.out.println("introduzca el precio total");
                nuevoEnvio.precioTotal = in.nextDouble();
                if (nuevoEnvio.precioTotal <= 0) {
                    System.out.println("el valor introducido es menor o igual a 0");
                }
            } while (nuevoEnvio.precioTotal <= 0);
            do {
                System.out.println("introduzca el coste");
                nuevoEnvio.coste = in.nextDouble();
                if (nuevoEnvio.coste <= 0) {
                    System.out.println("el valor introducido es menor o igual a 0");
                }
            } while (nuevoEnvio.coste <= 0);
            do {
                System.out.println("Introduce el lugar del envio");
                nuevoEnvio.lugar = in.nextLine();
                if (nuevoEnvio.lugar.isEmpty() || nuevoEnvio.lugar.length() < 3 || nuevoEnvio.lugar.length() > 25) {
                    System.out.println("el campo esta vacio, su lonjitud es menor a 3 o mayor a 25");
                }
            } while (nuevoEnvio.lugar.isEmpty() || nuevoEnvio.lugar.length() < 3 || nuevoEnvio.lugar.length() > 25);

        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es valido");
        }
        return nuevoEnvio;
    }

    //metodo to string
    @Override
    public String toString() {
        return "Envio{" + "id=" + id + ", fechaSalida=" + fechaSalida + ", precioDeReparto=" + precioDeReparto + ", precioTotal=" + precioTotal + ", coste=" + coste + ", lugar=" + lugar + ", repartidores=" + repartidores + '}';
    }

    public static ArrayList<Envio> arraydeEnvio(ArrayList<Envio> lista, int[] ids) {

        ArrayList<Envio> ret = new ArrayList<Envio>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Envio) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Envio> convertir(Envio[] array) {
        ArrayList<Envio> ret = new ArrayList<Envio>();
        for (Envio e : array) {
            ret.add((Envio) e);
        }
        return ret;
    }

    public String data() {
        return idEnvio + "|" + fechaSalida + '|' + precioDeReparto + '|' + precioTotal + '|' + coste + '|' + lugar + '|' + repartidores;
    }

}
