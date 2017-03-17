package hlk.com.mystudyandroidtest.ui.newuimode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import hlk.com.mystudyandroidtest.R;

/**
 * http://blog.csdn.net/xyz_lmn/article/details/48055919
 * Created by user on 2017/3/17.
 */

public class CoordinatorImageFragment extends NewUIBaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_coordinator_image);
    }

    @Override
    protected void initViews(View view) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setTitle("折叠布局");
        setHasOptionsMenu(true);


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.coordinator_image_more, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                getActivity().onBackPressed();
                break;
            case R.id.appname:
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(R.layout.sheet_dialog);
                bottomSheetDialog.show();
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
