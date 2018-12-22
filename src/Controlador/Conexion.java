package Controlador;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Conexion
{
    
    
    private static Connection con = null;
    private static String servidor = "localhost";
    private static String nombreBD = "empresa";
    private static String usuario = "root";
    private static String clave = "";

    public static Connection getCon() {
        return con;
    }


    public static boolean conectar() {
            
        try {
            System.out.println("yorman");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("joder");
            String url = "jdbc:mysql://" + servidor + ":3306/" + nombreBD;
            con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("yorman");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            String msg = "";
            if (ex.getErrorCode() == 1049) {
                msg = "La base de datos: " + nombreBD + " no existe.";
            } else if (ex.getErrorCode() == 1044) {
                msg = "El usuario: " + usuario + " no existe.";
            } else if (ex.getErrorCode() == 1045) {
                msg = "Contraseña incorrecta.";
            } else if (ex.getErrorCode() == 0) {
                msg = "La conexión con la base de datos no se puede realizar.\n Parece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (con != null) {
            System.out.println("Conexión Exitosa.");
            return true;
        }
        return false;

    }
    
  

    
   
}
