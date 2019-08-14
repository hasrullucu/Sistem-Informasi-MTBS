package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDiare2 extends Fragment implements View.OnClickListener {
    protected Button btnNext, btnBack, btnGejala, btnKlas, btnTindakan;
    protected PemeriksaanMain activity;

    public FragmentDiare2() {
        // Required empty public constructor
    }

    public static FragmentDiare2 newInstance(PemeriksaanMain activity){
        FragmentDiare2 fragmentDiare2 = new FragmentDiare2();
        fragmentDiare2.activity = activity;
        return fragmentDiare2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result  = inflater.inflate(R.layout.diare2 , container, false);
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
            this.activity.changeToDiare1();
        }else if(v == this.btnNext){
//            change to the next fragment
            this.activity.changeToDemam1();
        }else if(v == this.btnGejala){

        }else if(v == this.btnKlas){

        }else if(v == this.btnTindakan){

        }

    }
}
