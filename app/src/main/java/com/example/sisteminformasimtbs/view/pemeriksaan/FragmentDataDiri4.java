package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.DateLogic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDataDiri4 extends Fragment implements View.OnClickListener{
    protected PemeriksaanMain activity;

    protected TextView tindakanAuto;

    private LinearLayout btn_Kembali ;
    private LinearLayout btn_Selanjutnya ;

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
        this.btn_Kembali  =res.findViewById(R.id.btn_Kembali) ;
        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);

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

//       this.tindakanAuto.setText(dateLogic.getStatus(resultUmur));

       this.btn_Selanjutnya.setOnClickListener(this);
       this.btn_Kembali.setOnClickListener(this);
        return res;
    }

    @Override
    public void onClick(View view) {
        if(view==btn_Kembali){
            this.activity.changeToDataDiri_2();
        }
        else if(view==btn_Selanjutnya){
            this.activity.changeToTandaBahayaUmum();
        }
    }
}