package hlk.com.mystudyandroidtest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import hlk.com.mystudyandroidtest.utils.SpeedToastUtil;

/**
 * Created by haokun on 2017/2/22.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //不可做耗时操作
        String action = intent.getAction();
        switch (action) {
            case "android.net.conn.CONNECTIVITY_CHANGE":
                ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = manager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isAvailable()) {
                    SpeedToastUtil.toast("network is Available");
                } else {
                    SpeedToastUtil.toast("network is not Available");
                }
                break;
            case "android.intent.action.BOOT_COMPLETED":
                SpeedToastUtil.toast("开机广播");
                break;
            case "android.intent.action.My_BROADCAST":
                SpeedToastUtil.toast("custom my broadcast");
                break;
            case "android.intent.action.My_ORDERED_BROADCAST":
                SpeedToastUtil.toast("custom my ordered broadcast");
                abortBroadcast();//中断广播
                break;
            case "android.intent.action.My_LOCATION_BROADCAST":
                SpeedToastUtil.toast("本地广播");
                break;
        }

    }
}
