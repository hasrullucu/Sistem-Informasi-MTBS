package com.example.sisteminformasimtbs.view.pemeriksaan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.sisteminformasimtbs.R;
import com.example.sisteminformasimtbs.model.Checkbox_Model;
import com.example.sisteminformasimtbs.model.Toggler;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAnemia extends Fragment implements View.OnClickListener, Toggler {
    private PemeriksaanMain_Activity activity;
    private LinearLayout progressbar;

    private CheckBox checkBox_1;
    private Checkbox_Model cb_1;
    private CheckBox checkBox_2;
    private Checkbox_Model cb_2;
    private CheckBox checkBox_3;
    private Checkbox_Model cb_3;


    // header button
    private ConstraintLayout btn_Gejala;
    private ConstraintLayout btn_Klasifikasi;
    private ConstraintLayout btn_Tindakan;

    // footer
    private Button btn_Kembali;
    private Button btn_Selanjutnya;

    private HashMap<String, Integer> collectionOfGejalaFromDatabase;

    public static final int ID_TOPIK = 7;


    public FragmentAnemia() {
        // Required empty public constructor
    }

    public static FragmentAnemia newInstance(PemeriksaanMain_Activity activity) {
        FragmentAnemia result = new FragmentAnemia();
        result.collectionOfGejalaFromDatabase = activity.presenter.getGejalaByIdTopik(result.ID_TOPIK);

        result.activity = activity;
        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View res = inflater.inflate(R.layout.anemia1, container, false);

        this.btn_Gejala = res.findViewById(R.id.btn_Gejala);
        this.btn_Gejala.setOnClickListener(this);
        this.btn_Gejala.setBackground(ContextCompat.getDrawable(getContext(), R.color.mustardColor));

        this.btn_Klasifikasi = res.findViewById(R.id.btn_Klasifikasi);
        this.btn_Klasifikasi.setOnClickListener(this);

        this.btn_Tindakan = res.findViewById(R.id.btn_Tindakan);
        this.btn_Tindakan.setOnClickListener(this);


        this.checkBox_1 = res.findViewById(R.id.cb_anemia_1);
        this.checkBox_2 = res.findViewById(R.id.cb_anemia_2);
        this.checkBox_3 = res.findViewById(R.id.cb_anemia_3);

        // set text cb 1 cb 2 cb 3

        int i = 0;
        for (Map.Entry<String, Integer> item : this.collectionOfGejalaFromDatabase.entrySet()) {
            switch (i) {
                case 0:
                    this.cb_1 = new Checkbox_Model(item.getKey(), item.getValue());
                    this.checkBox_1.setText(this.cb_1.getText_Checkbox());
                    break;
                case 1:
                    this.cb_2 = new Checkbox_Model(item.getKey(), item.getValue());
                    this.checkBox_2.setText(this.cb_2.getText_Checkbox());
                    break;
                case 2:

                    this.cb_3 = new Checkbox_Model(item.getKey(), item.getValue());
                    this.checkBox_3.setText(this.cb_3.getText_Checkbox());
                    break;

            }
            i++;
        }
        this.checkBox_1.setOnClickListener(this);
        this.checkBox_2.setOnClickListener(this);
        this.checkBox_3.setOnClickListener(this);


        this.btn_Kembali = res.findViewById(R.id.btn_Kembali);
        this.btn_Kembali.setOnClickListener(this);

        this.btn_Selanjutnya = res.findViewById(R.id.btn_Selanjutnya);
        this.btn_Selanjutnya.setOnClickListener(this);

        this.progressbar = res.findViewById(R.id.progressbar_background);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.progressbar.getLayoutParams();
        params.weight = (1f/15)* 14;
        this.progressbar.setLayoutParams(params);
        return res;
    }

    @Override
    public void onClick(View view) {
        if (this.checkBox_1.getId() == view.getId()) {
            toggle(cb_1, checkBox_1);
        } else if (this.checkBox_2.getId() == view.getId()) {
            toggle(cb_2, checkBox_2);
        } else if (this.checkBox_3.getId() == view.getId()) {
            toggle(cb_3, checkBox_3);
        } else if (this.btn_Kembali == view) {
            this.activity.changeToStatusGizi_3();
        } else if (this.btn_Selanjutnya == view) {
            this.activity.changeToStatusHIV1();
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