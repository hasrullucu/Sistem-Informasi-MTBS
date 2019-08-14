package com.example.sisteminformasimtbs.model.relation;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.Gejala;
import com.example.sisteminformasimtbs.model.dataclass.KlasifikasiPenyakit;

public class GejalaMemilikiKlasifikasi {
    // pk relationship
    private int id ;
    // fk dari klasifikasi
    private int idGejala ;
    // fk dari gejala
    private int idKlasifikasi ;

    public static final String TABLE_GEJ_KLAS = "GejalaMemilikiKlasifikasi";

    //COLUMN NAME TABLE - GEJALA MEMILIKI KLASIFIKASI
    private static final String COL_ID = "id"; // id universal
    // fk dari klasifikasi
    // fk dari gejala

    public static final String CREATE_GEJ_KLAS = "create table "+TABLE_GEJ_KLAS
            +" ("
            + COL_ID+" int primary key , "
            + Gejala.COL_IDGEJALA+" int , "
            + KlasifikasiPenyakit.COL_IDKLASIFIKASIPENYAKIT+" int,"
            +"  foreign key (idGejala) references Gejala (idGejala), \n"
            +"  foreign key  (idKlasifikasi) references KlasifikasiPenyakit (idKlasifikasi) \n"
            +");";

    /**
     * constructor
     * @param id
     * @param idGejala
     * @param idKlasifikasi
     */
    public GejalaMemilikiKlasifikasi(int id, int idGejala, int idKlasifikasi) {
        this.id = id;
        this.idGejala = idGejala;
        this.idKlasifikasi = idKlasifikasi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGejala() {
        return idGejala;
    }

    public void setIdGejala(int idGejala) {
        this.idGejala = idGejala;
    }

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }

    public void setIdKlasifikasi(int idKlasifikasi) {
        this.idKlasifikasi = idKlasifikasi;
    }

    private static long insert_One_Row(SQLiteDatabase db, int id , int idGejala , int idKlasifikasi){
        ContentValues res = new ContentValues();

        res.put(COL_ID , id);
        res.put(Gejala.COL_IDGEJALA , idGejala);
        res.put(KlasifikasiPenyakit.COL_IDKLASIFIKASIPENYAKIT , idKlasifikasi);

        long ret = db.insert(TABLE_GEJ_KLAS , null , res);
        Log.d("in_query_gej_klas" , ret+"");
        return ret;

    }

    public static void insert_All_Row(SQLiteDatabase db){
        // insert tanda bahaya umum gej_klas id 1-8
        insert_One_Row(db , 1,1,1);
        insert_One_Row(db , 2,2,1);
        insert_One_Row(db,3,3,1);
        insert_One_Row(db,4,4,1);
        insert_One_Row(db,5,5,1);
        insert_One_Row(db,6,6,1);
        insert_One_Row(db,7,7,1);
        insert_One_Row(db,8,8,1);
    }
}
