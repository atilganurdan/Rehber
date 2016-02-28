/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.data.dto;

/**
 *
 * @author vektorel
 */
public class Il {
    private Long id;
    private String tanim;

    public Il() {
    }

    public Il(Long id, String tanim) {
        this.id = id;
        this.tanim = tanim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }
    
    
}
