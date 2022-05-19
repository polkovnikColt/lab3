package com.example.lab3.Async;

import android.os.AsyncTask;

import com.example.lab3.Dao.SettingsDao;
import com.example.lab3.SettingsRoomDatabase;

public class DeleteAsyncTask extends AsyncTask<Void,Void,Void> {
    private final SettingsDao dao;

    public DeleteAsyncTask(SettingsDao daoD) {
        dao = daoD;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.deleteAll();
        return null;
    }
}