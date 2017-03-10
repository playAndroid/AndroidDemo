package com.android.hlk.moduleone.socketdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.hlk.moduleone.R;

/**
 * Created by user on 2017/3/10.
 */

public class ServerActivity extends AppCompatActivity {

    private EditText edit_text;
    private TextView text_view;
    private StringBuilder sb = new StringBuilder();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 0x11) {
                sb.append(msg.what);
                text_view.setText(sb.toString());
                sb.append("\r\n");
            }
        }
    };
    private ServiceRunable serviceRunable;
    private Thread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        initViews();
        serviceRunable = new ServiceRunable(handler);
        thread = new Thread(serviceRunable);
        thread.start();

    }

    private void initViews() {
        edit_text = (EditText) findViewById(R.id.edit_text);
        text_view = (TextView) findViewById(R.id.text_view);
        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edit_text.getText().toString();
                serviceRunable.send(string);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        serviceRunable.cloes();

    }
}
