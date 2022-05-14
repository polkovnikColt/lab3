package com.example.lab3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3.R;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.DatabaseViewHolder> {

    private Map<String, String> list;
    private LayoutInflater lI;

    class DatabaseViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv1;
        private final TextView tv2;
        final DatabaseAdapter databaseAdapter;

        public DatabaseViewHolder(@NonNull View itemView, DatabaseAdapter databaseAdapter) {
            super(itemView);
            this.tv1 = itemView.findViewById(R.id.key);
            this.tv2 = itemView.findViewById(R.id.value);
            this.databaseAdapter = databaseAdapter;
        }
    }

    public DatabaseAdapter (Context context, HashMap<String, String> data) {
        this.list = data;
        this.lI = LayoutInflater.from(context);
    }

    private String getKeyByValue(Map<String, String> map, String value) {
        Collection<String> collection = map.keySet();
        for (String key: collection) {
            String temp = map.get(key);
            if(temp.equals(value)) {
                return key;
            }
        }
        return null;
    }

    @NonNull
    @Override
    public DatabaseAdapter.DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = lI.inflate(R.layout.database_item, parent, false);
       return new DatabaseViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseAdapter.DatabaseViewHolder holder, int position) {
        String value = list.get("Key" + position);
        String key = this.getKeyByValue(list, value);
        holder.tv1.setText(key);
        holder.tv2.setText(value);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
