package com.example.sisteminformasimtbs.model.classifier;

import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.ArrayList;
import java.util.HashMap;

public class Demam_Classifier extends Classifier
{
    private HashMap<String , Integer> collectionOfGejalaInDatabase;

    private String namaKlasifikasi_10 = "PENYAKIT BERAT DENGAN DEMAM";
    private int idKlasifikasi_10 = 10 ;

    private String namaKlasifikasi_11 = "MALARIA";
    private int idKlasifikasi_11 = 11 ;

    private String namaKlasifikasi_12 = "DEMAM MUNGKIN BUKAN MALARIA";
    private int idKlasifikasi_12 = 12 ;

    private String namaKlasifikasi_13 = "PENYAKIT BERAT DENGAN DEMAM";
    private int idKlasifikasi_13 = 13 ;

    private String namaKlasifikasi_14 = "DEMAM BUKAN MALARIA";
    private int idKlasifikasi_14 = 14 ;

    private String namaKlasifikasi_15 = "CAMPAK DENGAN KOMPLIKASI BERAT";
    private int idKlasifikasi_15 = 15 ;

    private String namaKlasifikasi_16 ="CAMPAK DENGAN KOMPLIKASI PADA MATA DAN/ATAU MULUT";
    private int idKlasifikasi_16 = 16;

    private String namaKlasifikasi_36 ="CAMPAK";
    private int idKlasifikasi_36 = 36;

    private String namaKlasifikasi_17 ="DEMAM BERDARAH DENGUE (DBD)";
    private int idKlasifikasi_17 = 17;

    private String namaKlasifikasi_18 ="MUNGKIN DBD";
    private int idKlasifikasi_18 = 18;

    private String namaKlasifikasi_19 ="DEMAM MUNGKIN BUKAN DBD";
    private int idKlasifikasi_19 = 19;

    public Demam_Classifier () {

    }

    @Override
    public DiagnosisResult classify(HashMap<String, Integer> collectionOfGejala) {
        return new DiagnosisResult("" , 0);
    }

    public ArrayList<DiagnosisResult> multiClassify(HashMap<String , Integer> collectionOfGejala){
        ArrayList<DiagnosisResult> res = new ArrayList<>();

        // diagnosis yang awal
//        int counterBerat = 0 ;
//        int counterSedang = 0 ;
//        for(Map.Entry<String , Integer> item : collectionOfGejala.entrySet()){
//
//
//            if(item.getKey().equals("Ada tanda bahaya umum"))
//            {
//                counterBerat++;
//            }
//            if(item.getKey().equals("Mata cekung") || item.getKey().equals("Rewel / mudah marah") || item.getKey().equals("Haus, minum dengan lahap")
//                    || item.getKey().equals("Cubitan kulit perut kembali lambat")){
//                counterSedang++;
//            }
//        }
//        Log.d("counterberat" , "counter berat : " + counterBerat);
//        if(counterBerat >= 2) res.add(new DiagnosisResult("DIARE DEHIDRASI BERAT" , 5) );
//        else if(counterSedang >= 2) res.add(new DiagnosisResult("DIARE DEHIDRASI RINGAN / SEDANG" ,6));
//        else res.add(new DiagnosisResult("DIARE TANPA DEHIDRASI", 7));


        if (collectionOfGejala.containsKey("Ada tanda bahaya umum") || collectionOfGejala.containsKey("Kaku kuduk"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_10, idKlasifikasi_10));
        }
        else if (collectionOfGejala.containsKey("Demam (pada anamnesis atau teraba panas atau suhu ≥ 37,5 °C)") &&
                collectionOfGejala.containsKey("Mikroskopis positif atau RDT positif"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_11, idKlasifikasi_11));
        }
        else if ( collectionOfGejala.containsKey("Mikroskopis negatif atau RDT negatif") ||
                collectionOfGejala.containsKey("Ditemukan penyebab lain dari demam"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_12, idKlasifikasi_12));
        }

//        CAMPAK
        if (collectionOfGejala.containsKey("Ada tanda bahaya umum") || collectionOfGejala.containsKey("Adanya kekeruhan pada kornea mata") ||
                collectionOfGejala.containsKey("Ada luka di mulut yang dalam atau luas"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_15, idKlasifikasi_15));
        }
        else if (collectionOfGejala.containsKey("Ada nanah pada mata") ||
                collectionOfGejala.containsKey("Ada luka pada mulut"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_16, idKlasifikasi_16));
        }
        else if (collectionOfGejala.containsKey("Campak sekarang atau dalam 3 bulan terakhir"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_36, idKlasifikasi_36));
        }

//        DBD
        if (collectionOfGejala.containsKey("Ada tanda tanda syok") || collectionOfGejala.containsKey("Nyeri ulu hati") ||
                collectionOfGejala.containsKey("Muntah-muntah") || collectionOfGejala.containsKey("Perdarahan (kulit/hidung/BAB)") ||
                collectionOfGejala.containsKey("Uji torniket positif"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_17 , idKlasifikasi_17));
        }
        else if (collectionOfGejala.containsKey("Demam mendadak tinggi dan terus menerus") ||
                collectionOfGejala.containsKey("Bintik-bintik perdarahan di kulit negatif") ||
                collectionOfGejala.containsKey("Uji torniket negatif"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_18, idKlasifikasi_18));
        }
        else if (collectionOfGejala.containsKey("Tidak ada satupun gejala di atas"))
        {
            res.add(new DiagnosisResult(namaKlasifikasi_19, idKlasifikasi_19));
        }

        return res ;
    }

    public void setAllGejalaInDatabase(){
        this.collectionOfGejalaInDatabase.put("Tarikan dinding dada ke dalam", 9);
        this.collectionOfGejalaInDatabase.put("Saturasi Oksigen < 90%" , 10);
        this.collectionOfGejalaInDatabase.put("Nafas cepat" , 11 );
    }

}