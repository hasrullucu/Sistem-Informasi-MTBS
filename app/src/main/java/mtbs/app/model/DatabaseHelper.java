package mtbs.app.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import mtbs.app.MainActivity;

public class DatabaseHelper extends SQLiteOpenHelper{
    // get Main Activity
    private MainActivity activity;
    // Log cat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1 ;

    // DATABASE NAME
    private static final String DATABASE_NAME = "MTBS";



    // Nama-Nama Tabel
    private static final String TABLE_BALITA = "balita";
    private static final String TABLE_KUNJUNGAN = "kunjungan";
    private static final String TABLE_PENYAKIT  = "penyakit";
    private static final String TABLE_KLASIFIKASI = "klasifikasi";
    private static final String TABLE_GEJALA = "gejala";
    private static final String TABLE_TINDAKAN = "tindakan";
    private static final String TABLE_LANGKAHTINDAKAN = "langkahTindakan";
    private static final String TABLE_JENISOBAT = "jenisObat";
    private static final String TABLE_OBAT = "obat";
    private static final String TABLE_PROVINSI = "provinsi";
    private static final String TABLE_KOTAKABUPATEN = "kotakabupaten";
    private static final String TABLE_ENDEMIS = "endemis";

    // ALL RELATION TABLE NAME
    private static final String TABLE_KUNJUNGAN_PENYAKIT = "kunjungan_penyakit";
    private static final String TABLE_KLASIFIKASI_GEJALA = "klasifikasi_gejala";
    private static final String TABLE_KLASIFIKASI_TINDAKAN = "klasifikasi_tindakan";
    private static final String TABLE_TINDAKAN_JENISOBAT = "tindakan_jenisobat";
    private static final String TABLE_OBAT_JENISOBAT = "obat_jenisobat";


    // COLUMN NAME TABLE - BALITA
    private static final String COL_NAMABALITA = "namabalita";
    private static final String COL_IDBALITA = "idbalita";
    private static final String COL_NAMAIBU = "namaibu";
    private static final String COL_ALAMAT = "alamat";
    private static final String COL_JENISKELAMIN = "jeniskelamin";
    private static final String COL_TANGGALLAHIR = "tanggallahir";
    private static final String COL_UMUR = "umur";


    // COLUMN NAME TABLE - KUNJUNGAN
    private static final String COL_IDKUNJUNGAN = "idkunjungan";
    private static final String COL_TIPEKUNJUNGAN = "tipekunjungan";
    private static final String COL_SUHU ="suhu";
    private static final String COL_PANJANGBADAN = "panjangbadan";
    private static final String COL_BERATBADAN = "beratbadan";
    private static final String COL_TANGGALKUNJUNGAN =  "tanggalkunjungan";
    private static final String COL_KUNJUNGANKE = "kunjunganke";
    private static final String COL_KELUHAN = "keluhan";
    // fk dari id balita

    //COLUMN NAME TABLE - PENYAKIT
    private static final String COL_IDPENYAKIT = "idpenyakit";
    private static final String COL_NAMAPENYAKIT = "namaPenyakit";


    //COLUMN NAME TABLE - KLASIFIKASI
    private static final String COL_IDKLASIFIKASI = "idklasifikasi";
    private static final String COL_NAMAKLASIFIKASI =  "namaklasifikasi";
    private static final String COL_JUMLAHGEJALA = "jumlahgejala";
    // fk dari idpenyakit

//    COLUMN NAME TABLE - GEJALA
    private static final String COL_IDGEJALA = "idgejala";
    private static final String COL_NAMAGEJALA = "namagejala";

    // COLUMN NAME TABLE - TINDAKAN
    private static final String COL_IDTINDAKAN ="idtindakan";
    private static final String COL_TINDAKAN = "tindakan" ;
    private static final String COL_TIPETINDAKAN = "tipetindakan";
    private static final String COL_PEMBERIAN = "pemberian";


