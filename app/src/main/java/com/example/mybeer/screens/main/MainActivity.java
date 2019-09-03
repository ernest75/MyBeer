package com.example.mybeer.screens.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mybeer.R;
import com.example.mybeer.adapters.BeersAdapter;
import com.example.mybeer.constants.Utils;
import com.example.mybeer.dagger.App;
import com.example.mybeer.models.BeerModel;
import com.example.mybeer.networking.apimodels.BeerApi;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements MainMvp.View {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.etFood)
    EditText mEtFood;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.btnReverse)
    Button mBtnReverse;
    @BindView(R.id.btnFind)
    Button mBtnFind;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    private Call<List<BeerApi>> beerCall;

    @Inject
    Context mContext;

    @Inject
    MainMvp.Presenter mMainPresenter;

    BeersAdapter mBeersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App) getApplication()).getApplicationComponent().inject(this);
        mMainPresenter.setView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.clearRxStreams();
        mMainPresenter.setView(null);
    }

    @OnClick(R.id.btnFind)
    public void onClick() {
        String food = mEtFood.getText().toString();
        if (food.isEmpty()) {
            Toast.makeText(mContext, "Type a food please", Toast.LENGTH_SHORT).show();
        } else {
            mRecyclerView.setAdapter(null);
            mMainPresenter.onBeersForFoodAsked(food);
            mEtFood.clearFocus();
            Utils.hideSoftKeyboard(mContext, mEtFood);
        }
    }

    @Override
    public void showProgressbar() {

        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressbar() {

        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String error) {
        Toast.makeText(mContext, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showBeers(List<BeerModel> beerModels) {
        mBeersAdapter = new BeersAdapter(beerModels, mContext);
        mRecyclerView.setAdapter(mBeersAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @OnClick(R.id.btnReverse)
    public void onClickButtonReverse() {
        mMainPresenter.reverseBeersOrder(mBeersAdapter.getBeerModelList());
    }


}
