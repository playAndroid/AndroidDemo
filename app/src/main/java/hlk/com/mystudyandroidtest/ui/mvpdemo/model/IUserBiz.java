package hlk.com.mystudyandroidtest.ui.mvpdemo.model;

/**
 * Created by user on 2017/3/8.
 */

public interface IUserBiz {
    void login(String username, String password,OnLoginListener loginListener);
}
