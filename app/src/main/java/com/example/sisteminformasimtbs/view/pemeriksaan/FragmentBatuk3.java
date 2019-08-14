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
public class FragmentBatuk3 extends Fragment implements View.OnClickListener {
    private PemeriksaanMain activity;
    private Button btnGejala , btnKlas , btnTindakan , btnBack , btnNext ;

    public FragmentBatuk3() {
        // Required empty public constructor
    }

    public static FragmentBatuk3 newInstance(PemeriksaanMain activity){
        FragmentBatuk3 res = new FragmentBatuk3();
        res.activity = activity;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.batuk3 , container , false);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);

//        set next button and back
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);

        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        return result;

    }

    @Override
    public void onClick(View v) {
        if (v == this.btnBack) {
            this.activity.changeToBatuk1();

        }else if(v == this.btnNext){
            this.activity.changeToDiare1();
        }
    }
}
