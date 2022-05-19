package com.example.lab3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3.Entities.Settings;
import com.example.lab3.R;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.DatabaseViewHolder> {

    private List<Settings> list;
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

    public DatabaseAdapter (Context context) {
        this.lI = LayoutInflater.from(context);
    }

    public void setSettings(List<Settings> data) {
        list = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DatabaseAdapter.DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = lI.inflate(R.layout.database_item, parent, false);
       return new DatabaseViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseAdapter.DatabaseViewHolder holder, int position) {
        Settings s = list.get(position);
        holder.tv1.setText(s.getKey());
        holder.tv2.setText(s.getValue());
    }

    @Override
    public int getItemCount() {
        if(list != null){ return list.size();}
        return 0;
    }
}
