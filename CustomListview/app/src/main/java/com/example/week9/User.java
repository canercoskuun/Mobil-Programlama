package com.example.week9;

public class User {
    private String ad;
    private String soyad;
    private String yas;
    private boolean kadinMi;

    public User(String ad, String soyad, String yas, boolean kadinMi) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.kadinMi = kadinMi;
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

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public boolean isKadinMi() {
        return kadinMi;
    }

    public void setKadinMi(boolean kadinMi) {
        this.kadinMi = kadinMi;
    }
}
