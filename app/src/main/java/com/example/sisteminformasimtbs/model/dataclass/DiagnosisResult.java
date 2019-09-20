package com.example.sisteminformasimtbs.model.dataclass;

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
