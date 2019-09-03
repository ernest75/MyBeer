package com.example.mybeer.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.mybeer.constants.Utils;
import com.example.mybeer.networking.PunkApiService;
import com.example.mybeer.repository.BeersRepo;
import com.example.mybeer.roomDb.BeerDAO;
import com.example.mybeer.roomDb.BeersDB;
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
        return new MainPresenter(provideContext(),provideModel(punkApiService,provideBeeerDao(provideBeersDatabase(provideContext()))));
    }

    @Provides
    MainMvp.Model provideModel(PunkApiService punkApiService, BeerDAO beerDAO){
        return new MainModel(punkApiService,new BeersRepo(beerDAO));
    }

    @Singleton
    @Provides
    public BeersDB provideBeersDatabase(Context context){
        return Room.databaseBuilder(context,BeersDB.class, Utils.DB_BEERS).build();
    }

    @Singleton
    @Provides
    public BeerDAO provideBeeerDao(BeersDB beersDB) {
        return beersDB.getBeerDAO();
    }
}
