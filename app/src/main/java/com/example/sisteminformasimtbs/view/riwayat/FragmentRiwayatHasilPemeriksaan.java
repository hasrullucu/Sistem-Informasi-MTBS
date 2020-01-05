package com.example.sisteminformasimtbs.view.riwayat;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.IndonesiaFormatter;
import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.Kunjungan;
import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;
import com.example.sisteminformasimtbs.view.pemeriksaan.KlasifikasiListAdapter;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRiwayatHasilPemeriksaan extends Fragment implements View.OnClickListener{
    private RiwayatBalita_Activity activity ;
    private Balita balitaNow ;
    private Kunjungan kunjunganNow ;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ImageView iv_jenisKelamin ;
    private LinkedList<DiagnosisResult> collectionOfClassificationResult ;

    private LinearLayout btn_akhirPemeriksaan;
    private LinearLayout btn_kembali ;

    private TextView kunjunganUlang;
    private TextView tanggalPemeriksaan;
    private TextView namaAnak;
    private TextView jenisKelamin;
    private TextView tinggiBerat;
    private TextView umur_EditText;

    public FragmentRiwayatHasilPemeriksaan() {
        // Required empty public constructor
    }

    public static FragmentRiwayatHasilPemeriksaan newInstance(RiwayatBalita_Activity activity, LinkedList<DiagnosisResult> collectionOfClassificationResult, Balita balitaNow, Kunjungan kunjunganNow){
        FragmentRiwayatHasilPemeriksaan res = new FragmentRiwayatHasilPemeriksaan();
        res.activity = activity ;
        res.collectionOfClassificationResult = collectionOfClassificationResult;
        res.mAdapter = new KlasifikasiListAdapter(res.collectionOfClassificationResult);
        res.balitaNow = balitaNow;
        res.kunjunganNow = kunjunganNow;
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res =  inflater.inflate(R.layout.fragment_fragment_riwayat_hasil_pemeriksaan, container, false);
        this.recyclerView = res.findViewById(R.id.recyclerViewKlasifikasi) ;
        this.mAdapter = new KlasifikasiListAdapter((LinkedList<DiagnosisResult>)this.collectionOfClassificationResult);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        this.recyclerView.setAdapter(this.mAdapter);

        this.kunjunganUlang = res.findViewById(R.id.kunjungan);
        this.kunjunganUlang.setText("Kunjungan : " + this.kunjunganNow.getKunjunganKe());

        this.tanggalPemeriksaan = res.findViewById(R.id.tanggalPemeriksaan);
        String formattedTanggalKunjungan = IndonesiaFormatter.splitAndFormatDate(this.kunjunganNow.getTanggalKunjungan());
        this.tanggalPemeriksaan.setText(formattedTanggalKunjungan);

        this.namaAnak = res.findViewById(R.id.namaAnak_Kesimpulan_EditText);
        this.namaAnak.setText(""  + this.balitaNow.getNama());

        this.jenisKelamin = res.findViewById(R.id.namaIbu_Kesimpulan_EditText);
        if(this.balitaNow.getJenisKelamin() == 'P'){
            this.jenisKelamin.setText("PEREMPUAN");
        }else{
            this.jenisKelamin.setText("LAKI-LAKI");
        }

        this.iv_jenisKelamin = res.findViewById(R.id.iv_jenis_kelamin);
        if(this.balitaNow.getJenisKelamin() == 'P'){
            this.iv_jenisKelamin.setImageDrawable(getResources().getDrawable(R.drawable.girl_withbg));
        }


        this.tinggiBerat = res.findViewById(R.id.tinggi_berat_EditText);
        this.tinggiBerat.setText(this.kunjunganNow.getBeratBadan() + " KG / " + this.kunjunganNow.getPanjangBadan() + " CM");

        this.umur_EditText = res.findViewById(R.id.umur_EditText);
        this.umur_EditText.setText("Keluhan :"+this.kunjunganNow.getKeluhan());

        this.btn_akhirPemeriksaan = res.findViewById(R.id.btn_akhiriPemeriksaan);
        this.btn_akhirPemeriksaan.setOnClickListener(this);

        this.btn_kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_kembali.setOnClickListener(this);


        return res;

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_kembali.getId() || view.getId() == this.btn_akhirPemeriksaan.getId()){
            this.activity.changeToProfileBalita(balitaNow);
        }
    }
}
