package hlk.com.mystudyandroidtest.ui.mvpdemo.model;

/**
 * view层应该有的接口,用接口规定view层的逻辑,同时使用presenter持有这个接口的引用
 * 从而达到数据交互 逻辑分离的目的
 * 登陆页面应该有什么方法 返回给数据层 就用什么接口去规定view层
 * Created by user on 2017/3/8.
 */

public interface IMainViewBiz {
    String getUsername();

    String getPassword();

    void logSuccess(User user);

    void logFile();

    void clearName();

    void clearPassword();

    void showLoading();
    void hintLoading();

}
