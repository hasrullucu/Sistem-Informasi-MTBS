package com.example.sisteminformasimtbs.model.relation;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.BentukObat;
import com.example.sisteminformasimtbs.model.dataclass.Obat;
import com.example.sisteminformasimtbs.model.dataclass.Tindakan;

public class TindakanMemilikiBentukObat {
    private int id; // id universal
    private int idTindakan; // id Tindakan
    private int idBentukObat; // id bentuk obat
    private int batasBawah; // batas bawah dari tabel syarat umur
    private int batasAtas; // batas atas dari tabel syarat umur
    private String syarat;
    private String dosis;

    public static final String TABLE_TIN_BENTUKOBAT = "TindakanMemilikiBentukObat";

    // COLUMN NAME TABLE - TINDAKAN_BENTUKOBAT
    private static final String COL_ID = "id"; // id universal
    private static final String COL_BATASBAWAH = "batasBawah";
    private static final String COL_BATASATAS = "batasAtas";
    private static final String COL_SYARAT = "syarat";
    private static final String COL_DOSIS = "dosis";

    public static final String CREATE_TIN_BENTUKOBAT = "create table "+ TABLE_TIN_BENTUKOBAT
            +" ("
            + COL_ID + " int primary key, "
            + Tindakan.COL_IDTINDAKAN + " int, "
            + BentukObat.COL_IDBENTUKOBAT + " int, "
            + COL_BATASBAWAH + " int, "
            + COL_BATASATAS + " int, "
            + COL_SYARAT + " varchar(255), "
            + COL_DOSIS + " varchar(255), "
            +   "      foreign key (idTindakan) references Tindakan (idTindakan), "
            +   "      foreign key (idBentukObat) references BentukObat (idBentukObat)"
            +");";

