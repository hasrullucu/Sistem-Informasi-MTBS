package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Status_HIV extends Initializer {
    private PemeriksaanMain activity;
    private FragmentStatusHIV1 statusHIV1;
    private FragmentStatusHIV2 statusHIV2;

    public Initializer_Status_HIV(PemeriksaanMain activity){
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll() {
        this.statusHIV1 = FragmentStatusHIV1.newInstance(activity);
        this.statusHIV2 = FragmentStatusHIV2.newInstance(activity);
    }

    public FragmentStatusHIV1 getStatusHIV1() {
        return statusHIV1;
    }

    public FragmentStatusHIV2 getStatusHIV2() {
        return statusHIV2;
    }
}
