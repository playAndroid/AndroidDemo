package hlk.com.mystudyandroidtest.designmode.observermode.test1;

/**
 * Created by user on 2017/3/16.
 */

public class ConcreteObserverT implements Observer {
    @Override
    public void update(Observerable o) {
//        LogUtil.d("observer","观察者2观察到,被观察者变化,做出动作");
        System.out.println("观察者2,观察到被观察者的变化,并做出相应动作");
    }
}
