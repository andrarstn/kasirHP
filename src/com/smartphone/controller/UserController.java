/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.controller;

import com.smartphone.model.UserModel;
import com.smartphone.view.ViewAdminUser;
import com.smartphone.view.ViewLogin;
import com.smartphone.view.ViewRegister;
import javax.swing.JOptionPane;

/**
 *
 * @author andra
 */
public class UserController {
    private UserModel model;
    

    public void setModel(UserModel model){
        this.model=model;
    }
    
    public void resetUser(ViewAdminUser view){
        model.resetForm();
    }
    
    public void registerUser(ViewRegister view){
        String nama = view.getTxtnama().getText();
        String username = view.getTxtusername().getText();
        String pw = view.getTxtpassword().getText();
        String pw2 = view.getTxtpassword2().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        }else if(username.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Username tidak boleh kosong");
        }else if(pw.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Password tidak boleh kosong");
        }else if(pw2.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Password tidak boleh kosong");
        }else if(!pw.equals(pw2)){
            JOptionPane.showMessageDialog(view, "Password tidak sama");
        }else{
            model.setNama(nama);
            model.setUsername(username);
            model.setPassword(pw);
            try{
                model.insertUser();
                JOptionPane.showMessageDialog(view, "Register berhasil");
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
    
    public void insertUser(ViewAdminUser view){
        String nama = view.getTxtnama().getText();
        String username = view.getTxtusername().getText();
        String pw = view.getTxtpassword().getText();
        String pw2 = view.getTxtpassword2().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        }else if(username.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Username tidak boleh kosong");
        }else if(pw.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Password tidak boleh kosong");
        }else if(pw2.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Password tidak boleh kosong");
        }else if(!pw.equals(pw2)){
            JOptionPane.showMessageDialog(view, "Password tidak sama");
        }else{
            model.setNama(nama);
            model.setUsername(username);
            model.setPassword(pw);
            try{
                model.insertUser();
                JOptionPane.showMessageDialog(view, "Berhasil ditambah");
                model.resetForm();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
    
    public void updateUser(ViewAdminUser view){
        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTableuser().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }
        Integer id = Integer.parseInt(view.getTxtid().getText());
        String nama = view.getTxtnama().getText();
        String username = view.getTxtusername().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        }else if(username.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Username tidak boleh kosong");
        }else{
            model.setId(id);
            model.setNama(nama);
            model.setUsername(username);
            try{
                model.updateUser();
                JOptionPane.showMessageDialog(view, "Data user berhasil diubah");
                model.resetForm();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
    
    public void deleteUser(ViewAdminUser view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTableuser().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            Integer id = Integer.parseInt(view.getTxtid().getText());
            model.setId(id);

            try {
                model.deleteUser();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Hapus");
                model.resetForm();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
    
    public void loginUser(ViewLogin login){
        String username = login.getTxtusername().getText();
        String pw = login.getTxtpassword().getText();
        model.setUsername(username);
    }
}
