package com.example.lab3.View;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lab3.Entities.Settings;
import com.example.lab3.Repoitories.SettingRepository;

import java.util.Map;

public class SettingsViewModel extends AndroidViewModel {

    private SettingRepository repository;
    private LiveData<Map<String, String>> data;

    public SettingsViewModel(@NonNull Application application) {
        super(application);
        repository = new SettingRepository(application);
        data = repository.getAllSettings();
    }

    public LiveData<Map<String, String>> getAllData() {
        return data;
    }

    public void insert(Settings settings) {
        repository.insetSetting(settings);
    }
}
