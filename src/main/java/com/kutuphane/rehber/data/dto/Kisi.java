/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.data.dto;

import java.util.Date;

/**
 *
 * @author vektorel
 */
public class Kisi {
    private Long id;
    private String ad;
    private String soyad;
    private Date dogumTarihi;
    private Long il;
    private Long ilce;

    public Kisi(Long id, String ad, String soyad, Date dogumTarihi) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
    }

    public Kisi() {
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public Long getIl() {
        return il;
    }

    public void setIl(Long il) {
        this.il = il;
    }

    public Long getIlce() {
        return ilce;
    }

    public void setIlce(Long ilce) {
        this.ilce = ilce;
    }
    
    
    @Override
    public String toString() {
        return "Kisi{" + "id=" + id + ", ad=" + ad + ", soyad=" + soyad + '}';
    }
    
    
}
