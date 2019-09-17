package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Demam extends Initializer {
    private PemeriksaanMain activity;
//    fragment fragment_fragmentdemam1 1
    private FragmentDemam1 fragmentDemam1;
    private FragmentDemam2 fragmentDemam2;
    private FragmentDemam3 fragmentDemam3;
    private FragmentDemam4 fragmentDemam4;
    private FragmentDemam5 fragmentDemam5;


    // fragment fragment_fragmentdemam1 2

    public Initializer_Demam(PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }


    public FragmentDemam5 getFragmentDemam5() {
        return fragmentDemam5;
    }

    @Override
    public void initAll() {

        this.fragmentDemam1 = FragmentDemam1.newInstance(this.activity);
        this.fragmentDemam2 = FragmentDemam2.newInstance(this.activity);
        this.fragmentDemam3 = FragmentDemam3.newInstance(this.activity);
        this.fragmentDemam4 = FragmentDemam4.newInstance(this.activity);
        this.fragmentDemam5 = FragmentDemam5.newInstance(this.activity);
    }
    public FragmentDemam2 getFragmentDemam2() {
        return fragmentDemam2;
    }

    public FragmentDemam1 getFragmentDemam1() {
        return fragmentDemam1;
    }

    public FragmentDemam3 getFragmentDemam3() {
        return fragmentDemam3;
    }

    public FragmentDemam4 getFragmentDemam4() {
        return fragmentDemam4;
    }
}
