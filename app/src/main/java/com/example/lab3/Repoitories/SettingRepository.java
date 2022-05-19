package com.example.lab3.Repoitories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.lab3.Async.DeleteAsyncTask;
import com.example.lab3.Dao.SettingsDao;
import com.example.lab3.Entities.Settings;
import com.example.lab3.SettingsRoomDatabase;

import java.util.List;

public class SettingRepository {
    private SettingsDao settingsDao;
    private LiveData<List<Settings>> allSettings;

    private class InsertAsyncTask extends AsyncTask<Settings, String, String> {

        private SettingsDao asyncDao;

        public InsertAsyncTask(SettingsDao dao) {
            asyncDao = dao;
        }

        @Override
        protected String doInBackground(Settings... settings) {
            asyncDao.insert(settings[0]);
            return "Success";
        }
    }

    public SettingRepository(Application app) {
        SettingsRoomDatabase db = SettingsRoomDatabase.getDatabase(app);
        settingsDao = db.settingsDao();
        allSettings = settingsDao.getAll();
    }

    public LiveData<List<Settings>> getAllSettings() {
        return allSettings;
    }

    public void deleteAll() {
        new DeleteAsyncTask(settingsDao).execute();
    }

   public void insetSetting(Settings settings) {
        new InsertAsyncTask(settingsDao).execute(settings);
   }
}
