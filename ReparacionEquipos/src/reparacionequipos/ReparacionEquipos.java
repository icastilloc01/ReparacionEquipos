/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

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
                                        break;
                                    default:
                                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                                }

                            } while (op1 > 4 || op1 < 0);
                        } catch (InputMismatchException ex) {
                            System.out.println("El caracter introducido no es un entero");
                        }
                        break;
                    case 2:
                        mostrarGestionEquipos();
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
                                        break;
                                    default:
                                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                                }

                            } while (op2 > 4 || op2 < 0);
                        } catch (InputMismatchException ex) {
                            System.out.println("El caracter introducido no es un entero");
                        }
                        break;
                    case 3:
                        mostrarGestionEmpleados();
                        int op3;
                        try {
                            do {
                                in.reset();
                                op3 = in.nextInt();
                                switch (op3) {
                                    case 1:
                                        //Empleado.verEmpleado();
                                        break;
                                    case 2:
                                        Empleado.nuevoEmpleado();
                                        break;
                                    case 3:
                                        //Empleado.buscarEmpleado();
                                        break;
                                    case 4:
                                        //metodo para cubrir bajas
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                                }

                            } while (op3 > 4 || op3 < 0);
                        } catch (InputMismatchException ex) {
                            System.out.println("El caracter introducido no es un entero");
                        }
                        break;
                    case 4:
                        mostrarGestionServicios();
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
                                        break;
                                    default:
                                        System.out.println("Ha introducido un numero que no va del 1 al 3");
                                }

                            } while (op4 > 4 || op4 < 0);
                        } catch (InputMismatchException ex) {
                            System.out.println("El caracter introducido no es un entero");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Ha introducido un numero que no va del 1 al 4");
                }

            } while (opcion > 4 || opcion < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un entero");
        }

    }

    public static void mostrarMenuPrincipal() {
        System.out.println("Pulse 1 para gestionar clientes");
        System.out.println("Pulse 2 para gestionar Equipos");
        System.out.println("Pulse 3 para gestionar Empleados");
        System.out.println("Pulse 4 para gestionar Servicios");
        System.out.println("Pulse 0 para Salir");
    }

    public static void mostrarGestionClientes() {
        System.out.println("Pulse 1 para ver los clientes");
        System.out.println("Pulse 2 para registrar un nuevo cliente");
        System.out.println("Pulse 3 para buscar un cliente");
        System.out.println("Pulse 0 para Salir");
    }

    public static void mostrarGestionEquipos() {
        System.out.println("Pulse 1 para ver los equipos");
        System.out.println("Pulse 2 para registrar un nuevo equipo");
        System.out.println("Pulse 3 para buscar un equipo");
        System.out.println("Pulse 0 para Salir");
    }

    public static void mostrarGestionEmpleados() {
        System.out.println("Pulse 1 para ver los empleados");
        System.out.println("Pulse 2 para registrar un nuevo empleado");
        System.out.println("Pulse 3 para buscar un empleado");
        System.out.println("Pulse 4 para cubrir una baja");
        System.out.println("Pulse 0 para Salir");
    }

    public static void mostrarGestionServicios() {
        System.out.println("Pulse 1 para registrar una nueva compra");
        System.out.println("Pulse 2 para registrar una nueva reparacion");
        System.out.println("Pulse 3 para registrar un nuevo envio");
        System.out.println("Pulse 0 para Salir");
    }
}
