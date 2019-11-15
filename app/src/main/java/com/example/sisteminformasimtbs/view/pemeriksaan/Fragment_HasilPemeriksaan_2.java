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
import com.example.sisteminformasimtbs.model.dataclass.DiagnosisResult;

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
        return res;
    }

    @Override
    public void onClick(View view) {
        if(view == this.btn_akhirPemeriksaan){
            activity.finish();
        }
    }
}
