package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Batuk extends Initializer
{
    private PemeriksaanMain_Activity activity;
    private FragmentBatuk batuk_Fragment ;


    public Initializer_Batuk (PemeriksaanMain_Activity activity)
    {
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll()
    {
        this.batuk_Fragment = FragmentBatuk.newInstance(activity);
    }

    public FragmentBatuk getBatuk_Fragment() {
        return batuk_Fragment;
    }
}
