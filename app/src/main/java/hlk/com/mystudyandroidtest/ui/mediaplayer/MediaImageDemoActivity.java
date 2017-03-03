package hlk.com.mystudyandroidtest.ui.mediaplayer;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

import butterknife.BindView;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.BaseActivity;
import hlk.com.mystudyandroidtest.utils.LogUtil;

/**
 * start camera get a image
 * <p>
 * Created by user on 2017/3/3.
 * <p>
 * http://blog.csdn.net/chenjie19891104/article/details/6320323
 */

public class MediaImageDemoActivity extends BaseActivity {
    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.button)
    Button button;
    private static final int RESULT_CODE = 1;
    private Uri imageFilePath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAndShowImage();
            }
        });

    }

    private void createAndShowImage() {
//        File file = new File(Environment.getExternalStorageDirectory()+"123.jpg");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        ContentValues values = new ContentValues(3);
        values.put(MediaStore.Images.Media.DISPLAY_NAME, "testing");
        values.put(MediaStore.Images.Media.DESCRIPTION, "this is description");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        imageFilePath = MediaImageDemoActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageFilePath);
        startActivityForResult(intent, RESULT_CODE);
        LogUtil.d("image",""+imageFilePath.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_CODE) {
//            Bundle extras = data.getExtras();

            //首先取得屏幕对象
            Display display = this.getWindowManager().getDefaultDisplay();
            //获取屏幕的宽和高
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            int dw = metrics.widthPixels;
            int dh = metrics.heightPixels;

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;

            try {
                Bitmap bitmap;
                BitmapFactory.decodeStream(this.getContentResolver().openInputStream(imageFilePath), null, options);
                int wRatio = (int) Math.ceil(options.outWidth / (float) dw); //计算宽度比例
                int hRatio = (int) Math.ceil(options.outHeight / (float) dh); //计算高度比例
                Log.v("Width Ratio:", wRatio + "");
                Log.v("Height Ratio:", hRatio + "");
                if (wRatio > 1 && hRatio > 1) {
                    if (wRatio > hRatio) {
                        options.inSampleSize = wRatio;
                    } else {
                        options.inSampleSize = hRatio;
                    }
                }
                options.inJustDecodeBounds = false; //注意这里，一定要设置为false，因为上面我们将其设置为true来获取图片尺寸了
                bitmap = BitmapFactory.decodeStream(this.getContentResolver()
                        .openInputStream(imageFilePath), null, options);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
