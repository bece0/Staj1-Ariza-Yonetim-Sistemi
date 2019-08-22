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
public class ArizaKaydi {

    private int akno;
    private String bolum;
    private String hat;
    private String makina;
    private String ariza;
    private String baslangic;
    private String bitis;
    private String kategori;
    private String teknisyen;
    private String islem;
    private String olusturan_sicilno;

    public ArizaKaydi() {
    }

    public ArizaKaydi(int akno, String bolum, String hat, String makina, String ariza, String baslangic, String bitis, String kategori, String teknisyen, String islem, String olusturan_sicilno) {
        this.akno = akno;
        this.bolum = bolum;
        this.hat = hat;
        this.makina = makina;
        this.ariza = ariza;
        this.baslangic = baslangic;
        this.bitis = bitis;
        this.kategori = kategori;
        this.teknisyen = teknisyen;
        this.islem = islem;
        this.olusturan_sicilno = olusturan_sicilno;
    }

    public String getOlusturan_sicilno() {
        return olusturan_sicilno;
    }

    public void setOlusturan_sicilno(String olusturan_sicilno) {
        this.olusturan_sicilno = olusturan_sicilno;
    }

    
    
    public int getAkno() {
        return akno;
    }

    public void setAkno(int akno) {
        this.akno = akno;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }

    public String getMakina() {
        return makina;
    }

    public void setMakina(String makina) {
        this.makina = makina;
    }

    public String getAriza() {
        return ariza;
    }

    public void setAriza(String ariza) {
        this.ariza = ariza;
    }

    public String getBaslangic() {
        return baslangic;
    }

    public void setBaslangic(String baslangic) {
        this.baslangic = baslangic;
    }

    public String getBitis() {
        return bitis;
    }

    public void setBitis(String bitis) {
        this.bitis = bitis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getTeknisyen() {
        return teknisyen;
    }

    public void setTeknisyen(String teknisyen) {
        this.teknisyen = teknisyen;
    }

    public String getIslem() {
        return islem;
    }

    public void setIslem(String islem) {
        this.islem = islem;
    }

}
