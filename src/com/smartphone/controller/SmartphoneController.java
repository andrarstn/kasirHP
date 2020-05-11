/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.controller;

import com.smartphone.error.SmartphoneException;
import com.smartphone.model.SmartphoneModel;
import com.smartphone.view.ViewAdminInputSmartphone;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andra
 */
public class SmartphoneController {
    private SmartphoneModel model;
    
    public void setModel(SmartphoneModel model){
        this.model=model;
    }
    
    public void resetForm(ViewAdminInputSmartphone view){
        model.resetForm();
    }
    
    public void insertSmartphone(ViewAdminInputSmartphone view){
        String nama = view.getTxtnama().getText();
        String merk = view.getTxtmerk().getText();
        String rilis = view.getTxtrilis().getText();
        String layar = view.getTxtlayar().getText();
        String kamera = view.getTxtkamera().getText();
        String os = view.getTxtos().getText();
        String cpu = view.getTxtcpu().getText();
        String gpu = view.getTxtgpu().getText();
        String ram = view.getTxtram().getText();
        String battery = view.getTxtbattery().getText();
        Integer stok = Integer.parseInt(view.getTxtstok().getText());
        Integer harga = Integer.parseInt(view.getTxtharga().getText());
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        }else if(merk.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Merk tidak boleh kosong");
        }else if(harga==null){
            JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong");
        }else if(rilis.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Rilis tidak boleh kosong");
        }else if(layar.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Layar tidak boleh kosong");
        }else if(kamera.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Kamera tidak boleh kosong");
        }else if(os.trim().equals("")){
            JOptionPane.showMessageDialog(view, "OS tidak boleh kosong");
        }else if(cpu.trim().equals("")){
            JOptionPane.showMessageDialog(view, "CPU tidak boleh kosong");
        }else if(gpu.trim().equals("")){
            JOptionPane.showMessageDialog(view, "GPU tidak boleh kosong");
        }else if(ram.trim().equals("")){
            JOptionPane.showMessageDialog(view, "RAM tidak boleh kosong");
        }else if(battery.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Battery tidak boleh kosong");
        }else if(stok==null){
            JOptionPane.showMessageDialog(null, "Stok tidak boleh kosong");
        }else{
            model.setNama(nama);
            model.setMerk(merk);
            model.setHarga(harga);
            model.setRilis(rilis);
            model.setLayar(layar);
            model.setKamera(kamera);
            model.setOs(os);
            model.setCpu(cpu);
            model.setGpu(gpu);
            model.setRam(ram);
            model.setBattery(battery);
            model.setStok(stok);
            try{
                model.insertSmartphone();
                JOptionPane.showMessageDialog(view, "Berhasil diinsert");
                model.resetForm();
            }catch (SmartphoneException throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            } catch (SQLException ex) {
                Logger.getLogger(SmartphoneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateSmartphone(ViewAdminInputSmartphone view){
        if (view.getTablesmartphone().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }
        Integer id = Integer.parseInt(view.getTxtid().getText());
        String nama = view.getTxtnama().getText();
        String merk = view.getTxtmerk().getText();
        String rilis = view.getTxtrilis().getText();
        String layar = view.getTxtlayar().getText();
        String kamera = view.getTxtkamera().getText();
        String os = view.getTxtos().getText();
        String cpu = view.getTxtcpu().getText();
        String gpu = view.getTxtgpu().getText();
        String ram = view.getTxtram().getText();
        String battery = view.getTxtbattery().getText();
        Integer stok = Integer.parseInt(view.getTxtstok().getText());
        Integer harga = Integer.parseInt(view.getTxtharga().getText());
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        }else if(merk.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Merk tidak boleh kosong");
        }else if(harga==null){
            JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong");
        }else if(rilis.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Rilis tidak boleh kosong");
        }else if(layar.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Layar tidak boleh kosong");
        }else if(kamera.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Kamera tidak boleh kosong");
        }else if(os.trim().equals("")){
            JOptionPane.showMessageDialog(view, "OS tidak boleh kosong");
        }else if(cpu.trim().equals("")){
            JOptionPane.showMessageDialog(view, "CPU tidak boleh kosong");
        }else if(gpu.trim().equals("")){
            JOptionPane.showMessageDialog(view, "GPU tidak boleh kosong");
        }else if(ram.trim().equals("")){
            JOptionPane.showMessageDialog(view, "RAM tidak boleh kosong");
        }else if(battery.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Battery tidak boleh kosong");
        }else if(stok==null){
            JOptionPane.showMessageDialog(null, "Stok tidak boleh kosong");
        }else{
            model.setId(id);
            model.setNama(nama);
            model.setMerk(merk);
            model.setHarga(harga);
            model.setRilis(rilis);
            model.setLayar(layar);
            model.setKamera(kamera);
            model.setOs(os);
            model.setCpu(cpu);
            model.setGpu(gpu);
            model.setRam(ram);
            model.setBattery(battery);
            model.setStok(stok);
            try{
                model.updateSmartphone();
                JOptionPane.showMessageDialog(view, "Berhasil diubah");
                model.resetForm();
            }catch (SmartphoneException throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            } catch (SQLException ex) {
                Logger.getLogger(SmartphoneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteSmartphone(ViewAdminInputSmartphone view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTablesmartphone().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            Integer id = Integer.parseInt(view.getTxtid().getText());
            model.setId(id);

            try {
                model.deleteSmartphone();
                JOptionPane.showMessageDialog(view, "Data Smartphone Berhasil Di Hapus");
                model.resetForm();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
}
