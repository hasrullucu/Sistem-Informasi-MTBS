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
public class FragmentAnemia extends Fragment implements View.OnClickListener {
    protected Button btnBack, btnNext, btnGejala, btnKlas, btnTindakan;
    protected PemeriksaanMain activity;

    public FragmentAnemia() {
        // Required empty public constructor
    }

    public static FragmentAnemia newInstance (PemeriksaanMain activity)
    {
        FragmentAnemia result = new FragmentAnemia();
        result.activity = activity;
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View result = inflater.inflate(R.layout.anemia1, container, false);
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
        if (v == this.btnBack)
        {
            this.activity.changeToStatusGizi2();
        }
        else if (v == this.btnNext)
        {
            this.activity.changeToStatusHIV1();
        }
    }
}