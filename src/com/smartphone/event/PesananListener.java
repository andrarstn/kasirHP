/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.event;

import com.smartphone.entitas.Pesanan;
import com.smartphone.model.PesananModel;

/**
 *
 * @author andra
 */
public interface PesananListener {
    public void onChange(PesananModel model);
    public void onInsert(Pesanan p);
    public void onDelete();
}
