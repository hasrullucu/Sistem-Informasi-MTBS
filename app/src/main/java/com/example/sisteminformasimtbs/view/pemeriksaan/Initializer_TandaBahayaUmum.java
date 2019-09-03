package com.example.sisteminformasimtbs.view.pemeriksaan;

import com.example.sisteminformasimtbs.testing.TandaBahayaUmum_Fragment;

public class Initializer_TandaBahayaUmum extends Initializer
{
    private PemeriksaanMain activity;
    private TandaBahayaUmum_Fragment tandaBahayaUmumFragment ;



    public Initializer_TandaBahayaUmum (PemeriksaanMain activity )
    {
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll()
    {

        this.tandaBahayaUmumFragment= TandaBahayaUmum_Fragment.newInstance(activity);
    }

    public TandaBahayaUmum_Fragment getTandaBahayaUmumFragment() {
        return tandaBahayaUmumFragment;
    }
}