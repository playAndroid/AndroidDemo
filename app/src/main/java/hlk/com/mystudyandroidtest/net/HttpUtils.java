package hlk.com.mystudyandroidtest.net;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import hlk.com.mystudyandroidtest.base.MyApplication;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * http api utils
 * Created by user on 2017/2/21.
 */

public class HttpUtils {

    private Context mContext = MyApplication.getContext();

    public void setCaChe() {

        OkHttpClient okHttpClient = new OkHttpClient();
        File cacheDir = mContext.getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024;
        //TODO 未完待续 设置缓存
        okHttpClient.connectTimeoutMillis();
    }

    public void setTime() {
        //TODO 设置超时时间
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.readTimeoutMillis();
    }

    public static void getHttp() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.method("GET", null);
        builder.url("http://www.baidu.com");
        Request build = builder.build();

        Call call = okHttpClient.newCall(build);
        Response response = call.execute();
        if (response.isSuccessful()) {
            String str = response.body().toString();
            Log.d("http", "请求成功" + str);
        } else {
            //请求失败
            Log.d("http", "请求失败");
        }

    }

    public static void getAsyHttp() {
        //创建okhttpclient
        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder();

        builder.url("http://www.baidu.com");

        builder.method("GET", null);

        Request request = builder.build();

        Call call = okHttpClient.newCall(request);
        //加入队列
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    //如果有缓存 从缓存中取数据
                    String str = response.cacheResponse().toString();
                    Log.d("http", "请求成功,缓存" + str);
                    System.out.print("请求成功,缓存123" + str);
                } else {
                    String str = response.body().toString();
                    Log.d("http", "请求成功,未缓存" + str);
                    System.out.print("请求成功,未缓存123" + str);
                }

                //TODO UI 线程 请求成功回调

            }
        });
    }

    public static void postAsyHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody.Builder formBody = new FormBody.Builder();

        formBody.add("user", "name").add("password", "123456");

        FormBody formBuild = formBody.build();

        Request.Builder builder = new Request.Builder();

//        builder.cacheControl(CacheControl.FORCE_CACHE);  表示一直从网络请求数据,不走缓存

        builder.post(formBuild);

        Call call = okHttpClient.newCall(builder.build());

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("http", "IOException" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().toString();
                Log.d("http", "s" + s);
            }
        });
    }

    public void cancleHttp() {
        //定时线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        OkHttpClient okHttpClient = new OkHttpClient();

        Request build = new Request.Builder().url("http://www.baidu.com").build();

        Call call = okHttpClient.newCall(build);
        final Call finalCall = call;
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                finalCall.cancel();
            }
        }, 100, TimeUnit.MILLISECONDS);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String s = response.body().string();

                } catch (IOException e) {
                    Log.d("http", "IOException");
                }
            }
        });
    }
}
