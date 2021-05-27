/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Exception.CompraException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
    private Equipo equipo;
    private long idEquipo;
    private long idLote;

    public Compra(long idCompra, double precioTotal, char metodoPago,long idEquipo,long idLote, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        super(id, fechaServicio, nota, clientes);
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.idEquipo = idEquipo;
        this.idLote = idLote;
    }

    
    

    public Compra(long idCompra, double precioTotal, char metodoPago,long idEquipo,long idLote, Servicio se) {
        super(se);
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.idEquipo = idEquipo;
        this.idLote = idLote;
    }
    
    public Compra(long idCompra, double precioTotal, char metodoPago,long idEquipo, long idLote) {
        super();
        this.idCompra = idCompra;
        this.precioTotal = precioTotal;
        this.metodoPago = metodoPago;
        this.idEquipo = idEquipo;
        this.idLote = idLote;
    }

    public Compra(Compra c) {
        super();
        this.idCompra = c.idCompra;
        this.metodoPago = c.metodoPago;
        this.precioTotal = c.precioTotal;
        this.idEquipo = idEquipo;
        this.idLote = idLote;
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

   

    public static long nextIdCompra() {
        long ret = 0;
        for (Compra c : Utilidades.COMPRAS) {
            if (c.getIdCompra() > ret) {
                ret = c.getIdCompra();
            }
        }
        return ret + 1;
    }
    
    public static Compra nuevaCompra() throws CompraException {
        Compra c = new Compra();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        char d;
        try{
        do {
            c.setId(nextIdCompra());
            System.out.println("Introduzca precio de la compra:");
            double precio = sc.nextDouble();
            c.setPrecioTotal(precio);
            System.out.println("Introduzca método de pago:");
            char pago = sc.next().charAt(0);
            
            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("precio total:" + precio);
            System.out.println("forma de pago"+ pago);
            salir = Utilidades.leerBoolean();
        } while (salir = false);
        }catch(CompraException e){
            System.out.println("Valor no válido ");
        }
        return c;
}

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", precioTotal=" + precioTotal + ", metodoPago=" + metodoPago + ", id equipos=" + idEquipo + ", id lote=" + idLote + '}';
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
    
    
    
    public void exportarCompraAFicheroDeTexto (String path){
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null ;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                buffer.print(this.data()+"\r\n");
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(escritor!=null)
                    escritor.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException"+e.getMessage());
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException"+e.getMessage());
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception"+e.getMessage());
        }
    }
    
    /**
     * Este metodo exporta una coleccion de objetos de tipo empleado a un
     * fichero binario
     *
     * @param path
     */
    public static void exportarColeccionComprasaArchivoBinario(String path) {
        ArrayList<Compra> coleccion;
        coleccion = Compra.convertir(Utilidades.COMPRAS);
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
    public static ArrayList<Compra> importarCompraDesdeFicheroBytes(String path) {
        ArrayList<Compra> ret = new ArrayList<Compra>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Compra c;
                while ((c = (Compra) lectorObjeto.readObject()) != null) {
                    ret.add(c);
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
    /*public static ArrayList<Compra> importarCompraDesdeFicheroCaracteres(String path) {
        ArrayList<Compra> ret = new ArrayList<Compra>();
        File fichero = new File(path);
        BufferedReader buffer = null;
        FileReader lector = null;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                while ((linea = buffer.readLine())!= null) {
                    String campos[] = linea.split("\\|");
                    long idCompra = Long.parseLong(campos[0]);
                    double precioTotal = Double.parseDouble(campos[1]);
                    char metodoPago = campos[2].charAt(0);
                    long id = Long.parseLong(campos[3]);
                    Date fechaServicio = campos[4];
                    String nota = campos[5];
                    Compra c = new Compra (idCompra,precioTotal,metodoPago, id,fechaServicio,nota);
                    ret.add(c);
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
    }*/

    public String data() {
        return id + "|" + precioTotal + '|' + metodoPago;
    }

 public static boolean comprobarSiEsLote(long idLote){
     return idLote == 0;
 }
    
}
