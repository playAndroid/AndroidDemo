package hlk.com.mystudyandroidtest.ui.uiview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.adapter.MainViewPagerAdapter;

/**
 * Created by user on 2017/3/22.
 */

public class ViewPagerDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics out = new DisplayMetrics();
        display.getMetrics(out);
        layoutParams.height = (int) (out.heightPixels * 7.0 / 10.0f);
        layoutParams.width = (int) (out.widthPixels * 7.0 / 10.0f);
        viewPager.setLayoutParams(layoutParams);

        viewPager.setAdapter(new MainViewPagerAdapter(this));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setOffscreenPageLimit(2);
        viewPager.setPageMargin(100);
    }
}
