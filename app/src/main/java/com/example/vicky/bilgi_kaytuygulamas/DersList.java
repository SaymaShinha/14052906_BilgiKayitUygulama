package com.example.vicky.bilgi_kaytuygulamas;

public class DersList {

    private String ders, dersnot, ders_ortalama, ogrenci_sayi;

    public DersList()
    {

    }

    public DersList(String ders, String dersnot, String ders_ortalama, String ogrenci_sayi) {
        this.ders = ders;
        this.dersnot = dersnot;
        this.ders_ortalama = ders_ortalama;
        this.ogrenci_sayi = ogrenci_sayi;
    }

    public String getDers() {
        return ders;
    }

    public void setDers(String ders) {
        this.dersnot = ders;
    }

    public String getDersnot() {
        return dersnot;
    }

    public void setDersnot(String dersnot) {
        this.dersnot = dersnot;
    }

    public String getDersOrtalama() {
        return ders_ortalama;
    }

    public void setDersOrtalama(String ders_ortalama) {
        this.ders_ortalama = ders_ortalama;
    }

    public String getOgrenciSayi() {
        return ogrenci_sayi;
    }

    public void setOgrenciSayi(String ogrenci_sayi) {
        this.ogrenci_sayi = ogrenci_sayi;
    }
}
