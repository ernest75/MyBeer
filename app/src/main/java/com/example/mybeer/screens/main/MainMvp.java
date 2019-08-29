package com.example.mybeer.screens.main;

import android.content.Intent;

import java.util.List;

import io.reactivex.Observable;

public interface MainMvp {

    interface Model {


    }

    interface Presenter {

        void setView(MainMvp.View view);

        void loadData();

        void rxJavaUnsubscribe();


    }

    interface View {

        }
}
