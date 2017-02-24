package hlk.com.mystudyandroidtest.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
<<<<<<< HEAD

import hlk.com.mystudyandroidtest.utils.LogUtil;
=======
import android.support.v4.app.NotificationCompat;
import android.util.Log;
>>>>>>> 743e0e4569826589feb26b3291808cb1d8d88c39

import hlk.com.mystudyandroidtest.MainActivity;
import hlk.com.mystudyandroidtest.R;

public class MyService extends Service {

    private MyServiceBinder serviceBinder = new MyServiceBinder();

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //创建时调用
<<<<<<< HEAD
        LogUtil.d(this.getClass().getSimpleName(), "OnCreate");
=======
        Log.d(this.getClass().getSimpleName(), "OnCreate");

        //创建一个前台服务
        //前台服务 提升服务的系统优先级
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("this notification title")
                .setContentText("this is notification text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
>>>>>>> 743e0e4569826589feb26b3291808cb1d8d88c39
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        每次启动时调用
        LogUtil.d(this.getClass().getSimpleName(), "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.d(this.getClass().getSimpleName(), "onBind");
        return serviceBinder;
    }

    @Override
    public void onDestroy() {
        LogUtil.d(this.getClass().getSimpleName(), "onDestroy");
        super.onDestroy();
    }

    public class MyServiceBinder extends Binder {

        public void startMusic()

        {
            LogUtil.d(this.getClass().getSimpleName(), "startMusic");
        }

        public void stopMusic()

        {
            LogUtil.d(this.getClass().getSimpleName(), "stopMusic");
        }
    }
}
