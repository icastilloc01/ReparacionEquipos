/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author icasc
 */
public class Sustituto extends Empleado {

    private String edad;
    private boolean exclusiónsocial;
    private ArrayList<Baja> bajas = new ArrayList<>();

    public Sustituto() {
        super();
    }

    public Sustituto(String edad, boolean exclusiónsocial) {
        this.edad = edad;
        this.exclusiónsocial = exclusiónsocial;
    }

    public Sustituto(Sustituto s) {
        this.edad = s.edad;
        this.exclusiónsocial = s.exclusiónsocial;
    }

    public String getEdad() {
        return edad;
    }

    public boolean isExclusiónsocial() {
        return exclusiónsocial;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setExclusiónsocial(boolean exclusiónsocial) {
        this.exclusiónsocial = exclusiónsocial;
    }

    public ArrayList<Baja> getBajas() {
        return bajas;
    }

    public void setBajas(ArrayList<Baja> bajas) {
        this.bajas = bajas;
    }

    public static Sustituto nuevoSustituto(){
        Sustituto nuevoSustituto = new Sustituto();
        Scanner in = new Scanner(System.in);
        System.out.print("Introduzca la edad del nuevo sustituto: ");
        nuevoSustituto.edad = in.nextLine();
        System.out.print("¿Tiene exclusión social? ");
        nuevoSustituto.exclusiónsocial = in.nextBoolean();
        return nuevoSustituto;
    }

    @Override
    public String toString() {
        return "Sustituto{" + "edad=" + edad + ", exclusi\u00f3nsocial=" + exclusiónsocial + '}';
    }
    
}
