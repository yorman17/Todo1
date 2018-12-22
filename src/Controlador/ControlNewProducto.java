/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Conexion.conectar;
import Modelo.NuevoProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Yorman
 */
public class ControlNewProducto {
    
    private static Statement state = null;
    private static PreparedStatement pState = null;
    private static ResultSet reSet = null;
    
     public static ArrayList<NuevoProducto> getProducto() {
       String consulta= NuevoProducto.SELECT;
        ArrayList<NuevoProducto> Nu = new ArrayList<NuevoProducto>();
        NuevoProducto np = null;
        if(Conexion.getCon() ==null)
        {
            conectar();
        }
        
        try {
            state = Conexion.getCon().createStatement();
            reSet = state.executeQuery(consulta);
            while (reSet.next()) {
                np = new NuevoProducto();
                np.setId(reSet.getString(1));
                np.setNombre(reSet.getString(2));
                np.setValor(reSet.getInt(3));
                np.setCantidad(reSet.getInt(4));
                np.setFecha(reSet.getDate(5));
                
                Nu.add(np);
            }
            state.close();
            reSet.close();
        } catch (SQLException ex) {
            
        }
         
        return Nu;
    }
    
    public static int insertProducto(NuevoProducto np) {
        int rsu = 0;
        String sql = NuevoProducto.INSERT;
        if (Conexion.getCon() == null) {
            conectar();
        }
        try {
            
            pState = Conexion.getCon().prepareStatement(sql);
            pState.setString(1, np.getId());
            pState.setString(2, np.getNombre());
            pState.setInt(3, np.getValor());
            pState.setInt(4, np.getCantidad());
            pState.setString(5, np.getFecha().toString());
            
            rsu = pState.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            String mensaje = "ALGO OCURRIO ";
            JOptionPane.showMessageDialog(null, mensaje, "Mensaje",JOptionPane.INFORMATION_MESSAGE);
          
        }
        
        return rsu;

    }
    
    
     public static int actualizarProducto(NuevoProducto np) {
        int rsu = 0;
        String sql = NuevoProducto.UPDATE;
        if (Conexion.getCon() == null) {
            conectar();
        }
        try {
            pState = Conexion.getCon().prepareStatement(sql);
           
                    pState.setInt(1, np.getValor());
                    pState.setInt(2, np.getCantidad());
                    pState.setString(3, np.getId());
                    
            rsu = pState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;

    }
     
     public static ArrayList<NuevoProducto> consultarEstudiante(String busqueda) {
        String consulta="";
        if(!busqueda.equals("")){
          consulta= "SELECT * FROM producto WHERE ID_P LIKE '%"+busqueda+"%'";  
        }
         if(busqueda.equals("")){
          consulta= "SELECT * FROM producto";  
        }
       
        
        ArrayList<NuevoProducto> np = new ArrayList<NuevoProducto>();
        NuevoProducto cl = null;
        if(Conexion.getCon() ==null)
        {
            conectar();
            System.out.println("jaja XD");
        }


        try {

            state = Conexion.getCon().createStatement();
            reSet = state.executeQuery(consulta);

            while (reSet.next()) {
                cl = new NuevoProducto();
                cl.setId(reSet.getString(1));
                cl.setNombre(reSet.getString(2));
                cl.setValor(reSet.getInt(3));
                cl.setCantidad(reSet.getInt(4));
                cl.setFecha(reSet.getDate(5));
                
                
                
               np.add(cl);
            }
            state.close();
            reSet.close();
        } catch (SQLException ex) {

        }

        return np;
    }
     
}