    // COLUMN NAME TABLE - LANGKAHTINDAKAN
    private static final String COL_IDLANGKAHTINDAKAN = "idlangkahtindakan";
    private static final String COL_KETERANGAN  = "keterangan";
    // fk dari tindakan

    // COLUMN NAME TABLE - JENISOBAT
    private static final String COL_IDJENISOBAT  = "idjenisobat";
    private static final String COL_NAMAJENISOBAT = "namajenisobat";
    private static final String COL_DOSIS =  "dosis";
    private static final String COL_SATUAN = "satuan";

    // COLUMN NAME TABLE - OBAT
    private static final String COL_IDOBAT =  "idobat";
    private static final String COL_NAMAOBAT =  "namaobat";

    // COLUMN NAME TABLE - PROVINSI
    private static final String COL_IDPROVINSI = "idprovinsi";
    private static final String COL_NAMAPROVINSI = "namaprovinsi";

    // COLUMN NAME TABLE -  KOTAKABUPATEN
    private static final String COL_IDKOTAKABUPATEN  = "idkotakabupaten";
    private static final String COL_NAMAKOTAKABUPATEN = "namakotakabupaten";
    // FK DARI  COL provinsi

    // COLUMN NAME TABLE - ENDEMIS
    private static final String COL_IDENDEMIS = "idendemis";
    private static final String COL_JENISENDEMIS = "jenisendemis";


    // COLUMN NAME TABLE - KUNJUNGAN_PENYAKIT
    private static final String COL_IDKUNJUNGANPENYAKIT =  "idkunjungan_penyakit";
    // fk dari idkunjungan
    // fk dari idpenyakit

    //COLUMN NAME TABLE - KLASIFIKASI_GEJALA
    private static final String COL_IDKLASIFIKASI_GEJALA  = "idklasifikasi_gejala";
    // fk dari klasifikasi
    // fk dari gejala

    //COLUMN NAME TABLE - KLASIFIKASI_TINDAKAN
    private static final String COL_IDKLASIFIKASI_TINDAKAN = "idklasifikasi_tindakan";
    // fk dari klasifikasi
    // fk dari tindakan

    // COLUMN NAME TABLE - TINDAKAN_JENISOBAT
    private static final String COL_IDTINDAKAN_JENISOBAT = "idtindakan_jenisobat";
    // fk dari tindakan
    // fk dari jenisobat

    //COLUMN NAME TABLE  OBAT_JENISOBAT
    private static final String COL_IDOBAT_JENISOBAT = "idobat_jenisobat";
    // fk dari obat
    // fk dari jenis obat





    //CREATE TABLE-BALITA
    private static final String CREATE_BALITA =
                        "CREATE TABLE "+ TABLE_BALITA + "("
                        + COL_NAMABALITA + " TEXT NOT NULL, "
                        + COL_IDBALITA + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_NAMAIBU + " TEXT NOT NULL,"
                        + COL_ALAMAT + " TEXT NOT NULL,"
                        + COL_JENISKELAMIN + " TEXT  NOT NULL,"
                        + COL_TANGGALLAHIR + " DATE NOT NULL,"
                        + COL_UMUR + " INTEGER NOT NULL"
                        + ")";


    // CREATE TABLE-KUNJUNGAN
    private static final String CREATE_KUNJUNGAN =
                        "CREATE TABLE " + TABLE_KUNJUNGAN + "("
                        + COL_IDKUNJUNGAN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_TIPEKUNJUNGAN + " INTEGER NOT NULL ,"
                        + COL_SUHU + " REAL NOT NULL ,"
                        + COL_PANJANGBADAN + " REAL NOT NULL ,"
                        + COL_BERATBADAN + " REAL NOT NULL ,"
                        + COL_TANGGALKUNJUNGAN + " DATE NOT NULL,"
                        + COL_KUNJUNGANKE + " INTEGER NOT NULL,"
                        + COL_IDBALITA + " INTEGER NOT NULL"
                        + ")";

