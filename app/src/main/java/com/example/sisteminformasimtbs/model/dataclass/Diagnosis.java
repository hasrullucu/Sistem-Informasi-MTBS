package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Diagnosis {
    private int idKunjungan ;
    private int idKlasifikasi ;

    //     COLUMN NAME TABLE - BALITA
    private static final String COL_ID = "id";
    private static final String COL_IDKUNJUNGAN = "idKunjungan";
    private static final String COL_IDKLASIFIKASI = "idKlasifikasi";

    // TABLE_NAME Balita
    public static final String TABLE_DIAGNOSIS  = "Diagnosis";

    //    CREATE Table balita
    public static final String CREATE_IF_EXISTS_DIAGNOSIS_=
            "CREATE TABLE IF NOT EXISTS "+ TABLE_DIAGNOSIS + "("
                    + COL_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + COL_IDKUNJUNGAN + " INTEGER NOT NULL,"
                    + COL_IDKLASIFIKASI + " INTEGER NOT NULL"
                    + ")";

    public int getIdKunjungan() {
        return idKunjungan;
    }

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }

    public Diagnosis(int idKunjungan, int idKlasifikasi) {
        this.idKunjungan = idKunjungan;
        this.idKlasifikasi = idKlasifikasi;
    }

    public static long insertDiagnosis(SQLiteDatabase db, int idKunjungan, int idKlasifikasi){
        ContentValues res = new ContentValues();

        res.put(COL_IDKUNJUNGAN, idKunjungan);
        res.put(COL_IDKLASIFIKASI , idKlasifikasi) ;

        long ret = db.insert(TABLE_DIAGNOSIS , null , res);
        Log.d("insertDiagnosisID : ", ret+" ");
        return ret;
    }
}
