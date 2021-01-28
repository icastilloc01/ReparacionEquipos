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
 * @author PC_Alba
 */
public class Envio extends Servicio {

    private long id;
    private Date fechaSalida;
    private int precioDeReparto;
    private double precioTotal;
    private double coste;
    private String lugar;
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Repartidor> repartidores = new ArrayList<>();

    //constructor por defecto
    public Envio() {
    }

    //constructor por atributos
    public Envio(long id, Date fechaSalida, int precioDeReparto, double precioTotal, double coste, String lugar) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.precioDeReparto = precioDeReparto;
        this.precioTotal = precioTotal;
        this.coste = coste;
        this.lugar = lugar;
    }
    
    public Envio(long id, Date fechaSalida, int precioDeReparto, double precioTotal, double coste, String lugar, ArrayList<Servicio> servicios, ArrayList<Repartidor> repartidores) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.precioDeReparto = precioDeReparto;
        this.precioTotal = precioTotal;
        this.coste = coste;
        this.lugar = lugar;
        this.servicios = servicios;
        this.repartidores = repartidores;
    }

    //constructor de copia
    public Envio(Envio en) {
        this.id = en.id;
        this.fechaSalida = en.fechaSalida;
        this.precioDeReparto = en.precioDeReparto;
        this.precioTotal = en.precioTotal;
        this.coste = en.coste;
        this.lugar = en.lugar;
    }

    Envio(int i, java.sql.Date valueOf, int i0, double d, double d0, String cLos_Santos_3, ArrayList<Servicio> arrayde, ArrayList<Repartidor> arrayde0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    //geters y seters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void setRepartidores(ArrayList<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public static Envio nuevoEnvio() {
        Envio nuevoEnvio = new Envio();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el id del envio");
        nuevoEnvio.id = in.nextLong();
        nuevoEnvio.lugar = in.nextLine();//esta linea es para que no se salte el proximo nextLine
        System.out.println("Introduzca la fecha de salidad del envio");
        nuevoEnvio.fechaSalida = Utilidades.introducirFecha();
        System.out.println("introduzca el precio del reparto");
        nuevoEnvio.precioDeReparto = in.nextInt();
        System.out.println("introduzca el precio total");
        nuevoEnvio.precioTotal = in.nextDouble();
        System.out.println("introduzca el coste");
        nuevoEnvio.coste = in.nextDouble();
        System.out.println("Introduce el lugar del envio");
        nuevoEnvio.lugar = in.nextLine();
        return nuevoEnvio;
    }

    //metodo to string
    @Override
    public String toString() {
        return "Envio{" + "id=" + id + ", fechaSalida=" + fechaSalida + ", precioDeReparto=" + precioDeReparto + ", precioTotal=" + precioTotal + ", coste=" + coste + ", lugar=" + lugar + ", servicios=" + servicios + ", repartidores=" + repartidores + '}';
    }
    
    
    public static ArrayList<Envio> arraydeEnvio (ArrayList<Envio> lista,int[] ids){
    
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
    
    
    
    
    }
    
    

