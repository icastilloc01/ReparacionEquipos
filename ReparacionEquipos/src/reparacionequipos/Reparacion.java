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
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author aitor
 */
public class Reparacion extends Servicio {

    private long idreparacion;
    private int duraciontotal;
    private Mantenimiento mantenimiento;

    public void setDuraciontotal(int duraciontotal) {
        this.duraciontotal = duraciontotal;
    }

    public Reparacion() {
        super();
    }

    public Reparacion(long idreparacion, int duraciontotal) {
        this.idreparacion = idreparacion;
        this.duraciontotal = duraciontotal;
    }
    
      public static ArrayList<Reparacion> convertir(Reparacion[] array) {
        ArrayList<Reparacion> ret = new ArrayList<Reparacion>();
        for (Reparacion r : array) {
            ret.add((Reparacion) r);
        }
        return ret;
    }

    public Reparacion(long idreparacion, int duraciontotal, Mantenimiento mantenimiento, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes) {
        super(id, fechaServicio, nota, clientes);
        this.idreparacion = idreparacion;
        this.duraciontotal = duraciontotal;
        this.mantenimiento = mantenimiento;
    }
     Reparacion(Integer valueOf, String parametro, String parametro0, String parametro1, String parametro2, String parametro3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reparacion(long idreparacion, int duraciontotal, Mantenimiento mantenimiento, Servicio se) {
        super(se);
        this.idreparacion = idreparacion;
        this.duraciontotal = duraciontotal;
        this.mantenimiento = mantenimiento;
    }

    public Reparacion(Reparacion e) {
        this.idreparacion = e.idreparacion;
        this.duraciontotal = e.duraciontotal;
        this.mantenimiento = e.mantenimiento;
    }

    public long getIdreparacion() {
        return idreparacion;
    }

    public void setIdreparacion(long idreparacion) {
        this.idreparacion = idreparacion;
    }

    public int getDuraciontotal() {
        return duraciontotal;
    }

    public static Reparacion nuevaReparacion() {
        
        Reparacion r = new Reparacion();
        Scanner in = new Scanner(System.in);
        boolean ret = false;
        boolean salir;
        do {
            System.out.println("Introduzca el id de la reparación:");
            long id = in.nextLong();
            if(r.getIdreparacion()>0){
                System.out.println("Id válido");
                ret = true;
            }
            if (r.getIdreparacion() < 0) {
                throw new ReparacionException("Valor inválido");
                
            }
            r.setId(id);
            System.out.println("Introduzca la duración de la reparación:");
            int duracion = in.nextInt();
            r.setDuraciontotal(duracion);
            System.out.println("Son correctos los siguientes datos?(s/n):");
            System.out.println("id:" + id);
            System.out.println("duracion:" + duracion);
            salir = Utilidades.leerBoolean();
        } while (salir);

        return r;

    }

    @Override
    public String toString() {
        return "Reparacion{" + "id=" + id + ", duraciontotal=" + duraciontotal + '}';
    }
    
    
    public String data() {
        return "Reparacion{" + "id=" + id + ", duraciontotal=" + duraciontotal + '}';
    }

    public Reparacion(long id, int duraciontotal, Mantenimiento mantenimiento) {
        this.id = id;
        this.duraciontotal = duraciontotal;
        this.mantenimiento = mantenimiento;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public static ArrayList<Reparacion> arrayde(ArrayList<Reparacion> lista, int[] ids) {
        ArrayList<Reparacion> ret = new ArrayList<Reparacion>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Reparacion) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    

    public static long nextIdReparacion() {
        long ret = 0;
        for (Reparacion r : Utilidades.REPARACIONES) {
            if (r.getIdreparacion() > ret) {
                ret = r.getIdreparacion();
            }
        }
        return ret + 1;
    }

    public static Reparacion listareparaciones() {
        SimpleDateFormat sdf = new SimpleDateFormat(" EEEE dd MMMM yyyy(hh:mm:ss)");
        System.out.println("Ahora es el día y la hora : " + sdf.format(new Date()));
        Servicio se = Servicio.nuevoServicio();
        Mantenimiento m = Mantenimiento.nuevomantenimiento();
        Scanner sc = new Scanner(System.in);
        Reparacion nuevoreparacion = new Reparacion();
        nuevoreparacion.idreparacion = nextIdReparacion();
        System.out.println(" Muestráme las horas que has trabajado :");
        do {
            int duraciontotal = sc.nextInt();
            if (duraciontotal > 0) {
                System.out.println("Los datos son validos");

            } else {
                System.out.println("Los datos no son validos");
            }
        } while (nuevoreparacion.duraciontotal <= 0);
        System.out.println("Vuelve a esribir de manera correcta las horas por favor");
        int duraciontotal = sc.nextInt();
        if (nuevoreparacion.getDuraciontotal() <= 0) {
            throw new ReparacionException("Valor no válido");
        }
        nuevoreparacion.setDuraciontotal(duraciontotal);
        System.out.println("Esta reparacion se ha asignado a un grupo");

        return nuevoreparacion;

    }
    
    
    //*Los métodos de manejo de ficheros están en la clase Serialización
    
    public void exportarObjetoReparacionTexto(String path) {
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
    
     public static void exportarColeccionDeObjetosReparacionTexto(String path) {
        ArrayList<Reparacion> coleccion;
        coleccion = Reparacion.convertir(Utilidades.REPARACIONES);
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Reparacion r: coleccion) {
                    buffer.print(r.data() + "\n");
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
     
     
        public void exportarReparacionaArchivoBinario(String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream Reparacion = new ObjectOutputStream(fichero);
          Reparacion.writeObject(this);
            Reparacion.flush();
            Reparacion.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }


        public static void exportarColeccionReparacionArchivoBinario(String path) {
        ArrayList<Reparacion> coleccion;
        coleccion = Reparacion.convertir(Utilidades.REPARACIONES);
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

        public static ArrayList<Reparacion> importarReparacionDesdeFicheroBinario(String path) {
        ArrayList<Reparacion> ret = new ArrayList<Reparacion>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Reparacion r;
                while ((r = (Reparacion) lectorObjeto.readObject()) != null) {
                    ret.add(r);
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
    
        public static ArrayList<Reparacion> importarReparacionDesdeFicheroTexto(String path) {
        ArrayList<Reparacion> ret = new ArrayList<Reparacion>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Reparacion r;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (!cadena.isEmpty()) {
                        String[] parametros = cadena.split("\\|");
                        r = new Reparacion(Integer.valueOf(parametros[0]), Integer.valueOf(parametros[1]));
                        ret.add(r);
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
    public static ArrayList<Reparacion> buscarPorIDEnFicheroDeTexto(String path) {
        ArrayList<Reparacion> ret = new ArrayList<Reparacion>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Reparacion r;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (!cadena.isEmpty()) {
                        String[] parametros = cadena.split("\\|");
                        r = new Reparacion(Integer.valueOf(parametros[0]), Integer.valueOf(parametros[1]));
                        ret.add(r);
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
                for (Reparacion re : ret) {
                    if (re.getId() == idBuscar) {
                        System.out.println(re.data());
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

}
