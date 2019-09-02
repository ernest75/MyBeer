package com.example.mybeer.roomDb.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.mybeer.constants.Utils;

@Entity(tableName = Utils.TABLE_BEER_WITH_FOOD)
public class BeerEntity {

    public BeerEntity(String beerName, String beerPicture, String tagline, String description, Double abv, String food) {
        this.beerName = beerName;
        this.beerPicture = beerPicture;
        this.tagline = tagline;
        this.description = description;
        this.abv = abv;
        this.food = food;
    }

    @ColumnInfo(name= Utils.BEER_ID)
    @PrimaryKey(autoGenerate =true)
    private long id;

    @ColumnInfo(name= Utils.BEER_NAME)
    private String beerName;

    @ColumnInfo(name= Utils.BEER_PICTURE)
    private String beerPicture;

    @ColumnInfo(name= Utils.BEER_TAGLINE)
    private String tagline;

    @ColumnInfo(name= Utils.BEER_DESCRIPTION)
    private String description;

    @ColumnInfo(name= Utils.BEER_ABV)
    private Double abv;

    @ColumnInfo(name= Utils.BEER_FOOD)
    private String food;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBeerPicture() {
        return beerPicture;
    }

    public void setBeerPicture(String beerPicture) {
        this.beerPicture = beerPicture;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
