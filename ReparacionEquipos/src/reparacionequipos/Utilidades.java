package reparacionequipos;

import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


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

        System.out.println("Introduzca la fecha en format dd/mm/aaaa");
        Scanner sc = new Scanner(System.in);

        String fechaTexto = sc.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
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



    public static final Cliente CLIENTES[] = {
        new Cliente(1, "Pepe", "74638264T", "C-Los Santos 34 5ºA", "608347586", "874639872", "ES874938376", new ArrayList<Servicio>()),
        new Cliente(2, "Juan", "84756292G", "C-San Lorenzo 24 15ºC", "654783223", "498398578", "ES754834721", new ArrayList<Servicio>())
    };
    
    public static final Servicio SERVICIOS[] = {
        new Servicio(1, java.sql.Date.valueOf(LocalDate.parse("12/12/2020", dateFormatter)), "El servicio se realizo con exito", Cliente.arrayde(Cliente.convertir(CLIENTES), new int[]{1, 3}))
    };

    public static final int numClientes = CLIENTES.length;
}
