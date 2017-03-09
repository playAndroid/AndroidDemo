package com.android.hlk.router;

import android.support.v4.app.Fragment;

/**
 * Created by user on 2017/3/9.
 */

public class FragmentRouter {
    public Fragment getFragment(String framentName) {
        Fragment fragment;
        try {
            fragment = (Fragment) Class.forName(framentName).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return fragment;
    }
}
