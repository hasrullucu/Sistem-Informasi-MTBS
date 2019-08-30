package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDataDiri3 extends Fragment implements View.OnClickListener{
    protected PemeriksaanMain activity;

    private LinearLayout btn_Kembali ;
    private LinearLayout btn_Selanjutnya ;



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
        this.btn_Kembali = res.findViewById(R.id.btn_Selanjutnya) ;
        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya) ;

        this.btn_Kembali.setOnClickListener(this);
        this.btn_Selanjutnya.setOnClickListener(this);
        return res;
    }

    @Override
    public void onClick(View view){
        if(view==btn_Selanjutnya){
            activity.changeToDataDiri_2();
        }
        else if(view==btn_Selanjutnya){
        }
    }
}
