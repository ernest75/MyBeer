package com.example.mybeer.screens.main;

import android.content.Context;

public class MainPresenter implements MainMvp.Presenter {

    private Context mContext;
    private  MainMvp.Model mMainModel;
    private MainMvp.View mMainView;

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

        mMainModel.getBeersFromApi(food);

    }
}
