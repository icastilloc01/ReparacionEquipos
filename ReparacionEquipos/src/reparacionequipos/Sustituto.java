/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparacionequipos;

/**
 *
 * @author icasc
 */
public class Sustituto extends Empleado{
    private String edad;
    private boolean exclusiónsocial;
    
    public Sustituto() {
        super();
    }
    
    public Sustituto(String edad, boolean exclusiónsocial) {
        this.edad = edad;
        this.exclusiónsocial = exclusiónsocial;
    }
    
    public Sustituto(Sustituto c) {
        this.edad = c.edad;
        this.exclusiónsocial = c.exclusiónsocial;
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
    
    
}
