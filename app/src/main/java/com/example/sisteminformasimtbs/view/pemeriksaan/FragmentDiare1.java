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
public class FragmentDiare1 extends Fragment implements View.OnClickListener{
    protected Button btnNext, btnBack, btnGejala, btnKlas, btnTindakan, increase, decrease;
    protected TextView integer_number;
    protected PemeriksaanMain activity;
    int minteger = 0;

    public FragmentDiare1() {
        // Required empty public constructor
    }


    public static FragmentDiare1 newInstance(PemeriksaanMain activity){
        FragmentDiare1 result = new FragmentDiare1();
        result.activity=activity;
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.diare1, container, false);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);
        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.increase = result.findViewById(R.id.increase);
        this.decrease = result.findViewById(R.id.decrease);
        this.integer_number = result.findViewById(R.id.integer_number);

        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.btnGejala.setOnClickListener(this);
        this.btnKlas.setOnClickListener(this);
        this.btnTindakan.setOnClickListener(this);
        this.increase.setOnClickListener(this);
        this.decrease.setOnClickListener(this);
        return result;
    }

    public void increaseInteger()
    {
        minteger = minteger + 1;
        display(minteger);
    }

    public void decreaseInteger()
    {
        minteger = minteger - 1;

        if (minteger < 0)
        {
            minteger = 0;
        }

        display(minteger);
    }

    private void display(int number)
    {
        this.integer_number.setText("" + number);
    }

    @Override
    public void onClick(View view) {
        if(view==btnBack){
            this.activity.changeToBatuk3();
        }
        else if(view==btnNext){
            this.activity.changeToDiare2();
        }
        else if(view==btnGejala){

        }
        else if(view==btnKlas){

        }
        else if(view==btnTindakan){

        }
        else if (view == decrease)
        {
            this.decreaseInteger();
        }
        else if (view == increase)
        {
            this.increaseInteger();
        }
    }
}