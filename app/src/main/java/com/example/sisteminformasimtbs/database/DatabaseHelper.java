package com.example.sisteminformasimtbs.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.BentukObat;
import com.example.sisteminformasimtbs.model.dataclass.Diagnosis;
import com.example.sisteminformasimtbs.model.dataclass.Gejala;
import com.example.sisteminformasimtbs.model.dataclass.KlasifikasiPenyakit;
import com.example.sisteminformasimtbs.model.dataclass.Kunjungan;
import com.example.sisteminformasimtbs.model.dataclass.LangkahTindakan;
import com.example.sisteminformasimtbs.model.dataclass.Obat;
import com.example.sisteminformasimtbs.model.dataclass.Tindakan;
import com.example.sisteminformasimtbs.model.dataclass.TopikPenyakit;
import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;
import com.example.sisteminformasimtbs.model.relation.GejalaMemilikiKlasifikasi;
import com.example.sisteminformasimtbs.model.relation.KlasifikasiMemilikiTindakan;
import com.example.sisteminformasimtbs.model.relation.ObatMemilikiBentukObat;
import com.example.sisteminformasimtbs.model.relation.TindakanMemilikiBentukObat;
import com.example.sisteminformasimtbs.model.dataclass.TindakanResult;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain_Activity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import static com.example.sisteminformasimtbs.model.dataclass.KlasifikasiPenyakit.COL_IDTOPIKPENYAKIT;


