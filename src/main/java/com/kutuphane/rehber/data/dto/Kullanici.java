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
public class Kullanici {
    
    private Long id;
    private String uname;
    private String pwd;
    private Date uyelikTarihi;

    public Kullanici() {
    }

    public Kullanici(Long id, String uname, String pwd, Date uyelikTarihi) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.uyelikTarihi = uyelikTarihi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getUyelikTarihi() {
        return uyelikTarihi;
    }

    public void setUyelikTarihi(Date uyelikTarihi) {
        this.uyelikTarihi = uyelikTarihi;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "id=" + id + ", uname=" + uname + ", pwd=" + pwd + '}';
    }
    
    
    
}
