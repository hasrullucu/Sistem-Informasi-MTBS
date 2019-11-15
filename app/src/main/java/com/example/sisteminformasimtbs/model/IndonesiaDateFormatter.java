package com.example.sisteminformasimtbs.model;

import android.util.Log;

import java.util.HashMap;

public class IndonesiaDateFormatter {
    private static HashMap<Integer , String> collectionOfMonth = new HashMap<Integer, String>(){{
        this.put(0,"Januari");
        this.put(1,"Febuari");
        this.put(2,"Maret");
        this.put(3,"April");
        this.put(4,"Mei") ;
        this.put(5, "Juni");
        this.put(6,"Juli");
        this.put(7,"Agustus");
        this.put(8,"September");
        this.put(9, "Oktober");
        this.put(10, "November");
        this.put(11, "Desember");
    }} ;


    public static String convert(int year, int month , int day){
        String indonesiaMonth = convertMonth(month) ;
        Log.d("now", "month : " + month);
        return day+" "+indonesiaMonth+" "+year;
    }

    /**
     * Method to convert number of month into Indonesian's month convention
     * example month = 1 - > januari
     *         month = 12 -> desember
     * @param month
     * @return
     */
    private static String convertMonth(int month){
        return collectionOfMonth.get(month);
    }
}
