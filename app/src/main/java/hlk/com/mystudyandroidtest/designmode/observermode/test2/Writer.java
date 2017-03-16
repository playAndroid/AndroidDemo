package hlk.com.mystudyandroidtest.designmode.observermode.test2;

/**
 * 作者被读者观察
 * Created by user on 2017/3/16.
 */

public class Writer extends Observerable {
    private String name;

    private String lastNovel;


    public Writer(String name) {
        this.name = name;
        WriterManager.getInstance().addWriter(this);
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public String getName() {
        return name;
    }

    public void addNovel(String lastNovel) {
        System.out.println(name + "发布了新书《" + lastNovel + "》！");
        this.lastNovel = lastNovel;
        setChanged();
        notifyObserver();
    }
}
