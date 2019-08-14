package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.PeriksaTandaBahayaUmum;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTandaBahayaUmum1 extends Fragment implements View.OnClickListener {
    protected Button btnBack, btnNext, btnGejala, btnKlas, btnTindakan;
    protected Context context;
    protected PemeriksaanMain activity;

    protected PeriksaTandaBahayaUmum ptb;


    protected CheckBox checkBox1 , checkBox2 , checkBox3 , checkBox4 , checkBox5 , checkBox6 , checkBox7 , checkBox8 ;

    public FragmentTandaBahayaUmum1() {
        // Required empty public constructor
    }

    public static FragmentTandaBahayaUmum1 newInstance(PemeriksaanMain activity , SQLiteDatabase db){
        FragmentTandaBahayaUmum1 result = new FragmentTandaBahayaUmum1();
        result.activity = activity;
        result.ptb = new PeriksaTandaBahayaUmum(db);
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.tandabahayaumum1, container, false);
        this.btnBack = result.findViewById(R.id.btnBack);
        this.btnNext = result.findViewById(R.id.btnNext);
        this.btnGejala = result.findViewById(R.id.btnGejala);
        this.btnKlas = result.findViewById(R.id.btnKlas);

        this.checkBox1 = result.findViewById(R.id.checkbox1);
        this.checkBox2 = result.findViewById(R.id.checkbox2);
        this.checkBox3 = result.findViewById(R.id.checkbox3);
        this.checkBox4 = result.findViewById(R.id.checkbox4);
        this.checkBox5 = result.findViewById(R.id.checkbox5);
        this.checkBox6 = result.findViewById(R.id.checkbox6);
        this.checkBox7 = result.findViewById(R.id.checkbox7);
        this.checkBox8 = result.findViewById(R.id.checkbox8);

        this.checkBox1.setText(ptb.getGejala(1));
        this.checkBox2.setText(ptb.getGejala(2));
        this.checkBox3.setText(ptb.getGejala(3));
        this.checkBox4.setText(ptb.getGejala(4));
        this.checkBox5.setText(ptb.getGejala(5));
        this.checkBox6.setText(ptb.getGejala(6));
        this.checkBox7.setText(ptb.getGejala(7));
        this.checkBox8.setText(ptb.getGejala(8));


        this.checkBox1.setOnClickListener(this);
        this.checkBox2.setOnClickListener(this);
        this.checkBox3.setOnClickListener(this);
        this.checkBox4.setOnClickListener(this);
        this.checkBox5.setOnClickListener(this);
        this.checkBox6.setOnClickListener(this);
        this.checkBox7.setOnClickListener(this);
        this.checkBox8.setOnClickListener(this);



        this.btnTindakan = result.findViewById(R.id.btnTindakan);
        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.btnGejala.setOnClickListener(this);
        this.btnKlas.setOnClickListener(this);
        this.btnTindakan.setOnClickListener(this);
        return result;
    }



    @Override
    public void onClick(View view) {
        if(view==btnBack){
            this.activity.changeToDataDiri_4();
        }
        else if(view==btnNext){
            this.activity.changeToBatuk1();
        }
        else if(view==btnGejala){
//            this.activity.changeToTandaBahayaUmum1();
        }
        else if(view==btnKlas){
//            this.activity.changeToKlasifikasiTandaBahayaUmum();
        }
        else if(view==btnTindakan){
//            this.activity.changeToTindakanTandaBahayaUmum();
        }
        else if(view== this.checkBox1) {
//            checkToModel(1);
        }
        else if(view == this.checkBox2){
//            checkToModel(2);
        }
        else if(view ==this.checkBox3){
//            checkToModel(3);
        }
        else if(view ==this.checkBox4) {
//            checkToModel(4);
        }
        else if(view ==this.checkBox5){
//            checkToModel(5);
        }
        else if(view ==this.checkBox6) {
//            checkToModel(6);
        }
        else if(view ==this.checkBox7){
//            checkToModel(7);
        }
        else if(view == this.checkBox8) {
//            checkToModel(8);
        }
    }

    private void checkToModel(int id ){
        ptb.updateHasil(id);
    }
}
