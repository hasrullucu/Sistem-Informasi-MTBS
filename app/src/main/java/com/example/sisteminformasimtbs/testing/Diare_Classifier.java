package com.example.sisteminformasimtbs.testing;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Diare_Classifier extends Classifier {
    private HashMap<String , Integer> collectionOfGejalaInDatabase;

    private String namaKlasifikasi_5 = "DIARE DEHIDRASI BERAT";
    private int idKlasifikasi_5 = 5 ;

    private String namaKlasifikasi_6 = "DIARE DEHIDRASI RINGAN / SEDANG";
    private int idKlasifikasi_6 = 6 ;

    private String namaKlasifikasi_7 = "DIARE TANPA DEHIDRASI";
    private int idKlasifikasi_7 = 7 ;

    private String namaKlasifikasi_8 = "DIARE PERSISTEN BERAT";
    private int idKlasifikasi_8 = 8 ;

    private String namaKlasifikasi_9 = "DISENTRI";
    private int idKlasifikasi_9 = 9 ;

    private String namaKlasifikasi_35 = "DIARE PERSISTEN";
    private int idKlasifikasi_35 = 35 ;

    public Diare_Classifier () {

    }



    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {


        return new DiagnosisResult("" , 0);


    }

    public ArrayList<DiagnosisResult> multiClassify(HashMap<String , Integer> collectionOfGejala){
        ArrayList<DiagnosisResult> res = new ArrayList<>();

        // diagnosis yang awal
        int counterBerat = 0 ;
        int counterSedang = 0 ;
        for(Map.Entry<String , Integer> item : collectionOfGejala.entrySet()){


            if(item.getKey().equals("Letargis atau Tidak Sadar ?") || item.getKey().equals("Mata cekung") || item.getKey().equals("Tidak bisa minum atau malas minum")
            || item.getKey().equals("Cubitan kulit perut kembali sangat lambat")){
                counterBerat++;
            }
            if(item.getKey().equals("Mata cekung") || item.getKey().equals("Rewel / mudah marah") || item.getKey().equals("Haus, minum dengan lahap")
            || item.getKey().equals("Cubitan kulit perut kembali lambat")){
                counterSedang++;
            }
        }
        Log.d("counterberat" , "counter berat : " + counterBerat);
        if(counterBerat >= 2) res.add(new DiagnosisResult("DIARE DEHIDRASI BERAT" , 5) );
        else if(counterSedang >= 2) res.add(new DiagnosisResult("DIARE DEHIDRASI RINGAN / SEDANG" ,6));
        else res.add(new DiagnosisResult("DIARE TANPA DEHIDRASI", 7));

        if (collectionOfGejala.containsKey("Tanpa dehidrasi") && collectionOfGejala.containsKey("Diare 14 hari atau lebih"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_35, idKlasifikasi_35));
        }
        else if (collectionOfGejala.containsKey("Dengan dehidrasi") && collectionOfGejala.containsKey("Diare 14 hari atau lebih"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_8, idKlasifikasi_8));
        }
        else if (collectionOfGejala.containsKey("Ada darah dalam tinja"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_9 , idKlasifikasi_9));
        }

        return res ;
    }

    public void setAllGejalaInDatabase(){
        this.collectionOfGejalaInDatabase.put("Tarikan dinding dada ke dalam", 9);
        this.collectionOfGejalaInDatabase.put("Saturasi Oksigen < 90%" , 10);
        this.collectionOfGejalaInDatabase.put("Nafas cepat" , 11 );
    }

}