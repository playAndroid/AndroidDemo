package hlk.com.mystudyandroidtest.utils;

import android.widget.Toast;

import hlk.com.mystudyandroidtest.base.MyApplication;

/**
 * Created by user on 2017/2/22.
 */

public class SpeedToastUtil {

    private static Toast toast;

    public static void toast(String text) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}
