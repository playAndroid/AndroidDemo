package hlk.com.mystudyandroidtest.ui.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.net.retrofittest.GitApi;
import hlk.com.mystudyandroidtest.net.retrofittest.Gitmodel;
import hlk.com.mystudyandroidtest.utils.SpeedToastUtil;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by user on 2017/2/24.
 */

public class RetrofitDemoActivity extends AppCompatActivity {

    @BindView(R.id.text_title)
    TextView mtext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo);
        ButterKnife.bind(this);
        mtext.setText("This is Retrofit Demo");
        initData();
    }

    private void initData() {
        String path = "https://api.github.com";
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(path)
                .build();
        GitApi gitApi = restAdapter.create(GitApi.class);
        gitApi.getString("basil2style", new Callback<Gitmodel>() {
            @Override
            public void success(Gitmodel gitmodel, Response response) {
                mtext.setText("Github Name :" + gitmodel.getName() +
                        "\nWebsite :" + gitmodel.getBlog() +
                        "\nCompany Name :" + gitmodel.getCompany());
                SpeedToastUtil.toast("success");
            }

            @Override
            public void failure(RetrofitError error) {
                SpeedToastUtil.toast("failure");
            }
        });
    }
}
