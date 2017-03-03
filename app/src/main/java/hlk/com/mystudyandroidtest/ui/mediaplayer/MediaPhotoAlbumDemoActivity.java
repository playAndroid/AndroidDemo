package hlk.com.mystudyandroidtest.ui.mediaplayer;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.BaseActivity;


/**
 * 查询图库中的图
 * Created by user on 2017/3/3.
 * http://blog.csdn.net/chenjie19891104/article/details/6320664
 */

public class MediaPhotoAlbumDemoActivity extends BaseActivity {
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.image_button)
    ImageView image_button;
    private Cursor cursor;
    private int nameIndex;
    private int photoIndex;
    private String photoPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_album);
        showImage();
        registerListener();
    }

    private void registerListener() {
        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cursor.moveToNext()) {
                    showThisImage();
                }
            }
        });
    }

    private void showImage() {
        //指定获取的列
        String columns[] = new String[]{
                MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID, MediaStore.Images.Media.TITLE, MediaStore.Images.Media.DISPLAY_NAME
        };
        cursor = this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null, null);
        if (cursor != null) {
            nameIndex = cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
            photoIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
            if (cursor.moveToFirst()) {
                showThisImage();
            }
        }

    }

    private void showThisImage() {
        photoPath = cursor.getString(photoIndex);
        String name = cursor.getString(nameIndex);
        Bitmap currPhoto = getcodeBitmap(photoPath);
        image_button.setImageBitmap(currPhoto);
        address.setText(name);
    }

    public Bitmap getcodeBitmap(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int wd = metrics.widthPixels;
        int hd = metrics.heightPixels;

        int wR = (int) Math.ceil(options.outWidth / (float) wd);
        int hR = (int) Math.ceil(options.outWidth / (float) hd);
        if (wR > 1 || hR > 1) {
            if (wR > hR) {
                options.inSampleSize = wR;
            } else {
                options.inSampleSize = hR;
            }
        }
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(path, options);
    }
}
