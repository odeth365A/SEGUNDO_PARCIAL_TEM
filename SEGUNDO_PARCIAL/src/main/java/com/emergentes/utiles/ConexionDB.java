package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_seminarios";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;
    
        public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
            if(conn!=null)
            {
                System.out.println("Coneccion OK "+ conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de Driver"+ex.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar"+e.getMessage());
        }
        
    }
    
    public Connection conectar()
    {
        return conn;
    }
    
    public void desconectar()
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al Cerrar la Conexion"+ex.getMessage());
        }
    }
}
