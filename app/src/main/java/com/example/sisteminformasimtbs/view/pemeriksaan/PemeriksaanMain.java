package com.example.sisteminformasimtbs.view.pemeriksaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.testing.Batuk_Test;
import com.example.sisteminformasimtbs.testing.Klasifikasi_Test;
import com.example.sisteminformasimtbs.testing.TandaBahayaUmum_Fragment;
import com.example.sisteminformasimtbs.testing.Presenter;
import com.example.sisteminformasimtbs.testing.TindakanResult;
import com.example.sisteminformasimtbs.testing.Tindakan_Test;

import java.util.HashMap;
import java.util.LinkedList;

public class PemeriksaanMain extends AppCompatActivity {

    public Presenter presenter ;


    private Fragment lastGejala ;


    // LinkedList Of TindakanFragment
    private LinkedList<Tindakan_Test> collectionOfTindakanFragment ;

    //kelas inisialisasi fragment datadiri
    private Initializer_DataDiri initializer_dataDiri;

    //        kelas inisialisasi fragment TandaBahayaUmum
    private Initializer_TandaBahayaUmum initializer_tandaBahayaUmum;

    //        kelas inisialisasi fragment Batuk
    private Initializer_Batuk initializer_batuk;

    //         Kelas inisialisasi semua fragment diare
    private Initializer_Diare initializer_diare;
//     Kelas inisalisasi semau fragment fragment_fragmentdemam1
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
        this.presenter = new Presenter(this);
        initAll();
        // test

        this.collectionOfTindakanFragment = new LinkedList<>();
        changeToDataDiri_1();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragContainer, this.tandaBahayaUmum_test );
//        fragmentTransaction.commit();
    }

//    public void changeToBatukTest(){
//        changeFragment(this.batuk_test);
//    }

    public void changeToTandaBahayaUmum(){
        TandaBahayaUmum_Fragment fragment = this.initializer_tandaBahayaUmum.getTandaBahayaUmumFragment();
        changeFragment(fragment);
    }

    public void changeToKlasifikasiTest(HashMap<String , Integer> collectionOfClassificationResult){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(Klasifikasi_Test.newInstance(this , collectionOfClassificationResult)).commit();

        FragmentTransaction fr2 = getSupportFragmentManager().beginTransaction();
        fr2.replace(R.id.fragContainer, Klasifikasi_Test.newInstance(this , collectionOfClassificationResult));
        fr2.commit();
    }

    public void changeToTindakanTest(){
        this.collectionOfTindakanFragment.clear();
        LinkedList<LinkedList<TindakanResult>> collectionOfLinkedListTindakan = this.presenter.getAllTindakan();
        if(collectionOfLinkedListTindakan.size() !=0 ){
            for(int i = 0 ; i  < collectionOfLinkedListTindakan.size() ; i++){
                LinkedList<TindakanResult> listOfTindakan = collectionOfLinkedListTindakan.get(i);
                // initialize the fragment
                Tindakan_Test now = Tindakan_Test.newInstance(this , listOfTindakan , i);
                this.collectionOfTindakanFragment.add(now);
            }
            changeFragment(this.collectionOfTindakanFragment.get(0));
        }else{
            Toast.makeText(getBaseContext() , "belum ada tindakan" , Toast.LENGTH_SHORT).show();
        }
    }

    public void changeToPreviousOrNextTindakan(int index){
        Tindakan_Test now = this.collectionOfTindakanFragment.get(index);
        changeFragment(now);
    }

    public int getCollectionFragmentTindakanSize(){
        return this.collectionOfTindakanFragment.size();
    }

    public void changeToLastGejala(){
        changeFragment(this.lastGejala);
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



    public void changeToBatuk_Fragment() {
        Batuk_Test now = this.initializer_batuk.getBatuk_Fragment();
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

        public void changeToDemam2(){
            FragmentDemam2 now = this.initializer_demam.getFragmentDemam2();
            changeFragment(now);
        }

        public void changeToDemam3(){
            FragmentDemam3 now = this.initializer_demam.getFragmentDemam3();
            changeFragment(now);
        }

        public void changeToDemam4(){
            FragmentDemam4 now = this.initializer_demam.getFragmentDemam4();
            changeFragment(now);
        }

        public void changeToDemam5(){
            FragmentDemam5 now = this.initializer_demam.getFragmentDemam5();
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

        public void saveLastGejala(Fragment fragment){
            this.lastGejala = fragment;
    }

        private void initAll(){
            // inisalisasi data diri
            this.initializer_dataDiri = new Initializer_DataDiri(this);
            // inisialisasi  semua fragment yang dibutuhkan untuk pemeriksaan 2 bulan - 5 tahun
            this.initializer_tandaBahayaUmum = new Initializer_TandaBahayaUmum(this);
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

