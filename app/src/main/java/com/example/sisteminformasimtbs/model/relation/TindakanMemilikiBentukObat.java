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
    }
}
