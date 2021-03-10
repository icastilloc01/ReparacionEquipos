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
 * @author icasc
 */
public class Sustituto extends Empleado {

    private String edad;
    private boolean exclusionsocial;
    private Baja baja = null;

    public Sustituto() {
        super();
    }

    public Sustituto(String edad, boolean exclusiónsocial, Baja baja, long id, String nombre, String telefono, String nif, String apellido, String direccion) {
        super(id, nombre, telefono, nif, apellido, direccion);
        this.edad = edad;
        this.exclusionsocial = exclusiónsocial;
        this.baja = baja;
    }

    public Sustituto(String edad, boolean exclusiónsocial, Baja baja, Empleado e) {
        super(e);
        this.edad = edad;
        this.exclusionsocial = exclusiónsocial;
        this.baja = baja;
    }

    public Sustituto(String edad, boolean exclusiónsocial, Baja baja) {
        this.edad = edad;
        this.exclusionsocial = exclusiónsocial;
        this.baja = baja;
    }

    public Sustituto(Sustituto s) {
        this.edad = s.edad;
        this.exclusionsocial = s.exclusionsocial;
        this.baja = s.baja;
    }

    public String getEdad() {
        return edad;
    }

    public boolean isExclusionsocial() {
        return exclusionsocial;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setExclusionsocial(boolean exclusionsocial) {
        this.exclusionsocial = exclusionsocial;
    }

    public Baja getBaja() {
        return baja;
    }

    public void setBaja(Baja baja) {
        this.baja = baja;
    }

    public static ArrayList<Sustituto> arrayde(ArrayList<Sustituto> lista, int[] ids) {
        ArrayList<Sustituto> ret = new ArrayList<Sustituto>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Sustituto) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static ArrayList<Sustituto> convertir(Sustituto[] array) {
        ArrayList<Sustituto> ret = new ArrayList<Sustituto>();
        for (Sustituto s : array) {
            ret.add((Sustituto) s);
        }
        return ret;
    }

    public static Sustituto nuevoSustituto() {
        Sustituto nuevoSustituto = new Sustituto();
        Empleado e = Empleado.nuevoEmpleado();
        nuevoSustituto.setId(e.getId());
        nuevoSustituto.setNombre(e.getNombre());
        nuevoSustituto.setTelefono(e.getTelefono());
        nuevoSustituto.setNif(e.getNif());
        nuevoSustituto.setApellido(e.getApellido());
        nuevoSustituto.setDireccion(e.getDireccion());
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Introduzca la edad del nuevo sustituto: ");
            nuevoSustituto.edad = in.nextLine();
            if (!Utilidades.isNumeric(nuevoSustituto.edad) || nuevoSustituto.edad.length() > 3 || nuevoSustituto.edad.length() < 0 || Integer.parseInt(nuevoSustituto.edad) < 0) {
                System.out.println("La edad que ha introducido no es valida");
            }
        } while (!Utilidades.isNumeric(nuevoSustituto.edad) || nuevoSustituto.edad.length() > 3 || nuevoSustituto.edad.length() < 0 || Integer.parseInt(nuevoSustituto.edad) < 0);
        System.out.println("¿Tiene exclusión social? s/n");
        nuevoSustituto.exclusionsocial = Utilidades.leerBoolean();
        return nuevoSustituto;
    }

    public static ArrayList<Sustituto> cubrirBaja(ArrayList<Baja> bajas, ArrayList<Sustituto> sustitutos, ArrayList<Empleado> empleados) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el id de la baja que quiera cubrir: ");
        in.reset();
        try {
            int idBaja = in.nextInt();
            Baja cubrir = null;
            if (idBaja <= 0 || idBaja > Utilidades.numBajas) {
                System.out.println("El numero de id que ha introducido no corresponde con ninguna baja registrada");
                System.out.println("");
                cubrirBaja(bajas, sustitutos, empleados);
            } else {
                for (Baja b : bajas) {
                    if (b.getId() == idBaja) {
                        cubrir = b;
                        break;
                    }
                }
            }
            System.out.println("Introduzca el id de sustituto que quiere que cubra esa baja: ");
            in.reset();
            int idSustituto = in.nextInt();
            Sustituto cubridor = null;
            if (idSustituto <= 0 || idBaja > Utilidades.numSustitutos) {
                System.out.println("El numero de id que ha introducido no corresponde con ningun sustituto registrado");
                System.out.println("");
                cubrirBaja(bajas, sustitutos, empleados);
            } else {
                for (Sustituto s : sustitutos) {
                    if (s.getId() == idSustituto) {
                        cubridor = s;
                        cubridor.setBaja(cubrir);
                        break;
                    }
                }
            }
            empleados.set(idSustituto - 1, cubridor);
            System.out.println("la baja" + Utilidades.BAJAS[idBaja - 1] + "ha sido cubierta");
        } catch (InputMismatchException ex) {
            System.out.println("El carácter introducido no es número, porfavor introduzca un número");
            cubrirBaja(bajas, sustitutos, empleados);
        }
        return sustitutos;
    }

    public static void verSustitutoCubreBaja(ArrayList<Sustituto> sustitutos) {
        System.out.println("En el sistema se encuentran los siguientes empleados de tipo sustituto: ");
        for (Sustituto s : sustitutos) {
            System.out.println(s.getId() + ". " + s.getApellido() + ". " + s.getTelefono() + ". " + s.getNif() + ". " + s.getDireccion() + ". " + s.getEdad() + ". " + s.getBaja());
        }
    }

    @Override
    public String toString() {
        return "Sustituto{" + "edad=" + edad + ", exclusionsocial=" + exclusionsocial + '}';
    }

}
