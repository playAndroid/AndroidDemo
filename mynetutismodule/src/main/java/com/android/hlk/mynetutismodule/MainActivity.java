package com.android.hlk.mynetutismodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.hlk.mynetutismodule.bean.MovieEntity;
import com.android.hlk.mynetutismodule.net.Api;
import com.android.hlk.mynetutismodule.net.MovieServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
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
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.DOUBAN_TOP_100)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.createAsync())
                        .build();

                MovieServer movieServer = retrofit.create(MovieServer.class);
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
        });
    }
}
