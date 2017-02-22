package hlk.com.mystudyandroidtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import hlk.com.mystudyandroidtest.utils.DimensUtils;

/**
 * 快速索引View
 * Created by user on 2017/2/22.
 */

public class SpeedIndexView extends View {

    private String[] letters = {"A", "B", "C", "D",
            "E", "F", "G", "H",
            "I", "J", "K", "L",
            "M", "N", "O", "P",
            "Q", "R", "S", "T",
            "U", "V", "W", "X",
            "Y", "Z"};
    private Paint paint;
    private Rect rect;
    private int width;
    private float letterLength;
    private int lastIndex = -1;
    private TouchIndexListener onIndexListener;

    public SpeedIndexView(Context context) {
        this(context, null);
    }

    public SpeedIndexView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpeedIndexView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //抗锯齿
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        //字体
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(DimensUtils.dip2px(context, 16));
        rect = new Rect();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SpeedIndexView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //尽量不要做创建对象的操作,防止内存频繁回收,造成界面卡顿
        for (int i = 0; i < letters.length; i++) {
            paint.getTextBounds(letters[i], 0, letters[i].length(), rect);
            float measureText = paint.measureText(letters[i]);//获取字符串的宽度
            float x = width / 2.0f - measureText / 2.0f;
            float y = letterLength + letterLength * i;
            canvas.drawText(letters[i], x, y, paint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //在onDraw中无法获得宽高
//        width = getMeasuredWidth();
//        height = getMeasuredHeight();
        width = w;
        Log.d("view", "w" + w + "h" + h + "oldw" + oldw + "oldh" + oldh);
        //每个字符串的高度
        letterLength = h * 1.0f / letters.length;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                measuerAndWhitch(event);
                break;
            case MotionEvent.ACTION_MOVE:
                measuerAndWhitch(event);
                break;
            case MotionEvent.ACTION_UP:
                lastIndex = -1;
                break;
        }
        return true;
    }

    private void measuerAndWhitch(MotionEvent event) {
        float y = event.getY();
        int index = (int) (y / letterLength);
        Log.d("view", "" + index);
        //与上次触摸不同
        if (lastIndex != index) {
            if (index >= 0 && index < letters.length) {
                if (onIndexListener != null)
                    onIndexListener.onTouchindexListener(letters[index]);
            }
            lastIndex = index;
        }

    }

    public void setOnTouchIndexListener(TouchIndexListener indexListener) {
        this.onIndexListener = indexListener;

    }

    public interface TouchIndexListener {
        void onTouchindexListener(String letter);
    }
}
