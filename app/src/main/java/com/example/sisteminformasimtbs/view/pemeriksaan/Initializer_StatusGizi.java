package com.example.sisteminformasimtbs.view.pemeriksaan;

public class Initializer_StatusGizi extends Initializer
{
    // fragment 1 , 2 , 3
    private PemeriksaanMain_Activity activity;

    private FragmentStatusGizi_1 fragmentStatusGizi_1;
    private FragmentStatusGizi_2 fragmentStatusGizi_2;
    private FragmentStatusGizi_3 fragmentStatusGizi3;

    public FragmentStatusGizi_2 getFragmentStatusGizi_2() {
        return fragmentStatusGizi_2;
    }

    public Initializer_StatusGizi (PemeriksaanMain_Activity activity)
    {
        this.activity = activity;
        initAll();
    }

    public FragmentStatusGizi_3 getFragmentStatusGizi3() {
        return fragmentStatusGizi3;
    }

    @Override
    public void initAll()
    {
       // create fragment for status gizi
        this.fragmentStatusGizi_1 = FragmentStatusGizi_1.newInstance(activity);
        this.fragmentStatusGizi_2 = FragmentStatusGizi_2.newInstance(activity);
        this.fragmentStatusGizi3 = FragmentStatusGizi_3.newInstance(activity);

    }

// getter

    public FragmentStatusGizi_1 getFragmentStatusGizi_1() {
        return fragmentStatusGizi_1;
    }
}