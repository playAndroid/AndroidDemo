package hlk.com.mystudyandroidtest.ui.mvpdemo.model;

import android.os.SystemClock;

/**
 * Created by user on 2017/3/8.
 */

public class UserBizImp implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);

                if (username.equals("hlk") && password.equals("hlk")) {
                    User user = new User();
                    user.setName(username);
                    user.setPassword(password);
                    loginListener.success(user);
                } else {
                    loginListener.failed();
                }
            }
        }).start();

    }
}
