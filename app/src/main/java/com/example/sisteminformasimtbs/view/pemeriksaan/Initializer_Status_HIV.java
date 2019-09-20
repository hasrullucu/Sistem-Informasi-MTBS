package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Status_HIV extends Initializer {
    private PemeriksaanMain_Activity activity;
    private FragmentStatusHIV_1 statusHIV1;


    public Initializer_Status_HIV(PemeriksaanMain_Activity activity){
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll() {
        this.statusHIV1 = FragmentStatusHIV_1.newInstance(activity);

    }

    public FragmentStatusHIV_1 getStatusHIV1() {
        return statusHIV1;
    }


}
