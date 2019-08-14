package com.example.sisteminformasimtbs.view.pemeriksaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.database.DatabaseHelper;

public class PemeriksaanMain extends AppCompatActivity {


    //kelas inisialisasi fragment datadiri
    private Initializer_DataDiri initializer_dataDiri;

    //        kelas inisialisasi fragment TandaBahayaUmum
    private Initializer_TandaBahayaUmum initializer_tandaBahayaUmum;

    //        kelas inisialisasi fragment Batuk
    private Initializer_Batuk initializer_batuk;

    //         Kelas inisialisasi semua fragment diare
    private Initializer_Diare initializer_diare;
//     Kelas inisalisasi semau fragment demam
        private Initializer_Demam initializer_demam;
    // Kelas inisialisasi semua fragment masalah telinga
        private Initializer_MasalahTelinga initializer_masalahTelinga;
    // Kelas inisialisasi semua fragment StatusGizi
        private Initializer_StatusGizi initializer_statusGizi;
    // Kelas inisialisasi semua fragment Anemia
        private Initializer_Anemia initializer_anemia;
//     Kelas inisialisasi semua fragment Status HIV
        private Initializer_Status_HIV initializer_status_hiv;
    // Kelas inisialisasi semua fragment klasifikasi tanda bahaya umum
//        private Initializer_KlasifikasiTandaBahayaUmum initializer_klasifikasiTandaBahayaUmum;
    // Kelas inisialisasi semua fragment tindakan tanda bahaya umum
//        private Initializer_TindakanTandaBahayaUmum initializer_tindakanTandaBahayaUmum;
//        private FragmentManager fragmentManager;
    // database
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemeriksaan_main);
        this.db = new DatabaseHelper(getApplicationContext(), this);
        initAll();
        changeToDataDiri_1();
    }

    /**
     * @param
     */
    private void changeFragment(Fragment now) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragContainer, now);
        fragmentTransaction.commit();
    }


    public void changeToDataDiri_1() {
        FragmentDataDiri1 now = this.initializer_dataDiri.getDataDiri1();
        changeFragment(now);
    }

    public void changeToDataDiri_2() {
        FragmentDataDiri2 now = this.initializer_dataDiri.getDataDiri2();
        changeFragment(now);
    }

    public void changeToDataDiri_3() {
        FragmentDataDiri3 now = this.initializer_dataDiri.getDataDiri3();
        changeFragment(now);
    }

    public void changeToDataDiri_4() {
        FragmentDataDiri4 now = this.initializer_dataDiri.getDataDiri4();
        changeFragment(now);
    }

    public void changeToTandaBahayaUmum1() {
        FragmentTandaBahayaUmum1 now = this.initializer_tandaBahayaUmum.getTandaBahayaUmum1();
        changeFragment(now);
    }

    public void changeToBatuk1() {
        FragmentBatuk1 now = this.initializer_batuk.getBatuk1();
        changeFragment(now);
    }

    public void changeToBatuk2() {
        FragmentBatuk2 now = this.initializer_batuk.getBatuk2();
        changeFragment(now);
    }

    public void changeToBatuk3() {
        FragmentBatuk3 now = this.initializer_batuk.getBatuk3();
        changeFragment(now);
    }

    public void changeToDiare1() {
        FragmentDiare1 now = this.initializer_diare.getFragmentDiare1();
        changeFragment(now);
    }

    public void changeToDiare2() {
        FragmentDiare2 now = this.initializer_diare.getFragmentDiare2();
        changeFragment(now);
        }
        public void changeToDemam1(){
            FragmentDemam1 now = this.initializer_demam.getFragmentDemam1();
            changeFragment(now);
        }

        public void changeToMasalahTelinga1(){
            FragmentMasalahTelinga1 now = this.initializer_masalahTelinga.getFragmentMasalahTelinga1();
            changeFragment(now);
        }

        public void changeToMasalahTelinga2(){
            FragmentMasalahTelinga2 now = this.initializer_masalahTelinga.getFragmentMasalahTelinga2();
            changeFragment(now);
        }
//
        public void changeToStatusGizi1(){
            FragmentStatusGizi1 now = this.initializer_statusGizi.getStatusGizi1();
            changeFragment(now);
        }
//
        public void changeToStatusGizi2(){
            FragmentStatusGizi2 now = this.initializer_statusGizi.getStatusGizi2();
            changeFragment(now);
        }
//
        public void changeToAnemia(){
            FragmentAnemia now = this.initializer_anemia.getFragmentAnemia();
            changeFragment(now);
        }
//
        public void changeToStatusHIV1(){
            FragmentStatusHIV1 now = this.initializer_status_hiv.getStatusHIV1();
            changeFragment(now);
        }

        public void changeToStatusHIV2(){
            FragmentStatusHIV2 now = this.initializer_status_hiv.getStatusHIV2();
            changeFragment(now);
        }
//
//        public void changeToKlasifikasiTandaBahayaUmum(){
//            FragmentKlasifikasiTandaBahayaUmum now = this.initializer_klasifikasiTandaBahayaUmum.getKlasifikasiTandaBahayaUmum();
//            changeFragment(now);
//        }
//
//        public void changeToTindakanTandaBahayaUmum(){
//            FragmentTindakanTandaBahayaUmum now = this.initializer_tindakanTandaBahayaUmum.getTindakanTandaBahayaUmum();
//            changeFragment(now);
//        }

        private void initAll(){
            // inisalisasi data diri
            this.initializer_dataDiri = new Initializer_DataDiri(this);
            // inisialisasi  semua fragment yang dibutuhkan untuk pemeriksaan 2 bulan - 5 tahun
            this.initializer_tandaBahayaUmum = new Initializer_TandaBahayaUmum(this, this.db.getReadableDatabase());
            this.initializer_batuk = new Initializer_Batuk(this);
            this.initializer_diare = new Initializer_Diare(this);
            this.initializer_demam = new Initializer_Demam(this);
            this.initializer_masalahTelinga = new Initializer_MasalahTelinga(this);
            this.initializer_statusGizi = new Initializer_StatusGizi(this);
            this.initializer_anemia = new Initializer_Anemia(this);
            this.initializer_status_hiv = new Initializer_Status_HIV(this);
//            this.initializer_klasifikasiTandaBahayaUmum = new Initializer_KlasifikasiTandaBahayaUmum(this);
//            this.initializer_tindakanTandaBahayaUmum = new Initializer_TindakanTandaBahayaUmum(this);
        }
    }

