package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDataDiri_1 extends Fragment implements View.OnClickListener{
    protected PemeriksaanMain_Activity activity;
    protected TextView tanggalPemeriksaanAuto;
    private SimpleDateFormat dateFormatter;

    private LinearLayout btn_Kembali ;
    private LinearLayout btn_Selanjutnya;

    public FragmentDataDiri_1() {
        // Required empty public constructor
    }

    public static FragmentDataDiri_1 newInstance(PemeriksaanMain_Activity activity){
        FragmentDataDiri_1 res = new FragmentDataDiri_1();
        res.activity=activity;
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.datadiri_1, container, false);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);

        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);


        Calendar nowDate = Calendar.getInstance();

        this.dateFormatter = new SimpleDateFormat("dd MMM yyyy", Locale.US);
//        this.tanggalPemeriksaanAuto.setText(dateFormatter.format(nowDate.getTime()));

        return res;
    }

    @Override
    public void onClick(View view){
        if(view.getId()==btn_Kembali.getId()){
            activity.finish();
        }
        else if(view.getId()==btn_Selanjutnya.getId()){
            this.activity.changeToDataDiri_2();
        }
    }
}
