package com.example.sisteminformasimtbs.view.pemeriksaan;


public class Initializer_Diare extends Initializer{
    private PemeriksaanMain_Activity activity;
    private FragmentDiare_1 fragmentDiare1 ;
    private FragmentDiare_2 fragmentDiare2 ;

    public Initializer_Diare(PemeriksaanMain_Activity activity){
        this.activity = activity;
        initAll();
    }

    public FragmentDiare_1 getFragmentDiare1() {
        return fragmentDiare1;
    }

    public FragmentDiare_2 getFragmentDiare2() {
        return fragmentDiare2;
    }

    @Override
    public void initAll() {
        this.fragmentDiare1 = FragmentDiare_1.newInstance(activity);
        this.fragmentDiare2 = FragmentDiare_2.newInstance(activity);
    }
}
