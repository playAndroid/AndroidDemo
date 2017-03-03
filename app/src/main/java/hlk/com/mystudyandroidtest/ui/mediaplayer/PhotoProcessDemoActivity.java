package hlk.com.mystudyandroidtest.ui.mediaplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.BaseActivity;
import hlk.com.mystudyandroidtest.utils.LogUtil;

/**
 * http://blog.csdn.net/chenjie19891104/article/details/6323423
 * Created by user on 2017/3/3.
 */

public class PhotoProcessDemoActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.image1)
    ImageView srcImageView;
    @BindView(R.id.image2)
    ImageView dstImageView;
    public static final int FIRST_PIC = 0;
    public static final int SECOND_PIC = 1;

    private Bitmap srcBitmap;
    private Bitmap dstBitmap;
    private Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_process);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        srcImageView.setOnClickListener(this);
        dstImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                // 启动Gallery应用
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, FIRST_PIC);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent2, SECOND_PIC);
                break;
            case R.id.image1:
                break;
            case R.id.image2:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "复制");
        menu.add(Menu.NONE, 2, Menu.NONE, "变换");
        menu.add(Menu.NONE, 3, Menu.NONE, "亮度");
        menu.add(Menu.NONE, 4, Menu.NONE, "合成");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case 1:
                //复制一个图像
                if (srcBitmap != null) {
                    dstBitmap = getDstImage(null);//这里没有变换
                    dstImageView.setImageBitmap(dstBitmap);
                }
                break;
            case 2:
                //对复制后的图像进行变换
                if (srcBitmap != null) {
                    dstBitmap = transferImage();
                    dstImageView.setImageBitmap(dstBitmap);
                }
                break;
            case 3:
                //改变图像的色彩
                if (srcBitmap != null) {
                    dstBitmap = ajustImage();
                    dstImageView.setImageBitmap(dstBitmap);
                }
                break;
            case 4:
                if (srcBitmap != null && dstBitmap != null) {
                    dstBitmap = compositeImages();
                    dstImageView.setImageBitmap(dstBitmap);
                }
                break;
        }
        return true;
    }

    private Bitmap compositeImages() {
        Bitmap bmp = null;
        //下面这个Bitmap中创建的函数就可以创建一个空的Bitmap
        bmp = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bmp);
        //首先绘制第一张图片，很简单，就是和方法中getDstImage一样
        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        //在绘制第二张图片的时候，我们需要指定一个Xfermode
        //这里采用Multiply模式，这个模式是将两张图片的对应的点的像素相乘
        //，再除以255，然后以新的像素来重新绘制显示合成后的图像
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(dstBitmap, 0, 0, paint);
        return bmp;

    }

    private Bitmap ajustImage() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(2.0f, 2.0f, 2.0f, 2.0f);//设置颜色同道色彩缩放
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        return getDstImage(null, paint);
    }

    private Bitmap transferImage() {
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{
                .5f, 0, 0,//这里只会影响到x轴，所以，图片的长度将是原来的一半
                0, 1, 0,
                0, 0, 1
        });
        return getDstImage(matrix);
    }

    /**
     * 复制一个图片
     */
    private Bitmap getDstImage(Matrix matrix) {
        Bitmap bmp = null;
        bmp = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
        //创建Canvas对象，
        Canvas canvas = new Canvas(bmp);
        //创建Paint对象，这里先不用
        Paint paint = new Paint();
        //在Canvas上绘制一个已经存在的Bitmap。这样，dstBitmap就和srcBitmap一摸一样了

        if (matrix != null) {
            //如果matrix存在，则采用变换
            canvas.drawBitmap(dstBitmap, matrix, paint);
        } else {
            canvas.drawBitmap(srcBitmap, 0, 0, paint);
        }
        return bmp;
    }

    /**
     * 复制一个图片
     */
    private Bitmap getDstImage(Matrix matrix, Paint paint) {
        Bitmap bmp = null;
        bmp = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
        //创建Canvas对象，
        Canvas canvas = new Canvas(bmp);
        //创建Paint对象，这里先不用
        //在Canvas上绘制一个已经存在的Bitmap。这样，dstBitmap就和srcBitmap一摸一样了

        if (matrix != null) {
            //如果matrix存在，则采用变换
            canvas.drawBitmap(dstBitmap, matrix, paint);
        } else {
            canvas.drawBitmap(srcBitmap, 0, 0, paint);
        }
        return bmp;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.v("Result OK Value:", resultCode + "");
        Log.v("RequestCode Value", requestCode + "");

        if (resultCode == RESULT_OK) {
            imageUri = data.getData();
            if (requestCode == FIRST_PIC) {
                //在Gallery中选中一个图片时，返回来的Intent中的Data就是选择图片的Uri
                srcBitmap = getSrcImage(imageUri);
                srcImageView.setImageBitmap(srcBitmap);
            } else if (requestCode == SECOND_PIC) {
                //这里处理用户选择的第二张图片

                dstBitmap = getSrcImage(imageUri);
                dstImageView.setImageBitmap(dstBitmap);
            }
        }
    }

    private Bitmap getSrcImage(Uri imageUri) {
        Bitmap bitmap = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(this.getContentResolver().openInputStream(imageUri), null, options);

            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            int wd = metrics.widthPixels;
            int hd = metrics.heightPixels;

            int wr = (int) Math.ceil(options.outWidth / (float) wd);
            int hr = (int) Math.ceil(options.outWidth / (float) hd);
            if (wr > 1 || hr > 1) {
                if (wr > hr) {
                    options.inSampleSize = wr;
                } else {
                    options.inSampleSize = hr;
                }
            }
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri), null, options);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d(this.getClass().getName(), e.getMessage());
        }
        return bitmap;
    }
}
