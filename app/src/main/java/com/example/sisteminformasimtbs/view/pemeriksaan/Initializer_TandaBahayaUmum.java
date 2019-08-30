package com.example.sisteminformasimtbs.view.pemeriksaan;

import android.database.sqlite.SQLiteDatabase;

import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.testing.TandaBahayaUmum_Test;

public class Initializer_TandaBahayaUmum extends Initializer
{
    private PemeriksaanMain activity;
    private TandaBahayaUmum_Test tandaBahayaUmumFragment ;



    public Initializer_TandaBahayaUmum (PemeriksaanMain activity )
    {
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll()
    {

        this.tandaBahayaUmumFragment= TandaBahayaUmum_Test.newInstance(activity);
    }

    public TandaBahayaUmum_Test getTandaBahayaUmumFragment() {
        return tandaBahayaUmumFragment;
    }
}