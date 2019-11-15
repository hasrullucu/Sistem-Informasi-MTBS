package com.example.sisteminformasimtbs.database;

import android.content.ContentValues;
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
import com.example.sisteminformasimtbs.model.dataclass.TindakanResult;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain_Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import static com.example.sisteminformasimtbs.model.dataclass.KlasifikasiPenyakit.COL_IDTOPIKPENYAKIT;


public class DatabaseHelper extends SQLiteOpenHelper{
//     get Main Activity
    private PemeriksaanMain_Activity activity;
    // Log cat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1 ;

    // DATABASE NAME
    private static final String DATABASE_NAME = "MTBS";

    @Override
    public SQLiteDatabase getWritableDatabase() {
        final SQLiteDatabase db;
        if(mDefaultWritableDatabase != null){
            db = mDefaultWritableDatabase;
        } else {
            db = super.getWritableDatabase();
        }
        return db;
    }

    //
    private SQLiteDatabase mDefaultWritableDatabase = null;

    // Nama-Nama Tabel
//    private static final String TABLE_BALITA = "balita";
//    private static final String TABLE_PROVINSI = "provinsi";
//    private static final String TABLE_KOTAKABUPATEN = "kotakabupaten";
//    private static final String TABLE_ENDEMIS = "endemis";

    // ALL RELATION TABLE NAME
//    private static final String TABLE_KUNJUNGAN_PENYAKIT = "kunjungan_penyakit";



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

    public DatabaseHelper(Context context , PemeriksaanMain_Activity activity ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.activity = activity;
        onUpgrade(this.getWritableDatabase(), DATABASE_VERSION , DATABASE_VERSION );


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.mDefaultWritableDatabase = sqLiteDatabase;
//        CREATE MAIN TABLE

        sqLiteDatabase.execSQL(Balita.CREATE_BALITA);
//        sqLiteDatabase.execSQL(CREATE_KUNJUNGAN);
        sqLiteDatabase.execSQL(TopikPenyakit.CREATE_PENYAKIT);
        sqLiteDatabase.execSQL(KlasifikasiPenyakit.CREATE_KLASIFIKASI);
        sqLiteDatabase.execSQL(Gejala.CREATE_GEJALA);
        sqLiteDatabase.execSQL(Tindakan.CREATE_TINDAKAN);
        sqLiteDatabase.execSQL(LangkahTindakan.CREATE_LANGKAHTINDAKAN);
        sqLiteDatabase.execSQL(Obat.CREATE_OBAT);
        sqLiteDatabase.execSQL(BentukObat.CREATE_BENTUKOBAT);

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
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.mDefaultWritableDatabase = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        this.mDefaultWritableDatabase = sqLiteDatabase;
        Log.d("DATABASE" , "RELATION TABLE DROPPED");

//        DROP IF EXISTS RELATION TABLE
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KUNJUNGAN_PENYAKIT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GejalaMemilikiKlasifikasi.TABLE_GEJ_KLAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + KlasifikasiMemilikiTindakan.TABLE_KLAS_TIN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TindakanMemilikiBentukObat.TABLE_TIN_BENTUKOBAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ObatMemilikiBentukObat.TABLE_OBAT_BENTUKOBAT);

        Log.d("DATABASE" , "MAIN TABLE DROPPED");


