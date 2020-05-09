/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.service;

import com.smartphone.entitas.Smartphone;
import com.smartphone.error.SmartphoneException;
import java.util.List;

/**
 *
 * @author andra
 */
public interface SmartphoneDao {
    public void insertSmartphone(Smartphone s) throws SmartphoneException;
    public void updateSmartphone(Smartphone s) throws SmartphoneException;
    public void deleteSmartphone(Integer id) throws SmartphoneException;
    public Smartphone getSmartphone(Integer id) throws SmartphoneException;
    public List<Smartphone> selectAllSmartphone() throws SmartphoneException;
}
