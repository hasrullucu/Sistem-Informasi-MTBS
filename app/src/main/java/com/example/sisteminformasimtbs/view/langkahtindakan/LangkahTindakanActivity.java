package com.example.sisteminformasimtbs.view.langkahtindakan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sisteminformasimtbs.R;

import java.util.ArrayList;

public class LangkahTindakanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LangkahTindakanAdapter langkahTindakanAdapter;

    private LinearLayout btn_Kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langkah_tindakan);

        this.btn_Kembali =  this.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });



        Intent intent = getIntent() ;
        ArrayList<String> arrayList = intent.getStringArrayListExtra("langkahtindakan");

        for(String item : arrayList){
            Log.d("tes" , item);
        }
        Log.d("tes" , "done looping");

        this.recyclerView = this.findViewById(R.id.recyclerViewLangkah) ;
        this.langkahTindakanAdapter= new LangkahTindakanAdapter(arrayList);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.langkahTindakanAdapter);
    }
}
