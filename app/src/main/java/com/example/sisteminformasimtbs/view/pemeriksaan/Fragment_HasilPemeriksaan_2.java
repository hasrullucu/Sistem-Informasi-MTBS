package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.IndonesiaFormatter;
import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_HasilPemeriksaan_2 extends Fragment implements View.OnClickListener {
    private PemeriksaanMain_Activity activity;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private LinearLayout btn_akhirPemeriksaan;
    private LinearLayout btn_kembali ;

    private TextView kunjunganUlang;
    private TextView tanggalPemeriksaan;
    private TextView namaAnak;
    private TextView jenisKelamin;
    private TextView tinggiBerat;
    private TextView umur_EditText;

    private LinkedList<DiagnosisResult> collectionOfClassificationResult ;

    public static Fragment_HasilPemeriksaan_2 newInstance(PemeriksaanMain_Activity activity , HashMap<String , Integer> collectionOfClassificationResult){
        Fragment_HasilPemeriksaan_2 res = new Fragment_HasilPemeriksaan_2();
        res.activity = activity ;
        res.collectionOfClassificationResult = new LinkedList<DiagnosisResult>();
        for(Map.Entry<String, Integer> item : collectionOfClassificationResult.entrySet() ){
            res.collectionOfClassificationResult.add(new DiagnosisResult(item.getKey() , item.getValue()));
        }
        res.mAdapter = new KlasifikasiListAdapter(res.collectionOfClassificationResult);
        return res;
    }

    public Fragment_HasilPemeriksaan_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res = inflater.inflate(R.layout.fragment_pemeriksaan_selesai_2, container, false);
        this.recyclerView = res.findViewById(R.id.recyclerViewKlasifikasi) ;
        this.mAdapter = new KlasifikasiListAdapter((LinkedList<DiagnosisResult>)this.collectionOfClassificationResult);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        this.recyclerView.setAdapter(this.mAdapter);

        this.btn_akhirPemeriksaan  = res.findViewById(R.id.btn_akhiriPemeriksaan);
        this.btn_akhirPemeriksaan.setOnClickListener(this);

        this.kunjunganUlang = res.findViewById(R.id.kunjungan);
        this.tanggalPemeriksaan = res.findViewById(R.id.tanggalPemeriksaan);
        this.namaAnak = res.findViewById(R.id.namaAnak_Kesimpulan_EditText);
        this.jenisKelamin = res.findViewById(R.id.namaIbu_Kesimpulan_EditText);
        this.tinggiBerat = res.findViewById(R.id.tinggi_berat_EditText);
        this.umur_EditText = res.findViewById(R.id.umur_EditText);



        if (activity.presenter.getKunjunganUlang() > 0) {
            this.kunjunganUlang.setText("KUNJUNGAN ULANG " + activity.presenter.getKunjunganUlang() + " HARI");
        } else {
            this.kunjunganUlang.setText("SELAMAT!!! PASIEN ANDA SEHAT");
        }

        Calendar nowDate = Calendar.getInstance();
        int day = nowDate.get(Calendar.DAY_OF_MONTH);
        int month = nowDate.get(Calendar.MONTH);
        int year = nowDate.get(Calendar.YEAR);

        this.tanggalPemeriksaan.setText("" + IndonesiaFormatter.convertDate(year, month , day));
        this.namaAnak.setText("" + activity.balitaNow.getNamaAnak());
        this.tinggiBerat.setText(activity.balitaNow.getBeratBadan() + " KG / " + activity.balitaNow.getTinggiBadan() + " CM");

        int tahunBalita = activity.balitaNow.getTahun();
        int bulanBalita = activity.balitaNow.getBulan();
        int tanggalBalita = activity.balitaNow.getTanggal();

        this.umur_EditText.setText(IndonesiaFormatter.convertUmur(tahunBalita,bulanBalita,tanggalBalita));
        if (activity.balitaNow.getJenisKelamin() == 'P')
        {
            this.jenisKelamin.setText("Perempuan");
        }
        else
        {
            this.jenisKelamin.setText("Laki-Laki");
        }

        this.btn_kembali = res.findViewById(R.id.include);
        this.btn_kembali.setOnClickListener(this);
        return res;
    }

    @Override
    public void onClick(View view) {
        if(view == this.btn_akhirPemeriksaan){
            activity.finish();
        }else if(view == this.btn_kembali){
            activity.changeToHasilPemeriksaan();
        }
    }
}
