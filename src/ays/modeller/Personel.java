/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ays.modeller;

/**
 *
 * @author test
 */
public class Personel {

    private String sicilNo;
    private String unvan;
    private String ad;
    private String soyad;
    private String parola;

    public Personel(String sicilNo, String unvan, String ad, String soyad, String parola) {
        this.sicilNo = sicilNo;
        this.unvan = unvan;
        this.ad = ad;
        this.soyad = soyad;
        this.parola = parola;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
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

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    
}
