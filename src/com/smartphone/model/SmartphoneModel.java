/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.model;

import com.smartphone.database.ConnectDatabase;
import com.smartphone.entitas.Smartphone;
import com.smartphone.error.SmartphoneException;
import com.smartphone.event.SmartphoneListener;
import com.smartphone.service.SmartphoneDao;
import java.sql.SQLException;

/**
 *
 * @author andra
 */
public class SmartphoneModel {
    private Integer id,harga,stok;
    private String nama,merk,rilis,layar,kamera,os,cpu,gpu,ram,battery;
    private SmartphoneListener listener;
    
    public SmartphoneListener getLstn(){
        return listener;
    }
    
    public void setLstn(SmartphoneListener listener){
        this.listener = listener;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        fireOnChange();
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
        fireOnChange();
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
        fireOnChange();
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
        fireOnChange();
    }

    public String getLayar() {
        return layar;
    }

    public void setLayar(String layar) {
        this.layar = layar;
        fireOnChange();
    }

    public String getKamera() {
        return kamera;
    }

    public void setKamera(String kamera) {
        this.kamera = kamera;
        fireOnChange();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
        fireOnChange();
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
        fireOnChange();
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
        fireOnChange();
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
        fireOnChange();
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Smartphone s) {
        if (listener != null) {
            listener.onInsert(s);
        }
    }

    protected void fireOnUpdate(Smartphone s) {
        if (listener != null) {
            listener.onUpdate(s);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void resetForm(){
        setNama("");
        setMerk("");
        setHarga(null);
        setRilis("");
        setLayar("");
        setKamera("");
        setOs("");
        setCpu("");
        setGpu("");
        setRam("");
        setBattery("");
        setStok(null);
        setId(null);
    }
    
    public void insertSmartphone() throws SQLException, SmartphoneException{
        SmartphoneDao dao = ConnectDatabase.getSmartphoneDao();   
        
        Smartphone s = new Smartphone();
        s.setNama(nama);
        s.setMerk(merk);
        s.setHarga(harga);
        s.setRilis(rilis);
        s.setLayar(layar);
        s.setKamera(kamera);
        s.setOs(os);
        s.setCpu(cpu);
        s.setGpu(gpu);
        s.setRam(ram);
        s.setBattery(battery);
        s.setStok(stok);
        
        dao.insertSmartphone(s);
        fireOnInsert(s);
    }
    
    public void updateSmartphone() throws SQLException, SmartphoneException{
        SmartphoneDao dao = ConnectDatabase.getSmartphoneDao();        
        Smartphone s = new Smartphone();
        
        s.setNama(nama);
        s.setMerk(merk);
        s.setHarga(harga);
        s.setRilis(rilis);
        s.setLayar(layar);
        s.setKamera(kamera);
        s.setOs(os);
        s.setCpu(cpu);
        s.setGpu(gpu);
        s.setRam(ram);
        s.setBattery(battery);
        s.setStok(stok);
        s.setId(id);
        
        dao.updateSmartphone(s);
        fireOnUpdate(s);
    }
    
    public void updateStokSmartphone() throws SQLException, SmartphoneException{
        SmartphoneDao dao = ConnectDatabase.getSmartphoneDao();        
        Smartphone s = new Smartphone();
        
        s.setNama(nama);
        s.setStok(stok);
        
        dao.updateStokSmartphone(s);
        fireOnUpdate(s);
    }
    
    public void deleteSmartphone() throws SQLException, SmartphoneException{
        SmartphoneDao dao = ConnectDatabase.getSmartphoneDao();
        
        dao.deleteSmartphone(id);
        fireOnDelete();
    } 
}
