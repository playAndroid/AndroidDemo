package hlk.com.mystudyandroidtest.ui.newuimode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.ui.newuimode.fragment.CoordinatorAppFragment;
import hlk.com.mystudyandroidtest.ui.newuimode.fragment.CoordinatorFragment;
import hlk.com.mystudyandroidtest.ui.newuimode.fragment.CoordinatorImageFragment;

/**
 * Created by user on 2017/3/17.
 */

public class NewAnyUIActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ui);
//        showCallapering();

//        showCoordinatorApp();

        showCoordinatorImage();
    }

    private void showCoordinatorImage() {
        CoordinatorImageFragment imageFragment = new CoordinatorImageFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, imageFragment)
                .commit();

    }

    private void showCoordinatorApp() {
        CoordinatorAppFragment coordinatorAppFragment = new CoordinatorAppFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, coordinatorAppFragment)
                .commit();
    }

    private void showCallapering() {
        CoordinatorFragment callaperingUIFragment = new CoordinatorFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, callaperingUIFragment)
                .commit();
    }
}
