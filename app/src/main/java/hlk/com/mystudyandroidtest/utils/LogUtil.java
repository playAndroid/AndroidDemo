package hlk.com.mystudyandroidtest.utils;

import com.orhanobut.logger.Logger;

import hlk.com.mystudyandroidtest.BuildConfig;

/**
 * logger manager
 * Created by user on 2017/2/24.
 */

public class LogUtil {
    private static boolean isDebug = BuildConfig.DEBUG;

    public static void d(String tag, String text) {
        if (isDebug)
            Logger.t(tag).d(text);
    }
}
