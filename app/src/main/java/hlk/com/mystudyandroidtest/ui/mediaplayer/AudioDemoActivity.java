package hlk.com.mystudyandroidtest.ui.mediaplayer;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.File;

import hlk.com.mystudyandroidtest.R;

/**
 * http://blog.csdn.net/chenjie19891104/article/details/6330383
 * Created by user on 2017/3/7.
 */

public class AudioDemoActivity extends ListActivity {


    private Cursor cursor;
    private boolean isAlbum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_audio_system);
        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAlbums();
                isAlbum = true;
            }
        });
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //判断当前是哪个列表
        if (isAlbum) {
            //如果是Album，当用户点击某一个时，获取该Album下的所有media
            //l.getChildAt(position);
            if (cursor.moveToPosition(position)) {
                getMedias(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Albums._ID)));
                isAlbum = false;
            }
        } else {
            //如果是Media，则当用户点击某一个时，则播放该Media
            //调用系统自带的MediaPlayer来播放
            if (cursor.moveToPosition(position)) {
                String mediaUri = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                String type = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.MIME_TYPE));
                Uri data = Uri.fromFile(new File(mediaUri));
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(data, type);
                startActivity(intent);
            }
        }
    }

    public void getAlbums() {
        String[] columns = new String[]{
                MediaStore.Audio.Albums._ID,
                MediaStore.Audio.Albums.ALBUM
        };
        String[] from = new String[]{
                MediaStore.Audio.Albums.ALBUM
        };
        int[] to = new int[]{
                android.R.id.text1
        };

//        cursor = this.managedQuery(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, columns, null, null, MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);

        cursor = getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, columns, null, null, MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);



        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to);
        this.setListAdapter(adapter);

    }

    //获取某个Albums下对应的medias
    public void getMedias(int albumId) {
        String[] columns = new String[]{
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.MIME_TYPE
        };
        String selection = MediaStore.Audio.Media.ALBUM_ID + "=?";
        String[] selectionArgs = new String[]{
                albumId + ""
        };

        String[] from = new String[]{
                MediaStore.Audio.Media.DISPLAY_NAME
        };
        int[] to = new int[]{
                android.R.id.text1
        };

        cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, columns, selection, selectionArgs, MediaStore.Audio.Media.TITLE);
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to);
        this.setListAdapter(adapter);
    }
}
