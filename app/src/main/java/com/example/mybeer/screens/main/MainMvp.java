package com.example.mybeer.screens.main;

import com.example.mybeer.models.BeerModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface MainMvp {

    interface Model {

        Observable<List<BeerModel>> getBeersFromNetwork(String food);

        Observable<List<BeerModel>> getBeersForFoodFromDb(String food);

        void insertToDb(List<BeerModel> beerModels, String food);
    }

    interface Presenter {

        void setView(MainMvp.View view);

        void onBeersForFoodAsked(String food);

        void reverseBeersOrder(List<BeerModel> beerModelList);
    }

    interface View {

        void showProgressbar();

        void hideProgressbar();

        void showError(String error);

        void showBeers(List<BeerModel> beerModels);


    }
}
