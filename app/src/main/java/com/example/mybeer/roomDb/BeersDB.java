package com.example.mybeer.roomDb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mybeer.roomDb.entities.BeerEntity;

@Database(entities = {BeerEntity.class},version = 1, exportSchema = false)
public abstract class BeersDB extends RoomDatabase {

    public abstract BeerDAO getBeerDAO();
}
