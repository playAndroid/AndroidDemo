package hlk.com.mystudyandroidtest.ui.scheme;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import java.util.List;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.BaseActivity;

/**
 * http://www.cnblogs.com/whoislcj/p/5825333.html
 *
 * shcmeme
 * 1,可用于页面跳转
 * 2,h5调用页面跳转
 * 3,服务器动态下发控制跳转页面
 * 4,通知栏收到不同数据时跳转等
 * Created by user on 2017/3/9.
 */

public class SchemeDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);


        initViews();
    }

    private void initViews() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        Button button = (Button) findViewById(R.id.btn_1);
        Button button2 = (Button) findViewById(R.id.btn_2);
        button.setText("跳转");
        button2.setText("跳转另一个app");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getPackageManager();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("hlk://ground:8888/hao?test"));
                List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
                boolean isValid = !activities.isEmpty();
                if (isValid) {
                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getPackageManager();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("hlk://ground:8888/other?123132"));
                List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
                boolean isValid = !activities.isEmpty();
                if (isValid) {
                    startActivity(intent);
                }
            }
        });
    }
}
