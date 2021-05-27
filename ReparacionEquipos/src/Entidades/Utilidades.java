package Entidades;

import java.text.Normalizer;
import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rxndy
 */
public class Utilidades {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Date introducirFecha() {

        System.out.println("Introduzca la fecha en format aaaa-mm-dd");
        Scanner sc = new Scanner(System.in);

        String fechaTexto = sc.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date fecha = null;
        try {
            fecha = df.parse(fechaTexto);
        } catch (ParseException ex) {
            System.out.println("La fecha es incorrecta...\n"
                    + "Introduzca la fecha en formato dd/mm/aaaa");
        }

        return fecha;
    }

    public static boolean leerBoolean() {
        boolean check = false;
        char r;
        Scanner in = new Scanner(System.in);
        r = in.next().charAt(0);
        while (r != 's' && r != 'S' && r != 'N' && r != 'n') {
            System.out.println("Por favor, introduzca un carácter válido (s/n)");
            r = in.next().charAt(0);
        }
        if ((r == 's') || (r == 'S')) {
            check = true;
        } else if ((r == 'n') || (r == 'N')) {
            check = false;

        }
        return check;

    }

    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public static boolean validarNIF(String nif) {
        boolean resultado = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(nif);
        if (matcher.matches()) {
            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);
            if (reference.equalsIgnoreCase(letra)) {
                resultado = true;
            } else {
                resultado = false;
            }
        } else {
            resultado = false;
        }
        return resultado;

    }

    public static String removeDiacriticalMarks(String string) {
        //Form.NFC acepta ñ y distingue las tildes en español
        return Normalizer.normalize(string, Normalizer.Form.NFC)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static final Cliente CLIENTES[] = {
        new Cliente(1, "Pepe", "74638264T", "C-Los Santos 34 5ºA", "608347586", "874639872", "ES874938376", new ArrayList<Servicio>()),
        new Cliente(2, "Juan", "84756292G", "C-San Lorenzo 24 15ºC", "654783223", "498398578", "ES754834721", new ArrayList<Servicio>()),
        new Cliente(3, "Aitor", "56748302F", "C-Marques de valdecilla 12 3ºD", "758694830", "567483980", "ES887499823", new ArrayList<Servicio>())
    };

    public static final Servicio SERVICIOS[] = {
        new Servicio(1, java.sql.Date.valueOf(LocalDate.parse("12/12/2020", dateFormatter)), "El servicio se realizo con exito", Cliente.arrayde(Cliente.convertir(CLIENTES), new int[]{0, 2})),
        new Servicio(2, java.sql.Date.valueOf(LocalDate.parse("22/11/2020", dateFormatter)), "El servicio se realizo con exito", Cliente.arrayde(Cliente.convertir(CLIENTES), new int[]{1, 2})),
        new Servicio(3, java.sql.Date.valueOf(LocalDate.parse("25/10/2020", dateFormatter)), "El servicio se realizo con exito", Cliente.arrayde(Cliente.convertir(CLIENTES), new int[]{0, 1}))
    };

    public static final Equipo EQUIPOS[] = {
        new Equipo(1, 244.99, "Equipo 1"),
        new Equipo(2, 399.99, "Equipo 2"),
        new Equipo(3, 495.49, "Equipo 3")
    };

    public static final Empleado EMPLEADOS[] = {
        new Empleado(1, "JoseManuel", "785904034", "78594834Y", "Ramirez", "C\\Los Santos 23 4ºA"),
        new Empleado(2, "Eustaquio", "765889239", "56749823R", "Fernandez", "C\\Los Santos 45 3ºC"),
        new Empleado(3, "Federico", "657387298", "87498923G", "Garcia", "C\\Menendez Pelayo 3 3ºC"),
        new Empleado(4, "Rigoberta", "897869589", "34873892F", "Diaz", "C\\San Lorenzo 15 4ºA"),
        new Empleado(5, "Anastasia", "567388298", "64538723H", "Larios", "C\\Los Santos 34 10ºC"),
        new Empleado(6, "Susana", "756498231", "76583934R", "Diaz", "C\\Los Santos 23 5ºD"),
        new Empleado(7, "Federica", "875983847", "92837461J", "Lopez", "C\\San Lorenzo 13 3ºC"),
        new Empleado(8, "Fernando", "765874938", "64830289N", "Gomez", "C\\Los Santos 23 4ºD"),
        new Empleado(9, "Beatriz", "874590873", "74628712U", "Garcia", "C\\Los Santos 12 7ºD"),
        new Empleado(10, "Anastasia", "874875908", "12345678I", "Gomez", "C\\Menendez Pelayo 5 3ºA")
    };

    public static final int numEmpleados = EMPLEADOS.length;

    public static final Detaller DETALLERES[] = {
        new Detaller(false, EMPLEADOS[0]),
        new Detaller(false, EMPLEADOS[1]),
        new Detaller(false, EMPLEADOS[2])
    };

    public static final Repartidor REPARTIDORES[] = {
        new Repartidor(EMPLEADOS[3]),
        new Repartidor(EMPLEADOS[4]),
        new Repartidor(EMPLEADOS[5])
    };

    public static final Baja BAJAS[] = {
        new Baja(1, java.sql.Date.valueOf(LocalDate.parse("12/10/2020", dateFormatter)), java.sql.Date.valueOf(LocalDate.parse("05/12/2020", dateFormatter)), "Cuarentena por coronavirus", EMPLEADOS[3]),
        new Baja(2, java.sql.Date.valueOf(LocalDate.parse("23/05/2020", dateFormatter)), java.sql.Date.valueOf(LocalDate.parse("16/09/2020", dateFormatter)), "Ruptura de brazo", EMPLEADOS[5]),
        new Baja(3, java.sql.Date.valueOf(LocalDate.parse("04/09/2020", dateFormatter)), java.sql.Date.valueOf(LocalDate.parse("25/01/2021", dateFormatter)), "Fisura de muñeca", EMPLEADOS[2])
    };

    public static final int numBajas = BAJAS.length;

    public static final Sustituto SUSTITUTOS[] = {
        new Sustituto("28", false, null, EMPLEADOS[6]),
        new Sustituto("35", false, null, EMPLEADOS[7]),
        new Sustituto("32", false, null, EMPLEADOS[8]),
        new Sustituto("25", false, null, EMPLEADOS[9])
    };

    public static final int numSustitutos = SUSTITUTOS.length;

    public static final Mantenimiento[] MANTENIMIENTOS = {
        //int horastrabajadas, long id, Date fechaServicio, String nota, ArrayList<Cliente> clientes
        new Mantenimiento(22, 2221214, new Date("22/02/2020"), "Servicio de reparaciones", new ArrayList<Cliente>()),
        new Mantenimiento(40, 25585526, new Date("28/05/2012"), "Servicio de reparaciones", new ArrayList<Cliente>()),
        new Mantenimiento(25, 232584688, new Date("02/05/2014"), "Servicio de reparaciones", new ArrayList<Cliente>())
    };
    public static final Envio[] ENVIOS = {
        new Envio(1, new Date("22/07/2020"), 20, 40.00, 20.00, "C-Los olmos 23", new ArrayList<Repartidor>(), SERVICIOS[0])
    };
    public static final int numMantenimientos = MANTENIMIENTOS.length;

    public static final Reparacion[] REPARACIONES = {
        //long id,int horastrabajadas
        new Reparacion(1, 22, MANTENIMIENTOS[1], SERVICIOS[1])
    };

    public static final int numReparaciones = REPARACIONES.length;

    public static final Compra[] COMPRAS = {
        //long idcompra, double preciototal, char metodoPago, long idEquipo, long idLote
       // new Compra(1, 240.99, 'T', new ArrayList<Equipo>(), new ArrayList<Lote>(), SERVICIOS[2])
    };

    public static final Grupo[] GRUPOS = {
        //long id
        new Grupo(1),
        new Grupo(2),
        new Grupo(3),
        new Grupo(4),
        new Grupo(5)

    };
    
     public static final Lote[] LOTES = {};

    public static final int numGrupos = GRUPOS.length;

}
