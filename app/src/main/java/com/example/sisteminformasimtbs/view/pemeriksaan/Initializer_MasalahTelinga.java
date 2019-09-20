package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_MasalahTelinga extends Initializer{
    private PemeriksaanMain_Activity activity;

    // all fragment for masalah telinga
    //fragment 1 masalah telinga
    private FragmentMasalahTelinga_1 fragmentMasalahTelinga1;
    // fragment 2 masalah


    // fragment 2 masalah telinga
    public Initializer_MasalahTelinga(PemeriksaanMain_Activity activity){
        this.activity = activity;
        initAll();
    }



    public FragmentMasalahTelinga_1 getFragmentMasalahTelinga1() {
        return this.fragmentMasalahTelinga1;
    }

    @Override
    public void initAll() {
        this.fragmentMasalahTelinga1 = FragmentMasalahTelinga_1.newInstance(this.activity);
    }
}
