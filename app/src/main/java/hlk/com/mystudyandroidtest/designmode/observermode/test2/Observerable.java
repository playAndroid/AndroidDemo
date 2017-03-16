package hlk.com.mystudyandroidtest.designmode.observermode.test2;

import java.util.Vector;

/**
 * 被观察者
 * Created by user on 2017/3/16.
 */

public class Observerable {
    private boolean isChange = false;

    private Vector obs;

    public Observerable() {
        obs = new Vector();
    }

    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!obs.contains(observer)) {
            obs.addElement(observer);
        }
    }

    public void deleteObserver(Observer observer) {
        obs.removeElement(observer);
    }

    public void notifyObserver() {
        notifyObserver(null);
    }

    private void notifyObserver(Object o) {
        Object[] local;

        synchronized (this) {
            if (!isChange) {
                return;
            }
            local = obs.toArray();
            clearnChangeState();
        }
        for (int i = local.length - 1; i >= 0; i--) {
            try {
                ((Observer) local[i]).update(this, o);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    public synchronized void setChanged() {
        isChange = true;
    }

    protected void clearnChangeState() {
        isChange = false;
    }

    public synchronized boolean hasChanged() {
        return isChange;
    }

    public synchronized int countObservers() {
        return obs.size();
    }
}
