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

        //batuk
        insert_One_Row(db, 7,2,7);
        insert_One_Row(db, 8,2,8);
        insert_One_Row(db, 9,2,6);
        insert_One_Row(db, 10,3,9);
        insert_One_Row(db, 11,3,10);
        insert_One_Row(db, 12,3,11);
        insert_One_Row(db, 13,3,12);
        insert_One_Row(db, 14,3,13);
        insert_One_Row(db, 15,3,14);

        //diare
        insert_One_Row(db, 16,4,10);
        insert_One_Row(db, 17,4,11);
        insert_One_Row(db, 18,4,12);
        insert_One_Row(db, 19,4,13);
        insert_One_Row(db, 20,4,14);
        insert_One_Row(db, 21,5,15);
        insert_One_Row(db, 22,5,16);
        insert_One_Row(db, 23,5,17);
        insert_One_Row(db, 24,6,18);
        insert_One_Row(db, 25,6,16);
        insert_One_Row(db, 26,6,13);
        insert_One_Row(db, 27,6,19);
        insert_One_Row(db, 28,7,20);
        insert_One_Row(db, 29,7,21);
        insert_One_Row(db, 30,7,6);
        insert_One_Row(db, 31,35,22);
        insert_One_Row(db, 32,35,23);
        insert_One_Row(db, 33,35,13);
        insert_One_Row(db, 34,35,19);
        insert_One_Row(db, 35,9,24);
        insert_One_Row(db, 36,9,23);
        insert_One_Row(db, 37,9,13);
        insert_One_Row(db, 38,9,19);

        //fragment_fragmentdemam1
        insert_One_Row(db, 39,10,25);
        insert_One_Row(db, 40,10,8);
        insert_One_Row(db, 41,10,4);
        insert_One_Row(db, 42,10,26);
        insert_One_Row(db, 43,10,6);
        insert_One_Row(db, 44,11,27);
        insert_One_Row(db, 45,11,26);
        insert_One_Row(db, 46,11,13);
        insert_One_Row(db, 47,11,19);
        insert_One_Row(db, 48,11,28);
        insert_One_Row(db, 49,12,26);
        insert_One_Row(db, 50,12,29);
        insert_One_Row(db, 51,12,13);
        insert_One_Row(db, 52,12,19);
        insert_One_Row(db, 53,12,28);
        insert_One_Row(db, 54,13,8);
        insert_One_Row(db, 55,13,4);
        insert_One_Row(db, 56,13,26);
        insert_One_Row(db, 57,13,6);
        insert_One_Row(db, 58,14,26);
        insert_One_Row(db, 59,14,29);
        insert_One_Row(db, 60,14,13);
        insert_One_Row(db, 61,14,14);
        insert_One_Row(db, 62,14,28);
        insert_One_Row(db, 63,15,30);
        insert_One_Row(db, 64,15,8);
        insert_One_Row(db, 65,15,31);
        insert_One_Row(db, 66,15,26);
        insert_One_Row(db, 67,15,6);
        insert_One_Row(db, 68,16,30);
        insert_One_Row(db, 69,16,32);
        insert_One_Row(db, 70,16,33);
        insert_One_Row(db, 71,16,34);
        insert_One_Row(db, 72,16,19);
        insert_One_Row(db, 73,17,35);
        insert_One_Row(db, 74,17,36);
        insert_One_Row(db, 75,17,37);
        insert_One_Row(db, 76,17,38);
        insert_One_Row(db, 77,17,6);
        insert_One_Row(db, 78,18,38);
        insert_One_Row(db, 79,18,13);
        insert_One_Row(db, 80,18,39);
        insert_One_Row(db, 81,19,29);
        insert_One_Row(db, 82,19,38);
        insert_One_Row(db, 83,19,13);
        insert_One_Row(db, 84,19,14);

        //masalah telinga
        insert_One_Row(db, 85,20,8);
        insert_One_Row(db, 86,20,40);
        insert_One_Row(db, 87,20,6);
        insert_One_Row(db, 88,21,41);
        insert_One_Row(db, 89,21,40);
        insert_One_Row(db, 90,21,42);
        insert_One_Row(db, 91,21,43);
        insert_One_Row(db, 92,22,42);
        insert_One_Row(db, 93,22,44);
        insert_One_Row(db, 94,22,43);
        insert_One_Row(db, 95,23,45);

        //Status gizi
        insert_One_Row(db, 96,24,8);
        insert_One_Row(db, 97,24,46);
        insert_One_Row(db, 98,24,4);
        insert_One_Row(db, 99,24,5);
        insert_One_Row(db, 100,24,6);
        insert_One_Row(db, 101,25,47);
        insert_One_Row(db, 102,25,46);
        insert_One_Row(db, 103,25,4);
        insert_One_Row(db, 104,25,5);
        insert_One_Row(db, 105,25,48);
        insert_One_Row(db, 106,25,13);
        insert_One_Row(db, 107,25,49);
        insert_One_Row(db, 108,26,50);
        insert_One_Row(db, 109,26,51);
        insert_One_Row(db, 110,26,52);
        insert_One_Row(db, 111,27,53);
        insert_One_Row(db, 112,27,54);

        //Anemia
        insert_One_Row(db, 113,28,55);
        insert_One_Row(db, 114,28,6);
        insert_One_Row(db, 115,29,56);
        insert_One_Row(db, 116,29,57);
        insert_One_Row(db, 117,29,58);
        insert_One_Row(db, 118,29,59);
        insert_One_Row(db, 119,29,13);
        insert_One_Row(db, 120,29,60);
        insert_One_Row(db, 121,30,61);

        //Status HIV
        insert_One_Row(db, 122,31,62);
        insert_One_Row(db, 123,32,63);
        insert_One_Row(db, 124,33,64);
        insert_One_Row(db, 125,34,65);
        insert_One_Row(db, 126,8,21);
        insert_One_Row(db, 127,8,6);
    }
}
