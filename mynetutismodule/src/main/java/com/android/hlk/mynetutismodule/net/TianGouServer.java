package com.android.hlk.mynetutismodule.net;

import com.android.hlk.mynetutismodule.bean.TianGouInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 2017/3/22.
 */

public interface TianGouServer {
    @GET("/list")
    Call<TianGouInfo> getTianGouData();
}
