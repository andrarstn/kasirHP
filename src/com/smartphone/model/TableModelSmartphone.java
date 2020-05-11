/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.model;

import com.smartphone.entitas.Smartphone;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andra
 */
public class TableModelSmartphone extends AbstractTableModel{
    private List<Smartphone> list = new ArrayList<Smartphone>();
    
    public void setList(List<Smartphone> list){
        this.list = list;
    }
    
    public boolean add(Smartphone e) {
        try{
            return list.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Smartphone get(int index) {
        return list.get(index);
    }

    public Smartphone set(int index, Smartphone element) {
        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }
    }

    public Smartphone remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "MERK";
            case 3:
                return "HARGA";
            case 4:
                return "RILIS";
            case 5:
                return "LAYAR";
            case 6:
                return "KAMERA";
            case 7:
                return "OS";
            case 8:
                return "CPU";
            case 9:
                return "GPU";
            case 10:
                return "RAM";
            case 11:
                return "BATTERY";
            case 12:
                return "STOK";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getMerk();
            case 3:
                return list.get(rowIndex).getHarga();
            case 4:
                return list.get(rowIndex).getRilis();
            case 5:
                return list.get(rowIndex).getLayar();
            case 6:
                return list.get(rowIndex).getKamera();
            case 7:
                return list.get(rowIndex).getOs();
            case 8:
                return list.get(rowIndex).getCpu();
            case 9:
                return list.get(rowIndex).getGpu();
            case 10:
                return list.get(rowIndex).getRam();
            case 11:
                return list.get(rowIndex).getBattery();
            case 12:
                return list.get(rowIndex).getStok();
            default:
                return null;
        }
    }
    
}
