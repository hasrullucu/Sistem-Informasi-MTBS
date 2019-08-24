package com.example.sisteminformasimtbs.testing;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Klasifikasi_Test extends Fragment implements View.OnClickListener{
    private PemeriksaanMain activity ;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private LinkedList<DiagnosisResult> collectionOfClassificationResult ;

    private Button backBtn ;

    public Klasifikasi_Test() {
        // Required empty public constructor
    }

    public static Klasifikasi_Test newInstance(PemeriksaanMain activity, HashMap<String, Integer> collectionOfClassificationResult){
        Klasifikasi_Test res = new Klasifikasi_Test();
        res.activity = activity ;
        res.collectionOfClassificationResult = new LinkedList<DiagnosisResult>();
        for(Map.Entry<String, Integer> item : collectionOfClassificationResult.entrySet() ){
           res.collectionOfClassificationResult.add(new DiagnosisResult(item.getKey() , item.getValue()));
        }
        res.mAdapter = new KlasifikasiListAdapter(res.collectionOfClassificationResult);
        return res;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_klasifikasi__test, container, false);
        this.recyclerView = res.findViewById(R.id.recyclerViewKlasifikasi) ;
        this.mAdapter = new KlasifikasiListAdapter((LinkedList<DiagnosisResult>)this.collectionOfClassificationResult);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        this.recyclerView.setAdapter(this.mAdapter);
        this.backBtn = res.findViewById(R.id.back_Btn);
        this.backBtn.setOnClickListener(this);
        return res;
    }

    public void cleanList(){
        this.collectionOfClassificationResult = new LinkedList<DiagnosisResult>();
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == this.backBtn.getId()){
            this.activity.changeToTandaBahayaUmumTest();
        }
    }
}
