package com.example.sisteminformasimtbs.view.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain_Activity;
import com.example.sisteminformasimtbs.view.petunjuk.Petunjuk_Activity;
import com.example.sisteminformasimtbs.view.riwayat.RiwayatBalita_Activity;

public class MainMenu_Activity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout btn_Mulai;
    private LinearLayout btn_Petunjuk;
    private LinearLayout btn_Riwayat ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        btn_Mulai = findViewById(R.id.btn_mulai);
        btn_Mulai.setOnClickListener(this);

        btn_Petunjuk = findViewById(R.id.btn_petunjuk) ;
        btn_Petunjuk.setOnClickListener(this);

        btn_Riwayat = findViewById(R.id.btn_riwayat);
        btn_Riwayat.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_Mulai.getId()){
            Intent intent = new Intent(getApplicationContext() , PemeriksaanMain_Activity.class);
            startActivity(intent);
        }else if(view.getId() == this.btn_Petunjuk.getId()){
           Intent intent = new Intent(getApplicationContext() , Petunjuk_Activity.class);
           startActivity(intent);
        }else if(view.getId() == this.btn_Riwayat.getId()){
           Intent intent = new Intent(getApplicationContext(), RiwayatBalita_Activity.class);

           // - use this class to
            startActivity(intent);
           }
        }
    }

