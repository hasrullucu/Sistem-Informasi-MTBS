package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_TandaBahayaUmum extends Initializer
{
    private PemeriksaanMain_Activity activity;
    private TandaBahayaUmum_Fragment tandaBahayaUmumFragment ;



    public Initializer_TandaBahayaUmum (PemeriksaanMain_Activity activity )
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