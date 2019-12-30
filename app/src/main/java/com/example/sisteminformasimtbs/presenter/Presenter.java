package com.example.sisteminformasimtbs.presenter;

import android.util.Log;

import com.example.sisteminformasimtbs.database.DatabaseHelper;
import com.example.sisteminformasimtbs.model.KunjunganUlang_Classifier;
import com.example.sisteminformasimtbs.model.classifier.StatusGizi_Classifier;
import com.example.sisteminformasimtbs.model.dataclass.Balita;
import com.example.sisteminformasimtbs.model.dataclass.Diagnosis;
import com.example.sisteminformasimtbs.model.dataclass.PasienNow;
import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;
import com.example.sisteminformasimtbs.model.classifier.Anemia_Classifier;
import com.example.sisteminformasimtbs.model.classifier.Batuk_Classifier;
import com.example.sisteminformasimtbs.model.classifier.Classifier;
import com.example.sisteminformasimtbs.model.classifier.Demam_Classifier;
import com.example.sisteminformasimtbs.model.classifier.Diare_Classifier;
import com.example.sisteminformasimtbs.model.classifier.MasalahTelinga_Classifier;
import com.example.sisteminformasimtbs.model.classifier.StatusHiv_Classifier;
import com.example.sisteminformasimtbs.model.classifier.TandaBahayaUmum_Classifier;
import com.example.sisteminformasimtbs.model.dataclass.Kunjungan;
import com.example.sisteminformasimtbs.view.pemeriksaan.TandaBahayaUmum_Fragment;
import com.example.sisteminformasimtbs.model.dataclass.TindakanResult;
import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain_Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Presenter {
    private PemeriksaanMain_Activity activity ;
    // collection of gejala from the patients
    // String namaGejala and integer id gejala
    private HashMap<String , Integer> collectionOfGejala ;

  //  create a collection of classifier
     private List<Classifier> listOfClassifier;

     private DatabaseHelper db ;

    public Presenter(PemeriksaanMain_Activity activity ){
        Log.d("debug", "masuk prsenter");
        this.activity = activity;
        this.collectionOfGejala = new HashMap<String ,Integer>();
        this.listOfClassifier = new LinkedList<>();
        this.db = new DatabaseHelper(activity.getApplicationContext(), activity);
        addAllClassifier();
        this.db.checkTableIfExist(Kunjungan.TABLE_KUNJUNGAN);
        this.db.checkTableIfExist(Diagnosis.TABLE_DIAGNOSIS);
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
        HashMap<String , Integer> res = this.db.getGejalaByIdTopik(idTopik);
        return res ;
    }

    public ArrayList<String> getLangkahTindakan(int idTindakan){
        ArrayList<String> res = this.db.getLangkahTindakanByTindakan(idTindakan) ;
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
        for(Map.Entry<String , Integer> item : this.collectionOfGejala.entrySet()){
            Log.d("gejalamasuk" , item.getKey());
        }
        HashMap<String , Integer> collectionOfKlasifikasiResult = new HashMap<String , Integer>();
        Log.d("total gejala yang masuk" , this.collectionOfGejala.size()+"edan");
        // loop all the possible classifier
        for(int i = 0 ; i < this.listOfClassifier.size() ; i++){

            Classifier now = this.listOfClassifier.get(i) ;
            if(now instanceof Diare_Classifier)
            {
                ArrayList<DiagnosisResult> res = ((Diare_Classifier) now).multiClassify(collectionOfGejala);
                 for(DiagnosisResult item : res){
                     collectionOfKlasifikasiResult.put(item.getNamaKlasifikasiPenyakit() , item.getIdKlasifikasi());
                 }
            }
            else if (now instanceof Demam_Classifier)
            {
                ArrayList<DiagnosisResult> res = ((Demam_Classifier) now).multiClassify(collectionOfGejala);
                for(DiagnosisResult item : res){
                    collectionOfKlasifikasiResult.put(item.getNamaKlasifikasiPenyakit() , item.getIdKlasifikasi());
                }
            }
            else{
                 DiagnosisResult hasil = now.classify(this.collectionOfGejala);
                 if(hasil.getIdKlasifikasi() != 0) collectionOfKlasifikasiResult.put(hasil.getNamaKlasifikasiPenyakit() , hasil.getIdKlasifikasi());

            }
        }
        return collectionOfKlasifikasiResult ;
    }

    /**
     * This method is use to initialize all off the
     * classifier model like tanda bahaya umum , batuk dll
     */
    private void addAllClassifier(){
        this.listOfClassifier.add(new TandaBahayaUmum_Classifier(this.db.getGejalaByIdTopik(TandaBahayaUmum_Fragment.ID_TOPIK)));
        this.listOfClassifier.add(new Batuk_Classifier());
        this.listOfClassifier.add(new Diare_Classifier());
        this.listOfClassifier.add(new StatusHiv_Classifier());
        this.listOfClassifier.add(new Anemia_Classifier());
        this.listOfClassifier.add(new MasalahTelinga_Classifier());
        this.listOfClassifier.add(new Demam_Classifier());
        this.listOfClassifier.add(new StatusGizi_Classifier());
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

    public HashMap<String, LinkedList<TindakanResult>> getAllTindakan_test(){
        //created LinkedList consist of linkedlist for every classification
        HashMap<String , Integer> collectionOfClassification = this.classifyAll();

        HashMap<String , LinkedList<TindakanResult>> collectionOfLinkedList = new HashMap<>();

        // for each for every classification, create a new linked of 1 topic with all tindakan
        // insert to the linkedlist
        // insert the linkedlist ot the collecctionof linked list tindakan

        // add dummy data for testing
        for(Map.Entry<String, Integer> itemKlasifikasi : collectionOfClassification.entrySet()){
            LinkedList<TindakanResult> linkedList = db.getTindakanByIdKlasifikasi(itemKlasifikasi.getValue());
            collectionOfLinkedList.put(itemKlasifikasi.getKey() , linkedList);
        }
        return collectionOfLinkedList;
    }

    public void saveDataBalita(String nama,  String namaIbu, String alamat, String jenisKelamin, String tanggalLahir, String wilayah){
        Balita.insertDataBalita(this.db.getWritableDatabase(), nama, namaIbu, jenisKelamin, alamat, tanggalLahir, wilayah);
    }

    public void saveDataKunjungan (String tanggalKunjungan, double beratBadan, double panjangBadan,
                                   double suhu, int kunjunganKe, int tipeKunjungan, String keluhan, int idBalita)
    {
        Kunjungan.insertKunjungan(this.db.getWritableDatabase(), tanggalKunjungan, beratBadan,
                panjangBadan, suhu, kunjunganKe, tipeKunjungan, keluhan, idBalita);
    }

    public void saveDiagnosis (int idKunjungan , int idKlasifikasi)
    {
        Diagnosis.insertDiagnosis(this.db.getWritableDatabase() , idKunjungan , idKlasifikasi);
    }

    public int getKunjunganUlang ()
    {
        KunjunganUlang_Classifier ku = new KunjunganUlang_Classifier();
        return ku.getMinKunjunganUlang(classifyAll());
    }

    public Balita getBalitaNow(){
        String namaBalita = activity.balitaNow.getNamaAnak();
        String namaIbu = activity.balitaNow.getNamaIbu();
        return this.db.getBalita(namaBalita , namaIbu);
    }

    public Kunjungan getKunjunganNow(int idBalita , String tanggalKunjungan){
        return this.db.getKunjungan(idBalita , tanggalKunjungan);
    }

    public LinkedList<Balita> getAllBalita(){
        return this.db.getAllBalita();
    }

    public LinkedList<Balita> searchBalitaByName(String namaBalita){
        return this.db.getBalitaLikeName(namaBalita);
    }
}
