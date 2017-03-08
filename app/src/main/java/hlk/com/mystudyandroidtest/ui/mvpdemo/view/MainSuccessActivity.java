package hlk.com.mystudyandroidtest.ui.mvpdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.BaseActivity;
import hlk.com.mystudyandroidtest.ui.mvpdemo.model.User;

/**
 * Created by user on 2017/3/8.
 */

public class MainSuccessActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView textView;
    String str;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        User user = (User) getIntent().getSerializableExtra("user");
        if (user != null) {
            str = "账号:" + user.getName() + "密码:" + user.getPassword();
        }
        textView.setText(getString(R.string.success,str));
    }
}
