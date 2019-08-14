package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_MasalahTelinga extends Initializer{
    private PemeriksaanMain activity;

    // all fragment for masalah telinga
    //fragment 1 masalah telinga
    private FragmentMasalahTelinga1 fragmentMasalahTelinga1;
    // fragment 2 masalah telinga
    private FragmentMasalahTelinga2 fragmentMasalahTelinga2;

    // fragment 2 masalah telinga
    public Initializer_MasalahTelinga(PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }

    public FragmentMasalahTelinga2 getFragmentMasalahTelinga2() {
        return this.fragmentMasalahTelinga2;
    }

    public FragmentMasalahTelinga1 getFragmentMasalahTelinga1() {
        return this.fragmentMasalahTelinga1;
    }

    @Override
    public void initAll() {
        this.fragmentMasalahTelinga1 = FragmentMasalahTelinga1.newInstance(this.activity);
        this.fragmentMasalahTelinga2 = FragmentMasalahTelinga2.newInstance(this.activity);

    }
}
