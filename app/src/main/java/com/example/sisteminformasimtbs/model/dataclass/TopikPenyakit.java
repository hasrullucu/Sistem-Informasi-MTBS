package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TopikPenyakit  {
    private int idTopikPenyakit ;
    private String namaTopikPenyakit ;
    private int tipePenyakit;

    // TABLE_NAME TopikPenyakit
    public static final String TABLE_TOPIKPENYAKIT  = "TopikPenyakit";


    //COLUMN NAME TABLE - PENYAKIT
    private static final String COL_IDTOPIKPENYAKIT = "idTopik";
    private static final String COL_NAMATOPIKPENYAKIT = "namaTopik";
    private static final String COL_TIPEPENYAKIT = "tipeTopik";

    //  CREATE TABLE-PENYAKIT
    public static final String CREATE_PENYAKIT = "create table "+ TABLE_TOPIKPENYAKIT
            +" ("
            + COL_IDTOPIKPENYAKIT +" int primary key ,"
            + COL_NAMATOPIKPENYAKIT+" namaTopikPenyakit varchar(255) ,"
            + COL_TIPEPENYAKIT+ " tipePenyakit int "
            + " );";


    public int getIdTopikPenyakit() {
        return idTopikPenyakit;
    }

    public void setIdTopikPenyakit(int idTopikPenyakit) {
        this.idTopikPenyakit = idTopikPenyakit;
    }

    public String getNamaTopikPenyakit() {
        return namaTopikPenyakit;
    }

    public void setNamaTopikPenyakit(String namaTopikPenyakit) {
        this.namaTopikPenyakit = namaTopikPenyakit;
    }

    public int getTipePenyakit() {
        return tipePenyakit;
    }

    public void setTipePenyakit(int tipePenyakit) {
        this.tipePenyakit = tipePenyakit;
    }

    public TopikPenyakit(int idTopikPenyakit, String namaTopikPenyakit, int tipePenyakit) {
        this.idTopikPenyakit = idTopikPenyakit;
        this.namaTopikPenyakit = namaTopikPenyakit;
        this.tipePenyakit = tipePenyakit;
    }

    private static long insert_One_Row(SQLiteDatabase db , int idTopikPenyakit , String namaTopikPenyakit , int tipePenyakit){
        ContentValues res = new ContentValues();

        res.put(COL_IDTOPIKPENYAKIT , idTopikPenyakit);
        res.put(COL_NAMATOPIKPENYAKIT , namaTopikPenyakit);
        res.put(COL_TIPEPENYAKIT, tipePenyakit);

        long ret = db.insert(TABLE_TOPIKPENYAKIT , null , res);
        Log.d("insert_query_topik" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db){
        insert_One_Row(db , 1 , "Tanad Bahaya Umum", 1);
    }




}
