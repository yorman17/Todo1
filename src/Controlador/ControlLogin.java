/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Conexion.conectar;
import Modelo.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlLogin {
    private static Statement state = null;
     private static ResultSet reSet = null;
     
    public boolean Validar (String usuario,String Contrasena) throws SQLException{
        Login L = null;
       
        if(Conexion.getCon() ==null)
        {
            conectar();
        }
        
       String consulta = "SELECT * FROM tbl_usuario where USUARIO='"+usuario+"'"+" and CONTRASENA='"+Contrasena+"';";
       state = Conexion.getCon().createStatement();
       reSet = state.executeQuery(consulta);
       
       if(reSet.first()){
           return true;
       }
       else{
           return false;
       }
//       
    }
}