    public TindakanMemilikiBentukObat(int id, int idTindakan, int idBentukObat, int batasBawah, int batasAtas, String syarat, String dosis) {
        this.id = id;
        this.idTindakan = idTindakan;
        this.idBentukObat = idBentukObat;
        this.batasBawah = batasBawah;
        this.batasAtas = batasAtas;
        this.syarat = syarat;
        this.dosis = dosis;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    public int getIdBentukObat() {
        return idBentukObat;
    }

    public void setIdBentukObat(int idBentukObat) {
        this.idBentukObat = idBentukObat;
    }

    public int getBatasBawah() {
        return batasBawah;
    }

    public void setBatasBawah(int batasBawah) {
        this.batasBawah = batasBawah;
    }

    public int getBatasAtas() {
        return batasAtas;
    }

    public void setBatasAtas(int batasAtas) {
        this.batasAtas = batasAtas;
    }

    public String getSyarat() {
        return syarat;
    }

    public void setSyarat(String syarat) {
        this.syarat = syarat;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    private static long insert_One_Row(SQLiteDatabase db, int id, int idTindakan, int idBentukObat,
                                       int batasBawah, int batasAtas, String syarat, String dosis){
        ContentValues res = new ContentValues();

        res.put(COL_ID, id);
        res.put(Tindakan.COL_IDTINDAKAN, idTindakan);
        res.put(BentukObat.COL_IDBENTUKOBAT, idBentukObat);
        res.put(COL_BATASBAWAH, batasBawah);
        res.put(COL_BATASATAS, batasAtas);
        res.put(COL_SYARAT, syarat);
        res.put(COL_DOSIS, dosis);

        long ret = db.insert(TABLE_TIN_BENTUKOBAT, null , res);
        Log.d("in_query_lang" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db ){
        //insert bentuk obat diazepam
        insert_One_Row(db, 1,1,1,5,7,"Berat badan","0.5 ml");
        insert_One_Row(db, 2,1,1,7,10,"Berat badan","1 ml");
        insert_One_Row(db, 3,1,1,10,14,"Berat badan","1.5 ml");
        insert_One_Row(db, 4,1,1,14,19,"Berat badan","2 ml");
        insert_One_Row(db, 5,1,2,0,10,"Berat badan","5 mg");
        insert_One_Row(db, 6,1,2,10,100,"Berat badan","10 mg");
        insert_One_Row(db, 7,8,3,4,6,"Berat badan","1/2");
        insert_One_Row(db, 8,8,3,6,10,"Berat badan","3/4");
        insert_One_Row(db, 9,8,3,10,16,"Berat badan","1 1/4");
        insert_One_Row(db, 10,8,3,16,19,"Berat badan","1 1/2");
        insert_One_Row(db, 11,8,4,4,6,"Berat badan","10 ml");
        insert_One_Row(db, 12,8,4,6,10,"Berat badan","15 ml");
        insert_One_Row(db, 13,8,4,10,16,"Berat badan","25 ml");
        insert_One_Row(db, 14,8,4,16,19,"Berat badan","30 ml");
        insert_One_Row(db, 15,8,5,4,6,"Berat badan","5 ml");
        insert_One_Row(db, 16,8,5,6,10,"Berat badan","7.5 ml");
        insert_One_Row(db, 17,8,5,10,16,"Berat badan","10 ml");
        insert_One_Row(db, 18,8,5,16,19,"Berat badan","12.5 ml");
        insert_One_Row(db, 19,9,3,4,6,"Berat badan","1/2");
        insert_One_Row(db, 20,9,3,6,10,"Berat badan","3/4");
        insert_One_Row(db, 21,9,3,10,16,"Berat badan","1 1/4");
        insert_One_Row(db, 22,9,3,16,19,"Berat badan","1 1/2");
        insert_One_Row(db, 23,9,4,4,6,"Berat badan","10 ml");
        insert_One_Row(db, 24,9,4,6,10,"Berat badan","15 ml");
        insert_One_Row(db, 25,9,4,10,16,"Berat badan","25 ml");
        insert_One_Row(db, 26,9,4,16,19,"Berat badan","30 ml");
        insert_One_Row(db, 27,9,5,4,6,"Berat badan","5 ml");
        insert_One_Row(db, 28,9,5,6,10,"Berat badan","7.5 ml");
        insert_One_Row(db, 29,9,5,10,16,"Berat badan","10 ml");
        insert_One_Row(db, 30,9,5,16,19,"Berat badan","12.5 ml");
        insert_One_Row(db, 31,17,6,6,10,"Berat badan","1/2");
        insert_One_Row(db, 32,17,6,10,19,"Berat badan","1");
        insert_One_Row(db, 33,17,7,4,6,"Berat badan","1/4");
        insert_One_Row(db, 34,17,7,6,10,"Berat badan","1/2");
        insert_One_Row(db, 35,17,7,10,19,"Berat badan","1");
        insert_One_Row(db, 36,17,8,4,6,"Berat badan","1");
        insert_One_Row(db, 37,17,8,6,10,"Berat badan","2");
        insert_One_Row(db, 38,17,8,10,19,"Berat badan","3");
        insert_One_Row(db, 39,17,9,4,6,"Berat badan","2.5 ml");
        insert_One_Row(db, 40,17,9,6,10,"Berat badan","5 ml");
        insert_One_Row(db, 41,17,9,10,19,"Berat badan","10 ml");
        insert_One_Row(db, 42,24,10,4,6,"Berat badan","1");
        insert_One_Row(db, 43,24,10,6,10,"Berat badan","2");
        insert_One_Row(db, 44,24,10,10,16,"Berat badan","2 1/2");
        insert_One_Row(db, 45,24,10,16,19,"Berat badan","3");
        insert_One_Row(db, 46,24,11,4,6,"Berat badan","1/16");
        insert_One_Row(db, 47,24,11,6,10,"Berat badan","1/8");
        insert_One_Row(db, 48,24,11,10,16,"Berat badan","1/4");
        insert_One_Row(db, 49,24,11,16,19,"Berat badan","1/2");
        insert_One_Row(db, 50,24,12,4,6,"Berat badan","0.5 ml");
        insert_One_Row(db, 51,24,12,6,10,"Berat badan","1 ml");
        insert_One_Row(db, 52,24,12,10,16,"Berat badan","2 ml");
        insert_One_Row(db, 53,24,12,16,19,"Berat badan","3 ml");

//        insert_One_Row(db, 54,24,3,4,6,"Berat badan","1/8 tab");
//        insert_One_Row(db, 55,24,3,6,10,"Berat badan","1/4 tab");
//        insert_One_Row(db, 56,24,3,10,16,"Berat badan","1/2 tab");
//        insert_One_Row(db, 57,24,3,16,19,"Berat badan","3/4 tab");

//        belum pasti
        insert_One_Row(db, 54,24,13,4,6,"Berat badan","1/8 tab");
        insert_One_Row(db, 55,24,13,6,10,"Berat badan","1/4 tab");
        insert_One_Row(db, 56,24,13,10,16,"Berat badan","1/2 tab");
        insert_One_Row(db, 57,24,13,16,19,"Berat badan","3/4 tab");

        insert_One_Row(db, 58,26,14,4,7,"Berat badan","1/8");
        insert_One_Row(db, 59,26,14,7,14,"Berat badan","1/4");
        insert_One_Row(db, 60,26,14,14,19,"Berat badan","1/2");
        insert_One_Row(db, 61,26,15,4,7,"Berat badan","1/2");
        insert_One_Row(db, 62,26,15,7,14,"Berat badan","1");
        insert_One_Row(db, 63,26,15,14,19,"Berat badan","2");
        insert_One_Row(db, 64,26,16,4,7,"Berat badan","2.5 ml (1/2 sdk takar)");
        insert_One_Row(db, 65,26,16,7,14,"Berat badan","5 ml (1 sdk takar)");
        insert_One_Row(db, 66,26,16,14,19,"Berat badan","7.5 ml (1 1/2 sdk takar)");
        insert_One_Row(db, 67,40,14,4,7,"Berat badan","1/8");
        insert_One_Row(db, 68,40,14,7,14,"Berat badan","1/4");
        insert_One_Row(db, 69,40,14,14,19,"Berat badan","1/2");
        insert_One_Row(db, 70,40,15,4,7,"Berat badan","1/2");
        insert_One_Row(db, 71,40,15,7,14,"Berat badan","1");
        insert_One_Row(db, 72,40,15,14,19,"Berat badan","2");
        insert_One_Row(db, 73,40,16,4,7,"Berat badan","2.5 ml (1/2 sdk takar)");
        insert_One_Row(db, 74,40,16,7,14,"Berat badan","5 ml (1 sdk takar)");
        insert_One_Row(db, 75,40,16,14,19,"Berat badan","7.5 ml (1 1/2 sdk takar)");
        insert_One_Row(db, 76,66,20,4,6,"Berat badan","1/4");
        insert_One_Row(db, 77,66,20,6,10,"Berat badan","1/2");
        insert_One_Row(db, 78,66,20,10,16,"Berat badan","2/3");
        insert_One_Row(db, 79,66,20,16,19,"Berat badan","3/4");
        insert_One_Row(db, 80,66,21,4,6,"Berat badan","5 ml");
        insert_One_Row(db, 81,66,21,6,10,"Berat badan","10 ml");
        insert_One_Row(db, 82,66,21,10,16,"Berat badan","12.5 ml");
        insert_One_Row(db, 83,66,21,16,19,"Berat badan","15 ml");
        insert_One_Row(db, 84,66,22,4,6,"Berat badan","2.5 ml");
        insert_One_Row(db, 85,66,22,6,10,"Berat badan","5 ml");
        insert_One_Row(db, 86,66,22,10,16,"Berat badan","7.5 ml");
        insert_One_Row(db, 87,66,22,16,19,"Berat badan","10 ml");
        insert_One_Row(db, 88,57,23,7,10,"Berat badan","1/4");
        insert_One_Row(db, 89,57,23,10,19,"Berat badan","1/2");
        insert_One_Row(db, 90,57,24,7,10,"Berat badan","2.5 ml (1/2 sendok takar)");
        insert_One_Row(db, 91,57,24,10,19,"Berat badan","5 ml (1 sendok takar)");
        insert_One_Row(db, 92,41,20,4,6,"Berat badan","1/4");
        insert_One_Row(db, 93,41,20,6,10,"Berat badan","1/2");
        insert_One_Row(db, 94,41,20,10,16,"Berat badan","2/3");
        insert_One_Row(db, 95,41,20,16,19,"Berat badan","3/4");
        insert_One_Row(db, 96,41,21,4,6,"Berat badan","5 ml");
        insert_One_Row(db, 97,41,21,6,10,"Berat badan","10 ml");
        insert_One_Row(db, 98,41,21,10,16,"Berat badan","12.5 ml");
        insert_One_Row(db, 99,41,21,16,19,"Berat badan","15 ml");
        insert_One_Row(db, 100,41,22,4,6,"Berat badan","2.5 ml");
        insert_One_Row(db, 101,41,22,6,10,"Berat badan","5 ml");
        insert_One_Row(db, 102,41,22,10,16,"Berat badan","7.5 ml");
        insert_One_Row(db, 103,41,22,16,19,"Berat badan","10 ml");
    }
}
