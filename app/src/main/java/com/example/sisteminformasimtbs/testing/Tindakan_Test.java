package com.example.sisteminformasimtbs.testing;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 *
 * 1 F
 */
public class Tindakan_Test extends Fragment implements View.OnClickListener {
    private PemeriksaanMain activity ;

    private  int INDEX_TINDAKAN_FRAGMENT ;


    private RecyclerView tindakanRecyclerView ;
    private TindakanListAdapter tindakanListAdapter ;

    // list of Tindakan
    private LinkedList<TindakanResult> listOfTindakan ;
    private Button back_Btn;

    // stroll through the tindakan
    private Button nextTindakan ;
    private Button previousTindakan ;
    public Tindakan_Test() {
    }

    public static Tindakan_Test newInstance(PemeriksaanMain activity , LinkedList<TindakanResult> listOfTindakan , int index){
        Tindakan_Test res = new Tindakan_Test();
        res.activity = activity;
        res.listOfTindakan = listOfTindakan;
        res.INDEX_TINDAKAN_FRAGMENT = index;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View res =  inflater.inflate(R.layout.fragment_tindakan__test, container, false);
       this.back_Btn = res.findViewById(R.id.back_Btn);
       this.back_Btn.setOnClickListener(this);

       this.previousTindakan = res.findViewById(R.id.previousTindakan);
       this.previousTindakan.setOnClickListener(this);

       this.nextTindakan  = res.findViewById(R.id.nextTindakan);
       this.nextTindakan.setOnClickListener(this);

       this.tindakanRecyclerView = res.findViewById(R.id.tindakanRecyclerView);
       this.tindakanListAdapter = new TindakanListAdapter(listOfTindakan);
       this.tindakanRecyclerView.setHasFixedSize(true);

       this.tindakanRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
       this.tindakanRecyclerView.setAdapter(this.tindakanListAdapter);


       return res ;
    }

    @Override
    public void onClick(View view) {
        if(this.back_Btn.getId() == view.getId()){
            // call activity to back to the current gejala
            activity.changeToTandaBahayaUmumTest();
        }else if(this.nextTindakan.getId() == view.getId()){
            if(INDEX_TINDAKAN_FRAGMENT < activity.getCollectionFragmentTindakanSize()){
                activity.changeToPreviousOrNextTindakan(INDEX_TINDAKAN_FRAGMENT+1);
            }
        }else if(this.previousTindakan.getId() == view.getId()){
           if(INDEX_TINDAKAN_FRAGMENT > 0){
               activity.changeToPreviousOrNextTindakan(INDEX_TINDAKAN_FRAGMENT-1);
           }
        }
    }
}
