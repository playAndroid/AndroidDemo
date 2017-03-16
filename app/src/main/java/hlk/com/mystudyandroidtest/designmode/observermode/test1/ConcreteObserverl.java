package hlk.com.mystudyandroidtest.designmode.observermode.test1;

/**
 * 具体的观察者
 * Created by user on 2017/3/16.
 */

public class ConcreteObserverl implements Observer {
    @Override
    public void update(Observerable o) {
//        LogUtil.d("observer","观察者1,观察到被观察者的变化,并做出相应动作");
        System.out.println("观察者1,观察到被观察者的变化,并做出相应动作");
    }
}
