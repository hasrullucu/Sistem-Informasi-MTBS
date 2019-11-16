package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.DateLogic;
import com.example.sisteminformasimtbs.model.IndonesiaFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDataDiri_2 extends Fragment implements View.OnClickListener , DatePickerDialog.OnDateSetListener{
    protected PemeriksaanMain_Activity activity;
     private Button btn_pickCalendar;

     private String rawDate ;

     private LinearLayout btn_Kembali ;
     private LinearLayout btn_Selanjutnya ;

     private EditText berat_EditText ;
     private EditText tinggi_EditText ;
     private EditText suhu_EditText ;
     private EditText kunjungan_EditText ;
     private EditText keluhan_EditText ;


    private DatePickerDialog.OnDateSetListener mDateSetListener ;
    // date picker
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter ;
    private DateLogic dateLogic;

    public FragmentDataDiri_2() {
        // Required empty public constructor
    }

    public static FragmentDataDiri_2 newInstance(PemeriksaanMain_Activity activity){
        FragmentDataDiri_2 res = new FragmentDataDiri_2();
        res.activity=activity;
        res.dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        res.dateLogic  = new DateLogic();
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.datadiri_2, container, false);
        this.btn_Kembali = res.findViewById(R.id.btn_Kembali) ;
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);

        this.btn_pickCalendar = res.findViewById(R.id.pickCalendar)  ;
        this.btn_pickCalendar.setOnClickListener(this);

        this.berat_EditText = res.findViewById(R.id.berat_EditText) ;
        this.tinggi_EditText = res.findViewById(R.id.tinggi_EditText);
        this.suhu_EditText = res.findViewById(R.id.suhu_EditText) ;
        this.kunjungan_EditText = res.findViewById(R.id.kunjungan_EditText);
        this.keluhan_EditText = res.findViewById(R.id.keluhan_EditText);
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
        datePickerDialog = new DatePickerDialog(this.activity, R.style.DialogTheme, this, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

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
        if(view==btn_Kembali){
            this.activity.changeToDataDiri_1();
        }
        else if(view==btn_Selanjutnya){
            // validated all the edit text
            double suhu = getSuhu();
            double beratBadan = getBeratBadan();
            double tinggiBadan = getTinggiBadan();
            int kunjungan = getKunjungan();

            String keluhan = this.keluhan_EditText.getText().toString();
            String tanggal = this.rawDate;
            if(isValidated(suhu , beratBadan , tinggiBadan , kunjungan , keluhan,tanggal)){
                // save patient data in second page
                this.activity.balitaNow.setSuhu(suhu);
                this.activity.balitaNow.setBeratBadan(beratBadan);
                this.activity.balitaNow.setTinggiBadan(tinggiBadan);
                this.activity.balitaNow.setKunjungan(kunjungan);
                this.activity.balitaNow.setKeluhan(keluhan);
                this.activity.balitaNow.setTanggalLahir(tanggal);


                String a = "nama : " + this.activity.balitaNow.getNamaAnak() + "\n "
                        + "ibu :  " + this.activity.balitaNow.getNamaIbu() + "\n"
                        + "jenis kelamin :" + this.activity.balitaNow.getJenisKelamin() + "\n"
                        + "alamat " + this.activity.balitaNow.getAlamat() + " \n"
                        + "tanggal lahir " + this.activity.balitaNow.getTanggalLahir() + "\n"
                        + "suhu badan" + this.activity.balitaNow.getSuhu() + " \n"
                        + "panjang badan " + this.activity.balitaNow.getTinggiBadan() + "\n"
                        + "berat badan : " + this.activity.balitaNow.getBeratBadan() + "\n"
                        + "kunjungan " + this.activity.balitaNow.getKunjungan() + "\n"
                        + "keluhan " + this.activity.balitaNow.getKeluhan() + "\n"
                        + "condition" + this.activity.balitaNow.checkAllNotNull() + " ";



                this.activity.changeToDataDiri_4();
            }else{
                Toast.makeText(getContext() , "Anda perlu mengisi semua data balita" , Toast.LENGTH_LONG).show();
            }





        }else if(view == this.btn_pickCalendar){
            onCalendarClick();
        }
    }


    private void onCalendarClick(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dialog = new DatePickerDialog(
               getActivity(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year,month,day
        );
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month ;
                Log.d("tanggal", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
                rawDate = ""+day+month+year;
                Log.d("tanggal" , month+day+year+"");
                btn_pickCalendar.setText(IndonesiaFormatter.convertDate(year, month , day));

                activity.balitaNow.setTanggal(day);
                activity.balitaNow.setBulan(month);
                activity.balitaNow.setTahun(year);

            }
        };
//        dialog.setOnDateSetListener(mDateSetListener);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


    }


    private boolean isValidated(double suhu , double beratBadan  , double tinggiBadan , int kunjungan , String keluhan , String tanggal ){
        if(suhu == 0 || beratBadan == 0 || tinggiBadan == 0 || kunjungan == 0 ||rawDate == null|| keluhan.equals("") ){
            return false;
        }

        return true;
    }


    private double getSuhu(){
        String textSuhu  = this.suhu_EditText.getText().toString();
        if(textSuhu.equals("")) return 0 ;
        return Double.parseDouble(textSuhu);
    }

    private double getBeratBadan(){
        String textBerat = this.berat_EditText.getText().toString();
        if(textBerat.equals("")) return 0;
        return Double.parseDouble(textBerat);
    }

    private double getTinggiBadan(){
        String textTinggiBadan = this.tinggi_EditText.getText().toString();
        if(textTinggiBadan.equals("")) return 0;
        return Double.parseDouble(textTinggiBadan);
    }

    private int getKunjungan(){
        String textKunjungan = this.kunjungan_EditText.getText().toString();
        if(textKunjungan.equals("")) return 0 ;
        return Integer.parseInt(textKunjungan);
    }
}
