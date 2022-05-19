package com.example.lab3.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lab3.Entities.Settings;

import java.util.List;
import java.util.Map;

@Dao
public interface SettingsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Settings setting);

    @Query("DELETE FROM settings_table")
    void deleteAll();

    @Query("SELECT * FROM settings_table")
    LiveData<List<Settings>> getAll();

    @Query("SELECT * FROM settings_table LIMIT 1")
    Settings[] getAny();
}
