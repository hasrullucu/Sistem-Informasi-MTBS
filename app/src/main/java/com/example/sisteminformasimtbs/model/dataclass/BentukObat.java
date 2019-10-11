package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Kelas  Jenis Obat untuk identifikasi jenis obat seperti
 * (Kapsul , sirup)
 *
 */
public class BentukObat {
    private int idBentukObat;
    private String namaBentukObat;

    // table name
    public static final String TABLE_BENTUKOBAT = "BentukObat";

    // column name
    // COLUMN NAME TABLE - JENISOBAT
    public static final String COL_IDBENTUKOBAT  = "idBentukObat";
    private static final String COL_NAMABENTUKOBAT = "namaBentukObat";

    public static final String CREATE_BENTUKOBAT  = "create table " + TABLE_BENTUKOBAT
            + " ("
            + COL_IDBENTUKOBAT +" int primary key, "
            + COL_NAMABENTUKOBAT+ " varchar(255) "
            +" );";

    public BentukObat(int idBentukObat, String namaBentukObat) {
        this.idBentukObat = idBentukObat;
        this.namaBentukObat = namaBentukObat;
    }

    public int getIdBentukObat() {
        return idBentukObat;
    }

    public void setIdBentukObat(int idBentukObat) {
        this.idBentukObat = idBentukObat;
    }

    public String getNamaBentukObat() {
        return namaBentukObat;
    }

    public void setNamaBentukObat(String namaBentukObat) {
        this.namaBentukObat = namaBentukObat;
    }

    private static long insert_One_Row(SQLiteDatabase db, int idBentukObat, String namaBentukObat){
        ContentValues res = new ContentValues();

        res.put(COL_IDBENTUKOBAT , idBentukObat);
        res.put(COL_NAMABENTUKOBAT, namaBentukObat);

        long ret = db.insert(TABLE_BENTUKOBAT, null , res);
        Log.d("in_query_lang" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db ){
        //insert bentuk obat diazepam
        insert_One_Row(db ,1 , "Diazepam (10 mg/2 ml)");
        insert_One_Row(db, 2, "Diazepam per rektum siap");
    }
}
