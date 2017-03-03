package hlk.com.mystudyandroidtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.MyApplication;
import hlk.com.mystudyandroidtest.ui.mediaplayer.CameraDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.MediaImageDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.MediaPhotoAlbumDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.MusicDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.PhotoProcessDemoActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * MediaPlayer demo
 * Created by user on 2017/3/3.
 */

public class MediaPlayerAdapter extends RecyclerView.Adapter<MediaPlayerAdapter.ViewHolder> {
    private String[] main_list = {"Image", "音乐播放", "ImageAlbum", "自定义Camera", "PhotoProcess"};
    private Context mContext = MyApplication.getContext();

    @Override
    public MediaPlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_project_list, parent, false);
        return new MediaPlayerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MediaPlayerAdapter.ViewHolder holder, final int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        jumpIntentActivity(MediaImageDemoActivity.class);
                        break;
                    case 1:
                        jumpIntentActivity(MusicDemoActivity.class);
                        break;
                    case 2:
                        jumpIntentActivity(MediaPhotoAlbumDemoActivity.class);
                        break;
                    case 3:
                        jumpIntentActivity(CameraDemoActivity.class);
                        break;
                    case 4:
                        jumpIntentActivity(PhotoProcessDemoActivity.class);
                        break;
                }
            }
        });

        holder.item_title.setText(main_list[position]);
    }

    private void jumpIntentActivity(Class aClass) {
        Intent intent = new Intent(mContext, aClass);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return main_list.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView item_title;

        ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
