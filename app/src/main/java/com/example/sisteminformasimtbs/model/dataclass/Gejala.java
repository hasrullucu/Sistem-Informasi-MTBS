package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Gejala {
    public static final String TABLE_GEJALA = "gejala";
    //COLUMN NAME TABLE - GEJALA
    public static final String COL_IDGEJALA = "idGejala";
    public static final String COL_NAMAGEJALA = "namaGejala";
    public static final String CREATE_GEJALA = "create table "+ TABLE_GEJALA
            + "("
            + COL_IDGEJALA+" int primary key, "
            + COL_NAMAGEJALA+" varchar(255)  "
            + ");";
    private int idGejala ;
    private String namaGejala ;

    private static long insert_One_Row(SQLiteDatabase db, int idGejala , String namaGejala ){
        ContentValues res = new ContentValues();

        res.put(COL_IDGEJALA , idGejala);
        res.put(COL_NAMAGEJALA , namaGejala);

        long ret = db.insert(TABLE_GEJALA , null , res);
        Log.d("insert_query_gejala" , ret+"");
        return ret;
    }

    public static long insert_All_Row(SQLiteDatabase db){
        // gejala Tanda Bahaya umum
         insert_One_Row(db,1 , "Tidak Bisa Minum Atau Menyusu ?");
         insert_One_Row(db , 2 ,"Memuntahkan semua makanan dan atau minuman");
       insert_One_Row(db , 3 , "Pernah atau sedang mengalami kejang ?");
       insert_One_Row(db , 4 , "Gelisah ?");
        insert_One_Row(db , 5 , "Letargis atau Tidak Sadar ?");
        insert_One_Row(db , 6 ,"Ada stridor ?");
        insert_One_Row(db , 7 , "Tampak Biru(sianosis) ?");
        insert_One_Row(db , 8 , "Ujung tangan dan kaki balita pucat dan dingin ?");

         return 1;

    }

    public int getIdGejala() {
        return idGejala;
    }

    public void setIdGejala(int idGejala) {
        this.idGejala = idGejala;
    }

    public String getNamaGejala() {
        return namaGejala;
    }

    public void setNamaGejala(String namaGejala) {
        this.namaGejala = namaGejala;
    }
}
