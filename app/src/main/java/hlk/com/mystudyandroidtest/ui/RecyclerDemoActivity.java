package hlk.com.mystudyandroidtest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.adapter.RecyclerDemoAdapter;

/**
 * RecyclerView Demo
 * Created by user on 2017/2/20.
 */

public class RecyclerDemoActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        mRecycler.setLayoutManager(manager);
        RecyclerDemoAdapter adapter = new RecyclerDemoAdapter();
        mRecycler.setAdapter(adapter);
    }


//    public void repleaceFrame(Fragment fragment){
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.frame_layout,fragment);
//        transaction.commit();
//    }
}
