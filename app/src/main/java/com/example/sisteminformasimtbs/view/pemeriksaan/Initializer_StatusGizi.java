package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_StatusGizi extends Initializer
{
    private FragmentStatusGizi1 statusGizi1;
    private FragmentStatusGizi2 statusGizi2;
    private PemeriksaanMain activity;

    public Initializer_StatusGizi (PemeriksaanMain activity)
    {
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll()
    {
        this.statusGizi1 = FragmentStatusGizi1.newInstance(activity);
        this.statusGizi2 = FragmentStatusGizi2.newInstance(activity);
    }

    public FragmentStatusGizi1 getStatusGizi1() {
        return statusGizi1;
    }

    public FragmentStatusGizi2 getStatusGizi2() {
        return statusGizi2;
    }
}