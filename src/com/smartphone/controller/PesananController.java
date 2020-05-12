/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.controller;

import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.Smartphone;
import com.smartphone.error.PesananException;
import com.smartphone.error.SmartphoneException;
import com.smartphone.impl.SmartphoneDaoImpl;
import com.smartphone.model.PesananModel;
import com.smartphone.model.SmartphoneModel;
import com.smartphone.service.SmartphoneDao;
import com.smartphone.view.ViewBeliSmartphone;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author andra
 */
public class PesananController {
    private PesananModel model;

    public void setModel(PesananModel model) {
        this.model = model;
    }
    
    public void resetForm(ViewBeliSmartphone view){
        model.resetForm();
    }
    
    public void beliSmartphone(ViewBeliSmartphone view) throws SmartphoneException{
        SmartphoneModel sm = new SmartphoneModel();
        String smartphone = view.getComboboxhp();
        String username = view.getTxtusername().getText();
        Integer jumlah = Integer.parseInt(view.getTxtjumlah().getText());
        Integer bayar = Integer.parseInt(view.getTxtbayar().getText());
        String tanggal = view.getTxttanggal().getText();
        
        SmartphoneDao dao = ConnectDatabase.getSmartphoneDao();
        Smartphone stok = dao.getStokSmartphone(smartphone);
        
        if(stok.getStok()-jumlah<0){
            JOptionPane.showMessageDialog(view, "Stok tidak cukup");
        }else if(bayar-stok.getHarga()<0){
            JOptionPane.showMessageDialog(view, "Uang yang anda bayarkan kurang");
        }else{
            Integer newstok = stok.getStok()-jumlah;
            System.out.println(newstok);
            
            model.setSmartphone(smartphone);
            model.setTanggal(tanggal);
            model.setJumlah(jumlah);
            model.setUsername(username);
            
            sm.setStok(newstok);
            sm.setNama(smartphone);
            try {
                model.insertPesanan();
                JOptionPane.showMessageDialog(view, "Berhasil diubah");
                sm.updateStokSmartphone();
                model.resetForm();
            } catch (Exception e) {
            }
        }    
    }
    
    public void getPesanan(String username) throws SQLException, PesananException{
        model.getPesanan(username);
    }
}
