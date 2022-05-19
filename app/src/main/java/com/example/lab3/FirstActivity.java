package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lab3.Adapters.DatabaseAdapter;
import com.example.lab3.Entities.Settings;
import com.example.lab3.View.SettingsViewModel;

import java.util.List;



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

        Context context = FirstActivity.this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.shared), Context.MODE_PRIVATE);

        model = new ViewModelProvider(this).get(SettingsViewModel.class);
        model.getAllData().observe(this, new Observer<List<Settings>>() {

            @Override
            public void onChanged(List<Settings> stringStringMap) {
                adapter.setSettings(stringStringMap);
            }
        });
    }

    public void setNewSetting(View view) {
        EditText key =  findViewById(R.id.keySetting);
        EditText value = findViewById(R.id.valueSetting);
        Settings s = new Settings(key.getText().toString(), key.getText().toString(), value.getText().toString());
        model.insert(s);
        key.setText("");
        value.setText("");
    }

    public void deleteAll(View view) {
        model.deleteAll();
    }
}