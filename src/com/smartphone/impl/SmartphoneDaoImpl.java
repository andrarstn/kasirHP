/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.impl;

import com.smartphone.entitas.Smartphone;
import com.smartphone.entitas.User;
import com.smartphone.error.SmartphoneException;
import com.smartphone.error.UserException;
import com.smartphone.service.SmartphoneDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andra
 */
public class SmartphoneDaoImpl implements SmartphoneDao{
    private Connection conn;
    private final String insertSmartphone = "INSERT INTO smartphone"+ "(nama, merk, harga, rilis, layar, kamera, os, cpu, gpu, ram, battery, stok) VALUES"+"(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String updateSmartphone = "UPDATE smartphone SET nama=?, merk=?, harga=?, rilis=?, layar=?, kamera=?, os=?, cpu=?, gpu=?, ram=?, battery=?, stok=? WHERE id=?";
    private final String deleteSmartphone = "DELETE FROM smartphone WHERE id=?";
    private final String updateStok = "UPDATE smartphone SET stok=? WHERE nama=?";
    private final String getSmartphone = "SELECT * FROM smartphone WHERE id=?";
    private final String getAllSmartphone = "SELECT * FROM smartphone";

    public SmartphoneDaoImpl(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertSmartphone(Smartphone s) throws SmartphoneException {
        PreparedStatement stmt=null;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(insertSmartphone, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, s.getNama());
            stmt.setString(2, s.getMerk());
            stmt.setInt(3, s.getHarga());
            stmt.setString(4, s.getRilis());
            stmt.setString(5, s.getLayar());
            stmt.setString(6, s.getKamera());
            stmt.setString(7, s.getOs());
            stmt.setString(8, s.getCpu());
            stmt.setString(9, s.getGpu());
            stmt.setString(10, s.getRam());
            stmt.setString(11, s.getBattery());
            stmt.setInt(12, s.getStok());
            stmt.executeUpdate();
            
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                s.setId(result.getInt(1));
            }
            conn.commit();
        }catch(SQLException ux){
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new SmartphoneException(ux.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }

    @Override
    public void updateSmartphone(Smartphone s) throws SmartphoneException {
        PreparedStatement stmt=null;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(updateSmartphone, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, s.getNama());
            stmt.setString(2, s.getMerk());
            stmt.setInt(3, s.getHarga());
            stmt.setString(4, s.getRilis());
            stmt.setString(5, s.getLayar());
            stmt.setString(6, s.getKamera());
            stmt.setString(7, s.getOs());
            stmt.setString(8, s.getCpu());
            stmt.setString(9, s.getGpu());
            stmt.setString(10, s.getRam());
            stmt.setString(11, s.getBattery());
            stmt.setInt(12, s.getStok());
            
            stmt.setInt(13, s.getId());
            stmt.executeUpdate();
            
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                s.setId(result.getInt(1));
            }
            conn.commit();
        }catch(SQLException ux){
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new SmartphoneException(ux.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }

    @Override
    public void deleteSmartphone(Integer id) throws SmartphoneException {
        PreparedStatement stmt=null;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(deleteSmartphone, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conn.commit();
        }catch(SQLException ux){
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new SmartphoneException(ux.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }

    @Override
    public void updateStok(String nama) throws SmartphoneException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Smartphone getSmartphone(Integer id) throws SmartphoneException {
        PreparedStatement stmt=null;
        try{
            stmt = conn.prepareStatement(getSmartphone);
            stmt.setInt(1, id);
            Smartphone s = null;
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                s = new Smartphone();
                s.setId(result.getInt("id"));
                s.setNama(result.getString("nama"));
                s.setMerk(result.getString("merk"));
                s.setHarga(result.getInt("harga"));
                s.setRilis(result.getString("rilis"));
                s.setLayar(result.getString("layar"));
                s.setKamera(result.getString("kamera"));
                s.setOs(result.getString("os"));
                s.setCpu(result.getString("cpu"));
                s.setGpu(result.getString("gpu"));
                s.setRam(result.getString("ram"));
                s.setBattery(result.getString("battery"));
                s.setStok(result.getInt("stok"));
            }else{
                throw new SmartphoneException("Smartphone dengan id "+id+" tidak ditemukan");
            }
            return s;
        }catch(SQLException ux){
            throw new SmartphoneException(ux.getMessage());
        }finally{
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }

    @Override
    public List<Smartphone> selectAllSmartphone() throws SmartphoneException {
        Statement stmt=null;
        List<Smartphone> list = new ArrayList<Smartphone>();
        try{
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(getAllSmartphone);
            while(result.next()){
                Smartphone s = new Smartphone();
                s.setId(result.getInt("id"));
                s.setNama(result.getString("nama"));
                s.setMerk(result.getString("merk"));
                s.setHarga(result.getInt("harga"));
                s.setRilis(result.getString("rilis"));
                s.setLayar(result.getString("layar"));
                s.setKamera(result.getString("kamera"));
                s.setOs(result.getString("os"));
                s.setCpu(result.getString("cpu"));
                s.setGpu(result.getString("gpu"));
                s.setRam(result.getString("ram"));
                s.setBattery(result.getString("battery"));
                s.setStok(result.getInt("stok"));
                list.add(s);
            }
            return list;
        }catch(SQLException ux){
            throw new SmartphoneException(ux.getMessage());
        }finally{
            if(stmt!=null){
               try{
                 stmt.close();  
               }catch(SQLException x){
                   
               }
            }
        }
    }
    
}
