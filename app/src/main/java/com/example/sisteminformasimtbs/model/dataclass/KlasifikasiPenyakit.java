package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class KlasifikasiPenyakit {

   private int idKlasifikasi;
   private String namaKlasifikasi ;
   private int syaratMinimal ;
   private int idTopikPenyakit ;
    private int tingkat;

   // NAMA TABEL
   public static final String TABLE_KLASIFIKASIPENYAKIT = "Klasifikasi";

    //COLUMN NAME TABLE - KLASIFIKASI
    public static final String COL_IDKLASIFIKASIPENYAKIT = "idKlasifikasi";
    public static final String COL_NAMAKLASIFIKASI =  "namaKlasifikasi";
    public static final String COL_SYARATMINIMAL = "syaratMinimal";
    public static final String COL_IDTOPIKPENYAKIT = "idTopik";
    public static final String COL_TINGKAT = "tingkat";

    public static final String CREATE_KLASIFIKASI = " create table "+ TABLE_KLASIFIKASIPENYAKIT
            +" ("
            +  COL_IDKLASIFIKASIPENYAKIT+" int primary key,"
            +  COL_NAMAKLASIFIKASI+"  varchar(255),"
            +  COL_SYARATMINIMAL+ " int,"
            +  COL_IDTOPIKPENYAKIT+ " int,"
            +  COL_TINGKAT+ " int,"
            +     "  foreign key (idTopik) references TopikPenyakit (idTopik)"
            +  ");" ;

    public int getIdKlasifikasi() {
        return idKlasifikasi;
    }

    public void setIdKlasifikasi(int idKlasifikasi) {
        this.idKlasifikasi = idKlasifikasi;
    }

    public String getNamaKlasifikasi() {
        return namaKlasifikasi;
    }

    public void setNamaKlasifikasi(String namaKlasifikasi) {
        this.namaKlasifikasi = namaKlasifikasi;
    }

    public int getSyaratMinimal() {
        return syaratMinimal;
    }

    public void setSyaratMinimal(int syaratMinimal) {
        this.syaratMinimal = syaratMinimal;
    }

    public int getIdTopikPenyakit() {
        return idTopikPenyakit;
    }

    public void setIdTopikPenyakit(int idTopikPenyakit) {
        this.idTopikPenyakit = idTopikPenyakit;
    }

    public int getTingkat() {
        return tingkat;
    }

    public void setTingkat(int tingkat) {
        this.tingkat = tingkat;
    }

    public KlasifikasiPenyakit(int idKlasifikasi, String namaKlasifikasi, int syaratMinimal, int idTopikPenyakit, int tingkat) {
        this.idKlasifikasi = idKlasifikasi;
        this.namaKlasifikasi = namaKlasifikasi;
        this.syaratMinimal = syaratMinimal;
        this.idTopikPenyakit = idTopikPenyakit;
        this.tingkat = tingkat;
    }

    private static  long insert_One_Row(SQLiteDatabase db, int idKlasifikasi, String namaKlasifikasi , int syaratMinimal , int idTopikPenyakit, int tingkat ){
        ContentValues res = new ContentValues();

        res.put(COL_IDKLASIFIKASIPENYAKIT , idKlasifikasi);
        res.put(COL_NAMAKLASIFIKASI , namaKlasifikasi);
        res.put(COL_SYARATMINIMAL, syaratMinimal);
        res.put(COL_IDTOPIKPENYAKIT, idTopikPenyakit);
        res.put(COL_TINGKAT, tingkat);

        long ret = db.insert(TABLE_KLASIFIKASIPENYAKIT ,null , res);
        Log.d("in_q_klasifikasi", ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db){
        insert_One_Row(db, 1 , "PENYAKIT SANGAT BERAT", 1 ,1, 1);

        insert_One_Row(db, 2,"PNEUMONIA BERAT",1,2,1);
        insert_One_Row(db, 3,"PNEUMONIA",1,2,2);
        insert_One_Row(db, 4,"BATUK BUKAN PNEUMONIA",1,2,3);
        insert_One_Row(db, 5,"DIARE DEHIDRASI BERAT",2,3,1);
        insert_One_Row(db, 6,"DIARE DEHIDRASI RINGAN / SEDANG",2,3,2);
        insert_One_Row(db, 7,"DIARE TANPA DEHIDRASI",1,3,3);
        insert_One_Row(db, 8,"DIARE PERSISTEN",2,3,2);
        insert_One_Row(db, 9,"DISENTRI",2,3,2);
        insert_One_Row(db, 10,"PENYAKIT BERAT DENGAN DEMAM",1,4,1);
        insert_One_Row(db, 11,"MALARIA",2,4,2);
        insert_One_Row(db, 12,"DEMAM MUNGKIN BUKAN MALARIA",1,4,3);
        insert_One_Row(db, 13,"PENYAKIT BERAT DENGAN DEMAM",1,4,1);
        insert_One_Row(db, 14,"DEMAM BUKAN MALARIA",2,4,3);
        insert_One_Row(db, 15,"CAMPAK DENGAN KOMPLIKASI BERAT",1,4,1);
        insert_One_Row(db, 16,"CAMPAK DENGAN KOMPLIKASI PADA MATA DAN/ATAU MULUT",1,4,2);
        insert_One_Row(db, 17,"DEMAM BERDARAH DENGUE (DBD)",1,4,1);
        insert_One_Row(db, 18,"MUNGKIN DBD",1,4,2);
        insert_One_Row(db, 19,"DEMAM MUNGKIN BUKAN DBD",1,4,3);
        insert_One_Row(db, 20,"MASTOIDITIS",1,5,1);
        insert_One_Row(db, 21,"INFEKSI TELINGA AKUT",1,5,2);
        insert_One_Row(db, 22,"INFEKSI TELINGA KRONIS",1,5,2);
        insert_One_Row(db, 23,"TIDAK ADA INFEKSI TELINGA",1,5,3);
        insert_One_Row(db, 24,"SANGAT KURUS DENGAN KOMPLIKASI",2,6,1);
        insert_One_Row(db, 25,"SANGAT KURUS TANPA KOMPLIKASI",1,6,2);
        insert_One_Row(db, 26,"KURUS",1,6,2);
        insert_One_Row(db, 27,"GIZI NORMAL",1,6,3);
        insert_One_Row(db, 28,"ANEMIA BERAT",1,7,1);
        insert_One_Row(db, 29,"ANEMIA",1,7,2);
        insert_One_Row(db, 30,"TIDAK ANEMIA",1,7,3);
        insert_One_Row(db, 31,"INFEKSI HIV TERKONFIRMASI",1,8,1);
        insert_One_Row(db, 32,"DIDUGA TERINFEKSI HIV",1,8,1);
        insert_One_Row(db, 33,"TERPAJAN HIV",1,8,1);
        insert_One_Row(db, 34,"MUNGKIN BUKAN INFEKSI HIV",1,8,3);
        insert_One_Row(db, 35,"DIARE PERSISTEN",2,3,1);
        insert_One_Row(db, 36,"CAMPAK",1,4,3);
    }
}
