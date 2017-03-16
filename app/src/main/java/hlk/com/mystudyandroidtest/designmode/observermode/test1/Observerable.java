package hlk.com.mystudyandroidtest.designmode.observermode.test1;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/3/15.
 */

public class Observerable {

    private List<Observer> observers = new ArrayList<>();


    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    public void changed() {
//        LogUtil.d("observer", "被观察者变化");
        System.out.println("被观察者变化");
        notifyObserver();
    }


    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
