package hlk.com.mystudyandroidtest.base;

import hlk.com.mystudyandroidtest.ui.anmimationdemo.AnimationActivity;
import hlk.com.mystudyandroidtest.ui.annotation.AnnotationDemoActivity;
import hlk.com.mystudyandroidtest.ui.brodcast.BroadcastDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.MediaPlayerDemoActivity;
import hlk.com.mystudyandroidtest.ui.mvpdemo.view.MVPDemoActivity;
import hlk.com.mystudyandroidtest.ui.okhttp.OkHttpDemoActivity;
import hlk.com.mystudyandroidtest.ui.recycler.RecyclerDemoActivity;
import hlk.com.mystudyandroidtest.ui.retrofit.RetrofitDemoActivity;
import hlk.com.mystudyandroidtest.ui.rxjava.RxJavaAndRetrofitDemoActivity;
import hlk.com.mystudyandroidtest.ui.rxjava.RxJavaDemoActivity;
import hlk.com.mystudyandroidtest.ui.scheme.SchemeDemoActivity;
import hlk.com.mystudyandroidtest.ui.service.ServiceDemoActivity;
import hlk.com.mystudyandroidtest.ui.socketdemo.ClientActivity;
import hlk.com.mystudyandroidtest.ui.uiview.CustomerViewActivity;

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
                break;
            case "Scheme":
                c = SchemeDemoActivity.class;
                break;
            case "注解":
                c = AnnotationDemoActivity.class;
            case "Socket":
                c = ClientActivity.class;
                break;
            case "动画":
                c = AnimationActivity.class;
                break;
        }

        return c;
    }
}
