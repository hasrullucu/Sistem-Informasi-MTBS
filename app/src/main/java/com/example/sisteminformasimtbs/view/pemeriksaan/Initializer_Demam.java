package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Demam extends Initializer {
    private PemeriksaanMain activity;
//    fragment demam 1
    private FragmentDemam1 fragmentDemam1;
    // fragment demam 2

    public Initializer_Demam(PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }
    @Override
    public void initAll() {
        this.fragmentDemam1 = FragmentDemam1.newInstance(this.activity);
    }

    public FragmentDemam1 getFragmentDemam1() {
        return fragmentDemam1;
    }
}
