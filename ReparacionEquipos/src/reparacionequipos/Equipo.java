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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rxndy
 */
public class Equipo {

    private long idEquipo;////valores validos: números positivos mayores que 0 - valor invalido: números menores o iguales que 0
    private double precioEquipo;//valores validos: números positivos mayores que 0 - valor invalido: números menores que 0
    private String modeloEquipo;// valores validos: cadena de caracteres con minimo de 4 letras - valor invalido: longitud de cadena menor de 4 letras

    public Equipo(long idEquipo, double precioEquipo, String modeloEquipo) {
        this.idEquipo = idEquipo;
        this.precioEquipo = precioEquipo;
        this.modeloEquipo = modeloEquipo;
    }

    public Equipo(Equipo e) {
        this.idEquipo = e.getIdEquipo();
        this.precioEquipo = e.getPrecioEquipo();
        this.modeloEquipo = e.getModeloEquipo();
    }

    public Equipo() {
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public double getPrecioEquipo() {
        return precioEquipo;
    }

    public void setPrecioEquipo(double precioEquipo) {
        this.precioEquipo = precioEquipo;
    }

    public String getModeloEquipo() {
        return modeloEquipo;
    }

    public void setModeloEquipo(String modeloEquipo) {
        this.modeloEquipo = modeloEquipo;
    }

    public static Equipo nuevoEquipo() throws EquipoException {
        Equipo e = new Equipo();
        Scanner sc = new Scanner(System.in);
        boolean salir;
        char d;
        do {
            System.out.println("Introduzca id del equipo:");
            Long id = sc.nextLong();
            e.setIdEquipo(id);
            System.out.println("Introduzca precio del equipo:");
            double precio = sc.nextDouble();
            e.setPrecioEquipo(precio);
            System.out.println("Introduzca modelo del equipo:");
            String modelo = sc.nextLine();
            e.setModeloEquipo(modelo);

            System.out.println("Son correctos los siguiente datos?(s/n)");
            System.out.println("id:" + id);
            System.out.println("precio equipo" + precio);
            System.out.println("modelo:" + modelo);
            salir = Utilidades.leerBoolean();
        } while (salir = false);

        if (!EquipoException.comprobarId(e.getIdEquipo())) {
            throw new EquipoException("El id no es valido");
        } else if (!EquipoException.comprobarModeloEquipo(e.getModeloEquipo())) {
            throw new EquipoException("El modelo no es valido");
        } else if (!EquipoException.validarPrecioEquipo(e.getPrecioEquipo())) {
            throw new EquipoException("El precio no es valido");

        }
        return e;
    }

    public static void verEquipo(ArrayList<Equipo> equipos) {
        System.out.println("en el sistema estan registrados los siguientes equipos");
        for (Equipo e : equipos) {
            System.out.println(e.getIdEquipo() + ", " + e.getModeloEquipo() + ", " + e.getPrecioEquipo());
        }
    }

    public static ArrayList<Equipo> convertir(Equipo[] array) {
        ArrayList<Equipo> ret = new ArrayList<Equipo>();
        for (Equipo e : array) {
            ret.add((Equipo) e);
        }
        return ret;
    }

    public static void buscarEquipo(ArrayList<Equipo> equipos) {
        ArrayList<Equipo> valores;
        Scanner in = new Scanner(System.in);
        valores = new ArrayList<Equipo>();
        System.out.println("Pulse 1 para buscar un equipo por el id");
        System.out.println("Pulse 2 para buscar un equipo por el modelo");
        System.out.println("Pulse 3 para buscar un equipo por el precio");
        in.reset();
        int opcion = in.nextInt();
        try {
            do {
                switch (opcion) {
                    case 1:
                        buscarEquipoPorId(equipos);
                        ReparacionEquipos.mostrarGestionEquipos(equipos);
                        break;
                    case 2:
                        System.out.println("introduzca el modeo de equipo que quiera buacar");
                        String modeloEqui = in.nextLine();
                        modeloEqui = in.nextLine();
                        valores = buscarEquipoPorModelo(modeloEqui, equipos);
                        if (valores.size() > 0) {
                            System.out.println("");
                            for (Equipo e : valores) {
                                System.out.println(e.getIdEquipo() + ", " + e.getModeloEquipo() + ", " + ", " + e.getPrecioEquipo());
                            }
                        } else {
                            System.out.println("El equipo de modelo " + modeloEqui + "no se a encontrado en el sistema");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionEquipos(equipos);
                        break;
                    case 3:
                        BuscarPorPrecio(equipos);
                        ReparacionEquipos.mostrarGestionEquipos(equipos);
                        break;
                    case 0:
                        ReparacionEquipos.mostrarGestionEquipos(equipos);
                        break;

                }
            } while (opcion > 3 || opcion < 0);

        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");

        }

    }

    public static void buscarEquipoPorId(ArrayList<Equipo> equipos) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Introduzca el id del equipo que quiera buscar");
            in.reset();
            int idEquipo = in.nextInt();
            Equipo ret = null;
            for (Equipo e : equipos) {
                if (e.getIdEquipo() == idEquipo) {
                    ret = e;
                    break;
                }
            }
            if (ret != null) {
                System.out.println("se ha encontrado un equipo ");
                System.out.println("el equipo contiene los siguientes datos");
                System.out.println(ret.getIdEquipo() + ", " + ret.getModeloEquipo() + ", " + ret.getPrecioEquipo());
            } else {
                System.out.println("el quipo con el id " + idEquipo + " no se a encontrado \n");
            }
        } catch (InputMismatchException ex) {
            System.out.println("El carácter introducido no es un número, porfavor introduzca un número");

        }
    }

