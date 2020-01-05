package com.example.sisteminformasimtbs.view.riwayat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.database.LoadRiwayatDatabaseAsyncTask;
import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.Kunjungan;
import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.LinkedList;

public class RiwayatBalita_Activity extends AppCompatActivity {

    private DatabaseHelper db;

    private FragmentRiwayatDataBalita fragmentRiwayatDataBalita;

    public void setDb(DatabaseHelper db) {
        this.db = db;
    }

    public DatabaseHelper getDb() {
        return db;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_balita_);

        ProgressDialog pd = new ProgressDialog(this);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage("Please Wait");

        pd.show();

        LoadRiwayatDatabaseAsyncTask l = new LoadRiwayatDatabaseAsyncTask(this , pd );
        l.execute((Object) null);

    }
    /**
     * @param
     */
    private void changeFragment(Fragment now) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragContainer, now);
        fragmentTransaction.commit();
    }

    public void initiateFragment(DatabaseHelper db){
        this.fragmentRiwayatDataBalita  = FragmentRiwayatDataBalita.newInstance(this , db);
        changeFragment(this.fragmentRiwayatDataBalita);
    }

    public void changeToProfileBalita(Balita balitaNow){
        FragmentBalitaProfile fragmentBalitaProfile = FragmentBalitaProfile.newInstance(this,balitaNow);
        changeFragment(fragmentBalitaProfile);
    }

    public void changeToRiwayatDataBalita(){
        changeFragment(this.fragmentRiwayatDataBalita);
    }

    public void changeToRiwayatHasilPemeriksaan(LinkedList<DiagnosisResult> listOfKlasifikasi , Kunjungan kunjunganNow ,Balita balitaNow){
        FragmentRiwayatHasilPemeriksaan fragmentRiwayatHasilPemeriksaan = FragmentRiwayatHasilPemeriksaan.newInstance(this,listOfKlasifikasi,balitaNow,kunjunganNow);
        changeFragment(fragmentRiwayatHasilPemeriksaan);
    }

}
