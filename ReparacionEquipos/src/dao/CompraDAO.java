/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import reparacionequipos.Compra;
import ConexionBD.ConexionBD;
import static com.mysql.jdbc.Messages.getString;
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
public class CompraDAO {
    
    private Compra c;
    private static Connection conn;
    
    public CompraDAO(){
    conn = ConexionBD.establecerConexion();
}
    
    public CompraDAO(Compra co){
        this.c = co;
        conn = ConexionBD.establecerConexion();
    }
    
    public ArrayList<Compra> todosCompras() {
        ArrayList<Compra> todosCompras = new ArrayList<Compra>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM clientes");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long idCompra = prs.getLong("id");
                    double precioTotal = prs.getDouble("precioTotal");
                    char metodoPago = prs.getString("metodoPago").charAt(0);
                    long idEquipo = prs.getLong("idEquipo");
                    long idLote = prs.getLong("idLote");
                    
                    Compra co = new Compra(idCompra,precioTotal,metodoPago,idEquipo,idLote);
                    todosCompras.add(co);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosCompras;
    }
    
    public void eliminarCompra(int idCompra) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
                pstmt.setString(1, String.valueOf(idCompra));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el cliente de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el cliente de la BD.");
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}