   //  CREATE TABLE-KUNJUNGAN
    private static final String CREATE_PENYAKIT =
                        "CREATE TABLE " + TABLE_PENYAKIT + "("
                        + COL_IDPENYAKIT + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_NAMAPENYAKIT + " TEXT NOT NULL"
                        + ")";


    private static final String CREATE_KLASIFIKASI =
                        "CREATE TABLE " + TABLE_KLASIFIKASI + "("
                        + COL_IDKLASIFIKASI + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_NAMAKLASIFIKASI + " TEXT NOT NULL,"
                        + COL_JUMLAHGEJALA + " INTEGER NOT NULL,"
                        + COL_IDPENYAKIT + " INTEGER NOT NULL"
                        + " )";

    private static final String CREATE_GEJALA =
                        "CREATE TABLE " + TABLE_GEJALA + " ("
                        + COL_IDGEJALA + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,"
                        + COL_NAMAGEJALA + " TEXT NOT NULL "
                        + " )";


    private static final String CREATE_TINDAKAN =
                        "CREATE TABLE " + TABLE_TINDAKAN + "("
                        + COL_IDTINDAKAN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_TINDAKAN+ " TEXT NOT NULL, "
                        + COL_TIPETINDAKAN + " INTEGER NOT NULL,"
                        + COL_PEMBERIAN + " TEXT"
                        + " )";

    private static final String CREATE_LANGKAHTINDAKAN =
                        "CREATE TABLE " + TABLE_LANGKAHTINDAKAN + "("
                        + COL_IDLANGKAHTINDAKAN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                        + COL_KETERANGAN + " TEXT ,"
                        + COL_IDTINDAKAN + " INTEGER NOT NULL"
                        + ")";

    private static final String CREATE_JENISOBAT  =
                        "CREATE TABLE " + TABLE_JENISOBAT + " ("
                        + COL_IDJENISOBAT + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                        + COL_NAMAJENISOBAT + " TEXT NOT NULL,"
                        + COL_DOSIS + " REAL NOT NULL,"
                        + COL_SATUAN + " TEXT NOT NULL"
                        + " )";

    private static final String CREATE_OBAT =
                        "CREATE TABLE " + TABLE_OBAT + " ("
                        + COL_IDOBAT + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_NAMAOBAT + " TEXT NOT NULL "
                        +" )";

    private static final String CREATE_PROVINSI =
                        "CREATE TABLE " + TABLE_PROVINSI + " ("
                        + COL_IDPROVINSI + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_NAMAPROVINSI + " TEXT NOT NULL "
                        + " )";

    private static final String CREATE_KOTAKABUPATEN =
                        "CREATE TABLE " + TABLE_KOTAKABUPATEN + " ("
                        + COL_IDKOTAKABUPATEN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_NAMAKOTAKABUPATEN + " TEXT NOT NULL,"
                        + COL_IDPROVINSI + " INTEGER NOT NULL"
                        + " )";

    private static final String CREATE_ENDEMIS =
                        "CREATE TABLE " + TABLE_ENDEMIS + " ("
                        + COL_IDENDEMIS + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_JENISENDEMIS + " TEXT NOT NULL"
                        + " )";

//    CREATE RELATION TABLE
    private static final String CREATE_KUNJUNGAN_PENYAKIT =
                        "CREATE TABLE " + TABLE_KUNJUNGAN_PENYAKIT + " ("
                        + COL_IDKUNJUNGANPENYAKIT + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                        + COL_IDKUNJUNGAN + " INTEGER NOT NULL ,"
                        + COL_IDPENYAKIT + " INTEGER NOT NULL"
                        + ")";

    private static final String CREATE_KLASIFIKASI_GEJALA =
                        "CREATE TABLE " + TABLE_KLASIFIKASI_GEJALA + " ("
                        + COL_IDKLASIFIKASI_GEJALA + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_IDKLASIFIKASI + " INTEGER NOT NULL,"
                        + COL_IDGEJALA + " INTEGER NOT NULL"
                        + " )";

