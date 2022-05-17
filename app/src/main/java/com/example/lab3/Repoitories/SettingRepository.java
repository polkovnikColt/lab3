package com.example.lab3.Repoitories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.lab3.Dao.SettingsDao;
import com.example.lab3.Entities.Settings;
import com.example.lab3.SettingsRoomDatabase;

import java.util.Map;

public class SettingRepository {
    private SettingsDao settingsDao;
    private LiveData<Map<String,String>> allSettings;

    private class InsertAsyncTask extends AsyncTask<Settings, Void, Void> {

        private SettingsDao asyncDao;

        public InsertAsyncTask(SettingsDao dao) {
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(Settings... settings) {
            asyncDao.inset(settings[0]);
            return null;
        }
    }

    public SettingRepository(Application app) {
        SettingsRoomDatabase db = SettingsRoomDatabase.getDatabase(app);
        settingsDao = db.settingsDao();
        allSettings = settingsDao.getAll();
    }

    public LiveData<Map<String, String>> getAllSettings() {
        return allSettings;
    }

   public void insetSetting(Settings settings) {
        new InsertAsyncTask(settingsDao).execute(settings);
   }
}
