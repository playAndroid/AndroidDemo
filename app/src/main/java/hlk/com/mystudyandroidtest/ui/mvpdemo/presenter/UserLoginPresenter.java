package hlk.com.mystudyandroidtest.ui.mvpdemo.presenter;

import android.os.Handler;

import hlk.com.mystudyandroidtest.ui.mvpdemo.model.IMainViewBiz;
import hlk.com.mystudyandroidtest.ui.mvpdemo.model.OnLoginListener;
import hlk.com.mystudyandroidtest.ui.mvpdemo.model.User;
import hlk.com.mystudyandroidtest.ui.mvpdemo.model.UserBizImp;

/**
 * Created by user on 2017/3/8.
 */

public class UserLoginPresenter {


    private UserBizImp userBiz;
    private IMainViewBiz viewImp;
    private Handler handler = new Handler();

    public UserLoginPresenter(IMainViewBiz viewBiz) {
        this.viewImp = viewBiz;
        this.userBiz = new UserBizImp();
    }


    public void login() {
        viewImp.showLoading();
        userBiz.login(viewImp.getUsername(), viewImp.getPassword(), new OnLoginListener() {
            @Override
            public void success(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        viewImp.logSuccess(user);
                        viewImp.hintLoading();
                    }
                });
            }

            @Override
            public void failed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        viewImp.logFile();
                        viewImp.hintLoading();
                    }
                });
            }
        });
    }


    public void celar() {
        viewImp.clearName();
        viewImp.clearPassword();
    }
}
