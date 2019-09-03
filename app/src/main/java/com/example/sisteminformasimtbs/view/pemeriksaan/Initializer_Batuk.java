package com.example.sisteminformasimtbs.view.pemeriksaan;

import com.example.sisteminformasimtbs.testing.Batuk_Test;

public class Initializer_Batuk extends Initializer
{
    private PemeriksaanMain activity;
    private Batuk_Test batuk_Fragment ;


    public Initializer_Batuk (PemeriksaanMain activity)
    {
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll()
    {
        this.batuk_Fragment = Batuk_Test.newInstance(activity);
    }

    public Batuk_Test getBatuk_Fragment() {
        return batuk_Fragment;
    }
}
