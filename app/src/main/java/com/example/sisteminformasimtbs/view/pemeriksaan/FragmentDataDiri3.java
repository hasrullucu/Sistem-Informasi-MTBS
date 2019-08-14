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
public class FragmentDataDiri3 extends Fragment implements View.OnClickListener{
    protected PemeriksaanMain activity;
    protected Button btnBack, btnNext;

    public FragmentDataDiri3() {
        // Required empty public constructor
    }

    public static FragmentDataDiri3 newInstance(PemeriksaanMain activity){
        FragmentDataDiri3 res = new FragmentDataDiri3();
        res.activity=activity;
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.datadiri_3, container, false);
        this.btnBack = res.findViewById(R.id.btnBack);
        this.btnNext = res.findViewById(R.id.btnNext);

        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        return res;
    }

    @Override
    public void onClick(View view){
        if(view==btnBack){
            this.activity.changeToDataDiri_2();
        }
        else if(view==btnNext){
            this.activity.changeToDataDiri_4();
        }
    }
}
