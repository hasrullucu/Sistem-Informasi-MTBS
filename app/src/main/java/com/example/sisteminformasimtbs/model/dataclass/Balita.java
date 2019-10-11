package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Kelas model untuk objek balita
 *
 *
 */
public class Balita {
    private String nama ;
    private int idBalita ;
    private String namaIbu ;
    private int nomorPasien ;
    private String alamat ;
    private char jenisKelamin ;
    private String tanggalLahir ;
    private int umur ;

    /**
     *  Constructor kelsa balita
     * @param nama
     * @param idBalita
     * @param namaIbu
     * @param nomorPasien
     * @param alamat
     * @param jenisKelamin
     * @param tanggalLahir
     * @param umur
     */
    //     COLUMN NAME TABLE - BALITA
    private static final String COL_NAMABALITA = "namabalita";
    private static final String COL_IDBALITA = "idbalita";
    private static final String COL_NAMAIBU = "namaibu";
    private static final String COL_ALAMAT = "alamat";
    private static final String COL_JENISKELAMIN = "jeniskelamin";
    private static final String COL_TANGGALLAHIR = "tanggallahir";
    private static final String COL_UMUR = "umur";


    // TABLE_NAME Balita
    public static final String TABLE_BALITA  = "Balita";



//    CREATE Table balita
    public static final String CREATE_BALITA =
                        "CREATE TABLE "+ TABLE_BALITA + "("
                        + COL_NAMABALITA + " TEXT NOT NULL, "
                        + COL_IDBALITA + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_NAMAIBU + " TEXT NOT NULL,"
                        + COL_ALAMAT + " TEXT NOT NULL,"
                        + COL_JENISKELAMIN + " TEXT  NOT NULL,"
                        + COL_TANGGALLAHIR + " DATE NOT NULL,"
                        + COL_UMUR + " INTEGER NOT NULL"
                        + ")";



    public Balita(String nama, int idBalita, String namaIbu, int nomorPasien, String alamat, char jenisKelamin, String tanggalLahir, int umur) {
        this.nama = nama;
        this.idBalita = idBalita;
        this.namaIbu = namaIbu;
        this.nomorPasien = nomorPasien;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.umur = umur;
    }

    public static long insertDataBalita(SQLiteDatabase db , String nama , String namaIbu , String jenisKelamin , String alamat , String tanggalLahir , int umur){
        ContentValues res = new ContentValues();
//
//        res.put(COL_IDTOPIKPENYAKIT , idTopikPenyakit);
//        res.put(COL_NAMATOPIKPENYAKIT , namaTopikPenyakit);
//        res.put(COL_TIPEPENYAKIT, tipePenyakit);
          res.put(COL_NAMABALITA  , nama);
          res.put(COL_NAMAIBU , namaIbu) ;
          res.put(COL_TANGGALLAHIR , tanggalLahir) ;
          res.put(COL_UMUR , umur) ;
          res.put(COL_ALAMAT , alamat);
          res.put(COL_JENISKELAMIN , jenisKelamin);

        long ret = db.insert(TABLE_BALITA , null , res);
        Log.d("insertbalita:ID " , ret+"");
        return ret;
    }




    /**
     * Getter id balita
     * @return id
     */
    public int getIdBalita() {
        return idBalita;
    }

    /**
     * Getter kelas
     */
    public void setIdBalita(int idBalita) {
        this.idBalita = idBalita;
    }

    /**
     * Getter nomor pasien
     * @return
     */
    public int getNomorPasien() {
        return nomorPasien;
    }

    /**
     * Setter nomor pasien
     * @param nomorPasien
     */
    public void setNomorPasien(int nomorPasien) {
        this.nomorPasien = nomorPasien;
    }

    /**
     * Getter dari alamat
     * @return
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * Setter dari alamat
     * @param alamat
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * Getter dari nama balita
     * @return
     */
    public String getNama() {
        return nama;
    }

    /**
     * Setter dari nama
     * @param nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Getter dari nama ibu
     * @return
     */
    public String getNamaIbu() {
        return namaIbu;
    }

    /**
     * Setter dari nama ibu
     * @param namaIbu
     */
    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    /**
     * Getter dari jenis kelamin
     * @return karakter L / P  (laki/ perempuan)
     */
    public char getJenisKelamin() {
        return jenisKelamin;
    }

    /**
     * Setter dari jenis kelamin
     * @param jenisKelamin
     */
    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * Getter dari tanggal lahir
     * @return string format 'ddmmyy'
     */
    public String getTanggalLahir() {
        return tanggalLahir;
    }

    /**
     * Setter dari tanggal lahir
     *
     * @param tanggalLahir
     */
    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    /**
     * Getter dari umur balita
     * @return
     */
    public int getUmur() {
        return umur;
    }

    /**
     * Setter dari umur
     * @param umur
     */
    public void setUmur(int umur) {
        this.umur = umur;
    }
}
