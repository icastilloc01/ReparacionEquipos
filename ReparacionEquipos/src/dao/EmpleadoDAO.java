/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reparacionequipos.Empleado;

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
    
    public void eliminarEmpleado(int idEmpleado) {
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
