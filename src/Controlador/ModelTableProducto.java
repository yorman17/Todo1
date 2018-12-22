/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.NuevoProducto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Yorman
 */
public class ModelTableProducto extends AbstractTableModel {

    private String[] nombreColumnas = {"ID","NOMBRE","VALOR UNITARIO","CANTIDAD","FECHA REGISTRO"};
    private ArrayList<NuevoProducto> cls;

    public ModelTableProducto(ArrayList<NuevoProducto> cls) {
        this.cls = cls;
    }

    public ModelTableProducto() {
    }

    public void setClase(ArrayList<NuevoProducto> cls) {
        this.cls = cls;
    }

    @Override
    public int getRowCount() {
        return cls.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public NuevoProducto getFila(int index) {
        return cls.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            
            case 0:
                return cls.get(rowIndex).getId();
            case 1:
                return cls.get(rowIndex).getNombre();
            case 2:
                return cls.get(rowIndex).getValor();
            case 3:
                return cls.get(rowIndex).getCantidad();
            case 4:
                return cls.get(rowIndex).getFecha();
            default :
                return null;

        }
    }
    
}
