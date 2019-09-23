package com.example.sisteminformasimtbs.model.classifier;

import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.DiagnosisResult;

import java.util.HashMap;
import java.util.Map;

public class StatusGizi_Classifier extends Classifier
{
    private HashMap<String , Integer> collectionOfGejalaInDatabase;

    private String namaKlasifikasi_24 = "SANGAT KURUS DENGAN KOMPLIKASI";
    private int idKlasifikasi_24 = 24 ;

    private String namaKlasifikasi_25 = "SANGAT KURUS TANPA KOMPLIKASI";
    private int idKlasifikasi_25 = 25 ;

    private String namaKlasifikasi_26 = "KURUS";
    private int idKlasifikasi_26 = 26 ;

    private String namaKlasifikasi_27 = "GIZI NORMAL";
    private int idKlasifikasi_27 = 27 ;

    public StatusGizi_Classifier () {

    }

    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {

        int denganKomplikasi = 0 ;
        int tanpaKomplikasi = 0 ;
        for(Map.Entry<String , Integer> item : collectionOfGejala.entrySet())
        {
            if (item.getKey().equals("Terlihat sangat kurus") ||
                    item.getKey().equals("BB/PP (TB) < -3 SD") ||
                    item.getKey().equals("LiLA  < 11,5 cm"))
            {
                denganKomplikasi++;
                tanpaKomplikasi++;
            }

            if(item.getKey().equals("Endema pada kedua punggung kaki")){
                denganKomplikasi++;
            }
        }

        if (denganKomplikasi >= 1)
        {
            if (collectionOfGejala.containsKey("Ada tanda bahaya umum") || collectionOfGejala.containsKey("Klasifikasi berat") ||
                    collectionOfGejala.containsKey("Masalah pemberian ASI pada umur < 6 bulan"))
            {
                return new DiagnosisResult(namaKlasifikasi_24, idKlasifikasi_24);
            }
        }
        else if (tanpaKomplikasi >= 1)
        {
            return new DiagnosisResult(namaKlasifikasi_25, idKlasifikasi_25);
        }
        else if ( collectionOfGejala.containsKey("BB/PB (TB) - 3 SD sampai - 2 SD") ||
                collectionOfGejala.containsKey("LiLA 11,5 cm - 12,5 cm"))
        {
            return new DiagnosisResult(namaKlasifikasi_26, idKlasifikasi_26);
        }
        else if ( collectionOfGejala.containsKey("BB/PB (TB) ≥ - 2 SD") ||
                collectionOfGejala.containsKey("LiLA ≥ 12,5 cm"))
        {
            return new DiagnosisResult(namaKlasifikasi_27, idKlasifikasi_27);
        }

        return new DiagnosisResult("" , 0);
    }

    public void setAllGejalaInDatabase(){
        this.collectionOfGejalaInDatabase.put("Tarikan dinding dada ke dalam", 9);
        this.collectionOfGejalaInDatabase.put("Saturasi Oksigen < 90%" , 10);
        this.collectionOfGejalaInDatabase.put("Nafas cepat" , 11 );
    }
}
