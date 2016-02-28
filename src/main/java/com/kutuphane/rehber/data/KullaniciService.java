/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.data;

import com.kutuphane.rehber.data.dto.Kisi;
import com.kutuphane.rehber.data.dto.Kullanici;
import com.kutuphane.rehber.util.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vektorel
 */
public class KullaniciService implements IDataService<Kullanici>{

    public Kullanici save(Kullanici nesne) {
        try {
            Connection conn = DbConnector.getConnection();
            PreparedStatement prp = conn.prepareStatement("insert into kullanici(id,uname,pwd,uyelik_tarihi)"
                    +"values(nextVal('sq_kullanici'),?,?,?)");
            prp.setString(1, nesne.getUname());
            prp.setString(2, nesne.getPwd());
            prp.setDate(3, new java.sql.Date(nesne.getUyelikTarihi().getTime()));
            prp.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Kullanici update(Kullanici nesne) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean delete(Kullanici nesne) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Kullanici> getAll() {
        List<Kullanici> list = new ArrayList<Kullanici>();
        try {
            Connection conn = DbConnector.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,uname,pwd from kullanici");
            while(rs.next()){
            Long id = rs.getLong("id");
            String uname = rs.getString("uname");
            String pwd = rs.getString("pwd");
            list.add(new Kullanici(id,uname,pwd,new Date()));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    public Kullanici getById(Long Id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     public Kullanici getKullaniciByUname(String uname) {
        Kullanici k = null;
         try {
             Connection conn = DbConnector.getConnection();
             Statement statement= conn.createStatement();
             ResultSet resultSet =statement.executeQuery("select id, uname, pwd, uyelik_tarihi from kullanici where uname = '" +uname+ "'");
             while(resultSet.next()){
             Long id = resultSet.getLong("id");
             String unameDb = resultSet.getString("uname");
             String pwd = resultSet.getString("pwd");
             
             k =  new Kullanici(id,unameDb,pwd, new Date());
             
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return k;
    }

   
}
