package com.example.sisteminformasimtbs.model.relation;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.BentukObat;
import com.example.sisteminformasimtbs.model.dataclass.Obat;

public class ObatMemilikiBentukObat {
    private int id; // id universal
    private int idObat ;
    private int idBentukObat;

    public static final String TABLE_OBAT_BENTUKOBAT = "ObatMemilikiBentukObat";

    private static final String COL_ID = "id";
    // fk obat
    // fk bentuk obat

    public static final String CREATE_OBAT_BENTUKOBAT = "create table "+TABLE_OBAT_BENTUKOBAT
            +" ( "
            +  COL_ID +" int primary key, "
            +  Obat.COL_IDOBAT  +" int, "
            +  BentukObat.COL_IDBENTUKOBAT +" int, "
            +   "   foreign key (idObat) references Obat (idObat), "
            +   "   foreign key (idBentukObat) references BentukObat (idBentukObat)"
            + ");";

    public ObatMemilikiBentukObat(int id, int idObat, int idBentukObat) {
        this.id = id;
        this.idObat = idObat;
        this.idBentukObat = idBentukObat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public int getIdBentukObat() {
        return idBentukObat;
    }

    public void setIdBentukObat(int idBentukObat) {
        this.idBentukObat = idBentukObat;
    }

    private static long insert_One_Row(SQLiteDatabase db, int id, int idObat, int idBentukObat){
        ContentValues res = new ContentValues();

        res.put(COL_ID, id);
        res.put(Obat.COL_IDOBAT , idObat);
        res.put(BentukObat.COL_IDBENTUKOBAT, idBentukObat);

        long ret = db.insert(TABLE_OBAT_BENTUKOBAT, null , res);
        Log.d("in_query_lang" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db ){
        //insert bentuk obat diazepam
        insert_One_Row(db,1,1,1);
        insert_One_Row(db,2,1,2);
        insert_One_Row(db,3,2,3);
        insert_One_Row(db,4,2,4);
        insert_One_Row(db,5,2,5);
        insert_One_Row(db,6,3,6);
        insert_One_Row(db,7,4,7);
        insert_One_Row(db,8,4,8);
        insert_One_Row(db,9,4,9);
        insert_One_Row(db,10,5,10);
        insert_One_Row(db,11,6,11);
        insert_One_Row(db,12,6,12);
//        insert_One_Row(db,13,7,3);

//        belum tentu
        insert_One_Row(db,13,7,13);

        insert_One_Row(db,14,8,14);
        insert_One_Row(db,15,8,15);
        insert_One_Row(db,16,8,16);
        insert_One_Row(db,17,12,20);
        insert_One_Row(db,18,12,21);
        insert_One_Row(db,19,12,22);
        insert_One_Row(db,20,13,23);
        insert_One_Row(db,21,13,24);
    }
}
