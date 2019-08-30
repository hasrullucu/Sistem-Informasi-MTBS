package com.example.sisteminformasimtbs.testing;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;

/**
 * A simple {@link Fragment} subclass.
 */
public class Batuk_Test extends Fragment implements View.OnClickListener{
    private PemeriksaanMain activity ;

    private CheckBox tarikan_CheckBox ;
    private Checkbox_Model tarikan_Model ;

    private CheckBox saturasiOksigen_CheckBox ;
    private Checkbox_Model saturasiOksigen_Model ;

    private CheckBox nafascepat_CheckBox ;
    private Checkbox_Model nafascepat_Model;

    private Button backBtn;
    private Button classify  ;
    public Batuk_Test() {
        // Required empty public constructor
    }

    public static Batuk_Test newInstance(PemeriksaanMain activity){
        Batuk_Test res = new Batuk_Test();
        res.activity = activity ;

        return res ;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res =  inflater.inflate(R.layout.fragment_batuk__test, container, false);
        this.tarikan_Model = new Checkbox_Model("Tarikan dinding dada ke dalam", 9) ;
        this.tarikan_CheckBox = res.findViewById(R.id.tarikan);
        this.tarikan_CheckBox.setText(this.tarikan_Model.getText_Checkbox());
        this.tarikan_CheckBox.setOnClickListener(this);


        this.saturasiOksigen_Model = new Checkbox_Model("Saturasi Oksigen < 90%" , 10);
        this.saturasiOksigen_CheckBox = res.findViewById(R.id.saturasi);
        this.saturasiOksigen_CheckBox.setText(this.saturasiOksigen_Model.getText_Checkbox());
        this.saturasiOksigen_CheckBox.setOnClickListener(this);

        this.nafascepat_Model= new Checkbox_Model("Nafas cepat" , 11 );
        this.nafascepat_CheckBox = res.findViewById(R.id.nafascepat);
        this.nafascepat_CheckBox.setText(this.nafascepat_Model.getText_Checkbox());
        this.nafascepat_CheckBox.setOnClickListener(this);


        this.backBtn  = res.findViewById(R.id.back_btn) ;
        this.backBtn.setOnClickListener(this);

        this.classify = res.findViewById(R.id.classify);
        this.classify.setOnClickListener(this);

        return res ;
    }

    @Override
    public void onClick(View view) {
        if(this.tarikan_CheckBox.getId() == view.getId()){
                toggle(this.tarikan_Model , this.tarikan_CheckBox);
        }else if(this.saturasiOksigen_CheckBox.getId() == view.getId()){
                toggle(this.saturasiOksigen_Model , this.saturasiOksigen_CheckBox);
        }else if(this.nafascepat_CheckBox.getId() == view.getId()) {
            toggle(this.nafascepat_Model , this.nafascepat_CheckBox);

        }else if(this.backBtn.getId() == view.getId()){
            this.activity.changeToTandaBahayaUmum();
        }else if(this.classify.getId() == view.getId()){
            Toast.makeText(getContext() ,"jumlah klasifikasi : " +  activity.presenter.classifyAll().size() ,Toast.LENGTH_SHORT ).show();
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
}
