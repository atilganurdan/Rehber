/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.data;

import com.kutuphane.rehber.data.dto.Il;
import com.kutuphane.rehber.data.dto.Ilce;
import com.kutuphane.rehber.util.DbConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vektorel
 */
public class YerlesimService {

    Connection conn = DbConnector.getConnection();

    public List<Il> getAllCity() {
        List<Il> iller = new ArrayList<Il>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id, tanim from il");

            while (rs.next()) {
                Long id = rs.getLong("id");
                String tanim = rs.getString("tanim");

                iller.add(new Il(id, tanim));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return iller;
    }

    public List<Ilce> getAllDistrict() {
        List<Ilce> ilceler = new ArrayList<Ilce>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id, il_id, tanim from ilce");

            while (rs.next()) {
                Long id = rs.getLong("id");
                Long ilId = rs.getLong("il_id");
                String tanim = rs.getString("tanim");

                ilceler.add(new Ilce(id, ilId, tanim));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ilceler;
    }

    public List<Ilce> getDistrictsByCityId(Long ilId) {
        List<Ilce> ilceler = new ArrayList<Ilce>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id, il_id, tanim from ilce where il_id= " + ilId);

            while (rs.next()) {
                Long id = rs.getLong("id");
                Long ilIdDb = rs.getLong("il_id");
                String tanim = rs.getString("tanim");

                ilceler.add(new Ilce(id, ilIdDb, tanim));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ilceler;
    }

    public List<Ilce> getDistrictsByCityName(String ilTanim) {
        List<Ilce> ilceler = new ArrayList<Ilce>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select ic.id, ic.il_id, ic.tanim from il i, ilce ic where i.id = ic.il_id and i.tanim = '" + ilTanim +"'");

            while (rs.next()) {
                Long id = rs.getLong("id");
                Long ilIdDb = rs.getLong("il_id");
                String tanim = rs.getString("tanim");

                ilceler.add(new Ilce(id, ilIdDb, tanim));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ilceler;
    }
}
