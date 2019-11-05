package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.Checkbox_Model;
import com.example.sisteminformasimtbs.model.Toggler;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStatusGizi_3 extends Fragment implements View.OnClickListener , Toggler {
    private PemeriksaanMain_Activity activity ;
    private LinearLayout progressbar;

    private CheckBox checkBox_9;
    private Checkbox_Model cb_9;

    private CheckBox checkBox_10;
    private Checkbox_Model cb_10;

    private CheckBox checkBox_11;
    private Checkbox_Model cb_11;



    // header button
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;

    // footer
    private Button btn_Kembali ;
    private Button btn_Selanjutnya ;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase ;

    public static final int ID_TOPIK = 6;




    public FragmentStatusGizi_3() {
        // Required empty public constructor
    }

    public static FragmentStatusGizi_3 newInstance(PemeriksaanMain_Activity activity){
        FragmentStatusGizi_3 result = new FragmentStatusGizi_3();
        result.activity = activity;
        result.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(result.ID_TOPIK);
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_fragment_status_gizi_3, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala) ;
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_9 = res.findViewById(R.id.cb_gizi_9) ;
        this.checkBox_10 = res.findViewById(R.id.cb_gizi_10) ;
        this.checkBox_11 = res.findViewById(R.id.cb_gizi_11);


        // set text cb 1 cb 2 cb 3

        int i = 0 ;
        for(Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()){
            switch (i){
                case 8 :
                    this.cb_9 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_9.setText(this.cb_9.getText_Checkbox());
                    break;
                case 9 :
                    this.cb_10 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_10.setText(this.cb_10.getText_Checkbox());
                    break ;
                case 10:

                    this.cb_11 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_11.setText(this.cb_11.getText_Checkbox());
                    break;
            }
            i++;
        }
        this.checkBox_9.setOnClickListener(this);
        this.checkBox_10.setOnClickListener(this);
        this.checkBox_11.setOnClickListener(this);



        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);

        this.progressbar = res.findViewById(R.id.progressbar_background);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.progressbar.getLayoutParams();
        params.weight = (1f/15)* 13;
        this.progressbar.setLayoutParams(params);
        return res;
    }

    @Override
    public void onClick(View view) {
        if(this.checkBox_9.getId() == view.getId()){
            toggle(cb_9 , checkBox_9);
        }else if(this.checkBox_10.getId() == view.getId()){
            toggle(cb_10 , checkBox_10);
        }else if(this.checkBox_11.getId() == view.getId()){
            toggle(cb_11, checkBox_11);
        }
        else if(this.btn_Kembali == view){
            this.activity.changeToStatusGizi_2();
        }else if(this.btn_Selanjutnya == view){
            this.activity.changeToAnemia();
        }else if(btn_Tindakan == view){
            activity.saveLastGejala(this);
            activity.changeToTindakanTest();

        }else if(this.btn_Gejala == view){

        }else if(this.btn_Klasifikasi == view){
            activity.saveLastGejala(this);
            HashMap<String , Integer> collectionOfClassification = activity.presenter.classifyAll();
            activity.changeToKlasifikasiTest(collectionOfClassification);
        }
    }

    @Override
    public void toggle(Checkbox_Model cm, CheckBox cb) {
        if(cb.isChecked()) {
            cm.setStatus_Check(true);
            activity.presenter.addGejala(cm.getText_Checkbox(),cm.getId());
            cb.setTextColor(ContextCompat.getColor(getContext() , R.color.redstatus));

        }
        else {
            cm.setStatus_Check(false);
            activity.presenter.removeGejala(cm.getText_Checkbox());
            cb.setTextColor(ContextCompat.getColor(getContext() , R.color.white));

        }
    }
}
