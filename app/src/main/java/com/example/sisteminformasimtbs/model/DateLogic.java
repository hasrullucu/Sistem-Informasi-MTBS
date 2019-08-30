package com.example.sisteminformasimtbs.model;

import java.util.Calendar;
import java.util.Date;

public class DateLogic{
    public DateLogic() {

    }

    /**
     * GET DIFFERENCE BEETWEEN two date
     * @param bigger
     * @param smaller
     * @param whatDate using Calendar Type constan
     * @return
     */

    public int getDiffDate(Calendar bigger ,Calendar smaller, int whatDate){
        int diffBig = bigger.get(whatDate);
        int diffSmall = smaller.get(whatDate);

        return diffBig - diffSmall;
    }


    /**
     * Method to check whether to diagnose for balita umur dibawah 2 bulan atau di atas 2 bulan
     * @param year
     * @param month
     * @return
     */
    public boolean checkDiAtas2BulanPemeriksaan(int year, int month){
        if(year > 0 ) return true ;
        else {
            if(month > 1) return true ;
            else return false;
        }
    }

    public String getStatus(boolean status){
        if(status) return "Proses MTBS akan dilakukan sesuai prosedur untuk balita umur 2 bulan - 5 tahun" ;
        else return "Proses MTBS akan dilakukan sesuai prosedur untuk balita berumur dibawah 2 bulan";
    }
}