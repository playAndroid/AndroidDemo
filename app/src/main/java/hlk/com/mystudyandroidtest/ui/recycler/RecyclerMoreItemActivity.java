package hlk.com.mystudyandroidtest.ui.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.adapter.RecyclerMoreItemAdapter;

/**
 * Created by user on 2017/2/20.
 */

public class RecyclerMoreItemActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_more_item)
    RecyclerView mRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_more_item);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        GridLayoutManager manager = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(manager);
        RecyclerMoreItemAdapter adapter = new RecyclerMoreItemAdapter();
        mRecycler.setAdapter(adapter);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
//        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

}
