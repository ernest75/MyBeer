package com.example.mybeer.screens.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mybeer.R;
import com.example.mybeer.dagger.App;
import com.example.mybeer.networking.PunkApiService;
import com.example.mybeer.networking.apimodels.Beer;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Call<List<Beer>> beerCall;

    @Inject
    PunkApiService mPunkApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getApplicationComponent().inject(this);

        beerCall = mPunkApiService.getBeersForFood("all");

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
