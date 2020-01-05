package com.example.sisteminformasimtbs.view.pemeriksaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.database.LoadPemeriksaanDatabaseAsyncTask;
import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.PasienNow;
import com.example.sisteminformasimtbs.presenter.Presenter;
import com.example.sisteminformasimtbs.model.dataclass.TindakanResult;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PemeriksaanMain_Activity extends AppCompatActivity {
    public PasienNow balitaNow ;

    public Presenter presenter ;


    private Fragment lastGejala ;

    public static Balita loadedBalita = null ;



    // LinkedList Of TindakanFragment
    private LinkedList<FragmentTindakan> collectionOfTindakanFragment ;

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

        private Initializer_HasilPemeriksaan initializer_hasilPemeriksaan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemeriksaan_main);
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Please Wait");
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        LoadPemeriksaanDatabaseAsyncTask loadPemeriksaanDatabaseAsyncTask = new LoadPemeriksaanDatabaseAsyncTask(this , pd);
        loadPemeriksaanDatabaseAsyncTask.execute((Object) null);
    }

    public void initiateProgram(DatabaseHelper db){
        this.presenter = new Presenter(this , db);
        initAll();
        // test
        this.balitaNow = new PasienNow();
        this.collectionOfTindakanFragment = new LinkedList<>();
        changeToDataDiri_1();
    }

    public void changeToCariBalita(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentTransaction fr2 = getSupportFragmentManager().beginTransaction();
        fr2.replace(R.id.fragContainer,FragmentCariBalita.newInstance(this));
        fr2.commit();
    }

    public void changeToTandaBahayaUmum(){
        TandaBahayaUmum_Fragment fragment = this.initializer_tandaBahayaUmum.getTandaBahayaUmumFragment();
        changeFragment(fragment);
    }

    public void changeToKlasifikasiTest(HashMap<String , Integer> collectionOfClassificationResult){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(FragmentKlasifikasi.newInstance(this , collectionOfClassificationResult)).commit();

        FragmentTransaction fr2 = getSupportFragmentManager().beginTransaction();
        fr2.replace(R.id.fragContainer, FragmentKlasifikasi.newInstance(this , collectionOfClassificationResult));
        fr2.commit();
    }

    public void changeToHasilPemeriksaanAkhir(HashMap<String , Integer> collectionOfClassificationResult){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(Fragment_HasilPemeriksaan_2.newInstance(this , collectionOfClassificationResult)).commit();

        FragmentTransaction fr2 = getSupportFragmentManager().beginTransaction();
        fr2.replace(R.id.fragContainer, Fragment_HasilPemeriksaan_2.newInstance(this , collectionOfClassificationResult));
        fr2.commit();
    }


    public void changeToTindakanTest(){
        this.collectionOfTindakanFragment.clear();
        HashMap<String , LinkedList<TindakanResult>> collectionOfLinkedList  = this.presenter.getAllTindakan_test();
        if(collectionOfLinkedList.size() !=0 ){
            int i = 0 ;
            for(Map.Entry<String , LinkedList<TindakanResult>> item : collectionOfLinkedList.entrySet()){
                LinkedList<TindakanResult> listOfTindakan = item.getValue();
                // initialize the fragment
                FragmentTindakan now = FragmentTindakan.newInstance(this , listOfTindakan , i , item.getKey());
                this.collectionOfTindakanFragment.add(now);
                i++;
            }
            changeFragment(this.collectionOfTindakanFragment.get(0));
        }else{
            Toast.makeText(getBaseContext() , "belum ada tindakan" , Toast.LENGTH_SHORT).show();
        }
    }

    public void changeToPreviousOrNextTindakan(int index){
        FragmentTindakan now = this.collectionOfTindakanFragment.get(index);
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
        FragmentDataDiri_1 now = this.initializer_dataDiri.getDataDiri1();
        changeFragment(now);
    }


    public void changeToDataDiri_2() {
        FragmentDataDiri_2 now = this.initializer_dataDiri.getDataDiri2();
        changeFragment(now);
    }



    public void changeToDataDiri_4() {
        FragmentDataDiri_3 now = this.initializer_dataDiri.getDataDiri4();
        changeFragment(now);
    }



    public void changeToBatuk_Fragment() {
        FragmentBatuk now = this.initializer_batuk.getBatuk_Fragment();
        changeFragment(now);
    }



    public void changeToDiare1() {
        FragmentDiare_1 now = this.initializer_diare.getFragmentDiare1();
        changeFragment(now);
    }

    public void changeToDiare2() {
        FragmentDiare_2 now = this.initializer_diare.getFragmentDiare2();
        changeFragment(now);
        }

        public void changeToDemam1(){
            FragmentDemam_1 now = this.initializer_demam.getFragmentDemam1();
            changeFragment(now);
        }

        public void changeToDemam2(){
            FragmentDemam_2 now = this.initializer_demam.getFragmentDemam2();
            changeFragment(now);
        }

        public void changeToDemam3(){
            FragmentDemam_3 now = this.initializer_demam.getFragmentDemam3();
            changeFragment(now);
        }

        public void changeToDemam4(){
            FragmentDemam_4 now = this.initializer_demam.getFragmentDemam4();
            changeFragment(now);
        }

        public void changeToDemam5(){
            FragmentDemam_5 now = this.initializer_demam.getFragmentDemam5();
            changeFragment(now);
        }

        public void changeToMasalahTelinga1(){
            FragmentMasalahTelinga_1 now = this.initializer_masalahTelinga.getFragmentMasalahTelinga1();
            changeFragment(now);
        }


//
        public void changeToStatusGizi_1(){
            FragmentStatusGizi_1 now = this.initializer_statusGizi.getFragmentStatusGizi_1();
            changeFragment(now);
        }

        public void changeToStatusGizi_2(){
            FragmentStatusGizi_2 now = this.initializer_statusGizi.getFragmentStatusGizi_2();
            changeFragment(now);
        }

        public void changeToStatusGizi_3(){
            FragmentStatusGizi_3 now = this.initializer_statusGizi.getFragmentStatusGizi3();
            changeFragment(now);
        }
//
        public void changeToAnemia(){
            FragmentAnemia now = this.initializer_anemia.getFragmentAnemia();
            changeFragment(now);
        }
//
        public void changeToStatusHIV1(){
            FragmentStatusHIV_1 now = this.initializer_status_hiv.getStatusHIV1();
            changeFragment(now);
        }

        public void changeToHasilPemeriksaan(){
          Fragment_HasilPemeriksaan_1 now = this.initializer_hasilPemeriksaan.getFragment_hasilPemeriksaan_1();
           changeFragment(now);
        }



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
            this.initializer_hasilPemeriksaan = new Initializer_HasilPemeriksaan(this);

        }


    }

