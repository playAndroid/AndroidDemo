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
import hlk.com.mystudyandroidtest.base.MediaPlayerFactory;
import hlk.com.mystudyandroidtest.base.MyApplication;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * MediaPlayer demo
 * Created by user on 2017/3/3.
 */

public class MediaPlayerAdapter extends RecyclerView.Adapter<MediaPlayerAdapter.ViewHolder> {
    private String[] main_list = {"Image", "音乐播放", "ImageAlbum", "自定义Camera", "PhotoProcess", "系统Music播放音乐"};
    private Context mContext = MyApplication.getContext();

    @Override
    public MediaPlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_project_list, parent, false);
        return new MediaPlayerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MediaPlayerAdapter.ViewHolder holder, int position) {
        final int select = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpIntentActivity(MediaPlayerFactory.createMediaPlayerDemo(select));
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
