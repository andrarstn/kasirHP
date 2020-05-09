/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.event;

import com.smartphone.entitas.User;
import com.smartphone.model.UserModel;

/**
 *
 * @author andra
 */
public interface UserListener {
    public void onChange(UserModel model);
    public void onInsert(User u);
    public void onUpdate(User u);
    public void onDelete();
}
