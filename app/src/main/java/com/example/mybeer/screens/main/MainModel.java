package com.example.mybeer.screens.main;

import com.example.mybeer.models.BeerModel;
import com.example.mybeer.networking.PunkApiService;
import com.example.mybeer.networking.apimodels.BeerApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Call;


public class MainModel implements MainMvp.Model {

    private PunkApiService mPunkApiService;

    private Call<List<BeerApi>> beerCall;

    private static final String TAG = MainModel.class.getSimpleName();


    public MainModel(PunkApiService punkApiService) {

        mPunkApiService = punkApiService;

    }

//    @Override
//    public void getBeersFromApi(String food) {
//
//        final List<BeerModel> beerModels = new ArrayList<>();
//
//        beerCall = mPunkApiService.getBeersForFood(food);
//        beerCall.enqueue(new Callback<List<BeerApi>>() {
//            @Override
//            public void onResponse(Call<List<BeerApi>> call, Response<List<BeerApi>> response) {
//                 Log.e(TAG,response.body().get(0).getName());
//
//            }
//
//            @Override
//            public void onFailure(Call<List<BeerApi>> call, Throwable t) {
//                Log.e(TAG,t.getMessage());
//            }
//        });
//
//    }

    @Override
    public Observable<List<BeerModel>> getBeersFromNetwork(String food) {
        Observable<List<BeerApi>> beerApiObservable = mPunkApiService.getBeersForFood(food);

        Observable<List<BeerModel>> beerModelFromNetwork = beerApiObservable.map(new Function<List<BeerApi>, List<BeerModel>>() {
            @Override
            public List<BeerModel> apply(List<BeerApi> beerApis) throws Exception {
                return convertApiBeerListToBeerModelList(beerApis);
            }
        });
        return beerModelFromNetwork;

    }

    private List<BeerModel> convertApiBeerListToBeerModelList(List<BeerApi> beerApis) {
        List<BeerModel> beerModels = new ArrayList<>();
        for (BeerApi beerApi: beerApis) {
            BeerModel beerModel = new BeerModel();
            beerModel.setName(beerApi.getName());
            beerModel.setAbv(beerApi.getAbv());
            beerModel.setDescription(beerApi.getDescription());
            //todo ojo al canviar Obkect peer string BeerApi
            beerModel.setPictureUrl(beerApi.getImageUrl());
            beerModel.setTagline(beerApi.getTagline());
            beerModels.add(beerModel);
        }

        return beerModels;
    }


}
