package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.dataclass.TindakanResult;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 *
 * 1 F
 */
public class FragmentTindakan extends Fragment implements View.OnClickListener {
    private PemeriksaanMain_Activity activity ;

    private  int INDEX_TINDAKAN_FRAGMENT ;
    private TextView judulTindakan;
    private String judulTindakantext;

    private RecyclerView tindakanRecyclerView ;
    private TindakanListAdapter tindakanListAdapter ;

    // list of Tindakan
    private LinkedList<TindakanResult> listOfTindakan ;
    private Button back_Btn;

    // stroll through the tindakan
    private Button btn_Selanjutnya ;
    private Button btn_Kembali;


    //  gejala , klasifikasi , tindakan
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;



    // PROGRESS BAR
    private LinearLayout progressbar ;


    public FragmentTindakan() {
    }

    public static FragmentTindakan newInstance(PemeriksaanMain_Activity activity , LinkedList<TindakanResult> listOfTindakan , int index , String judulTindakan){
        FragmentTindakan res = new FragmentTindakan();
        res.activity = activity;
        res.listOfTindakan = listOfTindakan;
        res.INDEX_TINDAKAN_FRAGMENT = index;
        res.judulTindakantext = judulTindakan;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View res =  inflater.inflate(R.layout.fragment_tindakan__test, container, false);
       this.judulTindakan = res.findViewById(R.id.judulTindakan) ;
       this.judulTindakan.setText(this.judulTindakantext);
       this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
       this.btn_Kembali.setOnClickListener(this);

       this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya) ;
       this.btn_Selanjutnya.setOnClickListener(this);

       this.btn_Gejala = res.findViewById(R.id.btn_Gejala);
       this.btn_Gejala.setOnClickListener(this);

       this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
       this.btn_Klasifikasi.setOnClickListener(this);

       this.btn_Tindakan  = res.findViewById(R.id.btn_Tindakan);
       this.btn_Tindakan.setBackground(getResources().getDrawable(R.color.mustardColor));
       this.tindakanRecyclerView = res.findViewById(R.id.tindakanRecyclerView);
       this.tindakanListAdapter = new TindakanListAdapter(listOfTindakan , activity);
       this.tindakanRecyclerView.setHasFixedSize(true);

       this.tindakanRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
       this.tindakanRecyclerView.setAdapter(this.tindakanListAdapter);

        // progress bar
        this.progressbar = res.findViewById(R.id.progressbar_background);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.progressbar.getLayoutParams();
        params.weight = (1f/this.activity.getCollectionFragmentTindakanSize())* (INDEX_TINDAKAN_FRAGMENT+1);
        this.progressbar.setLayoutParams(params);


       return res ;
    }

    @Override
    public void onClick(View view) {
        if(this.btn_Gejala.getId() == view.getId()){
            // call activity to back to the current gejala
            activity.changeToLastGejala();
        }else if(btn_Klasifikasi.getId() == view.getId()){
            HashMap<String ,Integer> collectionOfClassificationResult = activity.presenter.classifyAll();
            activity.changeToKlasifikasiTest(collectionOfClassificationResult);
        } else if(this.btn_Selanjutnya.getId() == view.getId()){
            if(INDEX_TINDAKAN_FRAGMENT +1 < activity.getCollectionFragmentTindakanSize()){
                activity.changeToPreviousOrNextTindakan(INDEX_TINDAKAN_FRAGMENT+1);
            }
        }else if(this.btn_Kembali.getId() == view.getId()){
           if(INDEX_TINDAKAN_FRAGMENT - 1 >= 0){
               activity.changeToPreviousOrNextTindakan(INDEX_TINDAKAN_FRAGMENT-1);
           }
        }
    }
}
