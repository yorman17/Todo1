/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Yorman
 */
public class NuevoProducto {
    
     public static String INSERT =" INSERT INTO producto "+"(ID_P,NOMBRE,PRECIO,STOCK,FECHA)VALUES(?,?,?,?,?)";
     public static String SELECT ="SELECT * FROM producto";
      public static String UPDATE ="UPDATE producto SET PRECIO =?,"+"STOCK =? WHERE ID_P =?";
    
    private String id;
    private String nombre;
    private int valor;
    private int cantidad;
    private Date fecha;

    public NuevoProducto() {
    }
    
    

    public NuevoProducto(String id, String nombre, int valor, int cantidad, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
