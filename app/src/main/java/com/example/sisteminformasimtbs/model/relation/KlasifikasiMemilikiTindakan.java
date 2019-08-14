package com.example.sisteminformasimtbs.model.relation;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.KlasifikasiPenyakit;
import com.example.sisteminformasimtbs.model.dataclass.Tindakan;

public class KlasifikasiMemilikiTindakan {
    // pk relationship
    private int id ;
    // fk dari klasifikasi
    private int idKlasifikasi ;
    // fk dari tindakan
    private int idTindakan ;

    public static final String TABLE_KLAS_TIN= "KlasifikasiMemilikiTindakan";

    //COLUMN NAME TABLE - KLASIFIKASI MEMILIKI TINDAKAN
    private static final String COL_ID = "id";// id universal
    // fk dari klasifikasi
    // fk dari tindakan

    public static final String CREATE_KLAS_TIN= "create table "+ TABLE_KLAS_TIN
            +"( "
            +   COL_ID +" int primary key , "
            +   KlasifikasiPenyakit.COL_IDKLASIFIKASIPENYAKIT+" int, "
            +   Tindakan.COL_IDTINDAKAN +" int, "
            +   " foreign key (idKlasifikasi) references KlasifikasiPenyakit (idKlasifikasi),"
            +   " foreign key (idTindakan) references Tindakan (idTindakan) "
            +");" ;

    public KlasifikasiMemilikiTindakan(int id, int idKlasifikasi, int idTindakan) {
        this.id = id;
        this.idKlasifikasi = idKlasifikasi;
        this.idTindakan = idTindakan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }

    public void setIdKlasifikasi(int idKlasifikasi) {
        this.idKlasifikasi = idKlasifikasi;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    private static long insert_One_Row(SQLiteDatabase db , int id , int idKlasifikasi , int idTindakan){
        ContentValues res = new ContentValues();

        res.put(COL_ID , id);
        res.put(KlasifikasiPenyakit.COL_IDKLASIFIKASIPENYAKIT , idKlasifikasi);
        res.put(Tindakan.COL_IDTINDAKAN , idTindakan);

        long ret = db.insert(TABLE_KLAS_TIN , null , res);
        Log.d("in_query_klas_tin" , ret+"");

        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db){
        // KMT Tanda Bahaya Umum
        insert_One_Row(db , 1,1,1);
        insert_One_Row(db,2,1,2);
        insert_One_Row(db,3,1,3);
        insert_One_Row(db,4,1,4);
        insert_One_Row(db,5,1,5);
        insert_One_Row(db, 6,1,6);
    }
}
