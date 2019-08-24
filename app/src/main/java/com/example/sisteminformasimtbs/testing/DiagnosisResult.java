package com.example.sisteminformasimtbs.testing;

public class DiagnosisResult {
   private String namaKlasifikasiPenyakit;
   private int idKlasifikasi;

    public DiagnosisResult(String namaKlasifikasiPenyakit, int idKlasifikasi) {
        this.namaKlasifikasiPenyakit = namaKlasifikasiPenyakit;
        this.idKlasifikasi = idKlasifikasi;
    }

    public String getNamaKlasifikasiPenyakit() {
        return namaKlasifikasiPenyakit;
    }

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }
}
