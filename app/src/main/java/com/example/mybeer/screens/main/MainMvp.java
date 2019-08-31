package com.example.mybeer.screens.main;

import com.example.mybeer.models.BeerModel;

import java.util.List;

import io.reactivex.Observable;

public interface MainMvp {

    interface Model {
        Observable<List<BeerModel>> getBeersFromNetwork(String food);
    }

    interface Presenter {

        void setView(MainMvp.View view);

        void onBeersForFoodAsked(String food);

    }

    interface View {

        void onBeersForFoodRetrived();

        void showError(String error);

        void showBeers(List<BeerModel> beerModels);


    }
}
