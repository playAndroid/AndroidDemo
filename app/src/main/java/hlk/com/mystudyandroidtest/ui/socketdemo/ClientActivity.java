package hlk.com.mystudyandroidtest.ui.socketdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import hlk.com.mystudyandroidtest.R;

/**
 * Created by user on 2017/3/10.
 */

public class ClientActivity extends AppCompatActivity {
    private EditText edit_text;
    private TextView text_view;
    private StringBuilder sb = new StringBuilder();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 0x12) {
                sb.append(msg.what);

                text_view.setText(sb.toString());
                sb.append("\r\n");
            }
        }
    };
    private Client client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_socket);

        initViews();
        client = new Client(handler);
        new Thread(client).start();

    }

    private void initViews() {
        edit_text = (EditText) findViewById(R.id.edit_text);
        text_view = (TextView) findViewById(R.id.text_view);
        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edit_text.getText().toString();
                client.send(string);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        client.cloes();
    }
}
