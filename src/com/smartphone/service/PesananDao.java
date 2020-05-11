/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.service;

import com.smartphone.entitas.Pesanan;
import com.smartphone.error.PesananException;
import java.util.List;

/**
 *
 * @author andra
 */
public interface PesananDao {
    public void insertPesanan(Pesanan p) throws PesananException;
    public void deletePesanan(Integer id) throws PesananException;
    public List<Pesanan> getUserPesanan(String Username) throws PesananException;
    public List<Pesanan> getAllPesanan() throws PesananException;
}
