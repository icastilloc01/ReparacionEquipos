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
    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<Cliente> clientes = Cliente.convertir(Utilidades.CLIENTES);
        ArrayList<Servicio> servicios = Servicio.convertir(Utilidades.SERVICIOS);
        ArrayList<Equipo> equipos = Equipo.convertir(Utilidades.EQUIPOS);
        ArrayList<Detaller> detalleres = Detaller.convertir(Utilidades.DETALLERES);
        ArrayList<Repartidor> repartidores = Repartidor.convertir(Utilidades.REPARTIDORES);
        ArrayList<Sustituto> sustitutos = Sustituto.convertir(Utilidades.SUSTITUTOS);
        ArrayList<Baja> bajas = Baja.convertir(Utilidades.BAJAS);
        empleados.addAll(detalleres);
        empleados.addAll(repartidores);
        empleados.addAll(sustitutos);
        mostrarMenuPrincipal();
        Scanner in = new Scanner(System.in);
        int opcion;
        try {
            do {
                in.reset();
                opcion = in.nextInt();
                switch (opcion) {
                    case 1:
                        mostrarGestionClientes();
                        break;
                    case 2:
                        mostrarGestionEquipos();
                        break;
                    case 3:
                        mostrarGestionEmpleados();
                        break;
                    case 4:
                        mostrarGestionServicios();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 1 al 4");
                }

            } while (opcion > 4 || opcion < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
        }

    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Pulse 1 para gestionar clientes");
        System.out.println("Pulse 2 para gestionar Equipos");
        System.out.println("Pulse 3 para gestionar Empleados");
        System.out.println("Pulse 4 para gestionar Servicios");
        System.out.println("Pulse 0 para salir");
    }

    public static void mostrarGestionClientes() {
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
                        //Cliente.verCliente();
                        break;
                    case 2:
                        Cliente.nuevoCliente();
                        break;
                    case 3:
                        //Cliente.buscarCliente();
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                }

            } while (op1 > 3 || op1 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
        }
    }

    public static void mostrarGestionEquipos() {
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
                        //Equipo.verEquipo()
                        break;
                    case 2:
                        Equipo.nuevoEquipo();
                        break;
                    case 3:
                        //Equipo.buscarEquipo();
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                }

            } while (op2 > 3 || op2 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
        }
    }

    public static void mostrarGestionEmpleados() {
        System.out.println("Pulse 1 para ver los empleados");
        System.out.println("Pulse 2 para registrar un nuevo empleado");
        System.out.println("Pulse 3 para buscar un empleado");
        System.out.println("Pulse 4 para cubrir una baja");
        System.out.println("Pulse 0 para volver");
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<Detaller> detalleres = Detaller.convertir(Utilidades.DETALLERES);
        ArrayList<Repartidor> repartidores = Repartidor.convertir(Utilidades.REPARTIDORES);
        ArrayList<Sustituto> sustitutos = Sustituto.convertir(Utilidades.SUSTITUTOS);
        empleados.addAll(detalleres);
        empleados.addAll(repartidores);
        empleados.addAll(sustitutos);
        Scanner in = new Scanner(System.in);
        int op3;
        try {
            do {
                in.reset();
                op3 = in.nextInt();
                switch (op3) {
                    case 1:
                        Empleado.verEmpleado(empleados);
                        break;
                    case 2:
                        mostrarTiposEmpleados();
                        break;
                    case 3:
                        //Empleado.buscarEmpleado;
                        break;
                    case 4:
                        //metodo para cubrir bajas
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 1 al 4");
                }

            } while (op3 > 4 || op3 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
        }
    }

    public static void mostrarTiposEmpleados() {
        System.out.println("Pulse 1 para registrar un nuevo empleado de taller");
        System.out.println("Pulse 2 para registrar un nuevo empleado repartidor");
        System.out.println("Pulse 3 para registrar un nuevo empleado sustituto");
        System.out.println("Pulse 0 para volver");
        Scanner in = new Scanner(System.in);
        int emp2;
        try {
            do {
                in.reset();
                emp2 = in.nextInt();
                switch (emp2) {
                    case 1:
                        Detaller.nuevoDetaller();
                        break;
                    case 2:
                        Repartidor.nuevoRepartidor();
                        break;
                    case 3:
                        Sustituto.nuevoSustituto();
                        break;
                    case 0:
                        mostrarGestionEmpleados();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                }

            } while (emp2 > 3 || emp2 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
        }
    }

    public static void mostrarGestionServicios() {
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
                        Compra.nuevaCompra();
                        break;
                    case 2:
                        //Reparacion.nuevoReparacion();
                        break;
                    case 3:
                        Envio.nuevoEnvio();
                        break;
                    case 0:
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                }

            } while (op4 > 3 || op4 < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
        }
    }
}
