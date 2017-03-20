package com.android.hlk.mynetutismodule.net;

import com.android.hlk.mynetutismodule.bean.MovieEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by user on 2017/3/20.
 */

public interface MovieServer {
    @GET("top250")
    Observable<MovieEntity> getMoveTop(@Query("start") int start, @Query("count") int count);
}
