package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_Batuk extends Initializer
{
    private PemeriksaanMain activity;
    private FragmentBatuk1 batuk1;
    private FragmentBatuk2 batuk2;
    private FragmentBatuk3 batuk3;

    public Initializer_Batuk (PemeriksaanMain activity)
    {
        this.activity = activity;
        initAll();
    }

    @Override
    public void initAll()
    {
        this.batuk1 = FragmentBatuk1.newInstance(activity);
        this.batuk2 = FragmentBatuk2.newInstance(activity);
        this.batuk3 = FragmentBatuk3.newInstance(activity);
    }

    public FragmentBatuk1 getBatuk1() {
        return batuk1;
    }

    public FragmentBatuk2 getBatuk2() {
        return batuk2;
    }

    public FragmentBatuk3 getBatuk3() { return batuk3; }
}
