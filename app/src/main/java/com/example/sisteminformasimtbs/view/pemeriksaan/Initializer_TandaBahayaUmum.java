package com.example.sisteminformasimtbs.view.pemeriksaan;

import android.database.sqlite.SQLiteDatabase;

import com.example.sisteminformasimtbs.database.DatabaseHelper;

public class Initializer_TandaBahayaUmum extends Initializer
{
    private PemeriksaanMain activity;
    private SQLiteDatabase db;
    private FragmentTandaBahayaUmum1 tandaBahayaUmum1;

    public Initializer_TandaBahayaUmum (PemeriksaanMain activity , SQLiteDatabase db)
    {
        this.activity = activity;
        this.db = db ;
        initAll();
    }

    @Override
    public void initAll()
    {
        this.tandaBahayaUmum1 = FragmentTandaBahayaUmum1.newInstance(activity , this.db);
    }

    public FragmentTandaBahayaUmum1 getTandaBahayaUmum1() {
        return tandaBahayaUmum1;
    }
}