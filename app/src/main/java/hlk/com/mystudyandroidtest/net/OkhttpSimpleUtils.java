package hlk.com.mystudyandroidtest.net;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp 简易封装
 * Created by user on 2017/2/22.
 */

public class OkhttpSimpleUtils {

    private OkHttpClient okHttpClient;

    private static OkhttpSimpleUtils mInstance;

    private Handler mHandler;

    private OkhttpSimpleUtils() {
        okHttpClient = new OkHttpClient();
        //TODO 设置初始化参数


        mHandler = new Handler();
    }

    public static OkhttpSimpleUtils getInstance() {
        if (mInstance == null) {
            synchronized (OkhttpSimpleUtils.class) {
                if (mInstance == null) {
                    mInstance = new OkhttpSimpleUtils();
                }
            }
        }
        return mInstance;
    }


    public void getAsyHttp(String url, RequestCallBack requestCallBack) {
        Request request = new Request.Builder().url(url).build();

        Call call = okHttpClient.newCall(request);

        dealResult(call, requestCallBack);
    }

    private void dealResult(final Call call, final RequestCallBack requestCallBack) {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailCallBack(requestCallBack, e);
            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                sendSuccessCallBack(response, requestCallBack);

            }

            private void sendSuccessCallBack(final Response response, final RequestCallBack callBack) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callBack != null) {
                            callBack.onResponse(response);
                        }

                    }
                });
            }

            private void sendFailCallBack(final RequestCallBack callBack, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callBack != null) {
                            callBack.onFailure(call, e);
                        }
                    }
                });
            }

        });
    }


}
