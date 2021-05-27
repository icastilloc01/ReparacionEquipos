/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import Entidades.Cliente;
import ConexionBD.ConexionBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
                    String tarjetaCredito = prs.getNString("tarjetaCredito");
                    String cuentaCorriente = prs.getNString("cuentaCorriente");
                    Cliente cl = new Cliente(id, nombre, nif, direccion, telefono, tarjetaCredito, cuentaCorriente);
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
    
}


