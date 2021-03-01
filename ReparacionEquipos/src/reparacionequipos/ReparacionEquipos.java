/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DAM105
 */
public class ReparacionEquipos {

    /**
     * @param args the command line arguments
     */
    //Inicializar los datos de la clase Utilidades en ArrayLists
    static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    static ArrayList<Cliente> clientes = Cliente.convertir(Utilidades.CLIENTES);
    static ArrayList<Servicio> servicios = Servicio.convertir(Utilidades.SERVICIOS);
    static ArrayList<Equipo> equipos = Equipo.convertir(Utilidades.EQUIPOS);
    static ArrayList<Detaller> detalleres = Detaller.convertir(Utilidades.DETALLERES);
    static ArrayList<Repartidor> repartidores = Repartidor.convertir(Utilidades.REPARTIDORES);
    static ArrayList<Sustituto> sustitutos = Sustituto.convertir(Utilidades.SUSTITUTOS);
    static ArrayList<Baja> bajas = Baja.convertir(Utilidades.BAJAS);
    
    public static void main(String[] args) {
        //Anadir al ArrayList de empleados los datos de los empleados de tipo Detalleres, Repartidores, Sustitutos
        empleados.addAll(detalleres);
        empleados.addAll(repartidores);
        empleados.addAll(sustitutos);
        
        System.out.println("Escribe el path");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        Empleado e = new Empleado();
        e.exportarColeccionDeObjetosEmpleado(path);
        
        //Comienzo del menu
        mostrarMenuPrincipal();        
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Pulse 1 para gestionar clientes");
        System.out.println("Pulse 2 para gestionar Equipos");
        System.out.println("Pulse 3 para gestionar Empleados");
        System.out.println("Pulse 4 para gestionar Servicios");
        System.out.println("Pulse 0 para salir");
        Scanner in = new Scanner(System.in);
        int opcion;
        try {
            do {
                in.reset();
                opcion = in.nextInt();
                switch (opcion) {
                    case 1:
                        mostrarGestionClientes(clientes);
                        mostrarMenuPrincipal();
                        break;
                    case 2:
                        mostrarGestionEquipos(equipos);
                        mostrarMenuPrincipal();
                        break;
                    case 3:
                        mostrarGestionEmpleados(empleados);
                        mostrarMenuPrincipal();
                        break;
                    case 4:
                        mostrarGestionServicios(servicios);
                        mostrarMenuPrincipal();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 0 al 4");
                        System.out.println("");
                }
            } while (opcion > 4 || opcion < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
        }
    }

    public static void mostrarGestionClientes(ArrayList<Cliente> clientes) {
        System.out.println("Pulse 1 para ver los clientes");
        System.out.println("Pulse 2 para registrar un nuevo cliente");
        System.out.println("Pulse 3 para buscar un cliente");
        System.out.println("Pulse 0 para volver");
        Scanner in = new Scanner(System.in);
        int op1;
        try {
            do {
                in.reset();
                op1 = in.nextInt();
                switch (op1) {
                    case 1:
                        Cliente.verClientes(clientes);
                        mostrarGestionClientes(clientes);
                        break;
                    case 2:
                        Cliente nuevoCliente = Cliente.nuevoCliente();
                        clientes.add(nuevoCliente);
                        mostrarGestionClientes(clientes);
                        break;
                    case 3:
                        Cliente.buscarClientes(clientes);
                        mostrarGestionClientes(clientes);
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 0 al 3");
                        System.out.println("");
                }

            } while (op1 > 3 || op1 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
        }
    }

    public static void mostrarGestionEquipos(ArrayList<Equipo> equipos) {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        System.out.println("Pulse 1 para ver los equipos");
        System.out.println("Pulse 2 para registrar un nuevo equipo");
        System.out.println("Pulse 3 para buscar un equipo");
        System.out.println("Pulse 0 para volver");
        Scanner in = new Scanner(System.in);
        int op2;
        try {
            do {
                in.reset();
                op2 = in.nextInt();
                switch (op2) {
                    case 1:
                        Equipo.verEquipo(equipos);
                        mostrarGestionEquipos(equipos);
                        break;
                    case 2:
                        Equipo nuevoEquipo = Equipo.nuevoEquipo();
                        equipos.add(nuevoEquipo);
                        mostrarGestionEquipos(equipos);
                        break;
                    case 3:
                        Equipo.buscarEquipo(equipos);
                        mostrarGestionEquipos(equipos);
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 0 al 3");
                        System.out.println("");
                }

            } while (op2 > 3 || op2 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
        }
    }

    public static void mostrarGestionEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("Pulse 1 para ver los empleados");
        System.out.println("Pulse 2 para registrar un nuevo empleado");
        System.out.println("Pulse 3 para buscar un empleado");
        System.out.println("Pulse 4 para cubrir una baja");
        System.out.println("Pulse 5 para comprobar las bajas que los sustitutos cubren");
        System.out.println("Pulse 0 para volver");
        Scanner in = new Scanner(System.in);
        int op3;
        try {
            do {
                in.reset();
                op3 = in.nextInt();
                switch (op3) {
                    case 1:
                        Empleado.verEmpleado(empleados);
                        mostrarGestionEmpleados(empleados);
                        break;
                    case 2:
                        mostrarTiposEmpleados(empleados);
                        mostrarGestionEmpleados(empleados);
                        break;
                    case 3:
                        Empleado.buscarEmpleado(empleados);
                        mostrarGestionEmpleados(empleados);
                        break;
                    case 4:
                        Sustituto.cubrirBaja(bajas, sustitutos, empleados);
                        empleados.addAll(sustitutos);
                        mostrarGestionEmpleados(empleados);
                        break;
                    case 5:
                        Sustituto.verSustitutoCubreBaja(sustitutos);
                        mostrarGestionEmpleados(empleados);
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 0 al 4");
                        System.out.println("");
                }

            } while (op3 > 4 || op3 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
        }
    }

    public static void mostrarTiposEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("Pulse 1 para registrar un nuevo empleado de taller");
        System.out.println("Pulse 2 para registrar un nuevo empleado repartidor");
        System.out.println("Pulse 3 para registrar un nuevo empleado sustituto");
        System.out.println("Pulse 0 para volver");
        Scanner in = new Scanner(System.in);
        int emp;
        try {
            do {
                in.reset();
                emp = in.nextInt();
                switch (emp) {
                    case 1:
                        Detaller nuevoDetaller = Detaller.nuevoDetaller();
                        empleados.add(nuevoDetaller);
                        mostrarTiposEmpleados(empleados);
                        break;
                    case 2:
                        Repartidor nuevoRepartidor = Repartidor.nuevoRepartidor();
                        empleados.add(nuevoRepartidor);
                        mostrarTiposEmpleados(empleados);
                        break;
                    case 3:
                        Sustituto nuevoSustituto = Sustituto.nuevoSustituto();
                        empleados.add(nuevoSustituto);
                        mostrarTiposEmpleados(empleados);
                        break;
                    case 0:
                        mostrarGestionEmpleados(empleados);
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 0 al 3");
                        System.out.println("");
                }

            } while (emp > 3 || emp < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
        }
    }

    public static void mostrarGestionServicios(ArrayList<Servicio> servicios) {
        System.out.println("Pulse 1 para registrar una nueva compra");
        System.out.println("Pulse 2 para registrar una nueva reparacion");
        System.out.println("Pulse 3 para registrar un nuevo envio");
        System.out.println("Pulse 0 para volver");
        Scanner in = new Scanner(System.in);
        int op4;
        try {
            do {
                in.reset();
                op4 = in.nextInt();
                switch (op4) {
                    case 1:
                        Compra nuevaCompra = Compra.nuevaCompra();
                        servicios.add(nuevaCompra);
                        mostrarGestionServicios(servicios);
                        break;
                    case 2:
                        Reparacion nuevaReparacion = Reparacion.nuevaReparacion();
                        servicios.add(nuevaReparacion);
                        mostrarGestionServicios(servicios);
                        break;
                    case 3:
                        Envio nuevoEnvio = Envio.nuevoEnvio();
                        servicios.add(nuevoEnvio);
                        mostrarGestionServicios(servicios);
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 0 al 3");
                        System.out.println("");
                }

            } while (op4 > 3 || op4 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
        }
    }
}