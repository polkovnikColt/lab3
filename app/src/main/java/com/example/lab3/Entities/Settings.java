package com.example.lab3.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "settings_table")
public class Settings {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @NonNull
    @ColumnInfo(name="key")
    private String key;
    @NonNull
    @ColumnInfo(name="value")
    private String value;

    public Settings(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }
}
