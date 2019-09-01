package com.example.mybeer.repository;

import android.util.Log;

import com.example.mybeer.models.BeerModel;
import com.example.mybeer.networking.PunkApiService;
import com.example.mybeer.roomDb.BeerDAO;
import com.example.mybeer.roomDb.entities.BeerEntity;

import java.util.List;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class BeersRepo {

    private static final String TAG = BeersRepo.class.getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private PunkApiService mPunkApiService;
    private BeerDAO mBeerDAO;


    @Inject
    public BeersRepo(PunkApiService mPunkApiService, BeerDAO mBeerDAO) {
        this.mPunkApiService = mPunkApiService;
        this.mBeerDAO = mBeerDAO;
    }

    //db related
    public void insertToDb(final List<BeerEntity> beerEntityList) {
        compositeDisposable.add(Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mBeerDAO.insertBeersWithFood(beerEntityList);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Log.e(TAG, "SUCCESFULLY INSERTED");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }
                }));

    }

    public Observable<List<BeerEntity>> getBeersFromDb(String food) {
         return Observable.fromPublisher(mBeerDAO.getBeersForFood(food));

    }
}
