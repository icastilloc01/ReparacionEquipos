/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public static Lote nuevoLote() throws LoteException {
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
        if(!LoteException.comprobarId(l.getIdLote())){
            throw new ServicioException("El id no es valida");}
        else if(!LoteException.comprobarDescuento(l.getDescuento())){
            throw new ServicioException("El descuento no es valido");
        }
        
        
        return l;
    
}
    
    public static ArrayList<Lote> convertir(Lote[] array) {
        ArrayList<Lote> ret = new ArrayList<Lote>();
        for (Lote l : array) {
            ret.add((Lote) l);
        }
        return ret;
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
    
     public static void exportarColeccionLotesaArchivoBinario(String path) {
        ArrayList<Lote> coleccion;
        coleccion = Lote.convertir(Utilidades.LOTES);
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            escritor.writeObject(coleccion);
            escritor.flush();
            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    /**
     * Este metodo importa una coleccion de obejtos de tipo empleado desde un
     * fichero de datos binario
     *
     * @param path
     * @return
     */
    public static ArrayList<Lote> importarLoteDesdeFicheroBytes(String path) {
        ArrayList<Lote> ret = new ArrayList<Lote>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Lote e;
                while ((e = (Lote) lectorObjeto.readObject()) != null) {
                    ret.add(e);
                }
            } finally {
                if (lectorObjeto != null) {
                    lectorObjeto.close();
                }
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase a la cual haces referencia");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    /**
     * Este metodo importa una coleccion de objetos de tipo empleado desde un
     * fichero de tecto
     *
     * @param path
     * @return
     */
    public static ArrayList<Lote> importarLoteDesdeFicheroCaracteres(String path) {
        ArrayList<Lote> ret = new ArrayList<Lote>();
        File fichero = new File(path);
        BufferedReader buffer = null;
        FileReader lector = null;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                while ((linea = buffer.readLine()) != null) {
                    String campos[] = linea.split("\\|");
                    long id = Long.parseLong(campos[0]);
                    int descuento = Integer.parseInt(campos[2]);
                    Lote e = new Lote(id, descuento);
                    ret.add(e);
                }
            } finally {
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    /**
     * Este metodo busca un objeto de la coleccion de objetos de un fichero de
     * texto mediante el id del objeto
     *
     * @param path
     * @return
     */
    public String data() {
        return idLote+ "|" + descuento + '|' + equipos;
    }
}
