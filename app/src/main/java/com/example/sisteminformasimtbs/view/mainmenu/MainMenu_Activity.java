package com.example.sisteminformasimtbs.view.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;
import com.example.sisteminformasimtbs.view.petunjuk.Petunjuk_Activity;

public class MainMenu_Activity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout btn_Mulai;
    private LinearLayout btn_Petunjuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        btn_Mulai = findViewById(R.id.btn_mulai);
        btn_Mulai.setOnClickListener(this);

        btn_Petunjuk = findViewById(R.id.btn_petunjuk) ;
        btn_Petunjuk.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_Mulai.getId()){
            Intent intent = new Intent(getApplicationContext() , PemeriksaanMain.class);
            startActivity(intent);
        }else if(view.getId() == this.btn_Petunjuk.getId()){
           Intent intent = new Intent(getApplicationContext() , Petunjuk_Activity.class);
           startActivity(intent);
        }
    }
}
