package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.InvalidationTracker;

import android.os.Bundle;

import com.example.lab3.Adapters.DatabaseAdapter;
import com.example.lab3.View.SettingsViewModel;

import java.util.HashMap;
import java.util.Map;


public class FirstActivity extends AppCompatActivity {
    private RecyclerView container;
    private DatabaseAdapter adapter;
    private SettingsViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.recycler_view);
        adapter = new DatabaseAdapter(this);
        container.setAdapter(adapter);
        container.setLayoutManager(new LinearLayoutManager(this));

        model = new ViewModelProvider(this).get(SettingsViewModel.class);
        model.getAllData().observe(this, new Observer<Map<String,String>>() {

            @Override
            public void onChanged(Map<String, String> stringStringMap) {
                adapter.setSettings(stringStringMap);
            }
        });
    }
}