package com.android.hlk.mynetutismodule.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017/3/22.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "http://gank.io/";

    private static OkHttpClient.Builder okhttpClinet = new OkHttpClient.Builder();

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();


    public static <S> S createServier(Class<S> className) {
        if (!okhttpClinet.interceptors().contains(logging)) {
            okhttpClinet.addInterceptor(logging);
            builder.client(okhttpClinet.build());
            retrofit = builder.build();
        }

        return retrofit.create(className);
    }

}
