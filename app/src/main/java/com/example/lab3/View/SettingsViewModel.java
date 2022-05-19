package com.example.lab3.View;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lab3.Entities.Settings;
import com.example.lab3.Repoitories.SettingRepository;

import java.util.List;
import java.util.Map;

public class SettingsViewModel extends AndroidViewModel {

    private SettingRepository repository;
    private LiveData<List<Settings>> data;

    public SettingsViewModel(@NonNull Application application) {
        super(application);
        repository = new SettingRepository(application);
        data = repository.getAllSettings();
    }

    public LiveData<List<Settings>> getAllData() {
        return data;
    }

    public void insert(Settings settings) {
        repository.insetSetting(settings);
    }

    public void deleteAll() {repository.deleteAll();}
}
