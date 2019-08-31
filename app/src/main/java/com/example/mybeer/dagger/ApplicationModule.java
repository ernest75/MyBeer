package com.example.mybeer.dagger;

import android.app.Application;
import android.content.Context;

import com.example.mybeer.networking.PunkApiService;
import com.example.mybeer.screens.main.MainModel;
import com.example.mybeer.screens.main.MainMvp;
import com.example.mybeer.screens.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mApplication;
    }

    @Provides
    MainMvp.Presenter provideMainPresenter(PunkApiService punkApiService){
        return new MainPresenter(provideContext(),provideModel(punkApiService));
    }

    @Provides
    MainMvp.Model provideModel(PunkApiService punkApiService){
        return new MainModel(punkApiService);
    }
}
