package com.example.sisteminformasimtbs.view.pemeriksaan;

import com.example.sisteminformasimtbs.model.Pemeriksaan;

public class Initializer_DataDiri extends Initializer{
    private PemeriksaanMain activity;
    private FragmentDataDiri1 dataDiri1;
    private FragmentDataDiri2 dataDiri2;
    private FragmentDataDiri3 dataDiri3;
    private FragmentDataDiri4 dataDiri4;

    public Initializer_DataDiri (PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll() {
        this.dataDiri1=FragmentDataDiri1.newInstance(activity);
        this.dataDiri2=FragmentDataDiri2.newInstance(activity);
        this.dataDiri3=FragmentDataDiri3.newInstance(activity);
        this.dataDiri4=FragmentDataDiri4.newInstance(activity);
    }

    public FragmentDataDiri1 getDataDiri1() {
        return dataDiri1;
    }

    public FragmentDataDiri2 getDataDiri2() {
        return dataDiri2;
    }

    public FragmentDataDiri3 getDataDiri3() {
        return dataDiri3;
    }

    public FragmentDataDiri4 getDataDiri4() {
        return dataDiri4;
    }
}
