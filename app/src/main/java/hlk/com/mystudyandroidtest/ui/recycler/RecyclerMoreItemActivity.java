package hlk.com.mystudyandroidtest.ui.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

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
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coolapsing)
    CollapsingToolbarLayout collapsing;
    @BindView(R.id.appBar)
    AppBarLayout appBarLayout;
    @BindView(R.id.fabtn)
    FloatingActionButton fabtn;
    private StaggeredGridLayoutManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_more_item);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsing.setTitle("折叠嵌套Recycler");
        //线性布局
//        LinearLayoutManager manager = new LinearLayoutManager(this);
        //网格布局
//        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(manager);
        RecyclerMoreItemAdapter adapter = new RecyclerMoreItemAdapter();
        mRecycler.setAdapter(adapter);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
//        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int spanCount = manager.getSpanCount();
                manager.setSpanCount(spanCount == 2 ? 1 : 2);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
