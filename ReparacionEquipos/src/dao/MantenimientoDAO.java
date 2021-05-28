/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import ConexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Empleado;
import Entidades.Mantenimiento;

/**
 *
 * @author aitor
 */
public class MantenimientoDAO {

    public static void insertarEmpleadoMantenimiento(Mantenimiento m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int horastrabajadas;
    private MantenimientoDAO m;
    private static Connection conn;

    ;

    public MantenimientoDAO() {

        conn = ConexionBD.establecerConexion();
    }

    public MantenimientoDAO(MantenimientoDAO m1) {
        this.m = m1;
        conn = ConexionBD.establecerConexion();
    }

    public MantenimientoDAO(MantenimientoDAO m2, int ht) {
        this.m = m2;
        this.horastrabajadas = ht;
        conn = ConexionBD.establecerConexion();
    }

    public static ArrayList<Empleado> todosempleados() {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM empleado");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nombre");
                    String tlf = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado e = new Empleado(id, nom, tlf, nif, apellido, direccion);
                    empleados.add(e);

                    for (Empleado em : empleados) {
                        System.out.println("Nombre : " + em.getNombre() + " Telefono : " + em.getTelefono() + " NIF : " + em.getNif() + " Apellido : " + em.getApellido() + " Direccion :" + em.getDireccion());

                    }
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    public void eliminarEmpleadoMantenimiento(int idEmpleado) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM empleado WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEmpleado));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado la planta de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado la planta de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Empleado> FiltrarEmpleadoMantenimientoPorNombre(String nombre) {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {

                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * FROM empleado WHERE nombre ='" + nombre + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nombre");
                    String tlf = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado e = new Empleado(id, nom, tlf, nif, apellido, direccion);
                    empleados.add(e);

                    for (Empleado em : empleados) {
                        System.out.println("Nombre : " + em.getNombre() + " Telefono : " + em.getTelefono() + " NIF : " + em.getNif() + " Apellido : " + em.getApellido() + " Direccion :" + em.getDireccion());

                    }
                }

                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    public void modificarEmpleadoMantenimiento(Empleado e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = e.getNombre();

                String sql = "UPDATE empleado SET ";
                sql += "nombre='" + nombre + "'";

                sql += " WHERE nombre= ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getNombre()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Empleado insertarEmpleadoMantenimiento(Empleado e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = e.getId();
                String nombre = e.getNombre();
                String telefono = e.getTelefono();
                String nif = e.getNif();
                String apellido = e.getApellido();
                String direccion = e.getDireccion();

                String sql = "INSERT INTO empleado(id,nombre,telefono,nif,apellido,direccion) VALUES(" + id + ",'" + nombre + "','"+telefono+"','"+nif+"','"+apellido+"','"+direccion+"')";
                System.out.println(sql);
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM empleado WHERE ";
                sqlRec +=  "id="+id;
//                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long idempl = rs.getLong("id");
                    String nom = rs.getString("nombre");
                    String tlf = rs.getString("telefono");
                    String niff = rs.getString("nif");
                    String apll = rs.getString("apellido");
                    String dir= rs.getString("direccion");
                    e = new Empleado(idempl, nom, tlf, niff, apll, dir);
                    return e;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
                e = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
     public static void eliminarMantenimiento(int horas) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM empleado WHERE horastrabajadas = ?");
                pstmt.setString(1, String.valueOf(horas));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el mantenimiento de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el mantenimiento de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}


