package hlk.com.mystudyandroidtest.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import hlk.com.mystudyandroidtest.R;


/**
 * Created by user on 2017/3/22.
 */

public class MainViewPagerAdapter extends PagerAdapter {

    public static final int[] PAGER = {R.drawable.splash0, R.drawable.splash1, R.drawable.splash2, R.drawable.splash3, R.drawable.splash4
            , R.drawable.splash5, R.drawable.splash6, R.drawable.splash7, R.drawable.splash8
    };
    private Context context;

    public MainViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGER.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(PAGER[position]);
        ((ViewPager) container).addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
