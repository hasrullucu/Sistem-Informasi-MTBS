package com.example.sisteminformasimtbs.model.classifier;

import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.HashMap;

public class MasalahTelinga_Classifier extends Classifier
{
    private HashMap<String , Integer> collectionOfGejalaInDatabase;

    private String namaKlasifikasi_20 = "MASTOIDITIS";
    private int idKlasifikasi_20 = 20 ;

    private String namaKlasifikasi_21 = "INFEKSI TELINGA AKUT";
    private int idKlasifikasi_21 = 21 ;

    private String namaKlasifikasi_22 = "INFEKSI TELINGA KRONIS";
    private int idKlasifikasi_22 = 22 ;

    private String namaKlasifikasi_23 = "TIDAK ADA INFEKSI TELINGA";
    private int idKlasifikasi_23 = 23 ;

    public MasalahTelinga_Classifier() {

    }

    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {
        if(collectionOfGejala.containsKey("Pembengkakan yang nyeri di belakang telinga")){
            return new DiagnosisResult(namaKlasifikasi_20 , idKlasifikasi_20);
        }else if(collectionOfGejala.containsKey("Nyeri telinga") || collectionOfGejala.containsKey("Rasa penuh di telinga") ||
                collectionOfGejala.containsKey("Tampak cairan/nanah keluar dari telinga selama kurang dari 14 hari")){
            return new DiagnosisResult(namaKlasifikasi_21 , idKlasifikasi_21);
        }else if(collectionOfGejala.containsKey("Tampak cairan/nanah keluar dari telinga dan telah terjadi selama 14 hari atau lebih")){
            return new DiagnosisResult(namaKlasifikasi_22 , idKlasifikasi_22);
        }
        else {
            return new DiagnosisResult(namaKlasifikasi_23 , idKlasifikasi_23);
        }
//        return new DiagnosisResult("0", 0);
    }

    public void setAllGejalaInDatabase(){
        this.collectionOfGejalaInDatabase.put("Pembengkakan yang nyeri di belakang telinga", 45);
        this.collectionOfGejalaInDatabase.put("Nyeri telinga", 46);
        this.collectionOfGejalaInDatabase.put("Rasa penuh di telinga", 47);
        this.collectionOfGejalaInDatabase.put("Tampak cairan/nanah keluar dari telinga selama kurang dari 14 hari", 48);
        this.collectionOfGejalaInDatabase.put("Tampak cairan/nanah keluar dari telinga dan telah terjadi selama 14 hari atau lebih", 49);
        this.collectionOfGejalaInDatabase.put("Tidak ada nyeri telinga DAN tidak ada nanah keluar dari telinga", 50);
    }
}