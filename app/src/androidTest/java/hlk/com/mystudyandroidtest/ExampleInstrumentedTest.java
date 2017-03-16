package hlk.com.mystudyandroidtest;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import hlk.com.mystudyandroidtest.designmode.observermode.test1.ConcreteObserverT;
import hlk.com.mystudyandroidtest.designmode.observermode.test1.ConcreteObserverl;
import hlk.com.mystudyandroidtest.designmode.observermode.test1.Observerable;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("hlk.com.mystudyjavatest", appContext.getPackageName());
        Observerable observerable = new Observerable();
        observerable.addObserver(new ConcreteObserverl());
        observerable.addObserver(new ConcreteObserverT());
        observerable.changed();

//        HttpUtils.getAsyHttp();
    }
}
