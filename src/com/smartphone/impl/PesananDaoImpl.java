/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.impl;

import com.smartphone.entitas.Pesanan;
import com.smartphone.error.PesananException;
import com.smartphone.service.PesananDao;
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
public class PesananDaoImpl implements PesananDao{
    private Connection conn;
    private final String insertPesanan ="INSERT INTO pesanan"+ "(username, tanggal, smartphone, jumlah) VALUES"+"(?,?,?,?)";
    private final String deletePesanan ="DELETE pesanan WHERE id=?";
    private final String getUserPesanan ="SELECT * FROM pesanan WHERE username=?";
    private final String getAllPesanan ="SELECT * FROM pesanan";

    public PesananDaoImpl(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertPesanan(Pesanan p) throws PesananException {
        PreparedStatement stmt=null;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(insertPesanan, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getUsername());
            stmt.setString(2, p.getTanggal());
            stmt.setString(3, p.getSmartphone());
            stmt.setInt(4, p.getJumlah());
            stmt.executeUpdate();
            
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                p.setId(result.getInt(1));
            }
            conn.commit();
        }catch(SQLException ux){
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new PesananException(ux.getMessage());
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
    public void deletePesanan(Integer id) throws PesananException {
        PreparedStatement stmt=null;
        try{
            stmt = conn.prepareStatement(deletePesanan);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException ux){
            throw new PesananException(ux.getMessage());
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
    public List<Pesanan> getUserPesanan(String Username) throws PesananException {
        PreparedStatement stmt=null;
        List<Pesanan> list = new ArrayList<Pesanan>();
        try{
            stmt = conn.prepareStatement(getUserPesanan);
            stmt.setString(1, Username);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Pesanan u = new Pesanan();
                u.setId(result.getInt("id"));
                u.setUsername(result.getString("username"));
                
                list.add(u);
            }
            return list;
        }catch(SQLException ux){
            throw new PesananException(ux.getMessage());
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
    public List<Pesanan> getAllPesanan() throws PesananException {
        Statement stmt=null;
        List<Pesanan> list = new ArrayList<Pesanan>();
        try{
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(getAllPesanan);
            while(result.next()){
                Pesanan p = new Pesanan();
                p.setId(result.getInt("id"));
                p.setUsername(result.getString("username"));
                
                list.add(p);
            }
            return list;
        }catch(SQLException ux){
            throw new PesananException(ux.getMessage());
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
