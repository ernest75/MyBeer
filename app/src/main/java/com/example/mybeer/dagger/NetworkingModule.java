package com.example.mybeer.dagger;

import com.example.mybeer.networking.PunkApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mybeer.constants.Constants.BASE_URL_PUNK_API;

@Module
public class NetworkingModule {

    @Provides
    Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    PunkApiService getPunkApiService(){
        return getRetrofit(BASE_URL_PUNK_API).create(PunkApiService.class);
    }
}