public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {
    // Log cat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1 ;

    // DATABASE NAME
    private static final String DATABASE_NAME = "MTBS";
    // transient will make the sqlite class
    private SQLiteDatabase mDefaultWritableDatabase = null;

    @Override
    public SQLiteDatabase getWritableDatabase() {
        final  SQLiteDatabase db;
        if(mDefaultWritableDatabase != null){
            db = mDefaultWritableDatabase;
        } else {
            db = super.getWritableDatabase();
        }
        return db;
    }


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

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        onUpgrade(this.getWritableDatabase(), DATABASE_VERSION , DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.mDefaultWritableDatabase = sqLiteDatabase;
//        CREATE MAIN TABLE
        sqLiteDatabase.execSQL(Balita.CREATE_BALITA_IF_EXISTS);
        sqLiteDatabase.execSQL(Kunjungan.CREATE_IF_EXISTS_KUNJUNGAN);
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
//        sqLiteDatabase.execSQL(Kunjungan.CREATE_KUNJUNGAN_PENYAKIT);
        sqLiteDatabase.execSQL(GejalaMemilikiKlasifikasi.CREATE_GEJ_KLAS);
        sqLiteDatabase.execSQL(KlasifikasiMemilikiTindakan.CREATE_KLAS_TIN);
        sqLiteDatabase.execSQL(TindakanMemilikiBentukObat.CREATE_TIN_BENTUKOBAT);
        sqLiteDatabase.execSQL(ObatMemilikiBentukObat.CREATE_OBAT_BENTUKOBAT);
        sqLiteDatabase.execSQL(Diagnosis.CREATE_IF_EXISTS_DIAGNOSIS_);

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
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Kunjungan.TABLE_KUNJUNGAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GejalaMemilikiKlasifikasi.TABLE_GEJ_KLAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + KlasifikasiMemilikiTindakan.TABLE_KLAS_TIN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TindakanMemilikiBentukObat.TABLE_TIN_BENTUKOBAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ObatMemilikiBentukObat.TABLE_OBAT_BENTUKOBAT);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Diagnosis.TABLE_DIAGNOSIS);

        Log.d("DATABASE" , "MAIN TABLE DROPPED");


        // DROP IF EXISTS MAIN TABLE
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Balita.TABLE_BALITA);
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

    public LinkedList<TindakanResult> getTindakanByIdKlasifikasi(int idKlasifikasi , int umur , double beratBadan){
        Log.d("umur", "umur : " + umur);

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
                namaTindakan += this.getObatByIdTindakan(idTindakan, beratBadan, umur);
                Log.d("obattttttt", "masukk");
                Log.d("obattttttt", "" + namaTindakan);
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



    public String getObatByIdTindakan (int idTindakan, double beratBadan, int umur){
//        get idBentukObat dari id tindakan
        String query = "SELECT BentukObat.idBentukObat, batasBawah, batasAtas, syarat, dosis, namaBentukObat, namaObat, pemberian " +
                "FROM TindakanMemilikiBentukObat " +
                "INNER JOIN BentukObat ON TindakanMemilikiBentukObat.idBentukObat = BentukObat.idBentukObat " +
                "INNER JOIN ObatMemilikiBentukObat ON BentukObat.idBentukObat = ObatMemilikiBentukObat.idBentukObat " +
                "INNER JOIN Obat ON ObatMemilikiBentukObat.idObat = Obat.idObat " +
                "WHERE idTindakan = " + idTindakan ;

        Cursor c = this.getReadableDatabase().rawQuery(query, null);

        int idBentukObat = 0;
        double nilai = 0;
        String listObat = "";
        String namaObat = "";
        int a = 0;

        while(c.moveToNext())
        {
            if (a == 0)
            {
                if (c.getString(3).equalsIgnoreCase("Berat badan"))
                {
                    nilai = beratBadan;
                    Log.d("typeeeeeeeeeeeeeee", "berat badan");
                }
                else if (c.getString(3).equalsIgnoreCase("Umur"))
                {
                    nilai = umur;
                }
                a++;
            }

            int batasBawah = c.getInt(1);
            int batasAtas = c.getInt(2);

//            cek apakah batas bawah dan atas nya sesuai apa ga
            if ( batasBawah <= nilai && nilai < batasAtas )
            {
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

    public LinkedList<Balita> getAllBalita(){
        LinkedList<Balita> allBalita  = new LinkedList<>();
        String query = "SELECT * FROM Balita" ;
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        Log.d("sizebalita" , "size balita dipanggil dari db select * from balita " + c.getCount());
        if(c.getCount() > 0){
            while(c.moveToNext()){
                // get data balita now
                int idBalitaNow = c.getInt(c.getColumnIndex("idbalita"));
                String namaBalitaNow= c.getString(c.getColumnIndex("namabalita"));
                String namaIbuNow = c.getString(c.getColumnIndex("namaibu"));
                String alamatNow = c.getString(c.getColumnIndex("alamat"));
                char jeniskelaminNow = c.getString(c.getColumnIndex("jeniskelamin")).charAt(0);
                String tanggalLahirNow = c.getString(c.getColumnIndex("tanggallahir"));
                char wilayahNow = c.getString(c.getColumnIndex("wilayah")).charAt(0);
                Balita balitaNow = new Balita(namaBalitaNow , idBalitaNow , namaIbuNow , alamatNow , jeniskelaminNow , tanggalLahirNow , wilayahNow);
                allBalita.add(balitaNow);
            }
        }
        return allBalita;
    }

    public Balita getBalita(String namaBalita , String  namaIbu){
        String query = "SELECT * FROM Balita WHERE namabalita = '" + namaBalita +"' AND namaibu = '"+ namaIbu + "'" ;
        int count = 0;
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        Balita balitaResult= null;
        if(c.getCount() > 0){
            while(c.moveToNext()){
                // get data balita now
                int idBalitaNow = c.getInt(c.getColumnIndex("idbalita"));
                String namaBalitaNow= c.getString(c.getColumnIndex("namabalita"));
                String namaIbuNow = c.getString(c.getColumnIndex("namaibu"));
                String alamatNow = c.getString(c.getColumnIndex("alamat"));
                char jeniskelaminNow = c.getString(c.getColumnIndex("jeniskelamin")).charAt(0);
                String tanggalLahirNow = c.getString(c.getColumnIndex("tanggallahir"));
                char wilayahNow = c.getString(c.getColumnIndex("wilayah")).charAt(0);
                balitaResult = new Balita(namaBalitaNow , idBalitaNow , namaIbuNow , alamatNow , jeniskelaminNow , tanggalLahirNow , wilayahNow);
                count++;
            }
        }
        return balitaResult;
    }

    public LinkedList<Balita> getBalitaLikeName(String keyword){
        String query = "SELECT * FROM Balita WHERE namabalita LIKE '%"+keyword+"%' " ;
        LinkedList<Balita> allBalita  = new LinkedList<>();
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        if(c.getCount() > 0){
            while(c.moveToNext()){
                // get data balita now
                int idBalitaNow = c.getInt(c.getColumnIndex("idbalita"));
                String namaBalitaNow= c.getString(c.getColumnIndex("namabalita"));
                String namaIbuNow = c.getString(c.getColumnIndex("namaibu"));
                String alamatNow = c.getString(c.getColumnIndex("alamat"));
                char jeniskelaminNow = c.getString(c.getColumnIndex("jeniskelamin")).charAt(0);
                String tanggalLahirNow = c.getString(c.getColumnIndex("tanggallahir"));
                char wilayahNow = c.getString(c.getColumnIndex("wilayah")).charAt(0);
                Balita balitaNow = new Balita(namaBalitaNow , idBalitaNow , namaIbuNow , alamatNow , jeniskelaminNow , tanggalLahirNow , wilayahNow);
                allBalita.add(balitaNow);
            }
        }
        return allBalita;


    }

    public Kunjungan getKunjungan(int idBalita , String tanggalKunjungan){
        String query = "SELECT * FROM KUNJUNGAN WHERE idBalita = "+ idBalita+" AND tanggalKunjungan='"+tanggalKunjungan + "'";
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        Kunjungan kunjunganResult = null;
        if(c.getCount() > 0){
            while(c.moveToNext()){

                int idKunjunganNow = c.getInt(c.getColumnIndex("idKunjungan"));
                String tanggalKunjunganNow = c.getString(c.getColumnIndex("tanggalKunjungan"));
                double beratBadanNow = c.getDouble(c.getColumnIndex("berat"));
                double panjangBadanNow = c.getDouble(c.getColumnIndex("panjang"));
                double suhuBadanNow = c.getDouble(c.getColumnIndex("suhu"));
                int kunjunganKe = c.getInt(c.getColumnIndex("kunjunganKe")) ;
                int tipeKunjungan = c.getInt(c.getColumnIndex("tipeKunjungan")) ;
                String keluhan = c.getString(c.getColumnIndex("keluhan"));
                int idBalitaNow = c.getInt(c.getColumnIndex("idBalita"));
                kunjunganResult = new Kunjungan(idKunjunganNow,tipeKunjungan , suhuBadanNow,panjangBadanNow,beratBadanNow,tanggalKunjungan,kunjunganKe,keluhan,idBalitaNow);
            }
        }

        return kunjunganResult;

    }

    /**
     *
     * @param idBalita
     * @return
     */
    public LinkedList<Kunjungan> getAllKunjunganBasedByBalitaId(int idBalita){
        LinkedList<Kunjungan> allKunjungan = new LinkedList<>() ;
        String query = "SELECT * FROM KUNJUNGAN WHERE idBalita = "+ idBalita+" ";
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        if(c.getCount() > 0){
            while(c.moveToNext()){
                int idKunjunganNow = c.getInt(c.getColumnIndex("idKunjungan"));
                String tanggalKunjunganNow = c.getString(c.getColumnIndex("tanggalKunjungan"));
                double beratBadanNow = c.getDouble(c.getColumnIndex("berat"));
                double panjangBadanNow = c.getDouble(c.getColumnIndex("panjang"));
                double suhuBadanNow = c.getDouble(c.getColumnIndex("suhu"));
                int kunjunganKe = c.getInt(c.getColumnIndex("kunjunganKe")) ;
                int tipeKunjungan = c.getInt(c.getColumnIndex("tipeKunjungan")) ;
                String keluhan = c.getString(c.getColumnIndex("keluhan"));
                int idBalitaNow = c.getInt(c.getColumnIndex("idBalita"));
                Kunjungan kunjunganNow = new Kunjungan(idKunjunganNow,tipeKunjungan , suhuBadanNow,panjangBadanNow,beratBadanNow,tanggalKunjunganNow,kunjunganKe,keluhan,idBalitaNow);
                allKunjungan.add(kunjunganNow);
            }
        }
        return allKunjungan;

    }

    /**
     *
     * @param idKunjungan
     */
    public LinkedList<Diagnosis> getAllKlasifikasiBasedByKunjunganId(int idKunjungan){
        LinkedList<Diagnosis> allDiagnosis = new LinkedList<>();
        String query = "SELECT * FROM DIAGNOSIS WHERE idKunjungan = "+ idKunjungan+" ";
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        if(c.getCount() > 0){
            while(c.moveToNext()){
                int idKunjunganNow = c.getInt(c.getColumnIndex("idKunjungan")) ;
                int idKlasifikasiNow = c.getInt(c.getColumnIndex("idKlasifikasi"));
                Diagnosis now = new Diagnosis(idKunjunganNow , idKlasifikasiNow);
                allDiagnosis.add(now);
            }
        }
        return allDiagnosis;

    }

    public DiagnosisResult getKlasifikasiBasedOnIdKlasifikasi(int idKlasifikasi){
        String query = "SELECT * FROM Klasifikasi WHERE idKlasifikasi = "+ idKlasifikasi+" ";
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        DiagnosisResult now = null;
        if(c.getCount() > 0){
            while(c.moveToNext()){
                int idKlasifikasiNow = c.getInt(c.getColumnIndex("idKlasifikasi")) ;
                String namaKlasifikasi = c.getString(c.getColumnIndex("namaKlasifikasi"));
                now = new DiagnosisResult(namaKlasifikasi , idKlasifikasiNow);
            }
        }
        return now;
    }

    public void checkTableIfExist(String tableName){
        String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+tableName+"'";
        Cursor c = this.getReadableDatabase().rawQuery(query , null);
        Log.d("tes" , "mantap");
        Log.d("exist", tableName + " size : " + c.getCount());
    }
}