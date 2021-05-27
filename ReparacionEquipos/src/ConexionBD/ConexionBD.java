package ConexionBD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM105
 */
public class ConexionBD {

    static final String DB_URL = "jdbc:mysql://localhost:3306/reparacion_equipos?useSSL=false";
    // Credenciales de la base de datos
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public static Connection establecerConexion() {
        try {
            System.out.println("Conectando a la Base de Datos reparacion_equipos");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Se ha producido una ClassNotFoundException:" + ex.getMessage());
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return conn;
        }
    }

    public static void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   
}
