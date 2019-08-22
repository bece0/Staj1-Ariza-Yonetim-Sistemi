/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ays.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author test
 */
public class MakinaIslemleri {

    public String[] BolumIsımleriniGetir() {

        return null;
    }

    public ArrayList<String> HatIsımleriniGetir(String bolum) {

        ArrayList<String> makinaListesi = new ArrayList<>();

        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet makinaSorgu;

            //Bu kullanıcı adı ve parolaya sahip kayıt sayısını çekmek için
            makinaSorgu = sorgu.executeQuery("Select  distinct hat from makina where bolum = '" + bolum + "'");

            while (makinaSorgu.next()) {
                makinaListesi.add(makinaSorgu.getString("hat"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return makinaListesi;
    }

    public ArrayList<String>  MakinaIsımleriniGetir(String bolum, String hat) {
        ArrayList<String> makinaListesi = new ArrayList<>();

        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet makinaSorgu;

            //Bu kullanıcı adı ve parolaya sahip kayıt sayısını çekmek için
            makinaSorgu = sorgu.executeQuery("Select  distinct isim from makina where bolum = '" + bolum + "' and hat = '" + hat +"'");

            while (makinaSorgu.next()) {
                makinaListesi.add(makinaSorgu.getString("isim"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return makinaListesi;
    }

}
