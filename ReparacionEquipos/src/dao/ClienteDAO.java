/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import ConexionBD.ConexionBD;
import Entidades.Cliente;
import static dao.ClienteDAO.filtrarClienteCCorriente;
import static dao.ClienteDAO.filtrarClienteTarjeta;
import static dao.ClienteDAO.filtrarClienteDireccion;
import static dao.ClienteDAO.filtrarClienteId;
import static dao.ClienteDAO.filtrarClienteNif;
import static dao.ClienteDAO.filtrarClienteNombre;
import static dao.ClienteDAO.filtrarClienteTelefono;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rxndy
 */
public class ClienteDAO {
    
    private Cliente c;
    private static Connection conn;
    
    public ClienteDAO(){
    conn = ConexionBD.establecerConexion();
}
    
    public ClienteDAO(Cliente cl){
        this.c = cl;
        conn = ConexionBD.establecerConexion();
    }
    
    public static void filtrarCliente() {
        Scanner in = new Scanner(System.in);
        System.out.println("Elije una opción:");
        System.out.println("1. Filtrar Cliente por id");
        System.out.println("2. Filtrar Cliente por nombre");
        System.out.println("3. Filtrar Cliente por CuentaCorriente");
        System.out.println("4. Filtrar Cliente por nif");
        System.out.println("5. Filtrar Cliente por telefono");
        System.out.println("6. Filtrar Cliente por dirección");
        System.out.println("7. Filtrar Cliente por tarjetaDeCredito");
        int opcion = 0;
        try {
            do {
                opcion = Integer.parseInt(in.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el id del Cliente que desea filtrar:");
                        int idCliente = Integer.parseInt(in.nextLine());
                        ArrayList<Cliente> clientes1 = new ArrayList<Cliente>();
                        clientes1 = filtrarClienteId(idCliente);
                        for (Cliente e : clientes1) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre del Cliente que desea filtrar:");
                        String nombreCliente = "\"" + in.nextLine() + "\"";
                        ArrayList<Cliente> clientes2 = new ArrayList<Cliente>();
                        clientes2 = filtrarClienteNombre(nombreCliente);
                        for (Cliente e : clientes2) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 3:
                        System.out.println("Introduzca la CuentaCorriente del Cliente que desea filtrar:");
                        String CuentaCorrienteCliente = "\"" + in.nextLine() + "\"";
                        ArrayList<Cliente> clientes3 = new ArrayList<Cliente>();
                        clientes3 = filtrarClienteCCorriente(CuentaCorrienteCliente);
                        for (Cliente e : clientes3) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 4:
                        System.out.println("Introduzca el nif del Cliente que desea filtrar:");
                        String nifCliente = "\"" + in.nextLine() + "\"";
                        ArrayList<Cliente> clientes4 = new ArrayList<Cliente>();
                        clientes4 = filtrarClienteNif(nifCliente);
                        for (Cliente e : clientes4) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 5:
                        System.out.println("Introduzca el telefono del Cliente que desea filtrar:");
                        String telefonoCliente = "\"" + in.nextLine() + "\"";
                        ArrayList<Cliente> clientes5 = new ArrayList<Cliente>();
                        clientes5 = filtrarClienteTelefono(telefonoCliente);
                        for (Cliente e : clientes5) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 6:
                        System.out.println("Introduzca el direccion del Cliente que desea filtrar:");
                        String direccionCliente = "\"" + in.nextLine() + "\"";
                        ArrayList<Cliente> clientes6 = new ArrayList<Cliente>();
                        clientes6 = filtrarClienteDireccion(direccionCliente);
                        for (Cliente e : clientes6) {
                            System.out.println(e.getNombre());
                            System.out.println(e.getNif());
                            System.out.println(e.getTelefono());
                            System.out.println(e.getDireccion());
                        }
                        break;
                    case 7:
                        System.out.println("Introduzca la tarjetaDeCredito del Cliente que desea filtrar:");
                        String tarjetaDeCreditoCliente = "\"" + in.nextLine() + "\"";
                        ArrayList<Cliente> clientes7 = new ArrayList<Cliente>();
                        clientes6 = filtrarClienteDireccion(tarjetaDeCreditoCliente);
                        for (Cliente e : clientes7) {
                            System.out.println(e.getNombre());
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
    
    public ArrayList<Cliente> todosClientes() {
        ArrayList<Cliente> todosClientes = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM clientes");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("id");
                    String nombre = prs.getNString("nombre");
                    String nif = prs.getNString("nif");
                    String direccion = prs.getNString("direccion");
                    String telefono = prs.getNString("telefono");
                    String tarjetaDeCreditoCredito = prs.getNString("tarjetaDeCreditoCredito");
                    String cuentaCorriente = prs.getNString("cuentaCorriente");
                    Cliente cl = new Cliente(id, nombre, nif, direccion, telefono, tarjetaDeCreditoCredito, cuentaCorriente);
                    todosClientes.add(cl);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosClientes;
    }
    
    public void eliminarCliente(int idCliente) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
                pstmt.setString(1, String.valueOf(idCliente));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el cliente de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el cliente de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Cliente> filtrarClienteId(int idCliente) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Cliente where id=" + idCliente + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Cliente encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    Cliente em = new Cliente(id, nombre, telefono, nif,direccion);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Cliente> filtrarClienteNombre(String nombreCliente) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Cliente where nombre=" + nombreCliente + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Cliente encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String CuentaCorriente = rs.getString("CuentaCorriente");
                    String tarjetaDeCredito = rs.getString("tarjetaDeCredito");
                    String direccion = rs.getString("direccion");
                    Cliente em = new Cliente(id, nombre, telefono, nif, direccion,tarjetaDeCredito, CuentaCorriente);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }
    public static ArrayList<Cliente> filtrarClienteTarjeta(String tarjetaDeCreditoCliente) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Cliente where nombre=" + tarjetaDeCreditoCliente + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Cliente encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String CuentaCorriente = rs.getString("CuentaCorriente");
                    String tarjetaDeCredito = rs.getString("tarjetaDeCredito");
                    String direccion = rs.getString("direccion");
                    Cliente em = new Cliente(id, nombre, telefono, nif, direccion,tarjetaDeCredito, CuentaCorriente);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Cliente> filtrarClienteCCorriente(String CuentaCorrienteCliente) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Cliente where apellido=" + CuentaCorrienteCliente + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Cliente encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String CuentaCorriente = rs.getString("CuentaCorriente");
                    String tarjetaDeCredito = rs.getString("tarjetaDeCredito");
                    String direccion = rs.getString("direccion");
                    Cliente em = new Cliente(id, nombre, telefono, nif, direccion,tarjetaDeCredito, CuentaCorriente);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Cliente> filtrarClienteTelefono(String telefonoCliente) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Cliente where telefono=" + telefonoCliente + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Cliente encontrado, estos son sus datos:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String CuentaCorriente = rs.getString("CuentaCorriente");
                    String tarjetaDeCredito = rs.getString("tarjetaDeCredito");
                    String direccion = rs.getString("direccion");
                    Cliente em = new Cliente(id, nombre, telefono, nif, direccion,tarjetaDeCredito, CuentaCorriente);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Cliente> filtrarClienteNif(String nifCliente) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Cliente where nif=" + nifCliente + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Cliente encontrado, estos son sus datos:");
               while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String CuentaCorriente = rs.getString("CuentaCorriente");
                    String tarjetaDeCredito = rs.getString("tarjetaDeCredito");
                    String direccion = rs.getString("direccion");
                    Cliente em = new Cliente(id, nombre, telefono, nif, direccion,tarjetaDeCredito, CuentaCorriente);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    public static ArrayList<Cliente> filtrarClienteDireccion(String direccionCliente) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * from Cliente where direccion=" + direccionCliente + "";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Cliente encontrado, estos son sus datos:");
               while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    String nif = rs.getString("nif");
                    String CuentaCorriente = rs.getString("CuentaCorriente");
                    String tarjetaDeCredito = rs.getString("tarjetaDeCredito");
                    String direccion = rs.getString("direccion");
                    Cliente em = new Cliente(id, nombre, telefono, nif, direccion,tarjetaDeCredito, CuentaCorriente);
                    ret.add(em);
                }
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }
    
    public static void modificarEjemplar(Cliente e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = e.getNombre();
                String nif = e.getNif();
                String telefono = e.getTelefono();
                String direccion = e.getDireccion();

                String sql = "UPDATE Cliente SET ";
                sql += "nombbre=" + nombre;

                sql += ", nif=" + nif;
                sql += ", telefono=" + telefono;
                sql += ", direccion=" + direccion;

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el ejemplar de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Cliente insertarEjemplar(Cliente e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = e.getNombre();
                String nif = e.getNif();
                String telefono = e.getTelefono();
                String direccion = e.getDireccion();
                String sql = "INSERT INTO ejemplares(nombre, apellido, nif, telefono, direccion) VALUES(" + nombre + ", " + nif + ", " + telefono + ", " + direccion + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM Cliente WHERE ";
                sqlRec += " nombre=" + nombre;
                sqlRec += " and nif=" + nif;
                sqlRec += " and telefono=" + telefono;
                sqlRec += " and direccion=" + direccion;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    nombre = rs.getString("nombre");
                    nif = rs.getString("nif");
                    telefono = rs.getString("telefono");
                    direccion = rs.getString("direccion");
                    e = new Cliente(id, nombre, telefono, nif, direccion);
                    return e;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                e = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    
}


