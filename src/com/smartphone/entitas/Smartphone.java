/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartphone.entitas;

import java.util.Objects;

/**
 *
 * @author andra
 */
public class Smartphone {
    private Integer id,harga,stok;
    private String nama,merk,rilis,layar,kamera,os,cpu,gpu,ram,battery;

    public Smartphone() {
    }

    public Smartphone(Integer id, Integer harga, Integer stok, String nama, String merk, String rilis, String layar, String kamera, String os, String cpu, String gpu, String ram, String battery) {
        this.id = id;
        this.harga = harga;
        this.stok = stok;
        this.nama = nama;
        this.merk = merk;
        this.rilis = rilis;
        this.layar = layar;
        this.kamera = kamera;
        this.os = os;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.battery = battery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public String getLayar() {
        return layar;
    }

    public void setLayar(String layar) {
        this.layar = layar;
    }

    public String getKamera() {
        return kamera;
    }

    public void setKamera(String kamera) {
        this.kamera = kamera;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.harga);
        hash = 79 * hash + Objects.hashCode(this.stok);
        hash = 79 * hash + Objects.hashCode(this.nama);
        hash = 79 * hash + Objects.hashCode(this.merk);
        hash = 79 * hash + Objects.hashCode(this.rilis);
        hash = 79 * hash + Objects.hashCode(this.layar);
        hash = 79 * hash + Objects.hashCode(this.kamera);
        hash = 79 * hash + Objects.hashCode(this.os);
        hash = 79 * hash + Objects.hashCode(this.cpu);
        hash = 79 * hash + Objects.hashCode(this.gpu);
        hash = 79 * hash + Objects.hashCode(this.ram);
        hash = 79 * hash + Objects.hashCode(this.battery);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Smartphone other = (Smartphone) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.merk, other.merk)) {
            return false;
        }
        if (!Objects.equals(this.rilis, other.rilis)) {
            return false;
        }
        if (!Objects.equals(this.layar, other.layar)) {
            return false;
        }
        if (!Objects.equals(this.kamera, other.kamera)) {
            return false;
        }
        if (!Objects.equals(this.os, other.os)) {
            return false;
        }
        if (!Objects.equals(this.cpu, other.cpu)) {
            return false;
        }
        if (!Objects.equals(this.gpu, other.gpu)) {
            return false;
        }
        if (!Objects.equals(this.ram, other.ram)) {
            return false;
        }
        if (!Objects.equals(this.battery, other.battery)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.harga, other.harga)) {
            return false;
        }
        if (!Objects.equals(this.stok, other.stok)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
