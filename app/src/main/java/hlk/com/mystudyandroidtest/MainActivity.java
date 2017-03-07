package hlk.com.mystudyandroidtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.adapter.MainProjectListAdapter;
import hlk.com.mystudyandroidtest.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        ClassLoader classLoader = getClassLoader();
        if (classLoader != null) {
            LogUtil.d("classLoader", "classLoader" + classLoader.toString());
            while (classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
                LogUtil.d("classLoader", "[onCreate] classLoader " + " : " + classLoader.toString());
            }
        }
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        MainProjectListAdapter adapter = new MainProjectListAdapter();
        mRecycler.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
