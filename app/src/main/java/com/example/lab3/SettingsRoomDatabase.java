package com.example.lab3;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase.Callback;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.lab3.Entities.Settings;
import com.example.lab3.Dao.SettingsDao;

import java.util.HashMap;
import java.util.Map;

@Database(entities = {Settings.class}, version = 1, exportSchema = false)
public abstract class SettingsRoomDatabase extends  RoomDatabase{

    public abstract SettingsDao settingsDao();

    public static SettingsRoomDatabase INSTANCE;

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private final SettingsDao dao;
        private Map<String,String> init;

        PopulateDbAsync(SettingsRoomDatabase db) {
            dao = db.settingsDao();
            init = new HashMap<String,String>() {{
                put("Key1", "Value1");
                put("Key2", "Value2");
            }};
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for ( Map.Entry<String,String> e : init.entrySet() ) {
                String key = e.getKey();
                String val = e.getValue();
                dao.inset(new Settings(key, val));
            }
            return null;
        }
    }

    public static SettingsRoomDatabase getDatabase (Context context) {
        if (INSTANCE == null) {
            synchronized (SettingsRoomDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(
                                    context.getApplicationContext(),
                                    SettingsRoomDatabase.class,
                                    "settings_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(setRoomDatabase)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback setRoomDatabase = new Callback() {
        @Override
        public void onOpen(SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        };
    };

}
