package com.example.sisteminformasimtbs.model.classifier;

import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.HashMap;

public class Anemia_Classifier extends Classifier {
    private String namaKlasifikasi_28 = "ANEMIA BERAT";
    private int idKlasifikasi_28 = 28 ;

    private String namaKlasifikasi_29 = "ANEMIA";
    private int idKlasifikasi_29 = 29 ;

    private String namaKlasifikasi_30 = "TIDAK ANEMIA";
    private int idKlasifikasi_30 = 30 ;

    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {
        if(collectionOfGejala.containsKey("Telapak tangan sangat pucat")){
            return new DiagnosisResult(namaKlasifikasi_28 , idKlasifikasi_28);
        }else if(collectionOfGejala.containsKey("Telapak tangan agak pucat") ){
            return new DiagnosisResult(namaKlasifikasi_29 , idKlasifikasi_29);
        }
        else
        {
            return new DiagnosisResult(namaKlasifikasi_30 , idKlasifikasi_30);
        }
//        return new DiagnosisResult("0", 0);
    }
}
