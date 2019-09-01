package com.example.mybeer.models;

import android.support.annotation.NonNull;

public class BeerModel implements Comparable<BeerModel> {

    public BeerModel() {
    }

    public BeerModel(String name, String pictureUrl, String tagline, String description, Double abv) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.tagline = tagline;
        this.description = description;
        this.abv = abv;
    }

    public String name;

    public String pictureUrl;

    public String tagline;

    public String description;

    public Double abv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    @Override
    public int compareTo(@NonNull BeerModel beerModel) {
        return (this.abv < beerModel.getAbv() ? -1 :
                (this.abv.equals(beerModel.getAbv()) ? 0 : 1));
    }
}
