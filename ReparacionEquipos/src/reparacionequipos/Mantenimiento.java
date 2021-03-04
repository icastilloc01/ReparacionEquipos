/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author aitor
 */
public class Mantenimiento extends Servicio implements Serializable {

    private int horastrabajadas;
    private ArrayList<Reparacion> reparaciones = new ArrayList<>();

    public Mantenimiento() {
        super();
    }

    
    Mantenimiento(Integer valueOf, String parametro, String parametro0, String parametro1, String parametro2, String parametro3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Mantenimiento(int horastrabajadas, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        super(id, fechaServicio, nota, clientes);
        this.horastrabajadas = horastrabajadas;
    }

    public Mantenimiento(Mantenimiento m) {
        super(m);
        this.horastrabajadas = m.horastrabajadas;
    }

    Mantenimiento(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
     public static ArrayList<Mantenimiento> convertir(Mantenimiento[] array) {
        ArrayList<Mantenimiento> ret = new ArrayList<Mantenimiento>();
        for (Mantenimiento m : array) {
            ret.add((Mantenimiento) m);
        }
        return ret;
    }

    public static Mantenimiento nuevomantenimiento() {

        Servicio nuevoservicio = Servicio.nuevoServicio();
        boolean exit;
        exit = false;
        SimpleDateFormat sdf = new SimpleDateFormat(" EEEE dd MMMM yyyy(hh:mm:ss)");
        System.out.println("Ahora es el día y la hora : " + sdf.format(new Date()));

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
        if (nuevomantenimiento.getHorastrabajadas() < 0) {
            throw new MantenimientoException("Valor introducido no válido");
        }
        //El campo de REPARACIONES se inicializa a un ArrayList vacío.
        return nuevomantenimiento;
    }

    public String data(){
    
    return this.getHorastrabajadas()+" | "+this.getReparaciones()+" | ";
    }
    //*Los métodos de manejo de ficheros están en la clase Serialización
    
    public void exportarObjetoMantenimientoTexto(String path) {
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                buffer.print(this.data() + "\r\n");
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }
    
     public static void exportarColeccionDeObjetosMantenimientoTexto(String path) {
        ArrayList<Mantenimiento> coleccion;
        coleccion = Mantenimiento.convertir(Utilidades.MANTENIMIENTOS);
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Mantenimiento m: coleccion) {
                    buffer.print(m.data() + "\n");
                }
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }
     
     
        public void exportarMantenimientoaArchivoBinario(String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream mantenimiento = new ObjectOutputStream(fichero);
           mantenimiento.writeObject(this);
            mantenimiento.flush();
            mantenimiento.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }


        public static void exportarColeccionMantenimientoArchivoBinario(String path) {
        ArrayList<Mantenimiento> coleccion;
        coleccion = Mantenimiento.convertir(Utilidades.MANTENIMIENTOS);
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

        public static ArrayList<Mantenimiento> importarMantenimientoDesdeFicheroBinario(String path) {
        ArrayList<Mantenimiento> ret = new ArrayList<Mantenimiento>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Mantenimiento m;
                while ((m = (Mantenimiento) lectorObjeto.readObject()) != null) {
                    ret.add(m);
                    lector.skip(4);
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
    
        public static ArrayList<Mantenimiento> importarMantenimientoDesdeFicheroTexto(String path) {
        ArrayList<Mantenimiento> ret = new ArrayList<Mantenimiento>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Mantenimiento m;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        m = new Mantenimiento(Integer.valueOf(parametros[0]), parametros[1], parametros[2], parametros[3], parametros[4], parametros[5]);
                        ret.add(m);
                    }
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
     * Este metodo busca un objeto de la coleccion de objetos de un fichero de texto mediante el id del objeto
     * @param path
     * @return 
     */
    public static ArrayList<Mantenimiento> buscarPorIDEnFicheroDeTexto(String path) {
        ArrayList<Mantenimiento> ret = new ArrayList<Mantenimiento>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Mantenimiento m;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        m = new Mantenimiento(Integer.valueOf(parametros[0]), parametros[1], parametros[2], parametros[3], parametros[4], parametros[5]);
                        ret.add(m);
                    }
                }
                Scanner in = new Scanner(System.in);
                int idBuscar = 0;
                do {
                    System.out.print("Introduce el id que desea buscar dentro del fichero de texto: ");
                    idBuscar = in.nextInt();
                    if (idBuscar <= 0) {
                        System.out.println("Debe introducir un valor mayor que cero");
                    }
                } while (idBuscar <= 0);
                for (Mantenimiento me : ret) {
                    if (me.getId() == idBuscar) {
                        System.out.println(me.data());
                        break;
                    }
                }
            } finally {
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("El carácter introducido no es un entero");
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

        @Override
        public String toString
        
            () {
        return "Mantenimiento{" + "horastrabajadas=" + horastrabajadas + ", reparaciones=" + reparaciones + '}';
        }

    }
