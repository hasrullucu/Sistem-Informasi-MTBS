package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.Pemeriksaan;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDataDiri1 extends Fragment implements View.OnClickListener{
    protected PemeriksaanMain activity;
    protected Button btnBack, btnNext;
    protected TextView tanggalPemeriksaanAuto;
    private SimpleDateFormat dateFormatter;

    public FragmentDataDiri1() {
        // Required empty public constructor
    }

    public static FragmentDataDiri1 newInstance(PemeriksaanMain activity){
        FragmentDataDiri1 res = new FragmentDataDiri1();
        res.activity=activity;
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.datadiri_1, container, false);
        this.btnBack = res.findViewById(R.id.btnBack);
        this.btnNext = res.findViewById(R.id.btnNext);
        this.tanggalPemeriksaanAuto = res.findViewById(R.id.tanggalPemeriksaanAuto);

        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);

        Calendar nowDate = Calendar.getInstance();

        this.dateFormatter = new SimpleDateFormat("dd MMM yyyy", Locale.US);
        this.tanggalPemeriksaanAuto.setText(dateFormatter.format(nowDate.getTime()));

        return res;
    }

    @Override
    public void onClick(View view){
        if(view==btnBack){
            activity.finish();
        }
        else if(view==btnNext){
            this.activity.changeToDataDiri_2();
        }
    }
}
