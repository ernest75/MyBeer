package com.example.mybeer.networking;

import com.example.mybeer.networking.apimodels.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PunkApiService {

    //https://api.punkapi.com/v2/beers?food=all

    @GET("beers")
    Call<List<Beer>> getBeersForFood(@Query("food") String food);


}

