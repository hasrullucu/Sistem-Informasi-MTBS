package com.example.sisteminformasimtbs.view.pemeriksaan;


public class Initializer_Diare extends Initializer{
    private PemeriksaanMain activity;
    private FragmentDiare1 fragmentDiare1 ;
    private FragmentDiare2 fragmentDiare2 ;

    public Initializer_Diare(PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }

    public FragmentDiare1 getFragmentDiare1() {
        return fragmentDiare1;
    }

    public FragmentDiare2 getFragmentDiare2() {
        return fragmentDiare2;
    }

    @Override
    public void initAll() {
        this.fragmentDiare1 = FragmentDiare1.newInstance(activity);
        this.fragmentDiare2 = FragmentDiare2.newInstance(activity);
    }
}
