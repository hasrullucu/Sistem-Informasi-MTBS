package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Gejala {
    public static final String TABLE_GEJALA = "gejala";
    //COLUMN NAME TABLE - GEJALA
    public static final String COL_IDGEJALA = "idGejala";
    public static final String COL_NAMAGEJALA = "namaGejala";
    public static final String CREATE_GEJALA = "create table "+ TABLE_GEJALA
            + "("
            + COL_IDGEJALA+" int primary key, "
            + COL_NAMAGEJALA+" varchar(255)  "
            + ");";
    private int idGejala ;
    private String namaGejala ;

    private static long insert_One_Row(SQLiteDatabase db, int idGejala , String namaGejala ){
        ContentValues res = new ContentValues();

        res.put(COL_IDGEJALA , idGejala);
        res.put(COL_NAMAGEJALA , namaGejala);

        long ret = db.insert(TABLE_GEJALA , null , res);
        Log.d("insert_query_gejala" , ret+"");
        return ret;
    }

    public static long insert_All_Row(SQLiteDatabase db){
        // gejala Tanda Bahaya umum
        insert_One_Row(db , 1 , "Tidak Bisa Minum Atau Menyusu ?");
        insert_One_Row(db , 2 , "Memuntahkan semua makanan dan atau minuman");
        insert_One_Row(db , 3 , "Pernah atau sedang mengalami kejang ?");
        insert_One_Row(db , 4 , "Gelisah ?");
        insert_One_Row(db , 5 , "Letargis atau Tidak Sadar ?");
        insert_One_Row(db , 6 , "Ada stridor ?");
        insert_One_Row(db , 7 , "Tampak Biru(sianosis) ?");
        insert_One_Row(db , 8 , "Ujung tangan dan kaki balita pucat dan dingin ?");

        //insert batuk atau sukar bernapas
        insert_One_Row(db, 9,"Tarikan dinding dada ke dalam");
        insert_One_Row(db, 10,"Saturasi Oksigen < 90%");
        insert_One_Row(db, 11,"Napas cepat");
        insert_One_Row(db, 12,"Tidak ada tanda-tanda Pneumonia Berat maupun Pneumonia");

        //diare
        insert_One_Row(db, 13,"Mata cekung");
        insert_One_Row(db, 14,"Tidak bisa minum atau malas minum");
        insert_One_Row(db, 15,"Cubitan kulit perut kembali sangat lambat");
        insert_One_Row(db, 16,"Rewel / mudah marah");
        insert_One_Row(db, 17,"Haus, minum dengan lahap");
        insert_One_Row(db, 18,"Cubitan kulit perut kembali lambat");
        insert_One_Row(db, 19,"Tidak cukup tanda-tanda untuk diklasifikasikan sebagai diare dehidrasi berat atau ringan/sedang");
        insert_One_Row(db, 20,"Tanpa dehidrasi");
        insert_One_Row(db, 21,"Diare 14 hari atau lebih");
        insert_One_Row(db, 22,"Ada darah dalam tinja");
        insert_One_Row(db, 70,"Dengan dehidrasi");

        //fragment_fragmentdemam1
        insert_One_Row(db, 23,"Ada tanda bahaya umum");
        insert_One_Row(db, 24,"Kaku kuduk");
        insert_One_Row(db, 25,"Demam (pada anamnesis atau teraba panas atau suhu ≥ 37,5 °C)");
        insert_One_Row(db, 26,"Mikroskopis positif atau RDT positif");
        insert_One_Row(db, 27,"Mikroskopis negatif atau RDT negatif");
        insert_One_Row(db, 28,"Ditemukan penyebab lain dari demam");
        insert_One_Row(db, 29,"Usia ≤ 3 bulan");
        insert_One_Row(db, 30,"Tidak ada tanda bahaya umum");
        insert_One_Row(db, 31,"Tidak ada kaku kuduk");
        insert_One_Row(db, 32,"Adanya kekeruhan pada kornea mata");
        insert_One_Row(db, 33,"Ada luka di mulut yang dalam atau luas");
        insert_One_Row(db, 34,"Ada nanah pada mata");
        insert_One_Row(db, 35,"Ada luka pada mulut");
        insert_One_Row(db, 36,"Ada tanda tanda syok");
        insert_One_Row(db, 37,"Nyeri ulu hati");
        insert_One_Row(db, 38,"Muntah-muntah");
        insert_One_Row(db, 39,"Perdarahan (kulit/hidung/BAB)");
        insert_One_Row(db, 40,"Uji torniket positif");
        insert_One_Row(db, 41,"Demam mendadak tinggi dan terus menerus");
        insert_One_Row(db, 42,"Bintik-bintik perdarahan di kulit negatif");
        insert_One_Row(db, 43,"Uji torniket negatif");
        insert_One_Row(db, 44,"Tidak ada satupun gejala di atas");

        //masalah telinga
        insert_One_Row(db, 45,"Pembengkakan yang nyeri di belakang telinga");
        insert_One_Row(db, 46,"Nyeri telinga");
        insert_One_Row(db, 47,"Rasa penuh di telinga");
        insert_One_Row(db, 48,"Tampak cairan/nanah keluar dari telinga selama kurang dari 14 hari");
        insert_One_Row(db, 49,"Tampak cairan/nanah keluar dari telinga dan telah terjadi selama 14 hari atau lebih");
        insert_One_Row(db, 50,"Tidak ada nyeri telinga DAN tidak ada nanah keluar dari telinga");

        //status gizi
        insert_One_Row(db, 51,"Terlihat sangat kurus");
        insert_One_Row(db, 52,"Endema pada kedua punggung kaki");
        insert_One_Row(db, 53,"BB/PP (TB) < -3 SD");
        insert_One_Row(db, 54,"LiLA  < 11,5 cm");
        insert_One_Row(db, 55,"Klasifikasi berat");
        insert_One_Row(db, 56,"Masalah pemberian ASI pada umur < 6 bulan");
        insert_One_Row(db, 57,"BB/PB (TB) - 3 SD sampai - 2 SD");
        insert_One_Row(db, 58,"LiLA 11,5 cm - 12,5 cm");
        insert_One_Row(db, 59,"BB/PB (TB) ≥ - 2 SD");
        insert_One_Row(db, 60,"LiLA ≥ 12,5 cm");
        insert_One_Row(db, 61,"Telapak tangan sangat pucat");
        insert_One_Row(db, 62,"Telapak tangan agak pucat");
        insert_One_Row(db, 63,"Tidak ditemukan tanda kepucatan pada telapak tangan");

        //status HIV
        insert_One_Row(db, 64,"Tes HIV anak positif");
        insert_One_Row(db, 65,"Ibu HIV positif atau riwayat kematian orang tua atau saudara kandung yang didiagnosis HIV atau dengan gejala klinis AIDS");
        insert_One_Row(db, 66,"Ibu HIV positif");
        insert_One_Row(db, 67,"Anak dari ibu dengan HIV, masih mendapat ASI");
        insert_One_Row(db, 68,"Anak dari ibu dengan HIV, status HIV anak tidak diketahui");
        insert_One_Row(db, 69,"Tes HIV pada ibu atau anak negatif");

         return 1;
    }

    public int getIdGejala() {
        return idGejala;
    }

    public void setIdGejala(int idGejala) {
        this.idGejala = idGejala;
    }

    public String getNamaGejala() {
        return namaGejala;
    }

    public void setNamaGejala(String namaGejala) {
        this.namaGejala = namaGejala;
    }
}
