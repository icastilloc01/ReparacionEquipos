/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Exception.GrupoException;
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

/**
 *
 * @author aitor
 */
public class Grupo {

    private long idgrupo;
    private ArrayList<Reparacion> reparaciones = new ArrayList<>();
    private ArrayList<Detaller> detalleres = new ArrayList<>();
    
     public static ArrayList<Grupo> convertir(Grupo[] array) {
        ArrayList<Grupo> ret = new ArrayList<Grupo>();
        for (Grupo g : array) {
            ret.add((Grupo) g);
        }
        return ret;
    }

    public long getId() {
        return idgrupo;
    }

    public void setId(long id) {
        this.idgrupo = id;
    }

    public Grupo() {
    }

    public Grupo(long id) {
        this.idgrupo = id;
    }

    public Grupo(Grupo g) {
        this.idgrupo = g.idgrupo;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public ArrayList<Detaller> getDetalleres() {
        return detalleres;
    }

    public void setDetalleres(ArrayList<Detaller> detalleres) {
        this.detalleres = detalleres;
    }

    public static Grupo nuevogrupo() {
        Reparacion r2 = Reparacion.listareparaciones();
        Grupo nuevogrupo = new Grupo();
        Scanner sc = new Scanner(System.in);
        //Muestro el día y la hora
        
        //System.out.println(" Este es tu id :" + Grupo.thenextid());
        if (nuevogrupo.getId() <= 0) {
            throw new GrupoException("Valor no valido");
        }
        if (nuevogrupo.getReparaciones().isEmpty()) {
            throw new GrupoException("Este ArrayList es un ArrayList vacío");
        } else {
            StringBuffer sb = new StringBuffer("Estos son los datos del arraydeReparaciones:" + nuevogrupo.getReparaciones());
            sb.insert(sb.indexOf(" . "), " Adios");
            System.out.println(sb);

        }

        if (nuevogrupo.getDetalleres().isEmpty()) {
            throw new GrupoException("Este ArrayList es un ArrayList vacío");
        } else {
            StringBuffer sb = new StringBuffer("Estos son los datos del arraydeReparaciones:" + nuevogrupo.getDetalleres());
            sb.insert(sb.indexOf(" . "), " Adios");
            System.out.println(sb);

        }

        //Los dos arrays de Reparaciones y Detaller, se inicializan a dos arrays vacíos.
        return nuevogrupo;
    }
    
    
     public String data(){
    
    return this.getId()+" | "+this.getDetalleres()+" | "+this.getReparaciones()+" | ";
    }
    //*Los métodos de manejo de ficheros están en la clase Serialización
    
    public void exportarObjetoGrupoTexto(String path) {
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
    
     public static void exportarColeccionDeObjetosGrupoTexto(String path) {
        ArrayList<Grupo> coleccion;
        coleccion = Grupo.convertir(Utilidades.GRUPOS);
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Grupo g: coleccion) {
                    buffer.print(g.data() + "\n");
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
            ObjectOutputStream Grupo = new ObjectOutputStream(fichero);
          Grupo.writeObject(this);
           Grupo.flush();
            Grupo.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }


        public static void exportarColeccionGrupoArchivoBinario(String path) {
        ArrayList<Grupo> coleccion;
        coleccion = Grupo.convertir(Utilidades.GRUPOS);
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

        public static ArrayList<Grupo> importarReparacionDesdeFicheroBinario(String path) {
        ArrayList<Grupo> ret = new ArrayList<Grupo>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Grupo g;
                while ((g = (Grupo) lectorObjeto.readObject()) != null) {
                    ret.add(g);
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
    
        public static ArrayList<Grupo> importarGrupoDesdeFicheroTexto(String path) {
        ArrayList<Grupo> ret = new ArrayList<Grupo>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Grupo g;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (!cadena.isEmpty()) {
                        String[] parametros = cadena.split("\\|");
                        g = new Grupo(Integer.valueOf(parametros[0]));
                        ret.add(g);
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
    public static ArrayList<Grupo> buscarPorIDEnFicheroDeTexto(String path) {
        ArrayList<Grupo> ret = new ArrayList<Grupo>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Grupo g;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        g = new Grupo(Integer.valueOf(parametros[0]));
                        ret.add(g);
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
                for (Grupo gr : ret) {
                    if (gr.getId() == idBuscar) {
                        System.out.println(gr.data());
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
    public String toString() {
        return "Grupo{" + "id=" + idgrupo + ", reparaciones=" + reparaciones + ", detalleres=" + detalleres;
    }

}
