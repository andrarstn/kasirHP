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
public class Pesanan {
    private Integer id, jumlah;
    private String username,tanggal,smartphone;

    public Pesanan() {
    }

    public Pesanan(String username, String tanggal, String smartphone, Integer jumlah) {
        this.username = username;
        this.tanggal = tanggal;
        this.smartphone = smartphone;
        this.jumlah = jumlah;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.jumlah);
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.tanggal);
        hash = 37 * hash + Objects.hashCode(this.smartphone);
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
        final Pesanan other = (Pesanan) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        if (!Objects.equals(this.smartphone, other.smartphone)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.jumlah, other.jumlah)) {
            return false;
        }
        return true;
    }

}
