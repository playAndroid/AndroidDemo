package hlk.com.mystudyandroidtest.designmode;

/**
 * http://www.cnblogs.com/zuoxiaolong/p/pattern2.html
 * JVM虚拟机保证对象唯一
 * Created by user on 2017/3/13.
 */

public class Singleton {

    private Singleton() {
    }

    public static Singleton getInstance() {

        return SingletonInstance.instance;
    }


    private static class SingletonInstance {
        static Singleton instance = new Singleton();
    }
}
