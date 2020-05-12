/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.model;

import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.Pesanan;
import com.smartphone.entitas.Smartphone;
import com.smartphone.error.PesananException;
import com.smartphone.error.SmartphoneException;
import com.smartphone.event.PesananListener;
import com.smartphone.service.PesananDao;
import com.smartphone.service.SmartphoneDao;
import java.sql.SQLException;

/**
 *
 * @author andra
 */
public class PesananModel {
    private Integer id,jumlah;
    private String tanggal,smartphone,username;
    private PesananListener listener;
    
    public PesananListener getLstn(){
        return listener;
    }
    
    public void resetForm(){
        setJumlah(null);
        setSmartphone("");
        setTanggal("");
        setUsername("");
    }
    
    public void setLstn(PesananListener listener){
        this.listener = listener;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Pesanan p) {
        if (listener != null) {
            listener.onInsert(p);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }
    public void insertPesanan() throws SQLException, PesananException, SmartphoneException{
        PesananDao dao = ConnectDatabase.getPesananDao();
        
        Pesanan p = new Pesanan();
        p.setUsername(username);
        p.setTanggal(tanggal);
        p.setSmartphone(smartphone);
        p.setJumlah(jumlah);
        
        dao.insertPesanan(p);
        fireOnInsert(p);
    }
    
    public void deleteUser() throws SQLException, PesananException{
        PesananDao dao = ConnectDatabase.getPesananDao();
        
        dao.deletePesanan(id);
        fireOnDelete();
    }
    
    public void getPesanan(String Username) throws SQLException, PesananException{
        PesananDao dao = ConnectDatabase.getPesananDao();
        
        dao.getUserPesanan(username);
    }
}
