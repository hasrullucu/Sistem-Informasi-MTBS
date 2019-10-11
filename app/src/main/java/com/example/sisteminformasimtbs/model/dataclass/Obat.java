package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Obat{
    private int idObat;
    private String namaObat;
    private String pemberian;

    // TABLE NAME OBAT
    public static final String TABLE_OBAT = "Obat";

    // COLUMN NAME TABLE - OBAT
    public static final String COL_IDOBAT =  "idObat";
    public static final String COL_NAMAOBAT =  "namaObat";
    public static final String COL_PEMBERIAN = "pemberian";

    public static final String CREATE_OBAT = "create table " + TABLE_OBAT
            +" ("
            + COL_IDOBAT+" int primary key , "
            + COL_NAMAOBAT+" varchar(255) , "
            + COL_PEMBERIAN+" varchar(255) "
            +");" ;

    public Obat(int idObat, String namaObat, String pemberian) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.pemberian = pemberian;
    }

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getPemberian() {
        return pemberian;
    }

    public void setPemberian(String pemberian) {
        this.pemberian = pemberian;
    }

    private static long insert_One_Row(SQLiteDatabase db, int idObat, String namaObat, String pemberian){
        ContentValues res = new ContentValues();

        res.put(COL_IDOBAT , idObat);
        res.put(COL_NAMAOBAT, namaObat);
        res.put(COL_PEMBERIAN, pemberian);

        long ret = db.insert(TABLE_OBAT, null , res);
        Log.d("in_query_lang" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db ){
        // langkah tindakan Tanda Bahaya Umum id = 1
        insert_One_Row(db ,1 , "Diazepam", "");
    }
}
