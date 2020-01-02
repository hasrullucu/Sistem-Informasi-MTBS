package com.example.sisteminformasimtbs.database;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

public class SerializedSQLiteDatabase implements Serializable {
    private SQLiteDatabase mDefaultWritableDatabase ;

    public SerializedSQLiteDatabase(SQLiteDatabase mDefaultWritableDatabase){
        this.mDefaultWritableDatabase =mDefaultWritableDatabase;
    }

    public SQLiteDatabase getmDefaultWritableDatabase() {
        return mDefaultWritableDatabase;
    }

    public void setmDefaultWritableDatabase(SQLiteDatabase mDefaultWritableDatabase) {
        this.mDefaultWritableDatabase = mDefaultWritableDatabase;
    }
}
