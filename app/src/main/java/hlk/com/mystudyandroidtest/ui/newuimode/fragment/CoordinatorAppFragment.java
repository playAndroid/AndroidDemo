package hlk.com.mystudyandroidtest.ui.newuimode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.ui.newuimode.adapter.NewUiViewPagerAdapter;

/**
 * http://blog.csdn.net/xyz_lmn/article/details/48055919
 * Created by user on 2017/3/17.
 */

public class CoordinatorAppFragment extends NewUIBaseFragment {

    private CoordinatorLayout coordinator;
    private AppBarLayout appBar;
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private FloatingActionButton fabtn;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_coordinator_app_layout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected void initViews(View view) {
        coordinator = (CoordinatorLayout) view.findViewById(R.id.coordinator);
        appBar = (AppBarLayout) view.findViewById(R.id.appBar);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        tablayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        fabtn = (FloatingActionButton) view.findViewById(R.id.fabtn);
        toolbar.setTitle("滑动收缩效果");
        toolbar.setNavigationIcon(R.drawable.ic_format_list_bulleted_white_24dp);
        NewUiViewPagerAdapter pagerAdapter = new NewUiViewPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(pagerAdapter);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout.setupWithViewPager(viewpager);

    }

}
