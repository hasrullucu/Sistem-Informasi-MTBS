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
public class FragmentBatuk2 extends Fragment implements View.OnClickListener {

    protected PemeriksaanMain activity;
    protected Button btnGejala, btnKlas, btnTindakan, btnBack, btnNext;


    public FragmentBatuk2 () {}



    public static FragmentBatuk2 newInstance(PemeriksaanMain activity)
    {
        FragmentBatuk2 res = new FragmentBatuk2();
        res.activity = activity;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.batuk2, container, false);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        return result ;
    }


    @Override
    public void onClick(View view) {
        if ( view == this.btnBack ) {
            this.activity.changeToBatuk1();
        }
        else if ( view == this.btnNext ) {
            this.activity.changeToBatuk3();
        }
    }
}
