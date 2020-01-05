package com.example.sisteminformasimtbs.database;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.sisteminformasimtbs.view.pemeriksaan.PemeriksaanMain_Activity;
import com.example.sisteminformasimtbs.view.riwayat.RiwayatBalita_Activity;

public class LoadPemeriksaanDatabaseAsyncTask extends AsyncTask<Object , DatabaseHelper , DatabaseHelper> {

    private PemeriksaanMain_Activity activity;
    private ProgressDialog pd ;

    public LoadPemeriksaanDatabaseAsyncTask(PemeriksaanMain_Activity activity, ProgressDialog pd) {
        this.activity = activity;
        this.pd = pd;
    }



    @Override
    protected DatabaseHelper doInBackground(Object... objects) {
        DatabaseHelper db = new DatabaseHelper(activity.getApplicationContext());
        this.pd.dismiss();
        return db;
    }

    @Override
    protected void onPostExecute(DatabaseHelper databaseHelper) {
        super.onPostExecute(databaseHelper);
        this.activity.initiateProgram(databaseHelper);
    }
}
