/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ays.database;

import ays.modeller.Personel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author begum.celebi
 */
public class PersonelIslemleri {

    public boolean GirisYap(String sicilNo, String parola) {

        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet girisSorgu;

            //Bu kullanıcı adı ve parolaya sahip kayıt sayısını çekmek için
            girisSorgu = sorgu.executeQuery("Select count(*) from personel where sicil_no = '" + sicilNo + "' and parola = '" + parola + "'");

            girisSorgu.next();
            int count = girisSorgu.getInt(1);

            //Gelen sorgu sonucu kayıt sayısı 0 dan büyük ise, giriş bilgileri doğrudur ve true dönder
            if (count > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Personel TeknisyenGetir(String sicilNo) {

        Personel personel = null;

        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet girisSorgu;

            //Bu kullanıcı adı ve parolaya sahip kayıt sayısını çekmek için
            girisSorgu = sorgu.executeQuery("Select * from personel where sicil_no = '" + sicilNo + "'");

            girisSorgu.next();
            String ad = girisSorgu.getString("ad");
            String soyad = girisSorgu.getString("soyad");
            String unvan = girisSorgu.getString("unvan");

            personel = new Personel(sicilNo, unvan, ad, soyad, "");

        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personel;
    }

    public ArrayList<Personel> TeknisyenleriGetir() {
        ArrayList<Personel> teknisyenler = new ArrayList<>();

        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet girisSorgu;

            //Bu kullanıcı adı ve parolaya sahip kayıt sayısını çekmek için
            girisSorgu = sorgu.executeQuery("Select * from personel where unvan = 'Teknisyen'");

            while (girisSorgu.next()) {

                String sicilNo = girisSorgu.getString("sicil_no");
                String ad = girisSorgu.getString("ad");
                String soyad = girisSorgu.getString("soyad");
                String unvan = girisSorgu.getString("unvan");

                Personel personel = new Personel(sicilNo, unvan, ad, soyad, "");
                teknisyenler.add(personel);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return teknisyenler;
    }

}
