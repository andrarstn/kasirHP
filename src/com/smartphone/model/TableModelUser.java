/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.model;

import com.smartphone.entitas.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andra
 */
public class TableModelUser extends AbstractTableModel{
    private List<User> list = new ArrayList<User>();
    
    public void setList(List<User> list){
        this.list = list;
    }
    
    public boolean add(User e) {
        try{
            return list.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public User get(int index) {
        return list.get(index);
    }

    public User set(int index, User element) {
        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }
    }

    public User remove(int index) {
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
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "USERNAME";
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
                return list.get(rowIndex).getUsername();
            default:
                return null;
        }
    }
    
}
