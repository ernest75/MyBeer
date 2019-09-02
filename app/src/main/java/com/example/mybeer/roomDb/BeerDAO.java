package com.example.mybeer.roomDb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.mybeer.constants.Utils;
import com.example.mybeer.roomDb.entities.BeerEntity;

import java.util.List;


import io.reactivex.Flowable;

@Dao
public interface BeerDAO {

    @Insert
    void insertBeersWithFood(List<BeerEntity> beerEntityList);

    @Query("SELECT * FROM " + Utils.TABLE_BEER_WITH_FOOD + " WHERE " + Utils.BEER_FOOD + " LIKE :food")
    Flowable<List<BeerEntity>> getBeersForFood(String food);
}
