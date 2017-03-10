package hlk.com.mystudyandroidtest.ui;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 2017/3/10.
 */

public class testevery {

    private AtomicInteger atomicInteger = new AtomicInteger();
    public void test(){
        atomicInteger.addAndGet(23);
    }
}
