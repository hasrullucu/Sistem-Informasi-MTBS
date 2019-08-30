package com.example.sisteminformasimtbs.testing;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.model.Pemeriksaan;
import com.example.sisteminformasimtbs.model.dataclass.Tindakan;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Presenter {
    private PemeriksaanMain activity ;
    // collection of gejala from the patients
    // String namaGejala and integer id gejala
    private HashMap<String , Integer> collectionOfGejala ;

  //  create a collection of classifier
     private List<Classifier> listOfClassifier;

     private DatabaseHelper db ;

    public Presenter(PemeriksaanMain activity ){
        Log.d("debug", "masuk prsenter");
        this.activity = activity;
        this.collectionOfGejala = new HashMap<String ,Integer>();
        this.listOfClassifier = new LinkedList<>();
        this.db = new DatabaseHelper(activity.getApplicationContext(), activity);
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

    public HashMap<String, Integer> getGejalaByIdTopik(int idTopik)
    {
        HashMap<String , Integer > res = this.db.getGejalaByIdTopik(1);
        return res ;

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
        this.listOfClassifier.add(new TandaBahayaUmum_Classifier(this.db.getGejalaByIdTopik(TandaBahayaUmum_Test.ID_TOPIK)));
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
        for(Map.Entry<String, Integer> itemKlasifikasi : collectionOfClassification.entrySet()){
            LinkedList<TindakanResult> linkedList = db.getTindakanByIdKlasifikasi(itemKlasifikasi.getValue());
            collectionOfLinkedListTindakan.add(linkedList);
        }
        return collectionOfLinkedListTindakan ;
    }


}