    private static final String CREATE_KLASIFIKASI_TINDAKAN =
                        "CREATE TABLE " + TABLE_KLASIFIKASI_TINDAKAN + " ("
                        + COL_IDKLASIFIKASI_TINDAKAN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_IDKLASIFIKASI + " INTEGER NOT NULL,"
                        + COL_IDTINDAKAN + " INTEGER NOT NULL"
                        + " )";

    private static final String CREATE_TINDAKAN_JENISOBAT =
                        "CREATE TABLE " + TABLE_TINDAKAN_JENISOBAT + " ("
                        + COL_IDTINDAKAN_JENISOBAT + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_IDTINDAKAN + " INTEGER NOT NULL,"
                        + COL_IDJENISOBAT + " INTEGER NOT NULL"
                        + " )";

    private static final String CREATE_OBAT_JENISOBAT =
                        "CREATE TABLE " + TABLE_OBAT_JENISOBAT + " ("
                        + COL_IDOBAT_JENISOBAT + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                        + COL_IDOBAT + " INTEGER NOT NULL,"
                        + COL_IDJENISOBAT + " INTEGER NOT NULL"
                        + " )";




    public DatabaseHelper(Context context , MainActivity activity ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.activity = activity;
        onUpgrade(this.getWritableDatabase(), DATABASE_VERSION , DATABASE_VERSION );

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        CREATE MAIN TABLE
        sqLiteDatabase.execSQL(CREATE_BALITA);
        sqLiteDatabase.execSQL(CREATE_KUNJUNGAN);
        sqLiteDatabase.execSQL(CREATE_PENYAKIT);
        sqLiteDatabase.execSQL(CREATE_KLASIFIKASI);
        sqLiteDatabase.execSQL(CREATE_GEJALA);
        sqLiteDatabase.execSQL(CREATE_TINDAKAN);
        sqLiteDatabase.execSQL(CREATE_LANGKAHTINDAKAN);
        sqLiteDatabase.execSQL(CREATE_JENISOBAT);
        sqLiteDatabase.execSQL(CREATE_OBAT);
        sqLiteDatabase.execSQL(CREATE_PROVINSI);
        sqLiteDatabase.execSQL(CREATE_KOTAKABUPATEN);
        sqLiteDatabase.execSQL(CREATE_ENDEMIS);

        Log.d("DATABASE" , "MAIN TABLE CREATED");

//        CREATE RELATION TABLE -
        sqLiteDatabase.execSQL(CREATE_KUNJUNGAN_PENYAKIT);
        sqLiteDatabase.execSQL(CREATE_KLASIFIKASI_GEJALA);
        sqLiteDatabase.execSQL(CREATE_KLASIFIKASI_TINDAKAN);
        sqLiteDatabase.execSQL(CREATE_TINDAKAN_JENISOBAT);
        sqLiteDatabase.execSQL(CREATE_OBAT_JENISOBAT);

        Log.d("DATABASE" , "RELATION TABLE CREATED");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("DATABASE" , "RELATION TABLE DROPPED");

//        DROP IF EXISTS RELATION TABLE
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KUNJUNGAN_PENYAKIT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KLASIFIKASI_GEJALA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KLASIFIKASI_TINDAKAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TINDAKAN_JENISOBAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_OBAT_JENISOBAT);

        Log.d("DATABASE" , "MAIN TABLE DROPPED");


        // DROP IF EXISTS MAIN TABLE
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_BALITA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KUNJUNGAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PENYAKIT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KLASIFIKASI);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GEJALA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TINDAKAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LANGKAHTINDAKAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_JENISOBAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_OBAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PROVINSI);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KOTAKABUPATEN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ENDEMIS);

        // DROP IF EXIST


        onCreate(sqLiteDatabase);
    }
}
