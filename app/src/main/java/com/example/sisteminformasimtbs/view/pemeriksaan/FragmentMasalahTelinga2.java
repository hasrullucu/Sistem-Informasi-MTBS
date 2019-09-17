package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMasalahTelinga2 extends Fragment implements View.OnClickListener {
    protected Button btnNext, btnBack, btnGejala, btnKlas, btnTindakan;
    protected PemeriksaanMain activity;


    public FragmentMasalahTelinga2() {
        // Required empty public constructor
    }

    public static FragmentMasalahTelinga2 newInstance(PemeriksaanMain activity){
        FragmentMasalahTelinga2 res = new FragmentMasalahTelinga2();
        res.activity = activity;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result  = inflater.inflate(R.layout.telinga2 , container, false);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.btnGejala.setOnClickListener(this);
        this.btnKlas.setOnClickListener(this);
        this.btnTindakan.setOnClickListener(this);
        return result;
    }

    @Override
    public void onClick(View v) {
        if(v == this.btnBack){
            this.activity.changeToMasalahTelinga1();
        }else if(v == this.btnNext){
            this.activity.changeToStatusGizi1();
        }else if(v == this.btnGejala){

        }else if(v == this.btnKlas){

        }else if(v == this.btnTindakan){

        }

    }
}
