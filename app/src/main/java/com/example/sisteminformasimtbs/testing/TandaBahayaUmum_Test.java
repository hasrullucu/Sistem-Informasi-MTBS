package com.example.sisteminformasimtbs.testing;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

    // classify button
    private Button button ;

    // next fragment button
    private Button nextBtn;

    // tindakan Button
    private Button tindakan_Btn ;




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



        this.checkBox_1 = res.findViewById(R.id.cb_1) ;
        this.checkBox_2 = res.findViewById(R.id.cb_2) ;

        this.button = res.findViewById(R.id.button);
        this.button.setOnClickListener(this);

        this.nextBtn = res.findViewById(R.id.nextBtn);
        this.nextBtn.setOnClickListener(this);

        this.tindakan_Btn = res.findViewById(R.id.tindakan_Btn) ;
        this.tindakan_Btn.setOnClickListener(this);

        this.cb_1 = new Checkbox_Model("Tidak bisa minum atau menyusu" , 1);
        this.cb_2 = new Checkbox_Model("Memuntahkan semua makanan dan atau minuman" , 2);
        this.checkBox_1.setOnClickListener(this);
        this.checkBox_2.setOnClickListener(this);
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
        }else if(this.button.getId()== view.getId() ){
            HashMap<String , Integer> res = this.activity.presenter.classifyAll();
            Toast.makeText(getContext(), "size : " + res.size() , Toast.LENGTH_SHORT).show();
            this.activity.changeToKlasifikasiTest(res);
        }else if(this.nextBtn.getId() == view.getId()){
            this.activity.changeToBatukTest();
        }else if(this.tindakan_Btn.getId() == view.getId()){
            this.activity.changeToTindakanTest();
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
