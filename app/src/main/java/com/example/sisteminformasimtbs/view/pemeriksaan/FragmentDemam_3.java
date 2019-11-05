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
 *
 */
public class FragmentDemam_3 extends Fragment implements View.OnClickListener , Toggler {
    private PemeriksaanMain_Activity activity ;
    private LinearLayout progressbar;

    private CheckBox checkBox_11;
    private Checkbox_Model cb_11;

    private CheckBox checkBox_12;
    private Checkbox_Model cb_12;

    private CheckBox checkBox_13;
    private Checkbox_Model cb_13;

    private CheckBox checkBox_14 ;
    private Checkbox_Model cb_14;

    private CheckBox checkBox_15;
    private Checkbox_Model cb_15;

    // header button
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;

    // footer
    private Button btn_Kembali ;
    private Button btn_Selanjutnya ;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase ;

    public static final int ID_TOPIK = 4 ;

    public FragmentDemam_3() {

    }

    public static FragmentDemam_3 newInstance(PemeriksaanMain_Activity activity){
        // Required empty public constructor
        FragmentDemam_3 result = new FragmentDemam_3();
        result.activity = activity;
        result.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(result.ID_TOPIK);
        return result;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_fragment_demam3, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala) ;
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_11 = res.findViewById(R.id.cb_demam_11) ;
        this.checkBox_12 = res.findViewById(R.id.cb_demam_12) ;
        this.checkBox_13= res.findViewById(R.id.cb_demam_13);
        this.checkBox_14 = res.findViewById(R.id.cb_demam_14);
        this.checkBox_15 =res.findViewById(R.id.cb_demam_15) ;


        // set text cb 1 cb 2 cb 3

        int i = 0 ;
        for(Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()){
            switch (i){
                case 10 :
                    this.cb_11 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_11.setText(this.cb_11.getText_Checkbox());
                    break;
                case 11 :
                    this.cb_12 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_12.setText(this.cb_12.getText_Checkbox());
                    break ;
                case 12 :

                    this.cb_13 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_13.setText(this.cb_13.getText_Checkbox());
                    break;

                case 13:
                    this.cb_14 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_14.setText(this.cb_14.getText_Checkbox());
                    break;

                case 14 :
                    this.cb_15 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_15.setText(this.cb_15.getText_Checkbox());
                    break ;

            }
            i++;
        }
        this.checkBox_11.setOnClickListener(this);
        this.checkBox_12.setOnClickListener(this);
        this.checkBox_13.setOnClickListener(this);
        this.checkBox_14.setOnClickListener(this);
        this.checkBox_15.setOnClickListener(this);



        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);
        this.progressbar = res.findViewById(R.id.progressbar_background);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.progressbar.getLayoutParams();
        params.weight = (1f/15)* 7;
        this.progressbar.setLayoutParams(params);
        return res;
    }

    @Override
    public void onClick(View view) {
        if (this.checkBox_11.getId() == view.getId()) {
            toggle(cb_11, checkBox_11);
        } else if (this.checkBox_12.getId() == view.getId()) {
            toggle(cb_12, checkBox_12);
        } else if (this.checkBox_13.getId() == view.getId()) {
            toggle(cb_13, checkBox_13);
        } else if (this.checkBox_14.getId() == view.getId()) {
            toggle(cb_14, checkBox_14);
        } else if (this.checkBox_15.getId() == view.getId()) {
            toggle(cb_15, checkBox_15);
        } else if (this.btn_Kembali == view) {
            this.activity.changeToDemam2();
        } else if (this.btn_Selanjutnya == view) {
            this.activity.changeToDemam4();
        } else if (btn_Tindakan == view) {
            activity.saveLastGejala(this);
            activity.changeToTindakanTest();

        } else if (this.btn_Gejala == view) {

        } else if (this.btn_Klasifikasi == view) {
            activity.saveLastGejala(this);
            HashMap<String, Integer> collectionOfClassification = activity.presenter.classifyAll();
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
