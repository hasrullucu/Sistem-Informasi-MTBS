package com.example.sisteminformasimtbs.testing;

import android.util.Log;

import com.example.sisteminformasimtbs.model.dataclass.Tindakan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Presenter {
    // collection of gejala from the patients
    // String namaGejala and integer id gejala
    private HashMap<String , Integer> collectionOfGejala ;

  //  create a collection of classifier
     private List<Classifier> listOfClassifier;


    public Presenter(){
        this.collectionOfGejala = new HashMap<String ,Integer>();
        this.listOfClassifier = new LinkedList<>();
        addAllClassifier();
    }

    public void addGejala(String gejala , int id){
        this.collectionOfGejala.put(gejala , id);
        printToLog();
    }

    public void removeGejala(String gejala){
        this.collectionOfGejala.remove(gejala);
        printToLog();
    }

    private String printListOfGejala(){
        int size = this.collectionOfGejala.size();
        String result = " list  : \n";
        for(Map.Entry<String , Integer> item : collectionOfGejala.entrySet()){
            result += "Key :" + item.getKey() + " Value : " + item.getValue() + " \n";
        }
        return result ;
    }

    public void printToLog(){
        String content  = printListOfGejala();
        Log.d("collection" , content);
    }

    public HashMap<String, Integer> classifyAll(){
        //create result of hashmap
        // create container containing all the klasifikasi result from the
        HashMap<String , Integer> collectionOfKlasifikasiResult = new HashMap<String , Integer>();

        // loop all the possible classifier
        for(int i = 0 ; i < this.listOfClassifier.size() ; i++){
            Classifier now = this.listOfClassifier.get(i) ;
            DiagnosisResult hasil = now.classify(this.collectionOfGejala);
            if(hasil.getIdKlasifikasi() != 0) collectionOfKlasifikasiResult.put(hasil.getNamaKlasifikasiPenyakit() , hasil.getIdKlasifikasi());
        }
        return collectionOfKlasifikasiResult ;
    }

    /**
     * This method is use to initialize all off the
     * classifier model like tanda bahaya umum , batuk dll
     */
    private void addAllClassifier(){
        this.listOfClassifier.add(new TandaBahayaUmum_Classifier());
        this.listOfClassifier.add(new Batuk_Classifier());
    }

    public LinkedList<LinkedList<TindakanResult>> getAllTindakan(){
        //created LinkedList consist of linkedlist for every classification
        HashMap<String , Integer> collectionOfClassification = this.classifyAll();
        LinkedList<LinkedList<TindakanResult>> collectionOfLinkedListTindakan = new LinkedList<LinkedList<TindakanResult>>();

        // for each for every classification, create a new linked of 1 topic with all tindakan
            // insert to the linkedlist
        // insert the linkedlist ot the collecctionof linked list tindakan

        // add dummy data for testing
        LinkedList<TindakanResult> tindakanClassification_1 = new LinkedList<TindakanResult>();
        tindakanClassification_1.add(new TindakanResult(1, "Bila sedang kejang beri diazepam"));
        tindakanClassification_1.add(new TindakanResult(2, "Bila ada stridor pastikan tidak ada sumbatan jalan napas"));
        tindakanClassification_1.add(new TindakanResult(3, "Bila ada stridor, sianosis dan ujung tangan dan kaki pucat dan dingin berikan oksigen 3-5 liter/menit melalui nasal prong dengan perangkat oksigen standar (tabung O dan 2 humidifier) Cegah agar gula"));
        tindakanClassification_1.add(new TindakanResult(4 , "Bila sedang kejang beri diazepam"));
        tindakanClassification_1.add(new TindakanResult(5, "Jaga anak tetap hangat"));
        tindakanClassification_1.add(new TindakanResult(7, "RUJUK SEGERA"));
        collectionOfLinkedListTindakan.add(tindakanClassification_1);

        LinkedList<TindakanResult> tindakanClassification_2 = new LinkedList<TindakanResult>();
        tindakanClassification_2.add(new TindakanResult(8, "Beri Oksigen maksimal 2-3 liter/menit dengan menggunakan nasal prong"));
        tindakanClassification_2.add(new TindakanResult(9 , "Beri dosis pertama antibiotik yang sesuai"));
        collectionOfLinkedListTindakan.add(tindakanClassification_2);


        return collectionOfLinkedListTindakan ;


    }


}