        // DROP IF EXISTS MAIN TABLE
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Balita.TABLE_BALITA);
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
        BentukObat.insert_All_Row(db);
        Obat.insert_All_Row(db);

        //insert data master n TO n
        GejalaMemilikiKlasifikasi.insert_All_Row(db);
        KlasifikasiMemilikiTindakan.insert_All_Row(db);
        TindakanMemilikiBentukObat.insert_All_Row(db);
        ObatMemilikiBentukObat.insert_All_Row(db);
    }

    public HashMap<String , Integer> getGejalaByIdTopik (int idTopik)
    {
        String query = "SELECT Gejala.idGejala, namaGejala FROM Gejala " +
                "INNER JOIN GejalaMemilikiKlasifikasi ON Gejala.idGejala = GejalaMemilikiKlasifikasi.idGejala " +
                "INNER JOIN Klasifikasi ON GejalaMemilikiKlasifikasi.idKlasifikasi = Klasifikasi.idKlasifikasi " +
                "WHERE idTopik = " + idTopik + " ORDER BY Gejala.idGejala ASC";

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
        String query = "SELECT Tindakan.idTindakan, namaTindakan, tipeTindakan FROM Tindakan\n" +
                " INNER JOIN KlasifikasiMemilikiTindakan ON Tindakan.idTindakan = KlasifikasiMemilikiTindakan.idTindakan\n" +
                " WHERE idKlasifikasi = " + idKlasifikasi;

        Cursor c = this.getReadableDatabase().rawQuery(query, null);

        LinkedList<TindakanResult> listTindakan = new LinkedList<>();

        while(c.moveToNext())
        {
            Integer idTindakan = c.getInt(c.getColumnIndex("idTindakan"));
            String namaTindakan = c.getString(c.getColumnIndex("namaTindakan"));

            if (c.getInt(c.getColumnIndex("tipeTindakan")) == 3 || c.getInt(c.getColumnIndex("tipeTindakan")) == 2)
            {
                namaTindakan += this.getObatByIdTindakan(idTindakan);
            }

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


    public String getObatByIdTindakan (int idTindakan){
//        get idBentukObat dari id tindakan
        String query = "SELECT BentukObat.idBentukObat, batasBawah, batasAtas, syarat, dosis, namaBentukObat, namaObat, pemberian " +
                "FROM TindakanMemilikiBentukObat " +
                "INNER JOIN BentukObat ON TindakanMemilikiBentukObat.idBentukObat = BentukObat.idBentukObat " +
                "INNER JOIN ObatMemilikiBentukObat ON BentukObat.idBentukObat = ObatMemilikiBentukObat.idBentukObat " +
                "INNER JOIN Obat ON ObatMemilikiBentukObat.idObat = Obat.idObat " +
                "WHERE idTindakan = " + idTindakan ;

        Cursor c = this.getReadableDatabase().rawQuery(query, null);

        int idBentukObat = 0;
        int nilai = 0;
        String listObat = "";
        String namaObat = "";

        while(c.moveToNext())
        {
            if (idBentukObat == 0)
            {
                int beratBadan = 12;
                int umur = 4; //dalam bulan

                if (c.getString(3).equalsIgnoreCase("Berat badan"))
                {
                    nilai = beratBadan;
                }
                else if (c.getString(3).equalsIgnoreCase("Umur"))
                {
                    nilai = umur;
                }
            }

            int batasBawah = c.getInt(1);
            int batasAtas = c.getInt(2);

//            Log.d("bawah, atas, jenis", "" + batasBawah + " " + batasAtas + " " + c.getString(5));

//            cek apakah batas bawah dan atas nya sesuai apa ga
            if ( batasBawah <= nilai && nilai < batasAtas )
            {
//                Log.d("msdukk if tulis ke list" , "asasasasa");

                String namaBentukObat = c.getString(5);
                String pemberian = c.getString(7);
                String dosis = c.getString(4);

                if (listObat.length() == 0 || !c.getString(6).equalsIgnoreCase(namaObat))
                {
                    namaObat = c.getString(6);
                    listObat +=  "\n\n" + namaObat + " : " + pemberian + " \n" + namaBentukObat + " -> " + dosis;
                }
                else
                {
                    listObat += "\n" + namaBentukObat + " -> " + dosis;
                }
            }
        }

        return listObat ;
    }

    public void getBalita(){
        String query = "SELECT * FROM Balita" ;
        int count = 0;
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        while(c.moveToNext()){
            count++;
        }

        Log.d("databalita" , "Data balita : " + count) ;
    }

    public void insertDataKunjungan ()
    {

    }

//    public void insert
}