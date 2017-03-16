package hlk.com.mystudyandroidtest.ui.anmimationdemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.utils.LogUtil;

/**
 * Created by user on 2017/3/16.
 */

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initViews();
    }

    private void initViews() {
        imageView = (ImageView) findViewById(R.id.image);
        ((Button) findViewById(R.id.button1)).setOnClickListener(this);
        ((Button) findViewById(R.id.button2)).setOnClickListener(this);
        ((Button) findViewById(R.id.button3)).setOnClickListener(this);
        ((Button) findViewById(R.id.button4)).setOnClickListener(this);
        textView = (TextView) findViewById(R.id.button5);
        textView.setOnClickListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button1:
                startOne();
                break;
            case R.id.button2:
                startTwo();
                break;
            case R.id.button3:
                startThree();
                break;
            case R.id.button4:
                startFour();
                break;
            case R.id.button5:
                startFifty();
                break;
            case R.id.image:
                float x = imageView.getX();
                float y = imageView.getY();
                Snackbar.make(imageView, "x:"+x+"y:"+y, Snackbar.LENGTH_SHORT).show();
                break;

        }
    }

    private void startFifty() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer animatedValue = (Integer) animation.getAnimatedValue();
                textView.setText(animatedValue+"");
            }
        });

        animator.start();
    }

    private void startFour() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", 0, 200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 200f);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animator2);
        set.play(animator3).before(animator);
        set.setDuration(1000);
        set.start();
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                LogUtil.d("animation", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                LogUtil.d("animation", "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                LogUtil.d("animation", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                LogUtil.d("animation", "onAnimationRepeat");
            }
        });
    }

    private void startThree() {
        //顺序播放
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", 0, 200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200f);
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(animator, animator2);
        set.start();
    }

    private void startTwo() {
        //同时播放
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", 0, 200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator, animator2);
        set.start();

    }

    private void startOne() {
        ObjectAnimator.ofFloat(imageView, "translationX", 0, 200F).setDuration(1000).start();

//        Animator animation = AnimatorInflater.loadAnimator(this,R.animator.animator_one);
//        animation.setTarget(imageView);
//        animation.start();

    }
}
