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

    private static long insert_One_Row(SQLiteDatabase db, int id , int idKlasifikasi , int idGejala){
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
        insert_One_Row(db, 1,1,1);
        insert_One_Row(db, 2,1,2);
        insert_One_Row(db, 3,1,3);
        insert_One_Row(db, 4,1,4);
        insert_One_Row(db, 5,1,5);
        insert_One_Row(db, 6,1,6);
        insert_One_Row(db, 7,1,7);
        insert_One_Row(db, 8,1,8);
        // batuk
        insert_One_Row(db, 9,2,9);
        insert_One_Row(db, 10,2,10);
        insert_One_Row(db, 11,3,11);
        insert_One_Row(db, 12,4,12);
        // diare
        insert_One_Row(db, 13,5,5);
        insert_One_Row(db, 14,5,13);
        insert_One_Row(db, 15,5,14);
        insert_One_Row(db, 16,5,15);
        insert_One_Row(db, 17,6,16);
        insert_One_Row(db, 18,6,13);
        insert_One_Row(db, 19,6,17);
        insert_One_Row(db, 20,6,18);
        insert_One_Row(db, 21,7,19);
        insert_One_Row(db, 22,8,70);
        insert_One_Row(db, 23,8,21);
        insert_One_Row(db, 24,9,22);
        insert_One_Row(db, 25,9,21);
        // fragment_fragmentdemam1

        insert_One_Row(db, 26,10,23);
        insert_One_Row(db, 27,10,24);
        insert_One_Row(db, 28,11,25);
        insert_One_Row(db, 29,11,26);
        insert_One_Row(db, 30,12,27);
        insert_One_Row(db, 31,12,28);
        insert_One_Row(db, 32,13,23);
        insert_One_Row(db, 33,13,24);
        insert_One_Row(db, 34,13,29);
        insert_One_Row(db, 35,14,30);
        insert_One_Row(db, 36,14,31);
        insert_One_Row(db, 37,15,23);
        insert_One_Row(db, 38,15,32);
        insert_One_Row(db, 39,15,33);
        insert_One_Row(db, 40,16,34);
        insert_One_Row(db, 41,16,35);
        insert_One_Row(db, 42,17,36);
        insert_One_Row(db, 43,17,37);
        insert_One_Row(db, 44,17,38);
        insert_One_Row(db, 45,17,39);
        insert_One_Row(db, 46,17,40);
        insert_One_Row(db, 47,18,41);
        insert_One_Row(db, 48,18,42);
        insert_One_Row(db, 49,18,43);
        insert_One_Row(db, 50,19,44);
        // masalah telinga
        insert_One_Row(db, 51,20,45);
        insert_One_Row(db, 52,21,46);
        insert_One_Row(db, 53,21,47);
        insert_One_Row(db, 54,21,48);
        insert_One_Row(db, 55,22,49);
        insert_One_Row(db, 56,23,50);
        // status gizi
        insert_One_Row(db, 57,24,51);
        insert_One_Row(db, 58,24,52);
        insert_One_Row(db, 59,24,53);
        insert_One_Row(db, 60,24,54);
        insert_One_Row(db, 61,24,23);
        insert_One_Row(db, 62,24,55);
        insert_One_Row(db, 63,24,56);
        insert_One_Row(db, 64,25,51);
        insert_One_Row(db, 65,25,53);
        insert_One_Row(db, 66,25,54);
        insert_One_Row(db, 67,26,57);
        insert_One_Row(db, 68,26,58);
        insert_One_Row(db, 69,27,59);
        insert_One_Row(db, 70,27,60);
        // anemia
        insert_One_Row(db, 71,28,61);
        insert_One_Row(db, 72,29,62);
        insert_One_Row(db, 73,30,63);
        // status hiv
        insert_One_Row(db, 74,31,64);
        insert_One_Row(db, 75,32,65);
        insert_One_Row(db, 76,33,66);
        insert_One_Row(db, 77,33,67);
        insert_One_Row(db, 78,33,68);
        insert_One_Row(db, 79,34,69);
        insert_One_Row(db, 80,35,20);
        insert_One_Row(db, 81,35,21);
    }
}
