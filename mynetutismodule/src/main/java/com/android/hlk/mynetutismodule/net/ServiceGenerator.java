package com.android.hlk.mynetutismodule.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017/3/22.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "http://gank.io/api/";

    private static OkHttpClient.Builder okhttpClinet = new OkHttpClient.Builder();

    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createServier(Class<S> className) {

        return retrofit.create(className);
    }

}
