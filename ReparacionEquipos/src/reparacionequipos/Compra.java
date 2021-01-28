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
 * @author Rxndy
 */
public class Compra extends Servicio {

    private long idCompra;//valores validos: números positivos mayores que 0 - valor invalido: números menores o iguales que 0
    private double precioTotal;//valores validos: números decimales >=0.0 - valores invalidos: números <0.0
    private char metodoPago;//valores validos: char = E(fectivo) || T(arjeta) || B(transferencia bancaria)
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Lote> lotes = new ArrayList<>();

    public Compra(long idCompra, double precioTotal, char metodoPago, ArrayList<Equipo> equipos, ArrayList<Lote> lotes, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        super(id, fechaServicio, nota, clientes);
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.equipos = equipos;
        this.lotes = lotes;
    }

    public Compra(long idCompra, double precioTotal, char metodoPago, ArrayList<Equipo> equipos, ArrayList<Lote> lotes, Servicio se) {
        super(se);
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.equipos = equipos;
        this.lotes = lotes;
    }
    
    public Compra(long idCompra, double precioTotal, char metodoPago, ArrayList<Equipo> equipos, ArrayList<Lote> lotes) {
        super();
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.equipos = equipos;
        this.lotes = lotes;
    }

    public Compra(Compra c) {
        super();
        this.idCompra = c.idCompra;
        this.metodoPago = c.metodoPago;
        this.precioTotal = c.precioTotal;
        this.equipos = c.equipos;
        this.lotes = c.lotes;
    }

    public Compra() {
        super();
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public char getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(char metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }

    public static long nextIdCompra() {
        long ret = 0;
        for (Compra c : Utilidades.COMPRAS) {
            if (c.getIdCompra() > ret) {
                ret = c.getIdCompra();
            }
        }
        return ret + 1;
    }
    
    public static Compra nuevaCompra() {
        Compra c = new Compra();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        char d;
        do {
            c.setId(nextIdCompra());
            System.out.println("Introduzca precio de la compra:");
            double precio = sc.nextDouble();
            c.setPrecioTotal(precio);
            System.out.println("Introduzca método de pago:");
            char pago = sc.next().charAt(0);
            System.out.println("Quiere Introducir un nuevo Equipo? s/n ");
            d = sc.next().charAt(0);

            while (d == 's') {
                c.equipos.add(Equipo.nuevoEquipo());

                System.out.println("Quiere Introducir otro Equipo? s/n ");
                d = sc.next().charAt(0);
            }
            System.out.println("Quiere Introducir un nuevo lote? s/n ");
            d = sc.next().charAt(0);
            while (d == 's') {
                c.lotes.add(Lote.nuevoLote());

                System.out.println("Quiere Introducir otro Lote? s/n ");
                d = sc.next().charAt(0);
            }     
            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("precio total:" + precio);
            System.out.println("forma de pago"+ pago);
            salir = Utilidades.leerBoolean();
        } while (salir = false);
        return c;
}

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", precioTotal=" + precioTotal + ", metodoPago=" + metodoPago + ", equipos=" + equipos + ", lotes=" + lotes + '}';
    }
    
    public static ArrayList<Compra> arrayde (ArrayList<Compra> listaC,int[] ids){
    
        ArrayList<Compra> ret = new ArrayList<Compra>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < listaC.size(); j++) {
                if (listaC.get(j).getId() == ids[i]) {
                    ret.add((Compra) listaC.get(j));
                    break;
                }
            }
        }
        return ret;
    
    }
    
    
        
    public static ArrayList<Compra> convertir(Compra[] array) {
        ArrayList<Compra> ret = new ArrayList<Compra>();
        for (Compra c : array) {
            ret.add((Compra) c);
        }
        return ret;
    }
    
    
}
