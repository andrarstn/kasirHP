/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.model;
import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.User;
import com.smartphone.error.UserException;
import com.smartphone.impl.UserDaoImpl;
import com.smartphone.view.ViewRegister;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.smartphone.event.UserListener;
import com.smartphone.service.UserDao;
/**
 *
 * @author andra
 */
public class UserModel {
    private Integer id;
    private String nama;
    private String username;
    private String password;
    private UserListener listener;

    public UserListener getLstn() {
        return listener;
    }

    public void setLstn(UserListener listener) {
        this.listener = listener;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        fireOnChange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(User u) {
        if (listener != null) {
            listener.onInsert(u);
        }
    }

    protected void fireOnUpdate(User u) {
        if (listener != null) {
            listener.onUpdate(u);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void resetForm(){
        setId(null);
        setNama("");
        setUsername("");
        setPassword("");
    }
    
    public void insertUser() throws SQLException, UserException{
        UserDao dao = ConnectDatabase.getUserDao();
        
        User u = new User();
        u.setNama(nama);
        u.setUsername(username);
        u.setPassword(password);
        
        dao.insertUser(u);
        fireOnInsert(u);
    }
    
    public void updateUser() throws SQLException, UserException{
        UserDao dao = ConnectDatabase.getUserDao();
        
        User u = new User();
        u.setNama(nama);
        u.setUsername(username);
        u.setId(id);
        
        dao.updateUser(u);
        fireOnUpdate(u);
    }
    
    public void deleteUser() throws SQLException, UserException{
        UserDao dao = ConnectDatabase.getUserDao();
        
        dao.deleteUser(id);
        fireOnDelete();
    }
    
    public void loginUser() throws SQLException, UserException{
        UserDao dao = ConnectDatabase.getUserDao();
        
        dao.getlogin(username, password);
    }
}
