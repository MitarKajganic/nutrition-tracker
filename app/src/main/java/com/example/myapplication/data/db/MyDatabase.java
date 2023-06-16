package com.example.myapplication.data.db;

import androidx.room.Database;

import com.example.myapplication.data.datasources.UserDao;
import com.example.myapplication.data.models.entities.UserEntity;

@Database(
        entities = {UserEntity.class},
        version = 1,
        exportSchema = false)
public abstract class MyDatabase {
    public abstract UserDao getUserDao();
}
