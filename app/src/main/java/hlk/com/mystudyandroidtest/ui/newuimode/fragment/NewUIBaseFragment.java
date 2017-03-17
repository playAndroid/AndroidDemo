package hlk.com.mystudyandroidtest.ui.newuimode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2017/3/17.
 */

public abstract class NewUIBaseFragment extends Fragment {
    private int layoutId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(layoutId, container, false);
        initViews(view);
        return view;
    }

    protected abstract void initViews(View view);

    protected void setContentView(int layoutId) {
        this.layoutId = layoutId;
    }
}
