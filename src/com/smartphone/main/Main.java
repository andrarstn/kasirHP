/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.main;

import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.User;
import com.smartphone.error.UserException;
import com.smartphone.service.UserDao;
import com.smartphone.view.ViewLogin;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author andra
 */
public class Main {
    public static void main(String[] args) throws UserException {
//        UserDao us = ConnectDatabase.getUserDao();
//        User u = us.getlogin("admin");
//        System.out.println(u.getUsername());
//        u.setNama("Andra Ristiano 17");
//        u.setUsername("Andra");
//        u.setPassword("andra");
//        
//        us.updateUser(u);
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                ViewLogin vl = new ViewLogin();
                vl.setVisible(true);    
            }
            
        });
    }
}
