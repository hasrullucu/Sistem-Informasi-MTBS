package mtbs.app.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
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
    private static final String COL = "";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
