package com.example.sisteminformasimtbs.database;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.sisteminformasimtbs.view.riwayat.RiwayatBalita_Activity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class LoadSaveDatabaseAsyncTask extends AsyncTask<Object ,DatabaseHelper ,DatabaseHelper> {
    private RiwayatBalita_Activity activity;
    private ProgressDialog pd ;




    public LoadSaveDatabaseAsyncTask(RiwayatBalita_Activity activity , ProgressDialog pd ) {
        this.activity = activity;
        this.pd = pd ;
    }

    @Override
    protected void onPostExecute(DatabaseHelper db) {
        super.onPostExecute(db);
        this.activity.initiateFragment(db);

    }

    @Override
    protected DatabaseHelper doInBackground(Object[] objects) {
        DatabaseHelper db = new DatabaseHelper(activity.getApplicationContext());

        this.pd.dismiss();
        return db;
    }

//

}
