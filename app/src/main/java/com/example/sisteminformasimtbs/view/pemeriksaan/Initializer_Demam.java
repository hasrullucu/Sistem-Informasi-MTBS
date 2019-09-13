package com.example.sisteminformasimtbs.view.pemeriksaan;

import com.example.sisteminformasimtbs.view.FragmentDemam2;

public class Initializer_Demam extends Initializer {
    private PemeriksaanMain activity;
//    fragment fragment_fragmentdemam1 1
    private FragmentDemam1 fragmentDemam1;
    private FragmentDemam2 fragmentDemam2;


    // fragment fragment_fragmentdemam1 2

    public Initializer_Demam(PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }


    @Override
    public void initAll() {

        this.fragmentDemam1 = FragmentDemam1.newInstance(this.activity);
        this.fragmentDemam2 = FragmentDemam2.newInstance(this.activity);
    }
    public FragmentDemam2 getFragmentDemam2() {
        return fragmentDemam2;
    }

    public FragmentDemam1 getFragmentDemam1() {
        return fragmentDemam1;
    }
}
