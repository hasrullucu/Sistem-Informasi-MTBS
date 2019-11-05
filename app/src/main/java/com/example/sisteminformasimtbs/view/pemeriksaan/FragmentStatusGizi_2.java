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
public class FragmentStatusGizi_2 extends Fragment implements View.OnClickListener, Toggler {
    private PemeriksaanMain_Activity activity;
    private LinearLayout progressbar ;

    private CheckBox checkBox_5;
    private Checkbox_Model cb_5;

    private CheckBox checkBox_6;
    private Checkbox_Model cb_6;

    private CheckBox checkBox_7;
    private Checkbox_Model cb_7;

    private CheckBox checkBox_8;
    private Checkbox_Model cb_8;

    // header button
    private ConstraintLayout btn_Gejala;
    private ConstraintLayout btn_Klasifikasi;
    private ConstraintLayout btn_Tindakan;

    // footer
    private Button btn_Kembali;
    private Button btn_Selanjutnya;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase;

    public static final int ID_TOPIK = 6;


    public FragmentStatusGizi_2() {
        // Required empty public constructor
    }

    public static FragmentStatusGizi_2 newInstance(PemeriksaanMain_Activity activity) {
        FragmentStatusGizi_2 result = new FragmentStatusGizi_2();
        result.activity = activity;
        result.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(result.ID_TOPIK);
        return result;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.fragment_fragment_status_gizi_2, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala);
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_5 = res.findViewById(R.id.cb_gizi_5);
        this.checkBox_6 = res.findViewById(R.id.cb_gizi_6);
        this.checkBox_7 = res.findViewById(R.id.cb_gizi_7);
        this.checkBox_8 = res.findViewById(R.id.cb_gizi_8);


        // set text cb 1 cb 2 cb 3

        int i = 0;
        for (Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()) {
            switch (i) {
                case 4:
                    this.cb_5 = new Checkbox_Model(item.getKey(), item.getValue());
                    this.checkBox_5.setText(this.cb_5.getText_Checkbox());
                    break;
                case 5:
                    this.cb_6 = new Checkbox_Model(item.getKey(), item.getValue());
                    this.checkBox_6.setText(this.cb_6.getText_Checkbox());
                    break;
                case 6:

                    this.cb_7 = new Checkbox_Model(item.getKey(), item.getValue());
                    this.checkBox_7.setText(this.cb_7.getText_Checkbox());
                    break;

                case 7:
                    this.cb_8 = new Checkbox_Model(item.getKey(), item.getValue());
                    this.checkBox_8.setText(this.cb_8.getText_Checkbox());
                    break;
            }
            i++;
        }
        this.checkBox_5.setOnClickListener(this);
        this.checkBox_6.setOnClickListener(this);
        this.checkBox_7.setOnClickListener(this);
        this.checkBox_8.setOnClickListener(this);


        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);

        this.progressbar = res.findViewById(R.id.progressbar_background);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.progressbar.getLayoutParams();
        params.weight = (1f/15)* 12;
        this.progressbar.setLayoutParams(params);
        return res;
    }

    @Override
    public void onClick(View view) {
        if (this.checkBox_5.getId() == view.getId()) {
            toggle(cb_5, checkBox_5);
        } else if (this.checkBox_6.getId() == view.getId()) {
            toggle(cb_6, checkBox_6);
        } else if (this.checkBox_7.getId() == view.getId()) {
            toggle(cb_7, checkBox_7);
        } else if (this.checkBox_8.getId() == view.getId()) {
            toggle(cb_8, checkBox_8);
        } else if (this.btn_Kembali == view) {
            this.activity.changeToStatusGizi_1();
        } else if (this.btn_Selanjutnya == view) {
            this.activity.changeToStatusGizi_3();
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
        if (cb.isChecked()) {
            cm.setStatus_Check(true);
            activity.presenter.addGejala(cm.getText_Checkbox(), cm.getId());
            cb.setTextColor(ContextCompat.getColor(getContext() , R.color.redstatus));

        } else {
            cm.setStatus_Check(false);
            activity.presenter.removeGejala(cm.getText_Checkbox());
            cb.setTextColor(ContextCompat.getColor(getContext() , R.color.white));

        }
    }
}
