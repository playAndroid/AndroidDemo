package hlk.com.mystudyandroidtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by haokun on 2017/2/28.
 */

public class ParallaxListView extends ListView {
    private ImageView image;
    private int intrinsicHeight;
    private int measuredHeight;

    public ParallaxListView(Context context) {
        this(context, null);
    }

    public ParallaxListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setParallaxImage(ImageView image){
        this.image = image;
        //固定高度 dp
        intrinsicHeight = image.getDrawable().getIntrinsicHeight();
        //测量高度 px
        measuredHeight = image.getMeasuredHeight();
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        Log.d("parallax", "overScrollBy:deltaY "+deltaY+"scrollY"+scrollY+"scrollRangeY");
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }
}