    public static ArrayList<Equipo> buscarEquipoPorModelo(String modeloEqui, ArrayList<Equipo> equipos) {
        ArrayList<Equipo> ret = new ArrayList<Equipo>();
        for (Equipo e : equipos) {
            if (Utilidades.removeDiacriticalMarks(e.getModeloEquipo().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(modeloEqui.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getModeloEquipo().toLowerCase().contains(modeloEqui.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static void BuscarPorPrecio(ArrayList<Equipo> equipos) {
        Scanner in = new Scanner(System.in);
        try {

            System.out.println("Introduzca el precio del equipo que quiera buscar");
            in.reset();
            double precioEquipo = in.nextDouble();
            Equipo ret = null;
            for (Equipo e : equipos) {
                if (e.getPrecioEquipo() == precioEquipo) {
                    ret = e;
                }
                break;
            }
            if (ret != null) {
                System.out.println("se a encontrado un equipo");
                System.out.println("El equipo encontrado tiene los siguientes datos");
                System.out.println(ret.getIdEquipo() + ", " + ret.getModeloEquipo() + ", " + ret.getPrecioEquipo());
            } else {
                System.out.println("el quipo con el precio " + precioEquipo + " no se a encontrado \n");
            }
        } catch (InputMismatchException ex) {
            System.out.println("El carácter introducido no es un número, porfavor introduzca un número");
        }
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", precioEquipo=" + precioEquipo + ", modeloEquipo=" + modeloEquipo + '}';
    }

    public static void exportarColeccionEquiposaArchivoBinario(String path) {
        ArrayList<Equipo> coleccion;
        coleccion = Equipo.convertir(Utilidades.EQUIPOS);
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
    public static ArrayList<Equipo> importarEquipoDesdeFicheroBytes(String path) {
        ArrayList<Equipo> ret = new ArrayList<Equipo>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Equipo e;
                while ((e = (Equipo) lectorObjeto.readObject()) != null) {
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
    public static ArrayList<Equipo> importarEquipoDesdeFicheroCaracteres(String path) {
        ArrayList<Equipo> ret = new ArrayList<Equipo>();
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
                    double precioEquipo = Double.parseDouble(campos[1]);
                    String nombreEquipo = campos[2];
                    Equipo e = new Equipo(id, precioEquipo, nombreEquipo);
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
        return idEquipo + "|" + modeloEquipo + '|' + precioEquipo;
    }

}
