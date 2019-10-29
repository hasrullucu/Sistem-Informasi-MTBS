package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    private TextView namaAnak_EditText ;
    private TextView namaIbu_EditText ;
    private TextView alamat_EditText ;


    private RadioGroup rg_JenisKelamin ;
    private RadioButton radioLaki ;
    private RadioButton radioPerempuan ;
    private String nowKelamin ;



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


        this.namaAnak_EditText = res.findViewById(R.id.namaAnak_editText);
        this.namaIbu_EditText = res.findViewById(R.id.namaIbu_EditText);
        this.alamat_EditText = res.findViewById(R.id.alamat_EditText) ;
        this.tanggalPemeriksaanAuto = res.findViewById(R.id.tanggalPemeriksaanAuto);

        this.rg_JenisKelamin = res.findViewById(R.id.rg_JenisKelamin);
        this.radioLaki = res.findViewById(R.id.radioLaki) ;
        this.radioLaki.setOnClickListener(this);
        this.radioPerempuan  =res.findViewById(R.id.radioPerempuan);
        this.radioPerempuan.setOnClickListener(this);

        Calendar nowDate = Calendar.getInstance();

        this.dateFormatter = new SimpleDateFormat("dd MMM yyyy", Locale.US);
        this.tanggalPemeriksaanAuto.setText(dateFormatter.format(nowDate.getTime()));




        return res;
    }

    @Override
    public void onClick(View view){
        if(view.getId()==btn_Kembali.getId()){
            activity.finish();
        }
        else if(view.getId()==btn_Selanjutnya.getId()){
            this.activity.changeToDataDiri_2();
            Log.d("datadiri" , this.tanggalPemeriksaanAuto.getText() +"");
            Log.d("datadiri" , this.alamat_EditText.getText() + "");
            Log.d("datadiri" , this.namaAnak_EditText.getText() + "");
            Log.d("datadiri" , this.namaIbu_EditText.getText() + "") ;
            Log.d("datadiri" , this.nowKelamin+"");

        }
        else if(view.getId() == this.radioPerempuan.getId()){
            if(this.radioPerempuan.isChecked()){
                this.nowKelamin = "perempuan" ;
            }
        }
        else if(view.getId() == this.radioLaki.getId()){
            if(this.radioLaki.isChecked()){
                this.nowKelamin = "lakilaki";
            }
        }
    }
}
