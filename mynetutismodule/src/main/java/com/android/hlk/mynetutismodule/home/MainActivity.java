package com.android.hlk.mynetutismodule.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.hlk.mynetutismodule.R;
import com.android.hlk.mynetutismodule.bean.GankApiRandomInfo;
import com.android.hlk.mynetutismodule.bean.MovieEntity;
import com.android.hlk.mynetutismodule.net.GankServer;
import com.android.hlk.mynetutismodule.net.MovieServer;
import com.android.hlk.mynetutismodule.net.ServiceGenerator;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private TextView title;
    private Object gankData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View button = findViewById(R.id.button);
        title = (TextView) findViewById(R.id.title);
        progress = (ProgressBar) findViewById(R.id.progress);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getMoverData();
                getGankData();

            }
        });
    }

    private void getMoverData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.createAsync())
//                .build();

        MovieServer movieServer = ServiceGenerator.createServier(MovieServer.class);
//                Observable<MovieEntity> moveTop =
        movieServer.getMoveTop(0, 10)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        progress.setVisibility(View.VISIBLE);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<MovieEntity, Observable<MovieEntity>>() {
                    @Override
                    public Observable<MovieEntity> call(MovieEntity movieEntity) {
                        return null;
                    }
                })
                .subscribe(new Subscriber<MovieEntity>() {
                    @Override
                    public void onCompleted() {
                        progress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        progress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(MovieEntity movieEntity) {
                        progress.setVisibility(View.GONE);
                        title.setText(movieEntity.getTitle());
                    }
                });
    }

    public void getGankData() {

        OkHttpClient.Builder okhttp = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://gank.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Retrofit retrofit = builder.client(okhttp.build()).build();
        GankServer gankServer = retrofit.create(GankServer.class);
        Call<GankApiRandomInfo> call = gankServer.getRandomData("Android","50");
        call.enqueue(new Callback<GankApiRandomInfo>() {
            @Override
            public void onResponse(Call<GankApiRandomInfo> call, Response<GankApiRandomInfo> response) {
                GankApiRandomInfo body = response.body();
                String s = response.toString();

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < body.getResults().size(); i++) {
                    sb.append(body.getResults().get(i).getDesc()+"\n");
                }
                title.setText(s+"\n"+sb.toString());
            }

            @Override
            public void onFailure(Call<GankApiRandomInfo> call, Throwable throwable) {
                title.setText("error"+throwable.getMessage());
                Log.e("error",throwable.getMessage());
            }
        });


    }
}
