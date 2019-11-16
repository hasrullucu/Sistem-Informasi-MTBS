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
import com.example.sisteminformasimtbs.model.IndonesiaFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;


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
        int day = nowDate.get(Calendar.DAY_OF_MONTH);
        int month = nowDate.get(Calendar.MONTH);
        int year = nowDate.get(Calendar.YEAR);

        this.activity.balitaNow.setTanggalPemeriksaan(""+day+month+year);

        this.tanggalPemeriksaanAuto.setText(IndonesiaFormatter.convertDate(year, month , day));
        return res;
    }

    @Override
    public void onClick(View view){
        if(view.getId()==btn_Kembali.getId()){
            activity.finish();
        }
        else if(view.getId()==btn_Selanjutnya.getId()){
            String namaAnak = this.namaAnak_EditText.getText().toString();
            String namaIbu  = this.namaIbu_EditText.getText().toString();
            RadioButton rJenisKelamin = this.activity.findViewById(this.rg_JenisKelamin.getCheckedRadioButtonId());
            String alamat = this.alamat_EditText.getText().toString();

            if(isValidated(namaAnak , namaIbu , rJenisKelamin , alamat)){
                this.activity.balitaNow.setNamaAnak(namaAnak);
                this.activity.balitaNow.setNamaIbu(namaIbu);
                this.activity.balitaNow.setAlamat(alamat);
                this.activity.balitaNow.setJenisKelamin(getJenisKelamin(rJenisKelamin.getText().toString()));
                this.activity.changeToDataDiri_2();

            }else{
                Toast.makeText(getContext() , "Anda perlu mengisi semua data balita" , Toast.LENGTH_LONG).show();
            }


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

    private char getJenisKelamin(String jenisKelamin){
        if(jenisKelamin.equals("Laki-laki")){
            return 'L';
        }

        return 'P';
    }

    private boolean isValidated(String namaAnak , String namaIbu , RadioButton rJenisKelamin , String alamat){

        if(rJenisKelamin == null){
            return false;
        }
        char  jenisKelamin = getJenisKelamin(rJenisKelamin.getText().toString());
        Log.d("tes" , namaAnak + " " + namaIbu + " " + jenisKelamin + " " + alamat);
        if(namaAnak.equals("") || namaIbu.equals("") || !Character.isLetter(jenisKelamin) || alamat.equals("")){
            return false;
        }
        return true ;

    }
}
