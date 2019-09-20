package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Demam extends Initializer {
    private PemeriksaanMain_Activity activity;
//    fragment fragment_fragmentdemam1 1
    private FragmentDemam_1 fragmentDemam1;
    private FragmentDemam_2 fragmentDemam2;
    private FragmentDemam_3 fragmentDemam3;
    private FragmentDemam_4 fragmentDemam4;
    private FragmentDemam_5 fragmentDemam5;


    // fragment fragment_fragmentdemam1 2

    public Initializer_Demam(PemeriksaanMain_Activity activity){
        this.activity = activity;
        initAll();
    }


    public FragmentDemam_5 getFragmentDemam5() {
        return fragmentDemam5;
    }

    @Override
    public void initAll() {

        this.fragmentDemam1 = FragmentDemam_1.newInstance(this.activity);
        this.fragmentDemam2 = FragmentDemam_2.newInstance(this.activity);
        this.fragmentDemam3 = FragmentDemam_3.newInstance(this.activity);
        this.fragmentDemam4 = FragmentDemam_4.newInstance(this.activity);
        this.fragmentDemam5 = FragmentDemam_5.newInstance(this.activity);
    }
    public FragmentDemam_2 getFragmentDemam2() {
        return fragmentDemam2;
    }

    public FragmentDemam_1 getFragmentDemam1() {
        return fragmentDemam1;
    }

    public FragmentDemam_3 getFragmentDemam3() {
        return fragmentDemam3;
    }

    public FragmentDemam_4 getFragmentDemam4() {
        return fragmentDemam4;
    }
}
