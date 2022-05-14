package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lab3.Adapters.DatabaseAdapter;

import java.util.HashMap;
import java.util.Map;

public class FirstActivity extends AppCompatActivity {
    private RecyclerView container;
    private DatabaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i <= 10; i++) {
            map.put("Key" + i, "Value" + i);
        }

        container = findViewById(R.id.recycler_view);
        adapter = new DatabaseAdapter(this, (HashMap<String, String>) map);
        container.setAdapter(adapter);
        container.setLayoutManager(new LinearLayoutManager(this));
    }
}