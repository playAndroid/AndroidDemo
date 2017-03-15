package hlk.com.mystudyandroidtest.designmode.observermode;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by user on 2017/3/15.
 */

public class Observerable  {

    private List<Observer> observers = new ArrayList<>();




    public void registerobserver(Observer observer){
        observers.add(observer);
    }


    public void unRegisterobserver(Observer observer){
        observers.remove(observer);
    }



    public void notifyObserver(){
        for (Observer observer : observers){
            observer.update(new Observable(),"通知");
        }
    }

}
