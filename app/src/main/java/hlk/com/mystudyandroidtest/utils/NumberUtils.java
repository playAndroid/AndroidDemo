package hlk.com.mystudyandroidtest.utils;

import java.util.Random;

/**
 * Created by user on 2017/2/21.
 */

public class NumberUtils {

    /**
     * 获取随机数
     *
     * @return 返回 0 - n 之间的随机数 不包括n
     */
    public static int getRandomNumber(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }
}
