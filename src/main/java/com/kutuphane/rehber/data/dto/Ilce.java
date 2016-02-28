/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.data.dto;

/**
 *
 * @author vektorel
 */
public class Ilce {
    private Long id;
    private Long ilId;
    private String tanim;

    public Ilce() {
    }

    public Ilce(Long id, Long ilId, String tanim) {
        this.id = id;
        this.ilId = ilId;
        this.tanim = tanim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIlId() {
        return ilId;
    }

    public void setIlId(Long ilId) {
        this.ilId = ilId;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }
    
    
}
