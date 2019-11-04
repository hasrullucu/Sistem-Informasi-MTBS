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

        res.put(COL_IDBENTUKOBAT, idBentukObat);
        res.put(COL_NAMABENTUKOBAT, namaBentukObat);

        long ret = db.insert(TABLE_BENTUKOBAT, null , res);
        Log.d("in_query_lang" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db ){
        //insert bentuk obat diazepam
        insert_One_Row(db ,1, "Diazepam (10 mg/2 ml)");
        insert_One_Row(db, 2, "Diazepam per rektum siap");
        insert_One_Row(db, 3,"Tablet (500 mg)");
        insert_One_Row(db, 4,"Sirup (125 mg/5 ml)");
        insert_One_Row(db, 5,"Sirup (250 mg/5ml)");
        insert_One_Row(db, 6,"Kapsul (250 mg)");
        insert_One_Row(db, 7,"Tablet dewasa (80 mg/400 mg) hari");
        insert_One_Row(db, 8,"Tablet anak (20 mg/100 mg)");
        insert_One_Row(db, 9,"Sirup per 5 ml (40 mg/200 mg)");
        insert_One_Row(db, 10,"Tablet anak (20mg TMP + 100mg SMZ)");
        insert_One_Row(db, 11,"Tablet (100 mg)");
        insert_One_Row(db, 12,"Sirup (100mg/5ml)");

//        belum pasti
        insert_One_Row(db, 13,"Tablet (500 mg)");

        insert_One_Row(db, 14,"Tablet 500 mg");
        insert_One_Row(db, 15,"Tablet 100 mg");
        insert_One_Row(db, 16,"Sirup 120 mg/5 ml");
        insert_One_Row(db, 17,"Kapsul");
        insert_One_Row(db, 18,"Kapsul");
        insert_One_Row(db, 19,"Kapsul");
        insert_One_Row(db, 20,"Tablet (500 mg)");
        insert_One_Row(db, 21,"Sirup 125 mg/5ml");
        insert_One_Row(db, 22,"Sirup 250 mg/5ml");
        insert_One_Row(db, 23,"Tablet Besi Folat (60 mg besi elemental dan 0,25 mg asam folat)");
        insert_One_Row(db, 24,"Sirup Besi (setiap 5 ml mengandung 30 mg besi elemental)");
    }
}
