package hlk.com.mystudyandroidtest.ui.brodcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.broadcast.MyBroadcastReceiver;

/**
 * Created by haokun on 2017/2/22.
 */

public class BroadcastDemoActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_broadcast)
    Button mBroadcast;
    @BindView(R.id.btn_ordered_broadcast)
    Button mOrderedBroad;
    @BindView(R.id.btn_location_broadcast)
    Button mLocationBroad;
    private MyBroadcastReceiver receiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcase_demo);
        ButterKnife.bind(this);
        registListener();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //动态注册
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new MyBroadcastReceiver();
        registerReceiver(receiver,intentFilter);
        intentFilter.addAction("android.intent.action.My_LOCATION_BROADCAST");
        localBroadcastManager.registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    private void registListener() {
        mBroadcast.setOnClickListener(this);
        mOrderedBroad.setOnClickListener(this);
        mLocationBroad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_broadcast:
                //自定义广播 发送标准广播
                Intent intent = new Intent();
                intent.setAction("android.intent.action.My_BROADCAST");
                sendBroadcast(intent);
                break;
            case R.id.btn_ordered_broadcast:
                //自定义广播 发送标准广播
                Intent intentOrdered = new Intent();
                intentOrdered.setAction("android.intent.action.My_ORDERED_BROADCAST");
                sendOrderedBroadcast(intentOrdered,null);
                break;
            case R.id.btn_location_broadcast:
                Intent location = new Intent();
                location.setAction("android.intent.action.My_LOCATION_BROADCAST");
                localBroadcastManager.sendBroadcast(location);
                break;
        }
    }
}
