/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.smartphone.error.PesananException;
import com.smartphone.error.SmartphoneException;
import com.smartphone.error.UserException;
import com.smartphone.impl.PesananDaoImpl;
import com.smartphone.impl.SmartphoneDaoImpl;
import com.smartphone.impl.UserDaoImpl;
import com.smartphone.service.PesananDao;
import com.smartphone.service.SmartphoneDao;
import com.smartphone.service.UserDao;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author andra
 */
public class ConnectDatabase {
    private static Connection koneksi;
    private static UserDao ud;
    private static SmartphoneDao sd;
    private static PesananDao pd;
               
    public static Connection getKoneksi(){
        if(koneksi == null){
            try{
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);
                
                String url = "jdbc:mysql://localhost/projek_smartphone";
                String user = "root";
                String pass = "";
                
                koneksi = (Connection) DriverManager.getConnection(url,user,pass);
                //JOptionPane.showMessageDialog(null,"Koneksi Berhasil");
                System.out.println("Koneksi Berhasil");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Koneksi Gagal");
                System.out.println("Koneksi Gagal");
            }
        }
        return koneksi;
    }
    
    public static UserDao getUserDao() throws UserException{
        if(ud==null){
            ud = new UserDaoImpl(getKoneksi());
        }
        return ud;
    }
    
    public static SmartphoneDao getSmartphoneDao() throws SmartphoneException{
        if(sd==null){
            sd = new SmartphoneDaoImpl(getKoneksi());
        }
        return sd;
    }
    
    public static PesananDao getPesananDao() throws PesananException{
        if(pd==null){
            pd = new PesananDaoImpl(getKoneksi());
        }
        return pd;
    }
}
