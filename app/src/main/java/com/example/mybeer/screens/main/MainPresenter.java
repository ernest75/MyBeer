package com.example.mybeer.screens.main;

import android.content.Context;
import android.util.Log;

import com.example.mybeer.R;
import com.example.mybeer.models.BeerModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainMvp.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private Context mContext;
    private  MainMvp.Model mMainModel;
    private MainMvp.View mMainView;

    List<BeerModel> mBeerModelList= new ArrayList<>();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainPresenter(Context context, MainMvp.Model mainModel) {
        mContext = context;
        mMainModel = mainModel;
    }

    @Override
    public void setView(MainMvp.View mainView) {
        mMainView = mainView;
    }

    @Override
    public void onBeersForFoodAsked(final String food) {

        compositeDisposable.add(mMainModel.getBeersForFoodFromDb(food)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<BeerModel>>() {
                    @Override
                    public void onNext(List<BeerModel> beerModels) {
                        // mBeerModelList = beerModels;
                        if (beerModels.isEmpty()){
                            Log.e(TAG,"BEERMDEL LIST IS EMPTY");
                            //go to the net
                            compositeDisposable.add(mMainModel.getBeersFromNetwork(food)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeWith(new DisposableObserver<List<BeerModel>>() {
                                        @Override
                                        public void onNext(List<BeerModel> beerModels) {
                                           // mBeerModelList = beerModels;
                                            if (beerModels.isEmpty()){
                                                mMainView.showError(mContext.getString(R.string.no_beers));
                                            }else{
                                                mMainModel.insertToDb(beerModels,food);
                                            }
                                            Log.e(TAG,mBeerModelList.size() + "");
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            mMainView.showError(e.getMessage());
                                        }

                                        @Override
                                        public void onComplete() {

                                        }
                                    }));
                        }else {
                            mMainView.showBeers(beerModels);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));


        }


    }

