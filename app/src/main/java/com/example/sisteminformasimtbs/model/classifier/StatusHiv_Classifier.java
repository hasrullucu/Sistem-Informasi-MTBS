package com.example.sisteminformasimtbs.model.classifier;

import com.example.sisteminformasimtbs.model.dataclass.DiagnosisResult;

import java.util.HashMap;

public class StatusHiv_Classifier extends Classifier {
    private HashMap<String , Integer> collectionOfGejalaInDatabase;

    private String namaKlasifikasi_31 = "INFEKSI HIV TERKONFIRMASI";
    private int idKlasifikasi_31 = 31 ;

    private String namaKlasifikasi_32 = "DIDUGA TERINFEKSI HIV";
    private int idKlasifikasi_32 = 32 ;

    private String namaKlasifikasi_33 = "TERPAJAN HIV";
    private int idKlasifikasi_33 = 33 ;

    private String namaKlasifikasi_34 = "MUNGKIN BUKAN INFEKSI HIV";
    private int idKlasifikasi_34 = 34 ;

    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {
        if(collectionOfGejala.containsKey("Tes HIV anak positif")){
            return new DiagnosisResult(namaKlasifikasi_31 , idKlasifikasi_31);
        }else if(collectionOfGejala.containsKey("Ibu HIV positif atau riwayat kematian orang tua atau saudara kandung yang didiagnosis HIV atau dengan gejala klinis AIDS")){
            return new DiagnosisResult(namaKlasifikasi_32 , idKlasifikasi_32);
        }else if(collectionOfGejala.containsKey("Ibu HIV positif") ||
                collectionOfGejala.containsKey("Anak dari ibu dengan HIV, masih mendapat ASI") ||
                collectionOfGejala.containsKey("Anak dari ibu dengan HIV, status HIV anak tidak diketahui")){
            return new DiagnosisResult(namaKlasifikasi_33 , idKlasifikasi_33);
        }
        else {
            return new DiagnosisResult(namaKlasifikasi_34 , idKlasifikasi_34);
        }



    }
}
