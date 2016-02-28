/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.data;

import com.kutuphane.rehber.data.dto.Kisi;
import com.kutuphane.rehber.util.DbConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vektorel
 */
public class KisiService implements IDataService<Kisi> {

    public Kisi save(Kisi nesne) {
        try {
           Connection conn = DbConnector.getConnection();
           Statement stmt = conn.createStatement();
           int affectedRows = stmt.executeUpdate("insert into kisi(id,ad,soyad,il_id,ilce_id)"
                   + "values(nextval('sq_kisi'),'"+nesne.getAd()+"','"+nesne.getSoyad()+"',"+nesne.getIl()+","+
                   nesne.getIlce()+")");
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Kisi update(Kisi nesne) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean delete(Kisi nesne) {
        try {
            Connection conn = DbConnector.getConnection();
            Statement stmt = conn.createStatement();
            int affectedRows = stmt.executeUpdate("delete from kisi where id = " + nesne.getId());
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Kisi> getAll() {
       List<Kisi> list = new ArrayList<Kisi>();
        try {
            Connection conn = DbConnector.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,ad,soyad from kisi");
            while(rs.next()){
            Long id = rs.getLong("id");
            String ad = rs.getString("ad");
            String soyad = rs.getString("soyad");
            list.add(new Kisi(id,ad,soyad, new Date()));
            
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Kisi getById(Long id) {
        try {
            Connection conn = DbConnector.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,ad,soyad from kisi where id =" + id);
            while(rs.next()){
            String ad = rs.getString("ad");
            String soyad = rs.getString("soyad");
            return (new Kisi(id,ad,soyad,new Date()));
            
            }
            
        } catch (Exception e) {
          e.printStackTrace();
        }
        
        return null;
    }
    
    
}
