package com.android.hlk.moduleone;

import android.app.Application;
import android.util.Log;

/**
 * 获取全局Appliction
 * Created by user on 2017/3/9.
 */

public class App {
    public static final Application INSTANCE;

    static {
        Application app = null;

        try {
            app = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplicaion").invoke(null);
            if (app == null) {
                throw new IllegalStateException("static initialization of Application must be on main thread.");
            }
        } catch (Exception e) {
            Log.e("error", "Failed to get current application form AppGlobals." + e.getMessage());
        }
        try {
            app = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
        } catch (Exception ex) {
            Log.e("error", "Failed to get current application form ActivityThread." + ex.getMessage());
        } finally {
            INSTANCE = app;
        }
    }
}
