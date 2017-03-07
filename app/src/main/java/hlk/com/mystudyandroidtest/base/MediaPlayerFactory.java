package hlk.com.mystudyandroidtest.base;

import hlk.com.mystudyandroidtest.ui.mediaplayer.AudioDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.CameraDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.MediaImageDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.MediaPhotoAlbumDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.MusicDemoActivity;
import hlk.com.mystudyandroidtest.ui.mediaplayer.PhotoProcessDemoActivity;

/**
 * 多媒体工厂类
 * Created by user on 2017/3/7.
 */

public class MediaPlayerFactory {

    public static Class createMediaPlayerDemo(int type) {
        Class c = null;
        switch (type) {
            case 0:
                c = MediaImageDemoActivity.class;
                break;
            case 1:
                c = MusicDemoActivity.class;
                break;
            case 2:
                c = MediaPhotoAlbumDemoActivity.class;
                break;
            case 3:
                c = CameraDemoActivity.class;
                break;
            case 4:
                c = PhotoProcessDemoActivity.class;
                break;
            case 5:
                c = AudioDemoActivity.class;
                break;
        }
        return c;
    }
}