/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.main;

import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.Smartphone;
import com.smartphone.entitas.User;
import com.smartphone.error.SmartphoneException;
import com.smartphone.error.UserException;
import com.smartphone.impl.SmartphoneDaoImpl;
import com.smartphone.model.SmartphoneModel;
import com.smartphone.service.SmartphoneDao;
import com.smartphone.service.UserDao;
import com.smartphone.view.ViewLogin;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author andra
 */
public class Main {
    public static void main(String[] args) throws UserException, SmartphoneException {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                ViewLogin vl = new ViewLogin();
                vl.setVisible(true);    
            }       
        });
    }
}
