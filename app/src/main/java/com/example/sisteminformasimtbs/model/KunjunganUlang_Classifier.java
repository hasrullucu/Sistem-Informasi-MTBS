package com.example.sisteminformasimtbs.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KunjunganUlang_Classifier
{
    //key : id klasifikasi
    //value : kunjungan ulang
    private Map<Integer, Integer> kunjunganUlang;

    public KunjunganUlang_Classifier ()
    {
        this.kunjunganUlang = new HashMap();
    }

    private void insertKunjunganUlang ()
    {
        this.kunjunganUlang.put(3, 2);
        this.kunjunganUlang.put(4, 2);
        this.kunjunganUlang.put(6, 3);
        this.kunjunganUlang.put(7, 3);
        this.kunjunganUlang.put(35, 3);
        this.kunjunganUlang.put(9, 3);
        this.kunjunganUlang.put(11, 3);
        this.kunjunganUlang.put(12, 3);
        this.kunjunganUlang.put(16, 3);
        this.kunjunganUlang.put(18, 1);
        this.kunjunganUlang.put(19, 2);
        this.kunjunganUlang.put(21, 5);
        this.kunjunganUlang.put(22, 5);
        this.kunjunganUlang.put(25, 7);
        this.kunjunganUlang.put(26, 30);
        this.kunjunganUlang.put(29, 14);
    }

    public int getMinKunjunganUlang (HashMap klasifikasi)
    {
        int minKunjunganUlang = Integer.MAX_VALUE;

        Iterator iter = klasifikasi.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int idKlas = (int) entry.getValue();
            int kunjunganUlangDay = this.kunjunganUlang.get(idKlas);

            if (kunjunganUlangDay > minKunjunganUlang)
            {
                minKunjunganUlang = kunjunganUlangDay;
            }
        }

        return minKunjunganUlang;
    }
}