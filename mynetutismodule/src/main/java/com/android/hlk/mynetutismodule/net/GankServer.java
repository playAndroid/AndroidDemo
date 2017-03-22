package com.android.hlk.mynetutismodule.net;

import com.android.hlk.mynetutismodule.bean.GankApiRandomInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 2017/3/22.
 */

public interface GankServer {
    @GET("/api/random/data/{client}/{count}")
    Call<GankApiRandomInfo> getRandomData(@Path("client") String client, @Path("count") String count);
}
