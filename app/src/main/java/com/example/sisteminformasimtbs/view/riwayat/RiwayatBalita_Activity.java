package com.example.sisteminformasimtbs.view.riwayat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.database.LoadSaveDatabaseAsyncTask;
import com.example.sisteminformasimtbs.model.dataclass.Balita;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class RiwayatBalita_Activity extends AppCompatActivity {

    private DatabaseHelper db;

    private FragmentRiwayatDataBalita fragmentRiwayatDataBalita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_balita_);

        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Please Wait");

        pd.show();

        LoadSaveDatabaseAsyncTask l = new LoadSaveDatabaseAsyncTask(this , pd );
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
        FragmentRiwayatDataBalita fragmentRiwayatDataBalita  = FragmentRiwayatDataBalita.newInstance(this , db);
        changeFragment(fragmentRiwayatDataBalita);


    }

}
