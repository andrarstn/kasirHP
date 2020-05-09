/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.service;

import com.smartphone.entitas.User;
import com.smartphone.error.UserException;
import java.util.List;

/**
 *
 * @author andra
 */
public interface UserDao {
    public void insertUser(User u) throws UserException;
    public void updateUser(User u) throws UserException;
    public void deleteUser(Integer id) throws UserException;
    public User getUser(Integer id) throws UserException;
    public User getlogin(String username, String password) throws UserException;
    public List<User> selectAllUser() throws UserException;
}
