package hlk.com.mystudyandroidtest.ui.customerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.utils.SpeedToastUtil;
import hlk.com.mystudyandroidtest.view.SpeedIndexView;

/**
 * Created by user on 2017/2/22.
 */

public class SpeedIndexActivity extends AppCompatActivity {
    @BindView(R.id.speed_index)
    SpeedIndexView indexView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_index);
        ButterKnife.bind(this);
        registListener();
    }

    private void registListener() {
        indexView.setOnTouchIndexListener(new SpeedIndexView.TouchIndexListener() {
            @Override
            public void onTouchindexListener(String letter) {
//                Toast.makeText(SpeedIndexActivity.this, letter, Toast.LENGTH_SHORT).show();
                SpeedToastUtil.toast(letter);
            }
        });
    }
}
