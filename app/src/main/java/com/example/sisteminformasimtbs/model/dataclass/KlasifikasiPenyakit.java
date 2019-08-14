package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class KlasifikasiPenyakit {

   private int idKlasifikasi;
   private String namaKlasifikasi ;
   private int syaratMinimal ;
   private int idTopikPenyakit ;

   // NAMA TABEL
   public static final String TABLE_KLASIFIKASIPENYAKIT = "KlasifikasiPenyakit";

    //COLUMN NAME TABLE - KLASIFIKASI
    public static final String COL_IDKLASIFIKASIPENYAKIT = "idKlasifikasi";
    public static final String COL_NAMAKLASIFIKASI =  "namaKlasifikasi";
    public static final String COL_SYARATMINIMAL = "syaratMinimal";
    public static final String COL_IDTOPIKPENYAKIT = "idTopikPenyakit";

    public static final String CREATE_KLASIFIKASI = " create table "+ TABLE_KLASIFIKASIPENYAKIT
            +" ("
            +  COL_IDKLASIFIKASIPENYAKIT+" int primary key,"
            +  COL_NAMAKLASIFIKASI+"  varchar(255),"
            +  COL_SYARATMINIMAL+ " int,"
            +  COL_IDTOPIKPENYAKIT+ " int,"
            +     "  foreign key (idTopikPenyakit) references TopikPenyakit (idTopikPenyakit)"
            +  ");" ;

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }

    public void setIdKlasifikasi(int idKlasifikasi) {
        this.idKlasifikasi = idKlasifikasi;
    }

    public String getNamaKlasifikasi() {
        return namaKlasifikasi;
    }

    public void setNamaKlasifikasi(String namaKlasifikasi) {
        this.namaKlasifikasi = namaKlasifikasi;
    }

    public int getSyaratMinimal() {
        return syaratMinimal;
    }

    public void setSyaratMinimal(int syaratMinimal) {
        this.syaratMinimal = syaratMinimal;
    }

    public int getIdTopikPenyakit() {
        return idTopikPenyakit;
    }

    public void setIdTopikPenyakit(int idTopikPenyakit) {
        this.idTopikPenyakit = idTopikPenyakit;
    }

    public KlasifikasiPenyakit(int idKlasifikasi, String namaKlasifikasi, int syaratMinimal, int idTopikPenyakit) {
        this.idKlasifikasi = idKlasifikasi;
        this.namaKlasifikasi = namaKlasifikasi;
        this.syaratMinimal = syaratMinimal;
        this.idTopikPenyakit = idTopikPenyakit;
    }

    private static  long insert_One_Row(SQLiteDatabase db, int idKlasifikasi, String namaKlasifikasi , int syaratMinimal , int idTopikPenyakit ){
        ContentValues res = new ContentValues();

        res.put(COL_IDKLASIFIKASIPENYAKIT , 1);
        res.put(COL_NAMAKLASIFIKASI , "PENYAKIT SANGAT BERAT");
        res.put(COL_SYARATMINIMAL, 1);
        res.put(COL_IDTOPIKPENYAKIT, 1);

        long ret = db.insert(TABLE_KLASIFIKASIPENYAKIT ,null , res);
        Log.d("in_q_klasifikasi", ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db){
        insert_One_Row(db, 1 , "PENYAKIT SANGAT BERAT", 1 ,1);
    }
}
