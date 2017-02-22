package hlk.com.mystudyandroidtest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.ui.customerview.SpeedIndexActivity;

/**
 * Created by user on 2017/2/22.
 */

public class CustomerViewActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_speed_index)
    Button speedIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);
        ButterKnife.bind(this);
        registerListener();
    }

    private void registerListener() {
        speedIndex.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_speed_index:
                Intent intent = new Intent(this, SpeedIndexActivity.class);
                startActivity(intent);
                break;
        }
    }
}
