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
public class FragmentMasalahTelinga1 extends Fragment implements View.OnClickListener , Toggler {
    private PemeriksaanMain activity ;

    private CheckBox checkBox_1;
    private Checkbox_Model cb_1;
    private CheckBox checkBox_2;
    private Checkbox_Model cb_2;
    private CheckBox checkBox_3;
    private Checkbox_Model cb_3;
    private CheckBox checkBox_4 ;
    private Checkbox_Model cb_4;
    private CheckBox checkBox_5;
    private Checkbox_Model cb_5;
    private CheckBox checkBox_6 ;
    private Checkbox_Model cb_6;



    // header button
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;

    // footer
    private Button btn_Kembali ;
    private Button btn_Selanjutnya ;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase ;

    public static final int ID_TOPIK = 5;
    public FragmentMasalahTelinga1() {
        // Required empty public constructor
    }

    public static FragmentMasalahTelinga1 newInstance(PemeriksaanMain activity){
        FragmentMasalahTelinga1 fragmentMasalahTelinga1 = new FragmentMasalahTelinga1();
        fragmentMasalahTelinga1.activity = activity;
        fragmentMasalahTelinga1.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(ID_TOPIK);
        return fragmentMasalahTelinga1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.telinga1, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala) ;
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_1 = res.findViewById(R.id.cb_6) ;
        this.checkBox_2 = res.findViewById(R.id.cb_7) ;
        this.checkBox_3 = res.findViewById(R.id.cb_8);
        this.checkBox_4 = res.findViewById(R.id.cb_10);
        this.checkBox_5 =res.findViewById(R.id.cb_9) ;
        this.checkBox_6 = res.findViewById(R.id.cb_6) ;


        // set text cb 1 cb 2 cb 3

        int i = 0 ;
        for(Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()){
            switch (i){
                case 0 :
                    this.cb_1 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_1.setText(this.cb_1.getText_Checkbox());
                    break;
                case 1 :
                    this.cb_2 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_2.setText(this.cb_2.getText_Checkbox());
                    break ;
                case 2 :

                    this.cb_3 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_3.setText(this.cb_3.getText_Checkbox());
                    break;

                case 3:
                    this.cb_4 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_4.setText(this.cb_4.getText_Checkbox());
                    break;

                case 4 :
                    this.cb_5 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_5.setText(this.cb_5.getText_Checkbox());
                    break ;
                case 5 :
                    this.cb_6 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_6.setText(this.cb_6.getText_Checkbox());
                    break;


            }
            i++;
        }
        this.checkBox_1.setOnClickListener(this);
        this.checkBox_2.setOnClickListener(this);
        this.checkBox_3.setOnClickListener(this);
        this.checkBox_4.setOnClickListener(this);
        this.checkBox_5.setOnClickListener(this);
        this.checkBox_6.setOnClickListener(this);



        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);
        return res;
    }

    @Override
    public void onClick(View view) {
        if(this.checkBox_1.getId() == view.getId()){
            toggle(cb_1 , checkBox_1);
        }else if(this.checkBox_2.getId() == view.getId()){
            toggle(cb_2 , checkBox_2);
        }else if(this.checkBox_3.getId() == view.getId()){
            toggle(cb_3, checkBox_3);
        }else if(this.checkBox_4.getId() == view.getId()){
            toggle(cb_4 , checkBox_4);
        }else if(this.checkBox_5.getId() == view.getId()){
            toggle(cb_5, checkBox_5);
        }else if(this.checkBox_6.getId() == view.getId()){
            toggle(cb_6 , checkBox_6) ;
        }
        else if(this.btn_Kembali == view){
            this.activity.changeToStatusHIV1();
        }else if(this.btn_Selanjutnya == view){
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
