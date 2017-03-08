package hlk.com.mystudyandroidtest.base;

import hlk.com.mystudyandroidtest.ui.BroadcastDemoActivity;
import hlk.com.mystudyandroidtest.ui.CustomerViewActivity;
import hlk.com.mystudyandroidtest.ui.MediaPlayerDemoActivity;
import hlk.com.mystudyandroidtest.ui.OkHttpDemoActivity;
import hlk.com.mystudyandroidtest.ui.RecyclerDemoActivity;
import hlk.com.mystudyandroidtest.ui.RetrofitDemoActivity;
import hlk.com.mystudyandroidtest.ui.RxJavaAndRetrofitDemoActivity;
import hlk.com.mystudyandroidtest.ui.RxJavaDemoActivity;
import hlk.com.mystudyandroidtest.ui.ServiceDemoActivity;
import hlk.com.mystudyandroidtest.ui.mvpdemo.view.MVPDemoActivity;

/**
 * Created by user on 2017/3/8.
 */

public class MainProjectFactory {

    public static Class createMainProject(String position) {
        Class c = null;
        switch (position) {
            case "RecyclerDemo":
                c = RecyclerDemoActivity.class;
                break;
            case "ServiceDemo":
                c = ServiceDemoActivity.class;
                break;
            case "自定义View":
                c = CustomerViewActivity.class;
                break;
            case "OkHttpDemo":
                c = OkHttpDemoActivity.class;
                break;
            case "Broadcast":
                c = BroadcastDemoActivity.class;
                break;
            case "RxJavaDemo":
                c = RxJavaDemoActivity.class;
                break;
            case "RetrofitDemo":
                c = RetrofitDemoActivity.class;
                break;
            case "RxJava&RetrofitDemo":
                c = RxJavaAndRetrofitDemoActivity.class;
                break;
            case "MediaPlayerDemo":
                c = MediaPlayerDemoActivity.class;
                break;
            case "MVP":
                c = MVPDemoActivity.class;
        }

        return c;
    }
}
