package hlk.com.mystudyandroidtest.ui.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.net.okhttptest.OkhttpSimpleUtils;
import hlk.com.mystudyandroidtest.net.okhttptest.RequestCallBack;
import hlk.com.mystudyandroidtest.utils.SpeedToastUtil;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by user on 2017/2/22.
 */

public class OkHttpDemoActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.text_content)
    TextView mContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_demo);
        ButterKnife.bind(this);
        registListener();
    }

    private void registListener() {
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                OkhttpSimpleUtils.getInstance().getAsyHttp("http://www.baidu.com", new RequestCallBack() {
                    @Override
                    public void onResponse(Response response) {
                        try {
                            String str = response.body().string();
                            SpeedToastUtil.toast(str);
                            mContent.setText(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call call, Exception e) {
                        SpeedToastUtil.toast("访问失败");
                    }
                });
                break;
        }
    }
}
