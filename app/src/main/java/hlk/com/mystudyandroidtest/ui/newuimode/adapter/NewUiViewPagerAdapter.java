package hlk.com.mystudyandroidtest.ui.newuimode.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import hlk.com.mystudyandroidtest.ui.newuimode.fragment.CoordinatorFragment;

/**
 * Created by user on 2017/3/17.
 */

public class NewUiViewPagerAdapter extends FragmentPagerAdapter {

    private static String[] titles = {"热门事件", "社会热点", "搞笑", "图片","图片","图片","图片"};
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public NewUiViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new CoordinatorFragment());
        fragments.add(new CoordinatorFragment());
        fragments.add(new CoordinatorFragment());
        fragments.add(new CoordinatorFragment());
        fragments.add(new CoordinatorFragment());
        fragments.add(new CoordinatorFragment());
        fragments.add(new CoordinatorFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
