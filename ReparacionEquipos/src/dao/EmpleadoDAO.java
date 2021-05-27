/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Empleado;

/**
 *
 * @author DAM105
 */
public class EmpleadoDAO {

    private Empleado e;
    private static Connection conn;

    public EmpleadoDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public EmpleadoDAO(Empleado e) {
        this.e = e;
        conn = ConexionBD.establecerConexion();
    }

    public static void filtrarEmpleado() {
        Scanner in = new Scanner(System.in);
        System.out.println("Elije una opción:");
        System.out.println("1. Filtrar Empleado por id");
        System.out.println("2. Filtrar Empleado por nombre");
        System.out.println("3. Filtrar Empleado por apellido");
        System.out.println("4. Filtrar Empleado por nif");
        System.out.println("5. Filtrar Empleado por telefono");
        System.out.println("6. Filtrar Empleado por dirección");
        int opcion = 0;
        try {
            do {
                opcion = Integer.parseInt(in.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el id del Empleado que desea filtrar:");
                        int idEmpleado = Integer.parseInt(in.nextLine());
                        ArrayList<Empleado> empleados1 = new ArrayList<Empleado>();
                        empleados1 = filtrarEmpleadoId(idEmpleado);
                        for (Empleado e : empleados1) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getApellido());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre del Empleado que desea filtrar:");
                        String nombreEmpleado = "\"" + in.nextLine() + "\"";
                        ArrayList<Empleado> empleados2 = new ArrayList<Empleado>();
                        empleados2 = filtrarEmpleadoNombre(nombreEmpleado);
                        for (Empleado e : empleados2) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getApellido());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 3:
                        System.out.println("Introduzca el apellido del Empleado que desea filtrar:");
                        String apellidoEmpleado = "\"" + in.nextLine() + "\"";
                        ArrayList<Empleado> empleados3 = new ArrayList<Empleado>();
                        empleados3 = filtrarEmpleadoApellido(apellidoEmpleado);
                        for (Empleado e : empleados3) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getApellido());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 4:
                        System.out.println("Introduzca el nif del Empleado que desea filtrar:");
                        String nifEmpleado = "\"" + in.nextLine() + "\"";
                        ArrayList<Empleado> empleados4 = new ArrayList<Empleado>();
                        empleados4 = filtrarEmpleadoNif(nifEmpleado);
                        for (Empleado e : empleados4) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getApellido());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 5:
                        System.out.println("Introduzca el telefono del Empleado que desea filtrar:");
                        String telefonoEmpleado = "\"" + in.nextLine() + "\"";
                        ArrayList<Empleado> empleados5 = new ArrayList<Empleado>();
                        empleados5 = filtrarEmpleadoTelefono(telefonoEmpleado);
                        for (Empleado e : empleados5) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getApellido());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 6:
                        System.out.println("Introduzca el direccion del Empleado que desea filtrar:");
                        String direccionEmpleado = "\"" + in.nextLine() + "\"";
                        ArrayList<Empleado> empleados6 = new ArrayList<Empleado>();
                        empleados6 = filtrarEmpleadoDireccion(direccionEmpleado);
                        for (Empleado e : empleados6) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getApellido());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    default:
                        System.out.println("Ha introducido una opcion invalida");
                        System.out.println("");
                        break;
                }
            } while (opcion > 6 || opcion < 0);
        } catch (InputMismatchException ex) {
            System.out.println("El caracter introducido no es un número");
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error inesperado, intentelo de nuevo");
            System.out.println("");
        }
    }

    public static ArrayList<Empleado> filtrarEmpleadoId(int idEmpleado) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Empleado where id=" + idEmpleado + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Empleado encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado em = new Empleado(id, nombre, telefono, nif, apellido, direccion);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Empleado> filtrarEmpleadoNombre(String nombreEmpleado) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Empleado where nombre=" + nombreEmpleado + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Empleado encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado em = new Empleado(id, nombre, telefono, nif, apellido, direccion);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Empleado> filtrarEmpleadoApellido(String apellidoEmpleado) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Empleado where apellido=" + apellidoEmpleado + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Empleado encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado em = new Empleado(id, nombre, telefono, nif, apellido, direccion);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Empleado> filtrarEmpleadoTelefono(String telefonoEmpleado) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Empleado where telefono=" + telefonoEmpleado + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Empleado encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado em = new Empleado(id, nombre, telefono, nif, apellido, direccion);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Empleado> filtrarEmpleadoNif(String nifEmpleado) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Empleado where nif=" + nifEmpleado + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Empleado encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado em = new Empleado(id, nombre, telefono, nif, apellido, direccion);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Empleado> filtrarEmpleadoDireccion(String direccionEmpleado) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Empleado where direccion=" + direccionEmpleado + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Empleado encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Empleado em = new Empleado(id, nombre, telefono, nif, apellido, direccion);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static Empleado insertarEjemplar(Empleado e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = e.getNombre();
                String apellido = e.getApellido();
                String nif = e.getNif();
                String telefono = e.getTelefono();
                String direccion = e.getDireccion();
                String sql = "INSERT INTO ejemplares(nombre, apellido, nif, telefono, direccion) VALUES(" + nombre + ", " + apellido + ", " + nif + ", " + telefono + ", " + direccion + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM Empleado WHERE ";
                sqlRec += " nombre=" + nombre;
                sqlRec += " and apellido=" + apellido;
                sqlRec += " and nif=" + nif;
                sqlRec += " and telefono=" + telefono;
                sqlRec += " and direccion=" + direccion;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    nombre = rs.getString("nombre");
                    apellido = rs.getString("apellido");
                    nif = rs.getString("nif");
                    telefono = rs.getString("telefono");
                    direccion = rs.getString("direccion");
                    e = new Empleado(id, nombre, telefono, nif, apellido, direccion);
                    return e;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                e = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public static void modificarEjemplar(Empleado e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = e.getNombre();
                String apellido = e.getApellido();
                String nif = e.getNif();
                String telefono = e.getTelefono();
                String direccion = e.getDireccion();

                String sql = "UPDATE Empleado SET ";
                sql += "nombbre=" + nombre;
                sql += ", apellido=" + apellido;
                sql += ", nif=" + nif;
                sql += ", telefono=" + telefono;
                sql += ", direccion=" + direccion;

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el ejemplar de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarEmpleado(int idEmpleado) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM empleado WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEmpleado));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el empleado de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el empleado de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}