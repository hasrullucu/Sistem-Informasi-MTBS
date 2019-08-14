package com.example.sisteminformasimtbs.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.HashMap;

public class PeriksaTandaBahayaUmum extends Pemeriksaan{
    private HashMap<Integer , Diagnosis> hasil ;
    private int count ; // jumlah gejala yang diderita
    public PeriksaTandaBahayaUmum( SQLiteDatabase db) {
        this.hasil = new HashMap<Integer , Diagnosis>();
        this.count = 0;
        insertModel(db);
    }

    private void insertModel(SQLiteDatabase db){
        Cursor res = db.rawQuery("SELECT gejala.idGejala  , namaGejala FROM gejala join gejalamemilikiklasifikasi on gejala.idGejala = gejalamemilikiklasifikasi.idgejala join klasifikasipenyakit on klasifikasipenyakit.idKlasifikasi = gejalamemilikiklasifikasi.idKlasifikasi where klasifikasipenyakit.idklasifikasi = 1" , null);

        while(res.moveToNext()){
            int idGejala = res.getInt(0);
            String namaGejala = res.getString(1);

            Diagnosis newD = new Diagnosis(namaGejala, false);
            Log.d("hasil_q", "id : "+ idGejala + " namaGejala :" + namaGejala);
            hasil.put(idGejala , newD);
        }

    }

    public String getGejala(int idGejala){
        Diagnosis res = hasil.get(idGejala);
        return res.getNamaGejala();
    }

    public void updateHasil(int idGejala ){
        Diagnosis now = this.hasil.get(idGejala);
        boolean statusNow = now.setStatus();
        if(statusNow) count++;
        else count--;

        check();
    }


    @Override
    public void check() {
        if(count > 0) Log.d("klasifikasi" , "kena");
        else Log.d("klasifikasi" , "engga");
    }
}

class Diagnosis{
    private String namaGejala ;
    private boolean status;

    public Diagnosis(String namaGejala, boolean status) {
        this.namaGejala = namaGejala;
        this.status = status;
    }

    public String getNamaGejala() {
        return namaGejala;
    }

    public void setNamaGejala(String namaGejala) {
        this.namaGejala = namaGejala;
    }

    public boolean isStatus() {
        return status;
    }

    // toggle and return checkBox status
    public boolean setStatus() {
        this.status = !status;
        return this.status;
    }
}
