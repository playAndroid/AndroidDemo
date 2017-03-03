package hlk.com.mystudyandroidtest.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.adapter.MediaPlayerAdapter;
import hlk.com.mystudyandroidtest.base.BaseActivity;

/**
 * https://github.com/guolindev/booksource/blob/master
 * /chapter8/PlayAudioTest/app/src/main/java/com/example/playaudiotest/MainActivity.java
 * Created by user on 2017/2/28.
 */

public class MediaPlayerDemoActivity extends BaseActivity {

    @BindView(R.id.recycle_view)
    RecyclerView recycle_view;

    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madia_player);
        initView();

    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycle_view.setLayoutManager(manager);
        MediaPlayerAdapter adapter = new MediaPlayerAdapter();
        recycle_view.setAdapter(adapter);
    }


}
