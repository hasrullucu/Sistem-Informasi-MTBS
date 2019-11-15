package com.example.sisteminformasimtbs.model.dataclass;

import android.content.ContentValues;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Tindakan {
    private int idTindakan ;
    private String namaTindakan ;
    private int tipeTindakan;

    // tabel Tindakan
    public static final String TABLE_TINDAKAN = "Tindakan";

    // COLUMN NAME TABLE - TINDAKAN
    public static final String COL_IDTINDAKAN ="idTindakan";
    public static final String COL_NAMATINDAKAN= "namaTindakan" ;
    public static final String COL_TIPETINDAKAN = "tipeTindakan";


    public static final String CREATE_TINDAKAN = "create table "+ TABLE_TINDAKAN
            +"("
            + COL_IDTINDAKAN +" int primary key, "
            + COL_NAMATINDAKAN +" varchar(255), "
            + COL_TIPETINDAKAN+" int"
            +");";

    public Tindakan(int idTindakan, String namaTindakan, int tipeTindakan) {
        this.idTindakan = idTindakan;
        this.namaTindakan = namaTindakan;
        this.tipeTindakan = tipeTindakan;
    }

    public int getIdTindakan() {
        return idTindakan;
    }

    public void setIdTindakan(int idTindakan) {
        this.idTindakan = idTindakan;
    }

    public String getNamaTindakan() {
        return namaTindakan;
    }

    public void setNamaTindakan(String namaTindakan) {
        this.namaTindakan = namaTindakan;
    }

    public int getTipeTindakan() {
        return tipeTindakan;
    }

    public void setTipeTindakan(int tipeTindakan) {
        this.tipeTindakan = tipeTindakan;
    }

    private static long insert_One_Row(SQLiteDatabase db ,int idTindakan , String namaTindakan , int tipeTindakan){
        ContentValues res = new ContentValues();

        res.put(COL_IDTINDAKAN , idTindakan);
        res.put(COL_NAMATINDAKAN , namaTindakan);
        res.put(COL_TIPETINDAKAN , tipeTindakan);

        long ret = db.insert(TABLE_TINDAKAN , null , res);
        Log.d("in_query_tin" , ret+"");
        return ret;
    }

    public static void insert_All_Row(SQLiteDatabase db){
//        tipe tindakan :
//        0 -> ga ada langkah tindakan
//        1 -> ada langkah tindakan
//        2 -> ada obat
//        3 -> ada langkah tindakan dan obat

        insert_One_Row(db , 1 , "Bila sedang kejang beri diazepam" , 3);
        insert_One_Row(db , 2 , "Bila ada stridor pastikan tidak ada sumbatan jalan napas",0);
        insert_One_Row(db , 3,"Bila ada stridor, sianosis dan ujung tangan dan kaki pucat dan dingin berikan oksigen 3-5 liter/\n" +
                "menit melalui nasal prong dengan perangkat oksigen standar (tabung oksigen dan humidifier)", 0);
        insert_One_Row(db , 4, "Cegah agar gula darah tidak turun", 1);
        insert_One_Row(db , 5 , "Jaga anak tetap hangat" , 0);
        insert_One_Row(db , 6 , "RUJUK SEGERA" , 0);

        //batuk
        insert_One_Row(db, 7,"Beri Oksigen maksimal 2-3 liter/menit dengan menggunakan nasal prong",0);
        insert_One_Row(db, 8,"Beri dosis pertama antibiotik yang sesuai",2);
        insert_One_Row(db, 9,"Beri amoksisilin 2X sehari selama 3 hari atau 5 hari",2);
        insert_One_Row(db, 10,"Beri pelega tenggorokan dan pereda batuk yang aman",0);
        insert_One_Row(db, 11,"Obati wheezing bila ada",1);
        insert_One_Row(db, 12,"Apabila batuk ≥ 14 hari RUJUK untuk pemeriksaan lanjutan",0);
        insert_One_Row(db, 13,"Nasehati kapan kembali segera",0);
        insert_One_Row(db, 14,"Kunjungan ulang 2 hari",0);
        // diare
        insert_One_Row(db, 15,"Jika tidak ada klasifikasi berat lain : beri cairan untuk dehidrasi berat dan tablet Zinc sesuai rencana terapi C",1);
        insert_One_Row(db, 16,"Jika anak juga mempunyai klasifikasi berat lain : RUJUK SEGERA dan jika masih bisa minum, berikan ASI dan larutan oralit selama perjalanan",0);
        insert_One_Row(db, 17,"Jika anak > 2 tahun dan ada wabah kolera di daerah tersebut, beri antibiotik untuk kolera",2);
        insert_One_Row(db, 18,"Beri cairan, tablet Zinc dan makanan sesuai Rencana Terapi B",1);
        insert_One_Row(db, 19,"Kunjungan ulang 3 hari jika tidak ada perbaikan",0);
        insert_One_Row(db, 20,"Beri cairan, tablet Zinc dan makanan sesuai Rencana Terapi A",1);
        insert_One_Row(db, 21,"Atasi dehidrasi sebelum dirujuk, kecuali ada klasifikasi berat lain",0);
        insert_One_Row(db, 22,"Nasihati pemberian makan untuk Diare Persisten",1);
        insert_One_Row(db, 23,"Beri tablet Zinc selama 10 hari berturut-turut",0);
        insert_One_Row(db, 24,"Beri antibiotik yang sesuai",2);
        // demam
        insert_One_Row(db, 25,"Beri dosis pertama artemeter injeksi atau kinin injeksi untuk malaria berat",0);
        insert_One_Row(db, 26,"Berikan satu dosis parasetamol untuk demam ≥ 38,5 °C",2);
        insert_One_Row(db, 27,"Beri obat anti malaria oral pilihan pertama",0);
        insert_One_Row(db, 28,"Jika demam berlanjut lebih dari 7 hari, RUJUK untuk penilaian lebih lanjut",0);
        insert_One_Row(db, 29,"Obati penyebab lain dari demam",0);
        insert_One_Row(db, 30,"Beri vitamin A dosis pengobatan",2);
        insert_One_Row(db, 31,"Jika ada kekeruhan pada kornea atau nanah pada mata berikan salep mata antibiotik",0);
        insert_One_Row(db, 32,"Jika ada nanah pada mata, beri salep mata antibiotik",0);
        insert_One_Row(db, 33,"Jika ada luka pada mulut oleskan antiseptik mulut",0);
        insert_One_Row(db, 34,"Jika anak Gizi Sangat Kurus beri vitamin A sesuai dosis",0);
        insert_One_Row(db, 35,"Jika ada syok, beri Oksigen 2-4 liter/menit dan beri segera cairan intravena sesuai petunjuk",0);
        insert_One_Row(db, 36,"Jika tidak ada syok tapi sering muntah atau malas minum, beri cairan infus Ringer Laktat/Ringer Asetat, jumlah cairan rumatan",0);
        insert_One_Row(db, 37,"Jika tidak ada syok, tidak muntah dan masih mau minum, beri oralit atau cairan lain sebanyak mungkin dalam perjalanan ke rumah sakit",0);
        insert_One_Row(db, 38,"Beri dosis pertama parasetamol, jika demam tinggi (≥ 38,5 ° C), tidak boleh golongan salisilat dan ibuprofen",0);
        insert_One_Row(db, 39,"Kunjungan ulang 1 hari",0);
        // masalah telinga
        insert_One_Row(db, 40,"Beri dosis pertama parasetamol untuk mengatasi nyeri",2);
        insert_One_Row(db, 41,"Beri antibiotik yang sesuai selama 7 hari",2);
        insert_One_Row(db, 42,"Keringkan telinga dengan bahan penyerap setelah dicuci dengan NaCl 0,9% atau H O 3%.",1);
        insert_One_Row(db, 43,"Kunjungan ulang 5 hari",0);
        insert_One_Row(db, 44,"Beri tetes telinga yang sesuai",1);
        insert_One_Row(db, 45,"Tangani masalah telinga yang ditemukan",0);
        // status gizi
        insert_One_Row(db, 46,"Beri vitamin A dosis pertama",0);
        insert_One_Row(db, 47,"Beri antibiotik yang sesuai selama 5 hari",0);
        insert_One_Row(db, 48,"RUJUK untuk penanganan gizi sangat kurus termasuk kemungkinan adanya penyakit penyerta",0);
        insert_One_Row(db, 49,"Kunjungan ulang 7 hari",0);
        insert_One_Row(db, 50,"Lakukan Penilaian Pemberian Makan pada anak dan nasihati sesuai “Anjuran Makan Untuk Anak Sehat Maupun Sakit”. Bila ada masalah pemberian makan, kunjungan ulang 7 hari.",0);
        insert_One_Row(db, 51,"RUJUK untuk penilaianan kemungkinan adanya penyakit penyerta ( Infeksi TB dll)",0);
        insert_One_Row(db, 52,"Kunjungan ulang 30 hari.",0);
        insert_One_Row(db, 53,"Jika anak berumur kurang dari 2 tahun, lakukan penilaian pemberian makan dan nasihati sesuai “Anjuran Makan untuk Anak Sehat Maupun Sakit”. Bila ada masalah pemberian makan, kunjungan ulang 7 hari",0);
        insert_One_Row(db, 54,"Anjurkan untuk menimbang berat badan anak setiap bulan",0);
        // anemia
        insert_One_Row(db, 55,"Bila masih menyusu, teruskan pemberian ASI",0);
        insert_One_Row(db, 56,"Lakukan Penilaian Pemberian Makan pada anak.",2);
        insert_One_Row(db, 71,"Bila ada masalah, beri konseling pemberian makan dan kunjungan ulang 7 hari", 2);
        insert_One_Row(db, 57,"Beri zat besi",2);
        insert_One_Row(db, 58,"Lakukan pemeriksaan tinja untuk deteksi kecacingan",0);
        insert_One_Row(db, 59,"Jika daerah Endemis Tinggi Malaria: periksa dan obati malaria terlebih dahulu jika positif.",0);
        insert_One_Row(db, 60,"Kunjungan ulang 14 hari",0);
        insert_One_Row(db, 61,"Jika anak < 2 tahun : ",2);
        // status hiv
        insert_One_Row(db, 62,"Rujuk ke puskesmas/RS Rujukan ARV untuk mendapatkan terapi ARV dan Kotrimoksasol profilaksis",2);
        insert_One_Row(db, 63,"Rujuk ke puskesmas / RS Rujukan ARV untuk mendapatkan pemeriksaan lebih lanjut dan terapi ARV dan Kotrimoksasol profilaksis",2);
        insert_One_Row(db, 64,"Rujuk ke puskesmas / RS Rujukan ARV untuk mendapatkan pemeriksaan lebih lanjut dan ARV profilaksis serta Kotrimoksasol profilaksis",2);
        insert_One_Row(db, 65,"Tangani infeksi yang ada",0);


        insert_One_Row(db, 66,"Beri dosis pertama antibiotik yang sesuai",2);
        insert_One_Row(db, 67,"Beri vitamin A dosis pengobatan",2);
        insert_One_Row(db, 68,"Beri vitamin A dosis pengobatan",2);
        insert_One_Row(db, 69,"Beri dosis pertama antibiotik yang sesuai", 0);
        insert_One_Row(db, 70,"Beri dosis pertama antibiotik yang sesuai", 0);


    }
}
