package hlk.com.mystudyandroidtest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.bean.MoveEntity;
import hlk.com.mystudyandroidtest.bean.Subjects;
import hlk.com.mystudyandroidtest.net.retrofittest.HttpMeathod;
import hlk.com.mystudyandroidtest.net.retrofittest.HttpResult;
import hlk.com.mystudyandroidtest.utils.LogUtil;
import rx.Subscriber;

/**
 * rxjava and retrofit
 * Created by user on 2017/2/27.
 */

public class RxJavaAndRetrofitDemoActivity extends AppCompatActivity {
    @BindView(R.id.btn_click)
    Button button;
    @BindView(R.id.tv_title)
    TextView content;
    private Subscriber<MoveEntity> subscriber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_retrofit_demo);
        ButterKnife.bind(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTopMove();
            }
        });
    }

    public void getTopMove() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        /**
         * 封装后
         */

        subscriber = new Subscriber<MoveEntity>() {
            @Override
            public void onCompleted() {
                LogUtil.d("rxjava", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.d("rxjava", "onError" + e.getMessage());
                content.setText(e.getMessage());
            }

            @Override
            public void onNext(MoveEntity moveEntity) {
                LogUtil.d("rxjava", "onError");
                content.setText(moveEntity.getTitle());
            }
        };

        HttpMeathod.getInstance().getMoveTop(subscriber, 0, 10);


        /**
         * 统一的http类型
         */
        Subscriber subscriber1 = new Subscriber<HttpResult<Subjects>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HttpResult<Subjects> subjectsHttpResult) {

            }
        };

        HttpMeathod.getInstance().getMoveTop(subscriber1,0,10);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
//                .setEndpoint(baseUrl)
//                .build();
//        MoveServer moveServer = retrofit.create(MoveServer.class);
//        Call<MoveEntity> call = moveServer.getTopMove(0, 10);
//        call.enqueue(new Callback<MoveEntity>() {
//            @Override
//            public void onResponse(Call<MoveEntity> call, Response<MoveEntity> response) {
//                content.setText(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<MoveEntity> call, Throwable t) {
//                content.setText("onFailure" + t.getMessage());
//            }
//        });
//        moveServer.getTopMove(0, 10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<MoveEntity>() {
//                    @Override
//                    public void onCompleted() {
//                        content.setText("onCompleted:");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        content.setText("onError:==========>"+e.getMessage());
//                        LogUtil.d("error",""+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(MoveEntity moveEntity) {
//                        content.setText("onNext"+moveEntity.getTitle());
//                    }
//                })
//        ;

    }
}
