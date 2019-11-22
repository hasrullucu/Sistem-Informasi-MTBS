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
    private static final String COL_KETERANGAN  = "namalangkahtindakan";
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

    public static void insert_All_Row(SQLiteDatabase db ) {
        // langkah tindakan Tanda Bahaya Umum id = 1
        insert_One_Row(db, 1, "Miringkan anak dan berishkan jalan napas. Jangan masukkan apapun ke dalam mulut anak", 1);
        insert_One_Row(db, 2, "Berikan 0,5mg/kg diazepam cairan injeksi per rektal menggunakan syringe kecil 1 cc tanpa jarum (seperti syringe tuber kulin)\n" +
                "atau dengan menggunakan kateter", 1);
        insert_One_Row(db, 3, "Periksa gula darah, lalu lakukan tatalaksana atau cegah agar tidak turun", 1);
        insert_One_Row(db, 4, "Beri oksigen dan RUJUK", 1);
        insert_One_Row(db, 5, "Jika kejang tidak berhenti setelah 5 menit ulangi dosis dizepam(maksimal 2 kali)", 1);
        insert_One_Row(db, 6, "Jika sudah terpasang akses vena maka diberikan diazepam 0,25-0,5 mg IV", 1);
        insert_One_Row(db, 7, "Jika kejang belum teratasi, dapat diberikan fenitoin 20 mg/kg IV yang dilarutkan dengan NaCl 0,9% atau fenorbarbital 20 mg/kg IV (bila tidak tersedia fenobarbital iv berikan sediaan im dalam dosis sama)", 1);

        // langkah tindakan Tanda Bahaya Umum id = 4
        insert_One_Row(db, 8, "Jika anak masih bisa menyusu, mintalah kepada ibu untuk menyusui anaknya", 4);
        insert_One_Row(db, 9, "Jika anak tidak bisa menyusu tapi masih bisa menelan, Beri perahan ASI atau susu formula / air gula 30-50 ml sebelum dirujuk. Cara membuat air gula : Larutkan 4 sendok teh (20 gr) gula dalam 200 ml air matang", 4);
        insert_One_Row(db, 10, "Jika anak tidak bisa menelan, Beri 50 ml susu formula / air gula melalui pipa orogastrik. Jika tidak tersedia pipa orogastrik, RUJUK SEGERA", 4);

//        langkah tindakan untuk idTndakan = 10
        insert_One_Row(db, 11, "Bahan aman yang dianjurkan: \n- ASI eksklusif sampai umur 6 bulan.\n" +
                "- Kecap manis atau madu dicampur dengan air jeruk nipis (Madu tidak dianjurkan untuk anak umur < 1 tahun).", 10);
        insert_One_Row(db, 12, "Obat yang tidak dianjurkan: \n- Semua jenis obat batuk yang dijual bebas yang mengandung atropin, codein dan derivatnya atau alkohol.\n" +
                "- Obat-obatan dekongestan oral dan nasal.", 10);

//        langkah tindakan untuk wheezing => id TIndakan 11
        insert_One_Row(db, 13, "Pemberian Bronkodilatator Kerja Cepat (Inhalasi) : \n- Salbutamol nebulisasi\n" +
                "- Salbutamol MDI (Metered Doses Inhaler) dengan Spacer\n" +
                "- Bila kedua cara tidak tersedia berikan dengan epinefrin (adrenalin) secara subkutan", 11);
        insert_One_Row(db, 14, "Jika pengobatan inhalasi tidak mungkin diberikan, berikan Bronkodilator Oral", 11);

//        lamgkah tindakan untuk idTindakan 22
        insert_One_Row(db, 15, "Jika anak mendapat ASI: Berikan lebih sering dan lebih lama, pagi, siang, dan malam", 22);
        insert_One_Row(db, 16, "Jika anak mendapat susu selain ASI :\n" +
                "- Ganti susu dengan susu formula untuk diare kronis,\n" +
                "- Gantikan setengah bagian susu dengan bubur nasi ditambah tempe,\n" +
                "- Jangan diberi susu kental manis,\n" +
                "- Untuk makanan lain, ikuti anjuran pemberian makan sesuai dengan kelompok umur", 22);

//        langkah tindakan untuk idTindakan 25
        insert_One_Row(db, 17, "UNTUK ANAK YANG HARUS DIRUJUK KARENA PENYAKIT BERAT DENGAN DEMAM :\n" +
                "- Berikan dosis pertama suntikan Artemeter sebelum dirujuk (dosis lihat di bawah), SEGERA RUJUK\n" +
                "- Jika rujukan tidak memungkinkan dan hasil pemeriksaan laboratorium dan\n" +
                "klinis menunjukkan malaria berat ikuti petunjuk berikut :", 25);
        insert_One_Row(db, 18, "Suntikan Artesunat intra vena atau intra muskular dengan dosis 2,4 mg/kg BB " +
                "sebanyak 3 kali jam ke 0, 12, dan 24. Selanjutnya berikan 2,4 mg/kg BB per iv atau im setiap 24 jam sampai anak mampu minum obat. " +
                "Lanjutkan pengobatan dengan obat anti malaria oral (DHP tablet)", 25);
        insert_One_Row(db, 19, "Jika anak belum sadar dalam 3 hari, RUJUK SEGERA", 25);
        insert_One_Row(db, 20, "Jika anak sudah bisa makan dan minum, gantikan dengan pemberian obat " +
                "antimalaria oral untuk Malaria Falciparum pertama selama 3 hari", 25);
        insert_One_Row(db, 21, "Keterangan : dosis artesunat pada anak BB < 20 kg " +
                "dengan malaria berat adalah 3 mg/kg BB/kali pemberian. Lebih tinggi dibanding anak BB > 20 kg (2,4 mg/kg BB)", 25);


        insert_One_Row(db, 22, "Minta ibu untuk melakukan kunjungan ulang secara teratur sesuai dengan pedoman nasional", 62);
        insert_One_Row(db, 23, "Setiap kunjungan, lakukan hal berikut :\n" +
                "- Tanyakan apakah ada masalah pada anak?\n" +
                "- Lakukan penilaian lengkap termasuk menilai masalah mulut dan gusi, lakukan tindakan, konseling dan kunjungan ulang untuk setiap masalah baru\n" +
                "- Berikan pelayanan kesehatan anak rutin: Vitamin A, obat cacing, imunisasi, dan penilaian dan konseling pemberian makan\n" +
                "- Lanjutkan pemberian profilaksis kotrimoksasol\n" +
                "- Tanyakan masalah kesehatan ibu. Rujuk untuk mendapatkan pelayanan konseling dan pemeriksaan jika perlu\n" +
                "- Rencanakan kunjungan ulang berikutnya", 62);
        insert_One_Row(db, 24, "PEMERIKSAAN HIV\n" +
                "- Jika hasil tes HIV baru diperoleh, lakukan klasifikasi ulang untuk infeksi HIV\n" +
                "- Rencanakan untuk memeriksa status HIV 6 minggu setelah berhenti menyusu.", 62);
        insert_One_Row(db, 25, "JIKA INFEKSI HIV TERKONFIRMASI\n" +
                "- RUJUK untuk mendapatkan ARV\n" +
                "- Lakukan kunjungan ulang sesuai pedoman nasional", 62);
        insert_One_Row(db, 26, "RUJUKAN :\n" +
                "- Segera lakukan rujukan\n" +
                "- Sementara, teruskan pemberian nutrisi (makanan/minuman) seperti biasa, hindari pemberian Mix Feeding*", 62);
        insert_One_Row(db, 27, "*Mix Feeding adalah pemberian ASI yang bercampur dengan susu formula. " +
                        "Sebaiknya pada ibu HIV positif, bayi diberikan susu formula dengan memenuhi syarat AFASS (Affordable/terjangkau, " +
                        "Feasible/mampu laksana, Acceptable/dapat diterima, Sustainable/berkesinambungan dan safe/aman). " +
                        "Jika persyarat AFASS tidak terpenuhi maka berikanlah ASI ekslusif sampai usia 6 bulan pada bayi, selanjutnya pemberian ASI dihentikan.",
                62);
        insert_One_Row(db, 28, "JIKA MASIH DIPERLUKAN KUNJUNGAN ULANG BERDASARKAN KUNJUNGAN PERTAMA ATAU KUNJUNGAN SAAT INI, " +
                "NASIHATILAH IBU TENTANG KUNJUNGAN BERIKUTNYA JUGA NASIHATI IBU KAPAN HARUS KEMBALI SEGERA", 62);
        insert_One_Row(db, 29, "Minta ibu untuk melakukan kunjungan ulang secara teratur sesuai dengan pedoman nasional", 63);
        insert_One_Row(db, 30, "Setiap kunjungan, lakukan hal berikut :\n" +
                "- Tanyakan apakah ada masalah pada anak?\n" +
                "- Lakukan penilaian lengkap termasuk menilai masalah mulut dan gusi, lakukan tindakan, konseling dan kunjungan ulang untuk setiap masalah baru\n" +
                "- Berikan pelayanan kesehatan anak rutin: Vitamin A, obat cacing, imunisasi, dan penilaian dan konseling pemberian makan\n" +
                "- Lanjutkan pemberian profilaksis kotrimoksasol\n" +
                "- Tanyakan masalah kesehatan ibu. Rujuk untuk mendapatkan pelayanan konseling dan pemeriksaan jika perlu\n" +
                "- Rencanakan kunjungan ulang berikutnya", 63);
        insert_One_Row(db, 31, "PEMERIKSAAN HIV\n" +
                "- Jika hasil tes HIV baru diperoleh, lakukan klasifikasi ulang untuk infeksi HIV\n" +
                "- Rencanakan untuk memeriksa status HIV 6 minggu setelah berhenti menyusu.", 63);
        insert_One_Row(db, 32, "JIKA DIDUGA TERINFEKSI :\n" +
                "- Konseling ibu untuk pemeriksaan lanjutan Infeksi HIV.", 63);
        insert_One_Row(db, 33, "RUJUKAN :\n" +
                "- Segera lakukan rujukan\n" +
                "- Sementara, teruskan pemberian nutrisi (makanan/minuman) seperti biasa, hindari pemberian Mix Feeding*", 63);
        insert_One_Row(db, 34, "*Mix Feeding adalah pemberian ASI yang bercampur dengan susu formula. " +
                        "Sebaiknya pada ibu HIV positif, bayi diberikan susu formula dengan memenuhi syarat AFASS (Affordable/terjangkau, " +
                        "Feasible/mampu laksana, Acceptable/dapat diterima, Sustainable/berkesinambungan dan safe/aman)." +
                        "Jika persyarat AFASS tidak terpenuhi maka berikanlah ASI ekslusif sampai usia 6 bulan pada bayi, selanjutnya pemberian ASI dihentikan.",
                63);
        insert_One_Row(db, 35, "JIKA MASIH DIPERLUKAN KUNJUNGAN ULANG BERDASARKAN KUNJUNGAN PERTAMA ATAU KUNJUNGAN SAAT INI, " +
                "NASIHATILAH IBU TENTANG KUNJUNGAN BERIKUTNYA JUGA NASIHATI IBU KAPAN HARUS KEMBALI SEGERA", 63);
        insert_One_Row(db, 36, "Minta ibu untuk melakukan kunjungan ulang secara teratur sesuai dengan pedoman nasional", 64);
        insert_One_Row(db, 37, "Setiap kunjungan, lakukan hal berikut :\n" +
                "- Tanyakan apakah ada masalah pada anak?\n" +
                "- Lakukan penilaian lengkap termasuk menilai masalah mulut dan gusi, lakukan tindakan, konseling dan kunjungan ulang untuk setiap masalah baru\n" +
                "- Berikan pelayanan kesehatan anak rutin: Vitamin A, obat cacing, imunisasi, dan penilaian dan konseling pemberian makan\n" +
                "- Lanjutkan pemberian profilaksis kotrimoksasol\n" +
                "- Tanyakan masalah kesehatan ibu. Rujuk untuk mendapatkan pelayanan konseling dan pemeriksaan jika perlu\n" +
                "- Rencanakan kunjungan ulang berikutnya", 64);
        insert_One_Row(db, 38, "PEMERIKSAAN HIV \n" +
                "- Jika hasil tes HIV baru diperoleh, lakukan klasifikasi ulang untuk infeksi HIV\n" +
                "- Rencanakan untuk memeriksa status HIV 6 minggu setelah berhenti menyusu.", 64);
        insert_One_Row(db, 39, "JIKA TERPAJAN HIV :\n" +
                "- Bantu pemantauan pemberian ARV profilaksis dan Kotrimoksasol profilaksis\n" +
                "- Monitoring klinis secara berkala, apakah ada gejala/tanda HIV yang muncul.", 64);
        insert_One_Row(db, 40, "RUJUKAN :\n" +
                "- Segera lakukan rujukan\n" +
                "- Sementara, teruskan pemberian nutrisi (makanan/minuman) seperti biasa, hindari pemberian Mix Feeding*", 64);
        insert_One_Row(db, 41, "*Mix Feeding adalah pemberian ASI yang bercampur dengan susu formula. Sebaiknya pada ibu HIV positif, " +
                "bayi diberikan susu formula dengan memenuhi syarat AFASS (Affordable/terjangkau, Feasible/mampu laksana, " +
                "Acceptable/dapat diterima, Sustainable/berkesinambungan dan safe/aman). " +
                "jika persyarat AFASS tidak terpenuhi maka berikanlah ASI ekslusif sampai usia 6 bulan pada bayi, " +
                "selanjutnya pemberian ASI dihentikan.", 64);
        insert_One_Row(db, 42, "JIKA MASIH DIPERLUKAN KUNJUNGAN ULANG BERDASARKAN KUNJUNGAN PERTAMA ATAU KUNJUNGAN SAAT INI, " +
                "NASIHATILAH IBU TENTANG KUNJUNGAN BERIKUTNYA JUGA NASIHATI IBU KAPAN HARUS KEMBALI SEGERA", 64);
        insert_One_Row(db, 43, "Menilai Cara Pemberian Makan", 56);
        insert_One_Row(db, 44, "Tanyakan tentang cara pemberian makan anak. Bandingkan jawaban ibu dengan ANJURAN MAKAN UNTUK ANAK SEHAT MAUPUN SAKIT.", 56);
        insert_One_Row(db, 45, "TANYAKAN :\n" +
                "1. Apakah ibu menyusui anak ini?\n" +
                "- Berapa kali sehari?\n" +
                "- Apakah ibu menyusui juga pada malam hari?", 56);
        insert_One_Row(db, 46, "2. Apakah anak mendapat makanan atau minuman lain?\n" +
                "- Makanan atau minuman apa?\n" +
                "- Berapa kali sehari?\n" +
                "- Alat apa yang digunakan untuk memberi makan/minum anak?", 56);
        insert_One_Row(db, 47, "3. Jika anak gizi kurus atau gizi sangat kurus tanpa komplikasi :\n" +
                "- Berapa banyak makanan/minuman yang diberikan kepada anak?\n" +
                "- Apakah anak mendapat porsi sendiri?\n" +
                "- Siapa yang memberi makan anak dan bagaimana caranya?\n" +
                "- Makanan apa yang tersedia di rumah?", 56);
        insert_One_Row(db, 48, "4. Selama anak sakit, apakah pemberian makanan berubah? Bila ya, bagaimana?", 56);
        insert_One_Row(db, 49, "Menasihati Ibu tentang Masalah Pemberian Makan\n" +
                "Jika pemberian makan anak tidak sesuai dengan \"Anjuran Makan untuk Anak Sehat Maupun Sakit\":\n" +
                "- Nasihati ibu cara pemberian makan sesuai kelompok umur anak", 71);
        insert_One_Row(db, 50, "Jika ibu mengeluhkan kesulitan pemberian ASI, lakukan konseling menyusui:\n" +
                "- Lakukan penilaian cara ibu menyusui (lihat bagan Bayi Muda)\n" +
                "- Tunjukkan pada ibu cara menyusui yang benar\n" +
                "- Jika ditemukan masalah lakukan tindakan yang sesuai", 71);
        insert_One_Row(db, 51, "Jika bayi berumur kurang dari 6 bulan mendapat susu formula atau makanan lain:\n" +
                "- Anjurkan ibu untuk relaktasi:\n" +
                "- Bangkitkan rasa percaya diri bahwa ibu mampu memproduksi ASI sesuai kebutuhan anaknya\n" +
                "- Susui bayi lebih sering, lebih lama, pagi, siang, maupun malam\n" +
                "- Secara bertahap mengurangi pemberian susu formula atau makanan lain", 71);
        insert_One_Row(db, 52, "Jika bayi berumur 6 bulan atau lebih dan ibu menggunakan botol untuk memberikan susu pada anaknya\n" +
                "- Minta ibu untuk mengganti botol dengan cangkir/mangkuk/gelas\n" +
                "- Peragakan cara memberi susu dengan cangkir/mangkuk/gelas\n" +
                "- Berikan Makanan Pendamping ASI (MP ASI) sesuai kelompok umur", 71);
        insert_One_Row(db, 53, "Jika anak tidak diberi makan secara aktif, nasihati ibu untuk:\n" +
                "- Duduk di dekat anak, membujuk agar mau makan, jika perlu menyuapi anak\n" +
                "- Memberi anak porsi makan yang cukup dengan piring/mangkuk tersendiri sesuai dengan kelompok umur\n" +
                "- Memberi makanan kaya gizi yang disukai anak", 71);
        insert_One_Row(db, 54, "Jika ibu merubah pemberian makan selama anak sakit:\n" +
                "- Beritahu ibu untuk tidak merubah pemberian makan selama anak sakit\n" +
                "- Nasihati ibu untuk memberi makanan sesuai kelompok umur dan kondisi anak", 71);
        insert_One_Row(db, 55, "Mengeringkan Telinga dengan Bahan Penyerap\n" +
                "- Keringkan telinga sekurang-kurangnya 3 kali sehari", 42);
        insert_One_Row(db, 56, "- Gulung selembar kain penyerap bersih dan lunak atau kertas tissu yang kuat, menjadi sebuah sumbu. Jangan gunakan lidi kapas", 42);
        insert_One_Row(db, 57, "- Masukkan sumbu tersebut ke dalam telinga anak", 42);
        insert_One_Row(db, 58, "- Keluarkan sumbu jika sudah basah", 42);
        insert_One_Row(db, 59, "- Ganti sumbu dengan yang baru dan ulangi langkah di atas sampai telinga anak kering", 42);
        insert_One_Row(db, 60, "Untuk INFEKSI TELINGA KRONIS :\n" +
                "- Teteskan 3-5 tetes larutan NaCl 0,9% atau H2O2 3% pada telinga yang sakit, lalu keringkan dengan kertas tissu. Lakukan hal ini 3 kali sehari.", 44);
        insert_One_Row(db, 61, "- Sesudah mengeringkan telinga, teteskan derivat Quinolon 2-3 tetes/kali dan biarkan selama 10 menit. Berikan 2x sehari, pagi dan malam selama 14 hari.", 44);
    }
}
