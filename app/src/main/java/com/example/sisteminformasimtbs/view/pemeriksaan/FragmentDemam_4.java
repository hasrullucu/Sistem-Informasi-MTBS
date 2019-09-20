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

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.Checkbox_Model;
import com.example.sisteminformasimtbs.model.Toggler;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDemam_4 extends Fragment implements View.OnClickListener , Toggler {
    private PemeriksaanMain_Activity activity ;

    private CheckBox checkBox_16;
    private Checkbox_Model cb_16;

    private CheckBox checkBox_17;
    private Checkbox_Model cb_17;

    private CheckBox checkBox_18;
    private Checkbox_Model cb_18;

    private CheckBox checkBox_19 ;
    private Checkbox_Model cb_19;

    private CheckBox checkBox_20;
    private Checkbox_Model cb_20;

    // header button
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;

    // footer
    private Button btn_Kembali ;
    private Button btn_Selanjutnya ;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase ;

    public static final int ID_TOPIK = 4 ;

    public FragmentDemam_4() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_fragment_demam4, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala) ;
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_16 = res.findViewById(R.id.cb_demam_16) ;
        this.checkBox_17 = res.findViewById(R.id.cb_demam_17) ;
        this.checkBox_18= res.findViewById(R.id.cb_demam_18);
        this.checkBox_19 = res.findViewById(R.id.cb_demam_19);
        this.checkBox_20 =res.findViewById(R.id.cb_demam_20) ;


        // set text cb 1 cb 2 cb 3

        int i = 0 ;
        for(Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()){
            switch (i){
                case 15 :
                    this.cb_16 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_16.setText(this.cb_16.getText_Checkbox());
                    break;
                case 16 :
                    this.cb_17 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_17.setText(this.cb_17.getText_Checkbox());
                    break ;
                case 17 :

                    this.cb_18 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_18.setText(this.cb_18.getText_Checkbox());
                    break;

                case 18:
                    this.cb_19 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_19.setText(this.cb_19.getText_Checkbox());
                    break;

                case 19 :
                    this.cb_20 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_20.setText(this.cb_20.getText_Checkbox());
                    break ;

            }
            i++;
        }
        this.checkBox_16.setOnClickListener(this);
        this.checkBox_17.setOnClickListener(this);
        this.checkBox_18.setOnClickListener(this);
        this.checkBox_19.setOnClickListener(this);
        this.checkBox_20.setOnClickListener(this);



        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);
        return res;
    }
    public static FragmentDemam_4 newInstance(PemeriksaanMain_Activity activity){
        // Required empty public constructor
        FragmentDemam_4 result = new FragmentDemam_4();
        result.activity = activity;
        result.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(result.ID_TOPIK);
        return result;
    }

    @Override
    public void onClick(View view) {
        if (this.checkBox_16.getId() == view.getId()) {
            toggle(cb_16, checkBox_16);
        } else if (this.checkBox_17.getId() == view.getId()) {
            toggle(cb_17, checkBox_17);
        } else if (this.checkBox_18.getId() == view.getId()) {
            toggle(cb_18, checkBox_18);
        } else if (this.checkBox_19.getId() == view.getId()) {
            toggle(cb_19, checkBox_19);
        } else if (this.checkBox_20.getId() == view.getId()) {
            toggle(cb_20, checkBox_20);
        } else if (this.btn_Kembali == view) {
            this.activity.changeToDemam3();
        } else if (this.btn_Selanjutnya == view) {
            this.activity.changeToDemam5();
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
