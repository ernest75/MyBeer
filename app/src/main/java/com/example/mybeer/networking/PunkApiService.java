package com.example.mybeer.networking;

import com.example.mybeer.networking.apimodels.BeerApi;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PunkApiService {

    @GET("beers")
    Observable<List<BeerApi>> getBeersForFood(@Query("food") String food);


}

