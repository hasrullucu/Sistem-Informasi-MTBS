package com.example.sisteminformasimtbs.model.dataclass;

public class KotaKabupaten  {
    private int IdKotaKabupaten ;
    private String namaKotaKabupaten ;

    // fk dari provinsi
    private int idProvinsi ;

    public KotaKabupaten(int idKotaKabupaten, String namaKotaKabupaten, int idProvinsi) {
        IdKotaKabupaten = idKotaKabupaten;
        this.namaKotaKabupaten = namaKotaKabupaten;
        this.idProvinsi = idProvinsi;
    }

    public int getIdKotaKabupaten() {
        return IdKotaKabupaten;
    }

    public void setIdKotaKabupaten(int idKotaKabupaten) {
        IdKotaKabupaten = idKotaKabupaten;
    }

    public String getNamaKotaKabupaten() {
        return namaKotaKabupaten;
    }

    public void setNamaKotaKabupaten(String namaKotaKabupaten) {
        this.namaKotaKabupaten = namaKotaKabupaten;
    }

    public int getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(int idProvinsi) {
        this.idProvinsi = idProvinsi;
    }
}
