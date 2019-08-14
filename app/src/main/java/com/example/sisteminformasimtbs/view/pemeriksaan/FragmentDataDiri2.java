package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.DateLogic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDataDiri2 extends Fragment implements View.OnClickListener , DatePickerDialog.OnDateSetListener{
    protected PemeriksaanMain activity;
    protected Button btnBack, btnNext , btn_PickDate;


    // date picker
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter ;
    private DateLogic dateLogic;


    public FragmentDataDiri2() {
        // Required empty public constructor
    }

    public static FragmentDataDiri2 newInstance(PemeriksaanMain activity){
        FragmentDataDiri2 res = new FragmentDataDiri2();
        res.activity=activity;
        res.dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        res.dateLogic  = new DateLogic();

        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.datadiri_2, container, false);
        this.btnBack = res.findViewById(R.id.btnBack);
        this.btnNext = res.findViewById(R.id.btnNext);
        this.btn_PickDate = res.findViewById(R.id.btn_PickDate);
        this.btnBack.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.btn_PickDate.setOnClickListener(this);
        return res;
    }



    private void showDateDialog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this.activity, this, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }

    /**
     *
     * @param datePicker
     * @param i year
     * @param i1 month
     * @param i2 date
     */
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        /**
         * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
         */

        /**
         * Set Calendar untuk menampung tanggal yang dipilih
         */
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(i,i1, i2);

        Calendar nowDate = Calendar.getInstance();




        /**
         * Update TextView dengan tanggal yang kita pilih
         */
        Log.d( "newdate" ,"Tanggal dipilih : "+dateFormatter.format(birthDate.getTime()));
        Log.d( "nowdate" ,"Tanggal dipilih : "+dateFormatter.format(nowDate.getTime()));
        Log.d("diff" , " diff month : "+ dateLogic.getDiffDate(nowDate , birthDate , Calendar.MONTH)) ;

        int year = dateLogic.getDiffDate(nowDate , birthDate , Calendar.YEAR) ;
        int month = dateLogic.getDiffDate(nowDate , birthDate , Calendar.MONTH) ;


        Log.d("logic" , "untuk diatas 2 bulan " + dateLogic.checkDiAtas2BulanPemeriksaan(year , month));

    }


    @Override
    public void onClick(View view){
        if(view==btnBack){
            this.activity.changeToDataDiri_1();
        }
        else if(view==btnNext){
            this.activity.changeToDataDiri_3();
        }else if(view == this.btn_PickDate){
            showDateDialog();
        }
    }
}
