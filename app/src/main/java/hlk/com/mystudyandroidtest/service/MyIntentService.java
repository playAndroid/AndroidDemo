package hlk.com.mystudyandroidtest.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by haokun on 2017/2/23.
 */

public class MyIntentService extends IntentService {
    private static String TAG = "myintentservice";
    public MyIntentService() {
        super("My intent service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: "+Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
