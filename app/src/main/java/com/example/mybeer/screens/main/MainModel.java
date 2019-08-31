package com.example.mybeer.screens.main;

import android.util.Log;

import com.example.mybeer.networking.PunkApiService;
import com.example.mybeer.networking.apimodels.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainModel implements MainMvp.Model {

    private PunkApiService mPunkApiService;

    private Call<List<Beer>> beerCall;

    private static final String TAG = MainModel.class.getSimpleName();


    public MainModel(PunkApiService punkApiService) {

        mPunkApiService = punkApiService;

    }

    @Override
    public void getBeersFromApi(String food) {

        beerCall = mPunkApiService.getBeersForFood(food);
        beerCall.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                Log.e(TAG,response.body().get(0).getName());
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
            }
        });



    }
}
