package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.testing.Checkbox_Model;
import com.example.sisteminformasimtbs.testing.Toggler;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDiare2 extends Fragment implements View.OnClickListener , Toggler {

    private PemeriksaanMain activity ;

    private CheckBox checkBox_7;
    private Checkbox_Model cb_7;

    private CheckBox checkBox_8;
    private Checkbox_Model cb_8;

    private CheckBox checkBox_9;
    private Checkbox_Model cb_9;

    private CheckBox checkBox_10 ;
    private Checkbox_Model cb_10;

    private CheckBox checkBox_11;
    private Checkbox_Model cb_11;

    private CheckBox checkBox_12 ;
    private Checkbox_Model cb_12;


    // header button
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;

    // footer
    private Button btn_Kembali ;
    private Button btn_Selanjutnya ;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase ;

    public static final int ID_TOPIK = 3;
    public FragmentDiare2() {
        // Required empty public constructor
    }

    public static FragmentDiare2 newInstance(PemeriksaanMain activity){
        FragmentDiare2 fragmentDiare2 = new FragmentDiare2();
        fragmentDiare2.activity = activity;
        fragmentDiare2.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(ID_TOPIK);
        return fragmentDiare2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View res  = inflater.inflate(R.layout.diare2 , container, false);


        this.btn_Gejala = res.findViewById(R.id.btn_Gejala) ;
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);

        this.checkBox_7 = res.findViewById(R.id.cb_6) ;
        this.checkBox_8 = res.findViewById(R.id.cb_7) ;
        this.checkBox_9 = res.findViewById(R.id.cb_8);
        this.checkBox_10 = res.findViewById(R.id.cb_10);
        this.checkBox_11= res.findViewById(R.id.cb_9);
        this.checkBox_12= res.findViewById(R.id.cb_6);

        int i = 0 ;
        for(Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()){
            switch (i){
                case 6 :
                    this.cb_7 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_7.setText(this.cb_7.getText_Checkbox());
                    break;
                case 7 :
                    this.cb_8 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_8.setText(this.cb_8.getText_Checkbox());

                    break ;
                case 8 :
                    this.cb_9 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_9.setText(this.cb_9.getText_Checkbox());

                    break;

                case 9:
                    this.cb_10 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_10.setText(this.cb_10.getText_Checkbox());
                    break;

                case 10:
                    this.cb_11 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_11.setText(this.cb_11.getText_Checkbox());
                    break;
                case 11:
                    this.cb_12 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_12.setText(this.cb_12.getText_Checkbox());
                    break;
            }
            i++;
        }

        this.checkBox_7.setOnClickListener(this);
        this.checkBox_8.setOnClickListener(this);
        this.checkBox_9.setOnClickListener(this);
        this.checkBox_10.setOnClickListener(this);
        this.checkBox_11.setOnClickListener(this);
        this.checkBox_12.setOnClickListener(this);

        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);


        return res;
    }

    @Override
    public void onClick(View view) {
        if(this.checkBox_7.getId() == view.getId()){
            toggle(cb_7 , checkBox_7);
        }else if(this.checkBox_8.getId() == view.getId()){
            toggle(cb_8 , checkBox_8);
        }else if(this.checkBox_9.getId() == view.getId()){
            toggle(cb_9, checkBox_9);
        }else if(this.checkBox_10.getId() == view.getId()){
            toggle(cb_10 , checkBox_10);
        }else if(this.checkBox_11.getId() == view.getId()){
            toggle(cb_11, checkBox_11);
        }else if(this.checkBox_12.getId() == view.getId()){
            toggle(cb_12 , checkBox_12) ;
        } else if(this.btn_Kembali == view){
            this.activity.changeToDiare1();
        }else if(this.btn_Selanjutnya == view){
           this.activity.changeToStatusHIV1();
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
        }
        else {
            cm.setStatus_Check(false);
            activity.presenter.removeGejala(cm.getText_Checkbox());
        }
    }
}
