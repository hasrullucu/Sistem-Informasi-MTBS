package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Tindakan {
    private int idTindakan ;
    private String namaTindakan ;
    private int tipeTindakan;

    // tabel Tindakan
    public static final String TABLE_TINDAKAN = "Tindakan";

    // COLUMN NAME TABLE - TINDAKAN
    public static final String COL_IDTINDAKAN ="idTindakan";
    public static final String COL_NAMATINDAKAN= "namaTindakan" ;
    public static final String COL_TIPETINDAKAN = "tipetindakan";


    public static final String CREATE_TINDAKAN = "create table "+ TABLE_TINDAKAN
            +"("
            + COL_IDTINDAKAN +" int primary key, "
            + COL_NAMATINDAKAN +" varchar(255), "
            + COL_TIPETINDAKAN+" int"
            +");";

    public Tindakan(int idTindakan, String namaTindakan, int tipeTindakan) {
        this.idTindakan = idTindakan;
        this.namaTindakan = namaTindakan;
        this.tipeTindakan = tipeTindakan;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    public String getNamaTindakan() {
        return namaTindakan;
    }

    public void setNamaTindakan(String namaTindakan) {
        this.namaTindakan = namaTindakan;
    }

    public int getTipeTindakan() {
        return tipeTindakan;
    }

    public void setTipeTindakan(int tipeTindakan) {
        this.tipeTindakan = tipeTindakan;
    }

    private static long insert_One_Row(SQLiteDatabase db ,int idTindakan , String namaTindakan , int tipeTindakan){
        ContentValues res = new ContentValues();

        res.put(COL_IDTINDAKAN , idTindakan);
        res.put(COL_NAMATINDAKAN , namaTindakan);
        res.put(COL_TIPETINDAKAN , 1);

        long ret = db.insert(TABLE_TINDAKAN , null , res);
        Log.d("in_query_tin" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db){
        insert_One_Row(db , 1 , "Bila sedang kejang beri diazepam" , 1);
        insert_One_Row(db , 2 , "Bila ada stridor pastikan tidak ada sumbatan jalan napas",2);
        insert_One_Row(db , 3,"Bila ada stridor, sianosis dan ujung tangan dan kaki pucat dan dingin berikan oksigen 3-5 liter/\n" +
                "menit melalui nasal prong dengan perangkat oksigen standar (tabung oksigen dan humidifier)", 1);
        insert_One_Row(db , 4, "Cegah agar gula darah tidak turun", 1);
        insert_One_Row(db , 5 , "Jaga anak tetap hangat" , 1);
        insert_One_Row(db , 6 , "RUJUK SEGERA" , 1);

    }
}
