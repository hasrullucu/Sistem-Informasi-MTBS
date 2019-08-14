package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class LangkahTindakan {
    private int idLangkahTindakan ;
    private String keterangan ;
    // fk dari tindakan
    private int idTindakan;


    public static final String TABLE_LANGKAHTINDAKAN = "langkahTindakan";


    // COLUMN NAME TABLE - LANGKAHTINDAKAN
    private static final String COL_IDLANGKAHTINDAKAN = "idlangkahtindakan";
    private static final String COL_KETERANGAN  = "keterangan";
    private static final String COL_IDTINDAKAN = "idTindakan";

    public static final String CREATE_LANGKAHTINDAKAN = "create table "+ TABLE_LANGKAHTINDAKAN
            +" ( "
            +   COL_IDLANGKAHTINDAKAN + "  int primary key, "
            +   COL_KETERANGAN+ " varchar(255), "
            +   COL_IDTINDAKAN + " int,"
            +"      foreign key(idTindakan) references Tindakan (idTindakan)"
            + " );";


    public LangkahTindakan(int idLangkahTindakan, String keterangan, int idTindakan) {
        this.idLangkahTindakan = idLangkahTindakan;
        this.keterangan = keterangan;
        this.idTindakan = idTindakan;
    }

    public int getIdLangkahTindakan() {
        return idLangkahTindakan;
    }

    public void setIdLangkahTindakan(int idLangkahTindakan) {
        this.idLangkahTindakan = idLangkahTindakan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    private static long insert_One_Row(SQLiteDatabase db, int idLangkahTindakan , String keterangan , int idTindakan){
        ContentValues res = new ContentValues();

        res.put(COL_IDLANGKAHTINDAKAN , idLangkahTindakan);
        res.put(COL_KETERANGAN , keterangan);
        res.put(COL_IDTINDAKAN , idTindakan);

        long ret = db.insert(TABLE_LANGKAHTINDAKAN, null , res);
        Log.d("in_query_lang" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db ){
        // langkah tindakan Tanda Bahaya Umum id = 1
        insert_One_Row(db ,1 , "Miringkan anak dan berishkan jalan napas. Jangan masukkan apapun ke dalam mulut anak",1 );
        insert_One_Row(db , 2, "Berikan 0,5mg/kg diazepam cairan injeksi per rektal menggunakan syringe kecil 1 cc tanpa jarum (seperti syringe tuber kulin)\n" +
                "atau dengan menggunakan kateter",1);
        insert_One_Row(db ,3 ,"Periksa gula darah, lalu lakukan tatalaksana atau cegah agar tidak turun", 1);
        insert_One_Row(db , 4 , "Beri oksigen dan RUJUK" , 1);
        insert_One_Row(db , 5 , "Jika kejang tidak berhenti setelah 5 menit ulangi dosis dizepam(maksimal 2 kali)",1);
        insert_One_Row(db , 6, "Jika kejang belum teratasi, dapat diberikan fenitoin 20mg/kg IV yang dilarutkan dengan NaCL 0,9%", 1);

        // langkah tindakan Tanda Bahaya Umum id = 4
        insert_One_Row(db , 7 , "Jika anak masih bisa menyusu Mintalah kepada ibu untuk menyusui anaknya",4);
        insert_One_Row(db , 8, "Jika anak tidak bisa menyusu tapi masih bisa menelan Beri perahan ASI atau susu formula / air gula", 4);
        insert_One_Row(db , 9 , "Jika anak tidak bisa menelan beri 50ml susu formula / air gula melalui pipa orogastrik" , 4);
        insert_One_Row(db , 10 , "Jika tidak tersedia pipa orogastrik, RUJUK SEGERA" , 4);

    }


}
