package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Anemia extends Initializer {
    private PemeriksaanMain activity;
    private FragmentAnemia fragmentAnemia;

    public Initializer_Anemia(PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll() {
        this.fragmentAnemia = FragmentAnemia.newInstance(activity);
    }

    public FragmentAnemia getFragmentAnemia() {
        return fragmentAnemia;
    }
}
