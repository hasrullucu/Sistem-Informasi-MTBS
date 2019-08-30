package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.content.Context;
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
public class FragmentBatuk1 extends Fragment implements View.OnClickListener {

    protected PemeriksaanMain activity;
    protected Button btnGejala, btnKlas, btnTindakan, increase, decrease, btnBack, btnNext;
    protected TextView integer_number;
    protected Context context;
    protected int n = 0;
    int minteger = 0;

    public FragmentBatuk1 () {}

    public static FragmentBatuk1 newInstance(PemeriksaanMain activity)
    {
        FragmentBatuk1 res = new FragmentBatuk1();
        res.activity=activity;
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.batuk1, container, false);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.increase = result.findViewById(R.id.increase);
        this.decrease = result.findViewById(R.id.decrease);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
        this.integer_number = result.findViewById(R.id.integer_number);
        this.btnGejala.setOnClickListener(this);
        this.btnKlas.setOnClickListener(this);
        this.btnTindakan.setOnClickListener(this);
        this.increase.setOnClickListener(this);
        this.decrease.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.integer_number.setOnClickListener(this);
        return result ;

    }

    public void increaseInteger() {
        minteger = minteger + 1;
        display(minteger);
    }

    public void decreaseInteger() {
        minteger = minteger - 1;

        if (minteger < 0)
        {
            minteger = 0;
        }

        display(minteger);
    }

    private void display(int number) {
        //TextView displayInteger = (TextView) integer_number.findViewById();
        this.integer_number.setText("" + number);
    }

    @Override
    public void onClick(View v) {
        if (v == this.btnBack)
        {
            this.activity.changeToTandaBahayaUmum();
        }
        else if (v == btnNext)
        {
            this.activity.changeToBatuk2();
        }
        else if (v == increase)
        {
            this.increaseInteger();
        }
        else if (v == decrease)
        {
            this.decreaseInteger();
        }
    }
}