/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rxndy
 */
public class Lote {
    private long idLote;//valores validos: números positivos mayores que 0 - valor invalido: números menores o iguales que 0
    private int descuento;//valores validos: números positivos mayores que 0 - valor invalido: números menores que 0
    private ArrayList<Equipo> equipos = new ArrayList<>();

    public Lote(long idLote, int descuento) {
        this.idLote = idLote;
        this.descuento = descuento;
    }
    
    public Lote (Lote l){
        this.idLote = l.getIdLote();
        this.descuento = l.getDescuento();
    }
    
    public Lote(){}
    
    public long getIdLote() {
        return idLote;
    }

    public void setIdLote(long idLote) {
        this.idLote = idLote;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public static Lote nuevoLote() {
        Lote l = new Lote();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        char d;
        do {
            System.out.println("Introduzca id del lote:");
            Long id = sc.nextLong();
            l.setIdLote(id);
            System.out.println("Introduzca descuento:");
            int descuento = sc.nextInt();
            l.setDescuento(descuento);
            System.out.println("Quiere Introducir un nuevo Equipo? s/n ");
            d = sc.next().charAt(0);

            while (d == 's') {
                l.equipos.add(Equipo.nuevoEquipo());

                System.out.println("Quiere Introducir otro Equipo? s/n ");
                d = sc.next().charAt(0);
            }
                
            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("id:" +id);
            System.out.println("descuento:" +descuento);
            salir = Utilidades.leerBoolean();
        } while (salir = false);
        return l;
    
}

    @Override
    public String toString() {
        return "Lote{" + "idLote=" + idLote + ", descuento=" + descuento + ", equipos=" + equipos + '}';
    }
    
    public static void calcularPrecioLote(ArrayList<Equipo> equipos){
        equipos = new ArrayList<Equipo>();
        double precioTotal = 0.0;
        double precio;
        for (int i = 0;i<equipos.size();i++){
            precio = equipos.get(i).getPrecioEquipo();
            precioTotal = precioTotal + precio;        
        }
        System.out.println("El precio de su compra es:" +precioTotal);
    
    }
}
