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
import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.model.IndonesiaFormatter;
import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.Kunjungan;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBalitaProfile extends Fragment implements View.OnClickListener  {
    private RiwayatBalita_Activity activity;
    private Balita balita;


    private TextView namaAnakTextView;
    private TextView namaIbuTextView ;
    private ImageView jenisKelaminImageView;
    private TextView tanggalLahirTextView  ;
    private TextView alamatTextView;

    private LinearLayout btn_Kembali;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    public FragmentBalitaProfile() {
        // Required empty public constructor
    }

    public static FragmentBalitaProfile newInstance(RiwayatBalita_Activity activity , Balita balita){
        FragmentBalitaProfile res = new FragmentBalitaProfile();
        res.activity = activity ;
        res.balita  = balita;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_fragment_balita_profile, container, false);

        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.namaAnakTextView = res.findViewById(R.id.namaAnak_TextView);
        this.namaAnakTextView.setText(this.balita.getNama()+"");

        this.namaIbuTextView = res.findViewById(R.id.namaIbu_TextView);
        this.namaIbuTextView.setText(this.balita.getNamaIbu()+"");


        this.jenisKelaminImageView = res.findViewById(R.id.jenisKelaminImageView);
        if(this.balita.getJenisKelamin() == 'P'){
                this.jenisKelaminImageView.setImageDrawable(getResources().getDrawable(R.drawable.girl_withbg));
        }

        this.alamatTextView = res.findViewById(R.id.alamat_TextView);
        this.alamatTextView.setText(this.balita.getAlamat()+"");

        String formattedTanggal = IndonesiaFormatter.splitAndFormatDate(this.balita.getTanggalLahir());

        this.tanggalLahirTextView = res.findViewById(R.id.tanggalLahirTextView);
        this.tanggalLahirTextView.setText(formattedTanggal+"");

        this.recyclerView = res.findViewById(R.id.riwayatPemeriksaanRecyclerView) ;

        DatabaseHelper db = this.activity.getDb();
        LinkedList<Kunjungan> allKunjungan = db.getAllKunjunganBasedByBalitaId(this.balita.getIdBalita()) ;
        this.mAdapter = new KunjunganRecyclerViewAdapter(activity, allKunjungan,balita);
//        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        this.recyclerView.setAdapter(this.mAdapter);

        return res ;
    }

    @Override
    public void onClick(View view) {
        if(this.btn_Kembali.getId() == view.getId()){
            this.activity.changeToRiwayatDataBalita();
        }
    }
}
