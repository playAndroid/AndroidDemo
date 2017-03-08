package hlk.com.mystudyandroidtest.ui.mvpdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.BaseActivity;
import hlk.com.mystudyandroidtest.ui.mvpdemo.model.IMainViewBiz;
import hlk.com.mystudyandroidtest.ui.mvpdemo.model.User;
import hlk.com.mystudyandroidtest.ui.mvpdemo.presenter.UserLoginPresenter;

/**
 * Created by user on 2017/3/8.
 */

public class MVPDemoActivity extends BaseActivity implements IMainViewBiz {
    @BindView(R.id.user_name)
    EditText user_name;
    @BindView(R.id.user_password)
    EditText user_password;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.clear)
    Button clear;

    private UserLoginPresenter presenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_demo);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.celar();
            }
        });
    }

    @Override
    public String getUsername() {
        return user_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return user_password.getText().toString();
    }

    @Override
    public void logSuccess(User user) {
        Intent intent = new Intent();
        intent.setClass(this, MainSuccessActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    @Override
    public void logFile() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearName() {
        user_name.setText("");
    }

    @Override
    public void clearPassword() {
        user_password.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hintLoading() {
        progressBar.setVisibility(View.GONE);
    }
}
