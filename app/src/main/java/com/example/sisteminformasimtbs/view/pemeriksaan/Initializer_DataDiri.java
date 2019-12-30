package com.example.sisteminformasimtbs.view.pemeriksaan;

import com.example.sisteminformasimtbs.model.dataclass.Balita;

public class Initializer_DataDiri extends Initializer{
    private PemeriksaanMain_Activity activity;
    private FragmentDataDiri_1 dataDiri1;
    private FragmentDataDiri_2 dataDiri2;
    private FragmentDataDiri_3 dataDiri4;

    public Initializer_DataDiri (PemeriksaanMain_Activity activity){
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll() {
        this.dataDiri1= FragmentDataDiri_1.newInstance(activity);
        this.dataDiri2= FragmentDataDiri_2.newInstance(activity);
        this.dataDiri4= FragmentDataDiri_3.newInstance(activity);
    }

    public FragmentDataDiri_1 getDataDiri1() {
        return dataDiri1;
    }

    public FragmentDataDiri_2 getDataDiri2() {
        return dataDiri2;
    }

    public FragmentDataDiri_3 getDataDiri4() {
        return dataDiri4;
    }


}
