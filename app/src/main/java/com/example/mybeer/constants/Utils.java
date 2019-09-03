package com.example.mybeer.constants;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {

    public static final String BASE_URL_PUNK_API = "https://api.punkapi.com/v2/";


    public static final String TABLE_BEER_WITH_FOOD = "beerTable";
    public static final String BEER_ID = "id";
    public static final String BEER_NAME = "name";
    public static final String BEER_PICTURE = "picture";
    public static final String BEER_TAGLINE = "tagline";
    public static final String BEER_DESCRIPTION = "description";
    public static final String BEER_ABV = "abv";
    public static final String BEER_FOOD = "food";


    public static final String DB_BEERS = "beersDb";

    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                view.getWindowToken(), 0);
    }
}
