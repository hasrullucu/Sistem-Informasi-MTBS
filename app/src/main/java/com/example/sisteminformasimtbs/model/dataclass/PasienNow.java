package com.example.sisteminformasimtbs.model.dataclass;

import android.util.Log;

import java.util.Calendar;

public class PasienNow {
    private String namaAnak ;
    private String namaIbu ;
    private String alamat ;
    private char jenisKelamin ;

    private double suhu= 0;
    private double beratBadan =0 ;
    private double tinggiBadan  = 0;
    private String tanggalPemeriksaan ;
    private String tanggalLahir ;
    private int tanggal ;
    private int bulan ;
    private int tahun ;
    private String keluhan ;
    private int kunjungan  = 0;


    public boolean checkAllNotNull(){
        if(namaAnak != null &&
                namaIbu != null &&
                alamat != null &&
                Character.isLetter(jenisKelamin) &&
                suhu != 0 &&
                beratBadan != 0 &&
                tinggiBadan != 0 &&
                tanggalPemeriksaan != null &&
                tanggalLahir != null && kunjungan != 0) return true;
        return false;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public char getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public double getSuhu() {
        return suhu;
    }

    public void setSuhu(double suhu) {
        this.suhu = suhu;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double beratBadan) {
        this.beratBadan = beratBadan;
    }

    public double getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(double tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getTanggalPemeriksaan() {
        return tanggalPemeriksaan;
    }

    public void setTanggalPemeriksaan(String tanggalPemeriksaan) {
        this.tanggalPemeriksaan = tanggalPemeriksaan;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public int getKunjungan() {
        return kunjungan;
    }

    public void setKunjungan(int kunjungan) {
        this.kunjungan = kunjungan;
    }

    public int getTanggal() {
        return tanggal;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public int getBulan() {
        return bulan;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

   public int getUmurInBulan(){
       String res = "";
       Calendar now  = Calendar.getInstance();
       int nowYear = now.get(Calendar.YEAR);
       int nowMonth = now.get(Calendar.MONTH);
       int nowDay   = now.get(Calendar.DAY_OF_MONTH);
       int selisihUmur = nowYear-this.tahun;
       int selisihBulan = nowMonth-this.bulan;


       return selisihUmur*12 + selisihBulan;
   }
}
