package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.DateLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDataDiri4 extends Fragment implements View.OnClickListener{
    protected PemeriksaanMain activity;
    protected Button btnBack, btnNext;
    protected TextView tindakanAuto;

    private SimpleDateFormat dateFormatter ;
    private DateLogic dateLogic;

    public FragmentDataDiri4() {
        // Required empty public constructor
    }

    public static FragmentDataDiri4 newInstance(PemeriksaanMain activity){
        FragmentDataDiri4 res = new FragmentDataDiri4();
        res.activity = activity;
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.datadiri_4, container, false);
        this.btnBack = res.findViewById(R.id.btnBack);
        this.btnNext = res.findViewById(R.id.btnNext);
        this.tindakanAuto = res.findViewById(R.id.tindakanAuto);

        this.dateFormatter = new SimpleDateFormat("dd MMM yyyy", Locale.US);
        this.dateLogic  = new DateLogic();

        //dapatkan tanggal sekarang
        Calendar nowDate = Calendar.getInstance();

        //dapatkan tanggal lahir balita
//        Balita balita = new Balita("abcdef", 1, "anna", 1, "Jl. abc", 'p', "16 Mar 2019", 10);
//        String tanggalLahir = balita.getTanggalLahir();
//        Log.d("tanggal asli", tanggalLahir);

        //ubah tanggal string to calendar
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
//        try {
////            cal.setTime(sdf.parse(tanggalLahir));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Log.d("tanggal lahir balita", tanggalLahir);
//        Log.d("tanggal date now", dateFormatter.format(nowDate.getTime()));

        int year = dateLogic.getDiffDate(nowDate , cal , Calendar.YEAR) ;
        int month = dateLogic.getDiffDate(nowDate , cal , Calendar.MONTH) ;

        DateLogic dateLogic = new DateLogic();
        boolean resultUmur = dateLogic.checkDiAtas2BulanPemeriksaan(year, month);

        if (resultUmur == true)
        {
            this.tindakanAuto.setText("Proses MTBS akan dilakukan sesuai prosedur untuk balita umur 2 bulan - 5 tahun");
        }
        else
        {
            this.tindakanAuto.setText("Proses MTBS akan dilakukan sesuai prosedur untuk balita berumur dibawah 2 bulan");
        }

        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        return res;
    }

    @Override
    public void onClick(View view) {
        if(view==btnBack){
            this.activity.changeToDataDiri_3();
        }
        else if(view==btnNext){
            this.activity.changeToTandaBahayaUmum1();
        }
    }
}