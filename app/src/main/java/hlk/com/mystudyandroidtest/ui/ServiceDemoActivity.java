package hlk.com.mystudyandroidtest.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.service.MyService;
import hlk.com.mystudyandroidtest.R;

/**
 * service demo
 * Created by haokun on 2017/2/22.
 */

public class ServiceDemoActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_start)
    Button start;
    @BindView(R.id.btn_stop)
    Button stop;
    @BindView(R.id.unbind)
    Button unbind;
    @BindView(R.id.bind)
    Button bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        ButterKnife.bind(this);
        registListener();
    }

    private void registListener() {
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.btn_stop:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.bind:
                bindService(new Intent(this, MyService.class), connection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(connection);
                break;
        }
    }

    private MyService.MyServiceBinder serviceBinder;
    private ServiceConnection connection = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //绑定
            serviceBinder = (MyService.MyServiceBinder) iBinder;
            serviceBinder.startMusic();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            //解绑
            serviceBinder.stopMusic();
        }
    };
}
