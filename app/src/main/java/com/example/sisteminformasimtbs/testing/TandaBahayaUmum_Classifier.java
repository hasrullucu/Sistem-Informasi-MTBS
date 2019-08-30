package com.example.sisteminformasimtbs.testing;

import java.util.HashMap;
import java.util.Map;

public class TandaBahayaUmum_Classifier extends Classifier{
    private HashMap<String , Integer> collectionOfGejalaInDatabase;

    private String nama_klasifikasi_1  = "Tanda Bahaya Umum";
    private int id_klasifikasi_1 = 1 ;


    public TandaBahayaUmum_Classifier(HashMap<String ,Integer> fromDatabase) {
        this.collectionOfGejalaInDatabase = fromDatabase;
        setAllGejalaInDatabase();
    }

    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {
        // DO THE DATABASE HERE !
        boolean isClassified = false;
        for(Map.Entry<String, Integer> item : collectionOfGejala.entrySet() ){
            if(collectionOfGejalaInDatabase.containsKey(item.getKey())){
                isClassified = true;
                break ;
            }
        }
        if(isClassified) return new DiagnosisResult(nama_klasifikasi_1 , id_klasifikasi_1);
        return new DiagnosisResult("0", 0);


    }


    public void setAllGejalaInDatabase(){
        this.collectionOfGejalaInDatabase.put("Tidak bisa minum atau menyusu" , 1);
        this.collectionOfGejalaInDatabase.put("Memuntahkan semua makanan dan atau minuman", 2);
        this.collectionOfGejalaInDatabase.put("Pernah atau sedang mengalami kejang",3);
        this.collectionOfGejalaInDatabase.put("Gelisah",4);
    }
}
