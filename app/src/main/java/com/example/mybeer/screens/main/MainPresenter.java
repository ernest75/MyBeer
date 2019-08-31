package com.example.mybeer.screens.main;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import com.example.mybeer.models.BeerModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainMvp.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private Context mContext;
    private  MainMvp.Model mMainModel;
    private MainMvp.View mMainView;

    List<BeerModel> mBeerModelList= new ArrayList<>();

    public Disposable mSubscription = null;

    public MainPresenter(Context context, MainMvp.Model mainModel) {
        mContext = context;
        mMainModel = mainModel;
    }

    @Override
    public void setView(MainMvp.View mainView) {
        mMainView = mainView;
    }

    @Override
    public void onBeersForFoodAsked(String food) {

        mSubscription = mMainModel.getBeersFromNetwork(food)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<BeerModel>>() {
                    @Override
                    public void onNext(List<BeerModel> beerModels) {
                        mBeerModelList = beerModels;
                        Log.e(TAG,mBeerModelList.size() + "");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mMainView.showBeers(mBeerModelList);
                    }
                });

        }

    }

