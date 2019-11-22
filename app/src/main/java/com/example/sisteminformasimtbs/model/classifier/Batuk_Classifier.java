package com.example.sisteminformasimtbs.model.classifier;

import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.HashMap;

public class Batuk_Classifier extends Classifier {

    private HashMap<String , Integer> collectionOfGejalaInDatabase;

    private String namaKlasifikasi_2 = "PNEUMONIA BERAT";
    private int idKlasifikasi_2 = 2 ;

    private String namaKlasifikasi_3 = "PNEUMONIA";
    private int idKlasifikasi_3 = 3 ;

    private String namaKlasifikasi_4 = "BATUK BUKAN PNEUMONIA";
    private int idKlasifikasi_4 = 4 ;

    public Batuk_Classifier() {

    }

    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {
        if(collectionOfGejala.containsKey("Tarikan dinding dada ke dalam") || collectionOfGejala.containsKey("Saturasi Oksigen < 90%")){
            return new DiagnosisResult(namaKlasifikasi_2 , idKlasifikasi_2);
        }else if(collectionOfGejala.containsKey("Napas cepat")){
            return new DiagnosisResult(namaKlasifikasi_3 , idKlasifikasi_3);
        }
        else if (collectionOfGejala.containsKey("Tidak ada tanda-tanda Pneumonia Berat maupun Pneumonia"))
        {
            return new DiagnosisResult(namaKlasifikasi_4, idKlasifikasi_4);
        }
        return new DiagnosisResult("0", 0);
    }

    public void setAllGejalaInDatabase(){
        this.collectionOfGejalaInDatabase.put("Tarikan dinding dada ke dalam", 9);
        this.collectionOfGejalaInDatabase.put("Saturasi Oksigen < 90%" , 10);
        this.collectionOfGejalaInDatabase.put("Nafas cepat" , 11 );
    }
}
