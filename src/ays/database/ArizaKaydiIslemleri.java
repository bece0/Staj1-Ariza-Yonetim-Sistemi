/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ays.database;

import ays.gui.YeniArızaKaydı;
import ays.modeller.ArizaKaydi;
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
public class ArizaKaydiIslemleri {

    /*
        ariza nesnesindeki verileri kullanarak ariza_kaydi tablosuna veri ekler.
     */
    public boolean ArizaKaydiEkle(ArizaKaydi ariza) {

        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        try {
            Statement sorgu = baglanti.createStatement();

            sorgu.executeUpdate("Insert into ariza_kaydi"
                    + "(bolum,hat,makina,ariza,baslangic,bitis,kategori,teknisyen,islem,olusturan_sicilno)"
                    + "VALUES"
                    + "("
                    + "'" + ariza.getBolum() + "',"
                    + "'" + ariza.getHat() + "',"
                    + "'" + ariza.getMakina() + "',"
                    + "'" + ariza.getAriza() + "',"
                    + "'" + ariza.getBaslangic() + "', ' ',"
                    + "'" + ariza.getKategori() + "', ' ' , ' ','" + ariza.getOlusturan_sicilno() + "')");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ArizaKaydiIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArizaKaydi ArizaKaydiGetir(int arizaKodu) {
        ArizaKaydi arizaKaydi = null;

        Connection baglanti;
        try {

            baglanti = VeritabaniBaglantiYoneticisi.getConnection();
            Statement sorgu;
            sorgu = baglanti.createStatement();
            ResultSet arizaBilgileriSorgu;

            arizaBilgileriSorgu = sorgu.executeQuery("SELECT * FROM ariza_kaydi WHERE akno = " + arizaKodu + "");

            if (!arizaBilgileriSorgu.next()) {
                return null;
            }

            String bolum = arizaBilgileriSorgu.getString("bolum");
            String hat = arizaBilgileriSorgu.getString("hat");
            String makine = arizaBilgileriSorgu.getString("makina");
            String ariza = arizaBilgileriSorgu.getString("ariza");
            String baslangic = arizaBilgileriSorgu.getString("baslangic");
            String bitis = arizaBilgileriSorgu.getString("bitis");
            String kategori = arizaBilgileriSorgu.getString("kategori");
            String teknisyen = arizaBilgileriSorgu.getString("teknisyen");
            String islem = arizaBilgileriSorgu.getString("islem");
            String olusturan_sicilno = arizaBilgileriSorgu.getString("olusturan_sicilno");

            arizaKaydi = new ArizaKaydi(arizaKodu, bolum, hat, makine, ariza, baslangic, bitis, kategori, teknisyen, islem, olusturan_sicilno);

        } catch (SQLException ex) {
            Logger.getLogger(YeniArızaKaydı.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arizaKaydi;
    }

    public ArrayList<ArizaKaydi> KayitleriGetir() {

        return null;
    }

    public ArrayList<ArizaKaydi> KayitleriGetir(String bolum) {

        return null;
    }

    public ArrayList<ArizaKaydi> KayitleriGetir(String bolum, String hat, String makina, String teknisyen, String arizaText) {
        ArrayList<ArizaKaydi> sonuclar = new ArrayList<>();
        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet cevap;

            String where = "WHERE ";
            if (!bolum.isEmpty()) {
                where = where + (" bolum = '" + bolum + "' and ");
            }
            if (!hat.isEmpty()) {
                where = where + (" hat = '" + hat + "' and ");
            }
            if (!makina.isEmpty()) {
                where = where + (" makina = '" + makina + "' and ");
            }
            if (!teknisyen.isEmpty()) {
                where = where + (" teknisyen = '" + teknisyen + "' and ");
            }

            if (!arizaText.isEmpty()) {
                where = where + (" ariza LIKE '%" + arizaText + "%' and ");
            }

            where = where + (" akno > 0 ");

            cevap = sorgu.executeQuery("SELECT DISTINCT * FROM ariza_kaydi " + where);

            while (cevap.next()) {
                ArizaKaydi arizaKaydi = new ArizaKaydi();

                arizaKaydi.setAkno(cevap.getInt("akno"));
                arizaKaydi.setAriza(cevap.getString("ariza"));
                arizaKaydi.setBolum(cevap.getString("bolum"));
                arizaKaydi.setHat(cevap.getString("hat"));
                arizaKaydi.setMakina(cevap.getString("makina"));
                arizaKaydi.setBaslangic(cevap.getString("baslangic"));
                arizaKaydi.setBitis(cevap.getString("bitis"));
                arizaKaydi.setKategori(cevap.getString("kategori"));
                arizaKaydi.setTeknisyen(cevap.getString("teknisyen"));
                arizaKaydi.setIslem(cevap.getString("islem"));
                arizaKaydi.setOlusturan_sicilno(cevap.getString("olusturan_sicilno"));
                sonuclar.add(arizaKaydi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArizaKaydiIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sonuclar;
    }

    public ArrayList<ArizaKaydi> KayitleriGetirMakina(String makina) {

        return null;
    }

    public ArrayList<ArizaKaydi> KayitleriGetirTeknisyen(String teknisyen) {

        return null;
    }

    public ArrayList<ArizaKaydi> BekleyenKayitleriGetir() {
        ArrayList<ArizaKaydi> sonuclar = new ArrayList<>();
        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet cevap;
            cevap = sorgu.executeQuery("SELECT DISTINCT * FROM ariza_kaydi WHERE coalesce(teknisyen, '' ) = ' ' AND coalesce(bitis, '') = ' '");

            while (cevap.next()) {
                ArizaKaydi arizaKaydi = new ArizaKaydi();

                arizaKaydi.setAkno(cevap.getInt("akno"));
                arizaKaydi.setAriza(cevap.getString("ariza"));
                arizaKaydi.setBolum(cevap.getString("bolum"));
                arizaKaydi.setHat(cevap.getString("hat"));
                arizaKaydi.setMakina(cevap.getString("makina"));
                arizaKaydi.setBaslangic(cevap.getString("baslangic"));
                arizaKaydi.setBitis(cevap.getString("bitis"));
                arizaKaydi.setKategori(cevap.getString("kategori"));
                arizaKaydi.setTeknisyen(cevap.getString("teknisyen"));
                arizaKaydi.setIslem(cevap.getString("islem"));
                arizaKaydi.setOlusturan_sicilno(cevap.getString("olusturan_sicilno"));
                sonuclar.add(arizaKaydi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArizaKaydiIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sonuclar;
    }

    public ArrayList<ArizaKaydi> OnarimdakiKayitleriGetir() {
        ArrayList<ArizaKaydi> sonuclar = new ArrayList<>();
        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet cevap;
            cevap = sorgu.executeQuery("SELECT DISTINCT * FROM ariza_kaydi WHERE coalesce(teknisyen, '' ) != ' ' AND coalesce(bitis, '') = ' '");

            while (cevap.next()) {
                ArizaKaydi arizaKaydi = new ArizaKaydi();

                arizaKaydi.setAkno(cevap.getInt("akno"));
                arizaKaydi.setAriza(cevap.getString("ariza"));
                arizaKaydi.setBolum(cevap.getString("bolum"));
                arizaKaydi.setHat(cevap.getString("hat"));
                arizaKaydi.setMakina(cevap.getString("makina"));
                arizaKaydi.setBaslangic(cevap.getString("baslangic"));
                arizaKaydi.setBitis(cevap.getString("bitis"));
                arizaKaydi.setKategori(cevap.getString("kategori"));
                arizaKaydi.setTeknisyen(cevap.getString("teknisyen"));
                arizaKaydi.setIslem(cevap.getString("islem"));
                arizaKaydi.setOlusturan_sicilno(cevap.getString("olusturan_sicilno"));
                sonuclar.add(arizaKaydi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArizaKaydiIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sonuclar;
    }

    public ArrayList<ArizaKaydi> TamamlananKayitleriGetir() {
        ArrayList<ArizaKaydi> sonuclar = new ArrayList<>();
        Connection baglanti = VeritabaniBaglantiYoneticisi.getConnection();
        Statement sorgu;
        try {
            sorgu = baglanti.createStatement();
            ResultSet cevap;
            cevap = sorgu.executeQuery("SELECT DISTINCT * FROM ariza_kaydi WHERE coalesce(bitis, '' ) != ' '");

            while (cevap.next()) {
                ArizaKaydi arizaKaydi = new ArizaKaydi();

                arizaKaydi.setAkno(cevap.getInt("akno"));
                arizaKaydi.setAriza(cevap.getString("ariza"));
                arizaKaydi.setBolum(cevap.getString("bolum"));
                arizaKaydi.setHat(cevap.getString("hat"));
                arizaKaydi.setMakina(cevap.getString("makina"));
                arizaKaydi.setBaslangic(cevap.getString("baslangic"));
                arizaKaydi.setBitis(cevap.getString("bitis"));
                arizaKaydi.setKategori(cevap.getString("kategori"));
                arizaKaydi.setTeknisyen(cevap.getString("teknisyen"));
                arizaKaydi.setIslem(cevap.getString("islem"));
                arizaKaydi.setOlusturan_sicilno(cevap.getString("olusturan_sicilno"));
                sonuclar.add(arizaKaydi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArizaKaydiIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sonuclar;
    }

    public void TeknisyenAta(int akno, String teknisyenSicilNo) {
        //TODO - ariza güncelle..
    }

}
