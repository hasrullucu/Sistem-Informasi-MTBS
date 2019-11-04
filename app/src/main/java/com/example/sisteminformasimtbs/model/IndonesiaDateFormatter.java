package com.example.sisteminformasimtbs.model;

import java.util.HashMap;

public class IndonesiaDateFormatter {
    private static HashMap<Integer , String> collectionOfMonth = new HashMap<Integer, String>(){{
        this.put(1,"Januari");
        this.put(2,"Febuari");
        this.put(3,"Maret");
        this.put(4,"April");
        this.put(5,"Mei") ;
        this.put(6, "Juni");
        this.put(7,"Juli");
        this.put(8,"Agustus");
        this.put(9,"September");
        this.put(10, "Oktober");
        this.put(11, "November");
        this.put(12, "Desember");
    }} ;


    public static String convert(int year, int month , int day){
        String indonesiaMonth = convertMonth(month);
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
