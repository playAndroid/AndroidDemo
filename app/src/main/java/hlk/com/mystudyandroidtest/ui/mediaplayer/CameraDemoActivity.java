package hlk.com.mystudyandroidtest.ui.mediaplayer;

import android.content.ContentValues;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.BaseActivity;

/**
 * 学习地址:http://blog.csdn.net/chenjie19891104/article/details/6321066
 * https://developer.android.google.cn/guide/topics/media/camera.html
 * Created by user on 2017/3/3.
 */

public class CameraDemoActivity extends BaseActivity implements Camera.PictureCallback, SurfaceHolder.Callback {

    @BindView(R.id.surface_view)
    SurfaceView surfaceView;
//    public static final int MAX_WIDTH ;
//    public static final int MAX_HEIGHT = 200;

    private Camera camera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        surfaceView.setSecure(true);
        surfaceView.setClickable(true);
        surfaceView.setFocusableInTouchMode(true);
        surfaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera.takePicture(null, null, null, CameraDemoActivity.this);
            }
        });

        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.addCallback(this);
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
//        / data是一个原始的JPEG图像数据，
        //在这里我们可以存储图片，很显然可以采用MediaStore
        //注意保存图片后，再次调用startPreview()回到预览
        Uri imageUri = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        try {
            OutputStream os = this.getContentResolver().openOutputStream(imageUri);
            os.write(data);
            os.flush();
            os.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        camera.startPreview();
    }

    /**
     * Surface 初始化时调用
     *
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();

        Camera.Parameters param = camera.getParameters();
        if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            //如果是竖屏
            param.set("orientation", "portrait");
            //在2.2以上可以使用
            //camera.setDisplayOrientation(90);
        } else {
            param.set("orientation", "landscape");
            //在2.2以上可以使用
            //camera.setDisplayOrientation(0);
        }

        List<String> colorEffects = param.getSupportedColorEffects();
        Iterator<String> colorItor = colorEffects.iterator();
        while (colorItor.hasNext()) {
            String currColor = colorItor.next();
            if (currColor.equals(Camera.Parameters.EFFECT_SOLARIZE)) {
                param.setColorEffect(Camera.Parameters.EFFECT_SOLARIZE);
                break;
            }
        }
        //设置完成需要再次调用setParameter方法才能生效
        camera.setParameters(param);

        try {
            camera.setPreviewDisplay(holder);
            /**
             * 在显示了预览后，我们有时候希望限制预览的Size
             * 我们并不是自己指定一个SIze而是指定一个Size，然后
             * 获取系统支持的SIZE，然后选择一个比指定SIZE小且最接近所指定SIZE的一个
             * Camera.Size对象就是该SIZE。
             *
             */
            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            int wd = metrics.widthPixels;
            int hd = metrics.heightPixels;
            int bestWidth = 0;
            int bestHeight = 0;

            List<Camera.Size> sizeList = param.getSupportedPreviewSizes();
            //如果sizeList只有一个我们也没有必要做什么了，因为就他一个别无选择
            if (sizeList.size() > 1) {
                Iterator<Camera.Size> itor = sizeList.iterator();
                while (itor.hasNext()) {
                    Camera.Size cur = itor.next();
                    if (cur.width > bestWidth && cur.height > bestHeight && cur.width < wd && cur.height < hd) {
                        bestWidth = cur.width;
                        bestHeight = cur.height;
                    }
                }
                if (bestWidth != 0 && bestHeight != 0) {
                    param.setPreviewSize(bestWidth, bestHeight);
                    //这里改变了SIze后，我们还要告诉SurfaceView，否则，Surface将不会改变大小，进入Camera的图像将质量很差
                    surfaceView.setLayoutParams(new LinearLayout.LayoutParams(bestWidth, bestHeight));
                }
            }
            camera.setParameters(param);
        } catch (Exception e) {
            e.printStackTrace();
            camera.release();
        }

        camera.startPreview();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
//        / 当Surface被销毁的时候，该方法被调用
        //在这里需要释放Camera资源
        camera.stopPreview();
        camera.release();
    }
}
