package com.example.sisteminformasimtbs.testing;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class TandaBahayaUmum_Test extends Fragment implements View.OnClickListener {
    private PemeriksaanMain activity ;

    private CheckBox checkBox_1;
    private Checkbox_Model cb_1;
    private CheckBox checkBox_2;
    private Checkbox_Model cb_2;
    private CheckBox checkBox_3;
    private Checkbox_Model cb_3;
    private CheckBox checkBox_4 ;
    private Checkbox_Model cb_4;


    // header button
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;

   // footer
    private Button btn_Kembali ;
    private Button btn_Selanjutnya ;




    public TandaBahayaUmum_Test() {
        // Required empty public constructor
    }

    public static TandaBahayaUmum_Test newInstance(PemeriksaanMain activity){
        TandaBahayaUmum_Test result = new TandaBahayaUmum_Test();
        result.activity = activity;
        return result;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_tandabahayaumum_test, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala) ;
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_1 = res.findViewById(R.id.cb_1) ;
        this.checkBox_2 = res.findViewById(R.id.cb_2) ;
        this.checkBox_3 = res.findViewById(R.id.cb_3);
        this.checkBox_4 = res.findViewById(R.id.cb_4);



        this.cb_1 = new Checkbox_Model("Tidak bisa minum atau menyusu" , 1);
        this.cb_2 = new Checkbox_Model("Memuntahkan semua makanan dan atau minuman" , 2);
//         cb _3
//        cb_4
        this.checkBox_1.setOnClickListener(this);
        this.checkBox_2.setOnClickListener(this);
        this.checkBox_4.setOnClickListener(this);
        this.checkBox_3.setOnClickListener(this);
        return res;
    }



    @Override
    public void onClick(View view) {
        if(this.checkBox_1.getId() == view.getId()){
            Toast.makeText(getContext() , "cb1 ", Toast.LENGTH_SHORT).show();
            toggle(cb_1 , checkBox_1);

        }else if(this.checkBox_2.getId() == view.getId()){
            toggle(cb_2 , checkBox_2);
            Toast.makeText(getContext(), "cb2" , Toast.LENGTH_SHORT).show();
        }else if(this.checkBox_3.getId() == view.getId()){
//
        }else if(this.checkBox_4.getId() == view.getId()){
//
        }
        else if(this.btn_Kembali == view){
            this.activity.changeToDataDiri_4();
        }else if(this.btn_Selanjutnya == view){
        }else if(btn_Tindakan == view){

        }else if(this.btn_Gejala == view){
        }else if(this.btn_Klasifikasi == view){
            HashMap<String , Integer> collectionOfClassification = activity.presenter.classifyAll();
            activity.changeToKlasifikasiTest(collectionOfClassification);
        }
    }

    private void toggle(Checkbox_Model cm , CheckBox cb){
        if(cb.isChecked()) {
            cm.setStatus_Check(true);
            activity.presenter.addGejala(cm.getText_Checkbox(),cm.getId());
        }
        else {
            cm.setStatus_Check(false);
            activity.presenter.removeGejala(cm.getText_Checkbox());
        }
    }

//    method to get all id's and gejala from the database
}
