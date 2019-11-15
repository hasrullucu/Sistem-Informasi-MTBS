package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_HasilPemeriksaan extends Initializer {
    private PemeriksaanMain_Activity activity;
    private Fragment_HasilPemeriksaan_1 fragment_hasilPemeriksaan_1;

    public Initializer_HasilPemeriksaan(PemeriksaanMain_Activity activity){
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll() {
        this.fragment_hasilPemeriksaan_1 = Fragment_HasilPemeriksaan_1.newInstance(activity);

    }


    public Fragment_HasilPemeriksaan_1 getFragment_hasilPemeriksaan_1() {
        return fragment_hasilPemeriksaan_1;
    }
}
