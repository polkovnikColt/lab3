package com.example.lab3.Async;

import android.os.AsyncTask;

import com.example.lab3.Dao.SettingsDao;
import com.example.lab3.Entities.Settings;

public class InsertAsyncTask extends AsyncTask<Settings, Void, Void> {

    private SettingsDao asyncDao;

    InsertAsyncTask(SettingsDao dao) {
        asyncDao = dao;
    }

    @Override
    protected Void doInBackground(Settings... settings) {
        asyncDao.insert(settings[0]);
        return null;
    }
}
