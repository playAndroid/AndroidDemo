package hlk.com.mystudyandroidtest.net.retrofittest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import hlk.com.mystudyandroidtest.bean.MoveEntity;
import hlk.com.mystudyandroidtest.bean.Subjects;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by user on 2017/2/27.
 */

public class HttpMeathod<T> {
    private static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIMEOUT = 5;
    private final Retrofit retrofit;
    private final MoveServer moveServer;


    private HttpMeathod() {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);


        retrofit = new Retrofit.Builder().client(okBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL).build();

        moveServer = retrofit.create(MoveServer.class);
    }


    private static class SingleHolder {
        private static final HttpMeathod instance = new HttpMeathod();
    }

    public static HttpMeathod getInstance() {
        return SingleHolder.instance;
    }


    public void getMoveTop(Subscriber<MoveEntity> subscriber, int start, int count) {
        moveServer.getTopMove(start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

//    public void getObject(Subscriber subscriber, int start, int count) {
//        moveServer.getTop(start, count)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//    }


    private class HttpResultFunc implements Func1<HttpResult<T>, T> {


        @Override
        public T call(HttpResult<T> tHttpResult) {
            if (tHttpResult.getCount() == 0) {
                throw new RuntimeException();
            }
            return tHttpResult.getData();
        }
    }


    public void getMoveTop2(Subscriber<List<Subjects>> subscriber, int start, int count) {
//        moveServer.getTopMove(start, count).map(new HttpResultFunc<List<Subjects>>)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//        moveServer.getTopMove(start, count)
//                .map(new HttpResultFunc<List<Subjects>>())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
    }
}
