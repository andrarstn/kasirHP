/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.event;

import com.smartphone.entitas.Smartphone;
import com.smartphone.model.SmartphoneModel;

/**
 *
 * @author andra
 */
public interface SmartphoneListener {
    public void onChange(SmartphoneModel model);
    public void onInsert(Smartphone s);
    public void onUpdate(Smartphone s);
    public void onDelete();
}
