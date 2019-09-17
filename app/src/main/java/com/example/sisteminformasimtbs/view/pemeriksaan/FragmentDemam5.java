package com.example.sisteminformasimtbs.view.pemeriksaan;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.testing.Checkbox_Model;
import com.example.sisteminformasimtbs.testing.Toggler;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDemam5 extends Fragment implements View.OnClickListener , Toggler {
    private PemeriksaanMain activity ;

    private CheckBox checkBox_21;
    private Checkbox_Model cb_21;

    private CheckBox checkBox_22;
    private Checkbox_Model cb_22;

    // header button
    private ConstraintLayout btn_Gejala ;
    private ConstraintLayout btn_Klasifikasi ;
    private ConstraintLayout btn_Tindakan ;

    // footer
    private Button btn_Kembali ;
    private Button btn_Selanjutnya ;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase ;

    public static final int ID_TOPIK = 4 ;

    public FragmentDemam5() {
        // Required empty public constructor
    }
    public static FragmentDemam5 newInstance(PemeriksaanMain activity){
        // Required empty public constructor
        FragmentDemam5 result = new FragmentDemam5();
        result.activity = activity;
        result.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(result.ID_TOPIK);
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_fragment_demam5, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala) ;
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_21 = res.findViewById(R.id.cb_21) ;
        this.checkBox_22 = res.findViewById(R.id.cb_22) ;

        this.checkBox_21.setOnClickListener(this);
        this.checkBox_22.setOnClickListener(this);



        int i = 0 ;
        for(Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()){
            switch (i){
                case 20 :
                    this.cb_21 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_21.setText(this.cb_21.getText_Checkbox());
                    break;
                case  21:
                    this.cb_22 = new Checkbox_Model(item.getKey() , item.getValue());
                    this.checkBox_22.setText(this.cb_22.getText_Checkbox());
                    break ;
            }
            i++;
        }


        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);
        return res;
    }

    @Override
    public void onClick(View view) {
        if (this.checkBox_21.getId() == view.getId()) {
            toggle(cb_21, checkBox_21);
        } else if (this.checkBox_22.getId() == view.getId()) {
            Log.d("clicked" , "Clicked");
            toggle(cb_22, checkBox_22);
        } else if (this.btn_Kembali == view) {
            this.activity.changeToDemam4();
        } else if (this.btn_Selanjutnya == view) {
            this.activity.changeToMasalahTelinga1();
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
        }
        else {
            cm.setStatus_Check(false);
            activity.presenter.removeGejala(cm.getText_Checkbox());
        }
    }
}
