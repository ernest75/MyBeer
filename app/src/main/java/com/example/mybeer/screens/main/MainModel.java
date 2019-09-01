package com.example.mybeer.screens.main;

import com.example.mybeer.models.BeerModel;
import com.example.mybeer.networking.PunkApiService;
import com.example.mybeer.networking.apimodels.BeerApi;
import com.example.mybeer.repository.BeersRepo;
import com.example.mybeer.roomDb.entities.BeerEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.Call;


public class MainModel implements MainMvp.Model {

    private PunkApiService mPunkApiService;

    private Call<List<BeerApi>> beerCall;

    private static final String TAG = MainModel.class.getSimpleName();

    private BeersRepo mBeersRepo;

    public MainModel(PunkApiService mPunkApiService, BeersRepo mBeersRepo) {
        this.mPunkApiService = mPunkApiService;
        this.mBeersRepo = mBeersRepo;
    }




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

    @Override
    public Observable<List<BeerModel>> getBeersForFoodFromDb(String food) {
        return mBeersRepo.getBeersFromDb(food).concatMap(new Function<List<BeerEntity>, Observable<List<BeerModel>>>() {
            @Override
            public Observable<List<BeerModel>> apply(List<BeerEntity> beerEntityList) throws Exception {
                return Observable.fromArray(convertBeerEntityListToBeerModelList(beerEntityList));
            }
        });
    }

    @Override
    public void insertToDb(List<BeerModel> beerModels, String food) {
        mBeersRepo.insertToDb(convertBeerModelToBeerEntity(beerModels, food));
    }

    private List<BeerEntity> convertBeerModelToBeerEntity(List<BeerModel> beerModels, String food) {
        List<BeerEntity> beerEntities = new ArrayList<>();
        for (BeerModel beerModel:beerModels) {
            BeerEntity beerEntity = new BeerEntity(beerModel.getName(),beerModel.getPictureUrl(),
                    beerModel.getTagline(),beerModel.getDescription(),beerModel.getAbv(),food);
            beerEntities.add(beerEntity);

        }
        return beerEntities;
    }

    private List<BeerModel> convertApiBeerListToBeerModelList(List<BeerApi> beerApis) {
        List<BeerModel> beerModels = new ArrayList<>();
        for (BeerApi beerApi: beerApis) {
            BeerModel beerModel = new BeerModel();
            beerModel.setName(beerApi.getName());
            beerModel.setAbv(beerApi.getAbv());
            beerModel.setDescription(beerApi.getDescription());
            beerModel.setPictureUrl(beerApi.getImageUrl());
            beerModel.setTagline(beerApi.getTagline());
            beerModels.add(beerModel);
        }

        return beerModels;
    }

    //String name, String pictureUrl, String tagline, String description, Double abv

    private List<BeerModel> convertBeerEntityListToBeerModelList(List<BeerEntity> beerEntityList) {
        List<BeerModel> beerModelList = new ArrayList<>();
        for (BeerEntity beerEntity : beerEntityList) {
            BeerModel beerModel = new BeerModel(beerEntity.getBeerName(), beerEntity.getBeerPicture(),
                    beerEntity.getTagline(), beerEntity.getDescription(), beerEntity.getAbv());
            beerModelList.add(beerModel);
        }

        return beerModelList;
    }




}
