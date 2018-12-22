/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Venta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Yorman
 */
public class ModelTableVenta extends AbstractTableModel {

    private String[] nombreColumnas = {"ID","CLIENTE","CANTIDAD","FECHA","TOTAL"};
    private ArrayList<Venta> cls;

    public ModelTableVenta(ArrayList<Venta> cls) {
        this.cls = cls;
    }

    public ModelTableVenta() {
    }

    public void setPersonal(ArrayList<Venta> cls) {
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

    public Venta getFila(int index) {
        return cls.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            
            case 0:
                return cls.get(rowIndex).getId();
            case 1:
                return cls.get(rowIndex).getCliente();
            case 2:
                return cls.get(rowIndex).getCantidad();
            case 3:
                return cls.get(rowIndex).getFecha();
            case 4:
                return cls.get(rowIndex).getTotal();
            default:
                return null;

        }
    }
}

