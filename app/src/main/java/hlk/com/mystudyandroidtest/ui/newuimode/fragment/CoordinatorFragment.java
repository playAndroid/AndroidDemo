package hlk.com.mystudyandroidtest.ui.newuimode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import hlk.com.mystudyandroidtest.R;

/**
 * 协调布局
 * CoordinatorLayout
 * Created by user on 2017/3/17.
 */

public class CoordinatorFragment extends NewUIBaseFragment {

    private FloatingActionButton fabtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_callapering);
    }

    @Override
    protected void initViews(View view) {
        fabtn = (FloatingActionButton) view.findViewById(R.id.fabtn);
        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(fabtn, "snackbar出来了", Snackbar.LENGTH_SHORT).setAction("点击这里", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        final TextView textView = (TextView) view.findViewById(R.id.content);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 500; i++) {
                    sb.append("这是内容");
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(sb.toString());
                    }
                });
            }
        }).start();

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
