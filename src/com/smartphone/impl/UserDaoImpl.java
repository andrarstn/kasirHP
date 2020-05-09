/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.impl;

import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.User;
import com.smartphone.error.UserException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.smartphone.service.UserDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andra
 */
public class UserDaoImpl implements UserDao{
    private Connection conn;
    private final String insertUser = "INSERT INTO user"+ "(nama, username, password) VALUES"+"(?,?,?)";
    private final String updateUser = "UPDATE user SET nama=?, username=? WHERE id=?";
    private final String deleteUser = "DELETE FROM user WHERE id=?";
    private final String getUser = "SELECT * FROM user WHERE id=?";
    private final String getLogin = "SELECT * FROM user WHERE username=? AND password=?";
    private final String getAllUser = "SELECT * FROM user";
    
    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertUser(User u) throws UserException {
        PreparedStatement stmt=null;
        try{
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, u.getNama());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getPassword());
            stmt.executeUpdate();
            
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                u.setId(result.getInt(1));
            }
            conn.commit();
        }catch(SQLException ux){
            try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new UserException(ux.getMessage());
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
    public void updateUser(User u) throws UserException {
        PreparedStatement stmt=null;
        try{
            stmt = conn.prepareStatement(updateUser);
            stmt.setString(1, u.getNama());
            stmt.setString(2, u.getUsername());
            
            stmt.setInt(3, u.getId());
            stmt.executeUpdate();
        }catch(SQLException ux){
            throw new UserException(ux.getMessage());
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
    public void deleteUser(Integer id) throws UserException {
        PreparedStatement stmt=null;
        try{
            stmt = conn.prepareStatement(deleteUser);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException ux){
            throw new UserException(ux.getMessage());
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
    public User getUser(Integer id) throws UserException {
        PreparedStatement stmt=null;
        try{
            stmt = conn.prepareStatement(getUser);
            stmt.setInt(1, id);
            User u = null;
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                u = new User();
                u.setId(result.getInt("id"));
                u.setNama(result.getString("nama"));
                u.setUsername(result.getString("username"));
            }else{
                throw new UserException("User dengan id "+id+" tidak ditemukan");
            }
            return u;
        }catch(SQLException ux){
            throw new UserException(ux.getMessage());
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
    public User getlogin(String username, String password) throws UserException {
        PreparedStatement stmt=null;
        try{
            stmt = conn.prepareStatement(getLogin);
            stmt.setString(1, username);
            stmt.setString(2, password);
            User u = null;
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                u = new User();
                u.setUsername(result.getString("username"));
                u.setPassword(result.getString("password"));
            }else{
                JOptionPane.showMessageDialog(null, "Cek kembali username dan password");
            }
            return u;
        }catch(SQLException ux){
            throw new UserException(ux.getMessage());
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
    public List<User> selectAllUser() throws UserException {
        Statement stmt=null;
        List<User> list = new ArrayList<User>();
        try{
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(getAllUser);
            while(result.next()){
                User u = new User();
                u.setId(result.getInt("id"));
                u.setNama(result.getString("nama"));
                u.setUsername(result.getString("username"));
                
                list.add(u);
            }
            return list;
        }catch(SQLException ux){
            throw new UserException(ux.getMessage());
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
