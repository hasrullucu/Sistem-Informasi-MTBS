package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sisteminformasimtbs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_HasilPemeriksaan_1 extends Fragment implements View.OnClickListener{

    private PemeriksaanMain_Activity activity;


    private LinearLayout btn_Selanjutnya ;
    private LinearLayout btn_Kembali ;
    public Fragment_HasilPemeriksaan_1() {
        // Required empty public constructor
    }

    public static Fragment_HasilPemeriksaan_1 newInstance(PemeriksaanMain_Activity activity){
        Fragment_HasilPemeriksaan_1 res = new Fragment_HasilPemeriksaan_1();
        res.activity = activity;

        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View res = inflater.inflate(R.layout.fragment_pemeriksaan_selesai, container, false);
        this.btn_Selanjutnya = res.findViewById(R.id.btn_hasil_pemeriksaan);
        this.btn_Selanjutnya.setOnClickListener(this);

        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        return res;

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_Selanjutnya.getId()){
//             change to  hasil 2
            activity.changeToHasilPemeriksaanAkhir(activity.presenter.classifyAll());

        }else if(view.getId() == this.btn_Kembali.getId()){
//            change to hasil 1
            activity.changeToStatusHIV1();
        }
    }
}
