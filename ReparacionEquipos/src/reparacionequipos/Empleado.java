/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author icasc
 */
public class Empleado {

    protected long id;                  //no puede ser menor de 0
    protected String nombre;
    protected String telefono;          //debe ser una sucesión de 9 números
    protected String nif;               //debe ser una sucesión de 8 números y 1 letra
    protected String apellido;
    protected String direccion;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String teléfono, String nif, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = teléfono;
        this.nif = nif;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.telefono = e.telefono;
        this.nif = e.nif;
        this.apellido = e.apellido;
        this.direccion = e.direccion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNif() {
        return nif;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static long nextIdEmpleado() {
        long ret = 0;
        for (Empleado e : Utilidades.EMPLEADOS) {
            if (e.getId() > ret) {
                ret = e.getId();
            }
        }
        for (Repartidor r : Utilidades.REPARTIDORES) {
            if (r.getId() > ret) {
                ret = r.getId();
            }
        }
        for (Sustituto s : Utilidades.SUSTITUTOS) {
            if (s.getId() > ret) {
                ret = s.getId();
            }
        }
        for (Detaller s : Utilidades.DETALLERES) {
            if (s.getId() > ret) {
                ret = s.getId();
            }
        }
        return ret + 1;
    }

    public static Empleado nuevoEmpleado() {
        Empleado nuevoEmpleado = new Empleado();
        Scanner in = new Scanner(System.in);
        nuevoEmpleado.id = nextIdEmpleado();
        System.out.print("Introduzca el nombre del nuevo empleado: ");
        nuevoEmpleado.nombre = in.nextLine();
        do {
            System.out.print("Introduzca el teléfono del nuevo empleado: ");
            nuevoEmpleado.telefono = in.nextLine();
            if (nuevoEmpleado.telefono.length() != 9 || Utilidades.isNumeric(nuevoEmpleado.telefono) == false) {
                System.out.println("La cadena introducida para teléfono contiene algún caracter que no es un número o no tiene una longitud de 9 carácteres");
            }
        } while (nuevoEmpleado.telefono.length() != 9 || Utilidades.isNumeric(nuevoEmpleado.telefono) == false);
        do {
            System.out.print("Introduzca el nif del nuevo empleado: ");
            nuevoEmpleado.nif = in.nextLine();
            if (Utilidades.validarNIF(nuevoEmpleado.nif) == false) {
                System.out.println("La cadena introducida no corresponde con el formato de un nif");
            }
        } while (Utilidades.validarNIF(nuevoEmpleado.nif) == false);
        System.out.print("Introduzca el apellido del nuevo empleado: ");
        nuevoEmpleado.apellido = in.nextLine();
        System.out.print("Introduzca la direccion del nuevo empleado: ");
        nuevoEmpleado.direccion = in.nextLine();
        return nuevoEmpleado;
    }

    public static void verEmpleado(ArrayList<Empleado> empleados) {
        System.out.println("En el sistema estan registrados los siguientes empleados:");
        for (Empleado e : empleados) {
            System.out.println(e.getId() + ". " + e.getNombre() + ". " + e.getApellido() + ". " + e.getTelefono() + ". " + e.getNif() + ". " + e.getDireccion() + ". (" + e.getClass().getSimpleName() + ")");
        }
    }

    public static void buscarEmpleado(ArrayList<Empleado> empleados) {
        ArrayList<Empleado> valores;
        Scanner in = new Scanner(System.in);
        valores = new ArrayList<Empleado>();
        System.out.println("Pulse 1 para buscar un empleado por el id");
        System.out.println("Pulse 2 para buscar un empleado por el nombre");
        System.out.println("Pulse 3 para buscar un empleado por el telefono");
        System.out.println("Pulse 4 para buscar un empleado por el nif");
        System.out.println("Pulse 5 para buscar un empleado por el apellido");
        System.out.println("Pulse 6 para buscar un empleado por la direccion");
        System.out.println("Pulse 0 para volver");
        in.reset();
        int opcion = in.nextInt();
        try {
            do {
                switch (opcion) {
                    case 1:
                        buscarEmpleadoPorId(empleados);
                        ReparacionEquipos.mostrarGestionEmpleados(empleados);
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre del empleado que desea buscar:");
                        String nombreEmp = in.nextLine(); //linea para que no se salte el nextLine()
                        nombreEmp = in.nextLine();
                        valores = buscarEmpleadoPorNombre(nombreEmp, empleados);
                        if (valores.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Empleado e : valores) {
                                System.out.println(e.getId() + ". " + e.getNombre() + ". " + e.getApellido() + ". " + e.getTelefono() + ". " + e.getNif() + ". " + e.getDireccion() + ". (" + e.getClass().getSimpleName() + ")");
                            }
                        } else {
                            System.out.println("El empleado con nombre " + nombreEmp + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionEmpleados(empleados);
                        break;
                    case 3:
                        System.out.println("Introduzca el telefono del empleado que desea buscar:");
                        String telefonoEmp = in.nextLine(); //linea para que no se salte el nextLine()
                        telefonoEmp = in.nextLine();
                        valores = buscarEmpleadoPorTelefono(telefonoEmp, empleados);
                        if (valores.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Empleado e : valores) {
                                System.out.println(e.getId() + ". " + e.getNombre() + ". " + e.getApellido() + ". " + e.getTelefono() + ". " + e.getNif() + ". " + e.getDireccion() + ". (" + e.getClass().getSimpleName() + ")");
                            }
                        } else {
                            System.out.println("El empleado con telefono " + telefonoEmp + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionEmpleados(empleados);
                        break;
                    case 4:
                        System.out.println("Introduzca el NIF del empleado que desea buscar:");
                        String nifEmp = in.nextLine(); //linea para que no se salte el nextLine()
                        nifEmp = in.nextLine();
                        valores = buscarEmpleadoPorNif(nifEmp, empleados);
                        if (valores.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Empleado e : valores) {
                                System.out.println(e.getId() + ". " + e.getNombre() + ". " + e.getApellido() + ". " + e.getTelefono() + ". " + e.getNif() + ". " + e.getDireccion() + ". (" + e.getClass().getSimpleName() + ")");
                            }
                        } else {
                            System.out.println("El empleado con NIF " + nifEmp + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionEmpleados(empleados);
                        break;
                    case 5:
                        System.out.println("Introduzca el apellido del empleado que desea buscar:");
                        String apellidoEmp = in.nextLine(); //linea para que no se salte el nextLine()
                        apellidoEmp = in.nextLine();
                        valores = buscarEmpleadoPorApellido(apellidoEmp, empleados);
                        if (valores.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Empleado e : valores) {
                                System.out.println(e.getId() + ". " + e.getNombre() + ". " + e.getApellido() + ". " + e.getTelefono() + ". " + e.getNif() + ". " + e.getDireccion() + ". (" + e.getClass().getSimpleName() + ")");
                            }
                        } else {
                            System.out.println("El empleado con apellido " + apellidoEmp + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionEmpleados(empleados);
                        break;
                    case 6:
                        System.out.println("Introduzca el direccion del empleado que desea buscar:");
                        String direccionEmp = in.nextLine(); //linea para que no se salte el nextLine()
                        direccionEmp = in.nextLine();
                        valores = buscarEmpleadoPorDireccion(direccionEmp, empleados);
                        if (valores.size() > 0) {
                            System.out.println("Se han encontrado datos: ");
                            for (Empleado e : valores) {
                                System.out.println(e.getId() + ". " + e.getNombre() + ". " + e.getApellido() + ". " + e.getTelefono() + ". " + e.getNif() + ". " + e.getDireccion() + ". (" + e.getClass().getSimpleName() + ")");
                            }
                        } else {
                            System.out.println("El empleado con direccion " + direccionEmp + " no se ha encontrado en el sistema.");
                        }
                        System.out.println("");
                        ReparacionEquipos.mostrarGestionEmpleados(empleados);
                        break;
                    case 0:
                        ReparacionEquipos.mostrarGestionEmpleados(empleados);
                        break;
                    default:
                        System.out.println("El valor que ha introducido no es un número del 0 al 6");
                        System.out.println("");
                }
            } while (opcion > 6 || opcion < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
            buscarEmpleado(empleados);
        }
    }

    public static void buscarEmpleadoPorId(ArrayList<Empleado> empleados) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Introduzca el id del empleado que quiere buscar");
            in.reset();
            int idEmpleado = in.nextInt();
            Empleado ret = null;
            for (Empleado e : empleados) {
                if (e.getId() == idEmpleado) {
                    ret = e;
                    break;
                }
            }
            if (ret != null) {
                System.out.println("Se ha encontrado a un empleado");
                System.out.print("El empleado encontrado tiene los siguientes datos: ");
                System.out.println(ret.getId() + ". " + ret.getNombre() + ". " + ret.getApellido() + ". " + ret.getTelefono() + ". " + ret.getNif() + ". " + ret.getDireccion() + ". (" + ret.getClass().getSimpleName() + ")");
            } else {
                System.out.println("Empleado con id " + idEmpleado + " no se ha encontrado en el sistema.");
            }
            System.out.println("");
        } catch (InputMismatchException ex) {
            System.out.println("El carácter introducido no es un número, porfavor introduzca un número");
            buscarEmpleadoPorId(empleados);
        }
    }

    public static ArrayList<Empleado> buscarEmpleadoPorNombre(String nombreEmp, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getNombre().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nombreEmp.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getNombre().toLowerCase().contains(nombreEmp.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorTelefono(String telefonoEmp, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getTelefono().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(telefonoEmp.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getTelefono().toLowerCase().contains(telefonoEmp.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorNif(String nifEmp, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getNif().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nifEmp.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getNif().toLowerCase().contains(nifEmp.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorApellido(String apellidoEmp, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getApellido().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(apellidoEmp.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getApellido().toLowerCase().contains(apellidoEmp.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorDireccion(String direccionEmp, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : empleados) {
            if (Utilidades.removeDiacriticalMarks(e.getDireccion().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(direccionEmp.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getDireccion().toLowerCase().contains(direccionEmp.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    /**
     * Este metodo exporta todos los datos de un objeto de tipo empleado a un
     * fichero de texto pasado anteriormente mediante un String llamado path
     *
     * @param path
     */
    public void exportarObjetoEmpleado(String path) {
        File fichero = new File(path);
        FileWriter empleado = null;
        PrintWriter buffer = null;
        try {
            try {
                empleado = new FileWriter(fichero, true);
                buffer = new PrintWriter(empleado);
                buffer.print(this.data() + "\r\n");
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (empleado != null) {
                    empleado.close();
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
    
    /**
     * Este metodo exporta todos los datos de una coleccion de objetos de la clase empleado empleado a un
     * fichero de texto pasado anteriormente mediante un String llamado path
     * @param path 
     */
    public void exportarColeccionDeObjetosEmpleado(String path) {
        ArrayList<Empleado> coleccion = new ArrayList<Empleado>();
        File fichero = new File(path);
        FileWriter empleado = null;
        PrintWriter buffer = null;
        try {
            try {
                empleado = new FileWriter(fichero, true);
                buffer = new PrintWriter(empleado);
                buffer.print(coleccion + "\r\n");
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (empleado != null) {
                    empleado.close();
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

    /**
     * Este metodo exporta todos los datos de un objeto de tipo empleado a un
     * fichero de bytes pasado anteriormente mediante un String llamado path
     * @param path 
     */
    public void exportarEmpleadoaArchivoBinario(String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream empleado = new ObjectOutputStream(fichero);
            empleado.writeObject(this);
            empleado.flush();
            empleado.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public String data() {
        return id + '|' + nombre + '|' + telefono + '|' + nif + '|' + apellido + '|' + direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", nif=" + nif + ", apellido=" + apellido + ", direccion=" + direccion + '}';
    }

}
