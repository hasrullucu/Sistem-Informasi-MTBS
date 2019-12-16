package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Kunjungan {
    private int idKunjungan;
    private int tipeKunjungan ;
    private double suhu ;
    private double panjangBadan ;
    private double beratBadan ;
    private String tanggalKunjungan ;
    private int kunjunganKe ;
    private String keluhan ;

    // fk dari id balita
    private int idBalita;

    public int getIdBalita() {
        return idBalita;
    }

    public void setIdBalita(int idBalita) {
        this.idBalita = idBalita;
    }

    private static final String COL_IDKUNJUNGAN = "idKunjungan";
    private static final String COL_TANGGALKUNJUNGAN = "tanggalKunjungan";
    private static final String COL_BERAT = "berat";
    private static final String COL_PANJANG = "panjang";
    private static final String COL_SUHU = "suhu";
    private static final String COL_KUNJUNGANKE = "kunjunganKe";
    private static final String COL_TIPEKUNJUNGAN = "tipeKunjungan";
    private static final String COL_KELUHAN = "keluhan";
    private static final String COL_IDBALITA = "idBalita";

    // TABLE_NAME Balita
    public static final String TABLE_KUNJUNGAN  = "Kunjungan";

    //    CREATE Table balita
    public static final String CREATE_KUNJUNGAN =
            "CREATE TABLE "+ TABLE_KUNJUNGAN + "("
                    + COL_IDKUNJUNGAN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + COL_TANGGALKUNJUNGAN + " TEXT NOT NULL, "
                    + COL_BERAT + " NUMERIC NOT NULL,"
                    + COL_PANJANG + " NUMERIC NOT NULL,"
                    + COL_SUHU + " NUMERIC  NOT NULL,"
                    + COL_KUNJUNGANKE + " INTEGER NOT NULL,"
                    + COL_TIPEKUNJUNGAN + " TEXT NOT NULL,"
                    + COL_KELUHAN + " TEXT NOT NULL,"
                    + COL_IDBALITA + " INTEGER NOT NULL"
                    + ")";

    public Kunjungan(int idKunjungan, int tipeKunjungan, double suhu, double panjangBadan, double beratBadan, String tanggalKunjungan, int kunjunganKe, String keluhan, int idBalita) {
        this.idKunjungan = idKunjungan;
        this.tipeKunjungan = tipeKunjungan;
        this.suhu = suhu;
        this.panjangBadan = panjangBadan;
        this.beratBadan = beratBadan;
        this.tanggalKunjungan = tanggalKunjungan;
        this.kunjunganKe = kunjunganKe;
        this.keluhan = keluhan;
        this.idBalita = idBalita;
    }

    public int getIdKunjungan() {
        return idKunjungan;
    }

    public void setIdKunjungan(int idKunjungan) {
        this.idKunjungan = idKunjungan;
    }

    public int getTipeKunjungan() {
        return tipeKunjungan;
    }

    public void setTipeKunjungan(int tipeKunjungan) {
        this.tipeKunjungan = tipeKunjungan;
    }

    public double getSuhu() {
        return suhu;
    }

    public void setSuhu(double suhu) {
        this.suhu = suhu;
    }

    public double getPanjangBadan() {
        return panjangBadan;
    }

    public void setPanjangBadan(double panjangBadan) {
        this.panjangBadan = panjangBadan;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    public void setTanggalKunjungan(String tanggalKunjungan) {
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public int getKunjunganKe() {
        return kunjunganKe;
    }

    public void setKunjunganKe(int kunjunganKe) {
        this.kunjunganKe = kunjunganKe;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public static long insertKunjungan(SQLiteDatabase db, String tanggalKunjungan, double beratBadan, double panjangBadan, double suhu, int kunjunganKe, int tipeKunjungan, String keluhan, int idBalita){
        ContentValues res = new ContentValues();

        res.put(COL_TANGGALKUNJUNGAN, tanggalKunjungan);
        res.put(COL_BERAT , beratBadan);
        res.put(COL_PANJANG, panjangBadan) ;
        res.put(COL_SUHU , suhu);
        res.put(COL_KUNJUNGANKE , kunjunganKe);
        res.put(COL_TIPEKUNJUNGAN, tipeKunjungan);
        res.put(COL_KELUHAN, keluhan);
        res.put(COL_IDBALITA, idBalita);

        long ret = db.insert(TABLE_KUNJUNGAN , null , res);
        Log.d("insertbalita:ID " , ret+"");
        return ret;
    }
}
