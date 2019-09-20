package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.dataclass.DiagnosisResult;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentKlasifikasi extends Fragment implements View.OnClickListener{
    private PemeriksaanMain_Activity activity ;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private LinkedList<DiagnosisResult> collectionOfClassificationResult ;

    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan;

    public FragmentKlasifikasi() {
        // Required empty public constructor
    }

    public static FragmentKlasifikasi newInstance(PemeriksaanMain_Activity activity, HashMap<String, Integer> collectionOfClassificationResult){
        FragmentKlasifikasi res = new FragmentKlasifikasi();
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

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala);
        this.btn_Gejala.setOnClickListener(this);

        this.btn_Klasifikasi= res.findViewById(R.id.btn_Klasifikasi) ;
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Klasifikasi.setBackground(getResources().getDrawable(R.color.mustardColor));


        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan) ;
        this.btn_Tindakan.setOnClickListener(this);

        return res;
    }

    public void cleanList(){
        this.collectionOfClassificationResult = new LinkedList<DiagnosisResult>();
    }


    @Override
    public void onClick(View view) {
       if(view == this.btn_Gejala){
            this.activity.changeToLastGejala();
       }else if(view ==this.btn_Klasifikasi){

       }else if(view ==this.btn_Tindakan){
            this.activity.changeToTindakanTest();
       }
    }
}
