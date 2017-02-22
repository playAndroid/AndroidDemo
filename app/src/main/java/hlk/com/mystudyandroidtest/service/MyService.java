package hlk.com.mystudyandroidtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private MyServiceBinder serviceBinder = new MyServiceBinder();
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //创建时调用
        Log.d(this.getClass().getSimpleName(), "OnCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        每次启动时调用
        Log.d(this.getClass().getSimpleName(), "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(this.getClass().getSimpleName(), "onBind");
        return serviceBinder;
    }

    @Override
    public void onDestroy() {
        Log.d(this.getClass().getSimpleName(), "onDestroy");
        super.onDestroy();
    }

    public  class MyServiceBinder extends Binder {

        public void startMusic()

        {
            Log.d(this.getClass().getSimpleName(), "startMusic");
        }

        public void stopMusic()

        {
            Log.d(this.getClass().getSimpleName(), "stopMusic");
        }
    }
}
