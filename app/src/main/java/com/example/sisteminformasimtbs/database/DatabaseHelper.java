package com.example.sisteminformasimtbs.database;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.BentukObat;
import com.example.sisteminformasimtbs.model.dataclass.Gejala;
import com.example.sisteminformasimtbs.model.dataclass.KlasifikasiPenyakit;
import com.example.sisteminformasimtbs.model.dataclass.LangkahTindakan;
import com.example.sisteminformasimtbs.model.dataclass.Obat;
import com.example.sisteminformasimtbs.model.dataclass.Tindakan;
import com.example.sisteminformasimtbs.model.dataclass.TopikPenyakit;
import com.example.sisteminformasimtbs.model.relation.GejalaMemilikiKlasifikasi;
import com.example.sisteminformasimtbs.model.relation.KlasifikasiMemilikiTindakan;
import com.example.sisteminformasimtbs.model.relation.ObatMemilikiBentukObat;
import com.example.sisteminformasimtbs.model.relation.TindakanMemilikiBentukObat;
import com.example.sisteminformasimtbs.testing.TindakanResult;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper{
//     get Main Activity
    private PemeriksaanMain activity;
    // Log cat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1 ;

    // DATABASE NAME
    private static final String DATABASE_NAME = "MTBS";



    // Nama-Nama Tabel
//    private static final String TABLE_BALITA = "balita";
//    private static final String TABLE_PROVINSI = "provinsi";
//    private static final String TABLE_KOTAKABUPATEN = "kotakabupaten";
//    private static final String TABLE_ENDEMIS = "endemis";

    // ALL RELATION TABLE NAME
//    private static final String TABLE_KUNJUNGAN_PENYAKIT = "kunjungan_penyakit";


    // COLUMN NAME TABLE - BALITA
//    private static final String COL_NAMABALITA = "namabalita";
//    private static final String COL_IDBALITA = "idbalita";
//    private static final String COL_NAMAIBU = "namaibu";
//    private static final String COL_ALAMAT = "alamat";
//    private static final String COL_JENISKELAMIN = "jeniskelamin";
//    private static final String COL_TANGGALLAHIR = "tanggallahir";
//    private static final String COL_UMUR = "umur";


    // COLUMN NAME TABLE - KUNJUNGAN
//    private static final String COL_IDKUNJUNGAN = "idkunjungan";
//    private static final String COL_TIPEKUNJUNGAN = "tipekunjungan";
//    private static final String COL_SUHU ="suhu";
//    private static final String COL_PANJANGBADAN = "panjangbadan";
//    private static final String COL_BERATBADAN = "beratbadan";
//    private static final String COL_TANGGALKUNJUNGAN =  "tanggalkunjungan";
//    private static final String COL_KUNJUNGANKE = "kunjunganke";
//    private static final String COL_KELUHAN = "keluhan";



    // COLUMN NAME TABLE - PROVINSI
//    private static final String COL_IDPROVINSI = "idprovinsi";
//    private static final String COL_NAMAPROVINSI = "namaprovinsi";

    // COLUMN NAME TABLE -  KOTAKABUPATEN
//    private static final String COL_IDKOTAKABUPATEN  = "idkotakabupaten";
//    private static final String COL_NAMAKOTAKABUPATEN = "namakotakabupaten";
    // FK DARI  COL provinsi

    // COLUMN NAME TABLE - ENDEMIS
//    private static final String COL_IDENDEMIS = "idendemis";
//    private static final String COL_JENISENDEMIS = "jenisendemis";


    // COLUMN NAME TABLE - KUNJUNGAN_PENYAKIT
//    private static final String COL_IDKUNJUNGANPENYAKIT =  "idkunjungan_penyakit";
    // fk dari idkunjungan
    // fk dari idpenyakit

    // id universal
    private static final String COL_ID = "id";






    //COLUMN NAME TABLE  OBAT_BENTUKOBAT
    // id universal
    // fk dari obat
    // fk dari jenis obat





    //CREATE TABLE-BALITA
//    private static final String CREATE_BALITA =
//                        "CREATE TABLE "+ TABLE_BALITA + "("
//                        + COL_NAMABALITA + " TEXT NOT NULL, "
//                        + COL_IDBALITA + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
//                        + COL_NAMAIBU + " TEXT NOT NULL,"
//                        + COL_ALAMAT + " TEXT NOT NULL,"
//                        + COL_JENISKELAMIN + " TEXT  NOT NULL,"
//                        + COL_TANGGALLAHIR + " DATE NOT NULL,"
//                        + COL_UMUR + " INTEGER NOT NULL"
//                        + ")";


    // CREATE TABLE-KUNJUNGAN
//    private static final String CREATE_KUNJUNGAN =
//                        "CREATE TABLE " + TABLE_KUNJUNGAN + "("
//                        + COL_IDKUNJUNGAN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
//                        + COL_TIPEKUNJUNGAN + " INTEGER NOT NULL ,"
//                        + COL_SUHU + " REAL NOT NULL ,"
//                        + COL_PANJANGBADAN + " REAL NOT NULL ,"
//                        + COL_BERATBADAN + " REAL NOT NULL ,"
//                        + COL_TANGGALKUNJUNGAN + " DATE NOT NULL,"
//                        + COL_KUNJUNGANKE + " INTEGER NOT NULL,"
//                        + COL_IDBALITA + " INTEGER NOT NULL"
//                        + ")";



//    private static final String CREATE_KOTAKABUPATEN =
//                        "CREATE TABLE " + TABLE_KOTAKABUPATEN + " ("
//                        + COL_IDKOTAKABUPATEN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
//                        + COL_NAMAKOTAKABUPATEN + " TEXT NOT NULL,"
//                        + COL_IDPROVINSI + " INTEGER NOT NULL"
//                        + " )";

//    private static final String CREATE_ENDEMIS =
//                        "CREATE TABLE " + TABLE_ENDEMIS + " ("
//                        + COL_IDENDEMIS + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
//                        + COL_JENISENDEMIS + " TEXT NOT NULL"
//                        + " )";

//    CREATE RELATION TABLE
//    private static final String CREATE_KUNJUNGAN_PENYAKIT =
//                        "CREATE TABLE " + TABLE_KUNJUNGAN_PENYAKIT + " ("
//                        + COL_IDKUNJUNGANPENYAKIT + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
//                        + COL_IDKUNJUNGAN + " INTEGER NOT NULL ,"
//                        + COL_IDPENYAKIT + " INTEGER NOT NULL"
//                        + ")";












    public DatabaseHelper(Context context , PemeriksaanMain activity ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.activity = activity;
        onUpgrade(this.getWritableDatabase(), DATABASE_VERSION , DATABASE_VERSION );

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        CREATE MAIN TABLE
//        sqLiteDatabase.execSQL(Balita.CREATE_BALITA);
//        sqLiteDatabase.execSQL(CREATE_KUNJUNGAN);
        sqLiteDatabase.execSQL(TopikPenyakit.CREATE_PENYAKIT);
        sqLiteDatabase.execSQL(KlasifikasiPenyakit.CREATE_KLASIFIKASI);
        sqLiteDatabase.execSQL(Gejala.CREATE_GEJALA);
        sqLiteDatabase.execSQL(Tindakan.CREATE_TINDAKAN);
        sqLiteDatabase.execSQL(LangkahTindakan.CREATE_LANGKAHTINDAKAN);
        sqLiteDatabase.execSQL(BentukObat.CREATE_BENTUKOBAT);
        sqLiteDatabase.execSQL(Obat.CREATE_OBAT);
//        sqLiteDatabase.execSQL(CREATE_PROVINSI);
//        sqLiteDatabase.execSQL(CREATE_KOTAKABUPATEN);
//        sqLiteDatabase.execSQL(CREATE_ENDEMIS);

        Log.d("DATABASE" , "MAIN TABLE CREATED");

//        CREATE RELATION TABLE -
//        sqLiteDatabase.execSQL(CREATE_KUNJUNGAN_PENYAKIT);
        sqLiteDatabase.execSQL(GejalaMemilikiKlasifikasi.CREATE_GEJ_KLAS);
        sqLiteDatabase.execSQL(KlasifikasiMemilikiTindakan.CREATE_KLAS_TIN);
        sqLiteDatabase.execSQL(TindakanMemilikiBentukObat.CREATE_TIN_BENTUKOBAT);
        sqLiteDatabase.execSQL(ObatMemilikiBentukObat.CREATE_OBAT_BENTUKOBAT);

        Log.d("DATABASE" , "RELATION TABLE CREATED");

//        call method to insert
        insertion();



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("DATABASE" , "RELATION TABLE DROPPED");

//        DROP IF EXISTS RELATION TABLE
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KUNJUNGAN_PENYAKIT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GejalaMemilikiKlasifikasi.TABLE_GEJ_KLAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + KlasifikasiMemilikiTindakan.TABLE_KLAS_TIN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TindakanMemilikiBentukObat.TABLE_TIN_BENTUKOBAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ObatMemilikiBentukObat.TABLE_OBAT_BENTUKOBAT);

        Log.d("DATABASE" , "MAIN TABLE DROPPED");


        // DROP IF EXISTS MAIN TABLE
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_BALITA);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KUNJUNGAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + KlasifikasiPenyakit.TABLE_KLASIFIKASIPENYAKIT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Gejala.TABLE_GEJALA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LangkahTindakan.TABLE_LANGKAHTINDAKAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tindakan.TABLE_TINDAKAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BentukObat.TABLE_BENTUKOBAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Obat.TABLE_OBAT);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PROVINSI);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KOTAKABUPATEN);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ENDEMIS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TopikPenyakit.TABLE_TOPIKPENYAKIT);

        // DROP IF EXIST


        onCreate(sqLiteDatabase);
    }

    private void insertion(){
        // insert data master single table
        SQLiteDatabase db = this.getWritableDatabase();
        TopikPenyakit.insert_All_Row(db);
        Gejala.insert_All_Row(db);
        KlasifikasiPenyakit.insert_All_Row(db);
        Tindakan.insert_All_Row(db);
        LangkahTindakan.insert_All_Row(db);

        //insert data master n TO n
        GejalaMemilikiKlasifikasi.insert_All_Row(db);
        KlasifikasiMemilikiTindakan.insert_All_Row(db);
    }

    public HashMap<String , Integer> getGejalaByIdTopik (int idTopik)
    {
        String query = "SELECT Gejala.idGejala, namaGejala FROM Gejala " +
                "INNER JOIN GejalaMemilikiKlasifikasi ON Gejala.idGejala = GejalaMemilikiKlasifikasi.idGejala " +
                "INNER JOIN Klasifikasi ON GejalaMemilikiKlasifikasi.idKlasifikasi = Klasifikasi.idKlasifikasi " +
                "WHERE idTopik = " + idTopik;

        Cursor c = this.getReadableDatabase().rawQuery(query, null);

        HashMap<String, Integer> hashMapGejala = new HashMap<>();

        while(c.moveToNext())
        {
            Integer idGejala = c.getInt(c.getColumnIndex("idGejala"));
            String namaGejala = c.getString(c.getColumnIndex("namaGejala"));

            hashMapGejala.put(namaGejala, idGejala);
        }

        return hashMapGejala ;
    }

    public LinkedList<TindakanResult> getTindakanByIdKlasifikasi(int idKlasifikasi){
        String query = "SELECT Tindakan.idTindakan, namaTindakan FROM Tindakan\n" +
                " INNER JOIN KlasifikasiMemilikiTindakan ON Tindakan.idTindakan = KlasifikasiMemilikiTindakan.idTindakan\n" +
                " WHERE idKlasifikasi = " + idKlasifikasi;


        Cursor c = this.getReadableDatabase().rawQuery(query, null);

        LinkedList<TindakanResult> listTindakan = new LinkedList<>();

        while(c.moveToNext())
        {
            Integer idTindakan = c.getInt(c.getColumnIndex("idTindakan"));
            String namaTindakan = c.getString(c.getColumnIndex("namaTindakan"));
            TindakanResult tindakanResult = new TindakanResult(idTindakan , namaTindakan);
            listTindakan.add(tindakanResult);
        }

        return listTindakan;
    }

    public ArrayList<String> getLangkahTindakanByTindakan(int idTindakan){
        String query = "SELECT idLangkahTindakan, namaLangkahTindakan FROM LangkahTindakan WHERE idtindakan =" + idTindakan ;

        Cursor c = this.getReadableDatabase().rawQuery(query, null);

        ArrayList<String> listTindakan = new ArrayList<String>();

        while(c.moveToNext())
        {
            String namaLangkahTindakan  =  c.getString(1);
            listTindakan.add(namaLangkahTindakan);
        }

        return listTindakan ;


    }
}