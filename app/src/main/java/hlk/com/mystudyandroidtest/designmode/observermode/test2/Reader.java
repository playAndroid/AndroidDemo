package hlk.com.mystudyandroidtest.designmode.observermode.test2;

/**
 * 读者 订阅作者
 * Created by user on 2017/3/16.
 */

public class Reader implements Observer {


    private String name;

    public Reader(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    @Override
    public void update(Observerable observerable, Object o) {
        if (observerable instanceof Writer) {
            Writer writer = (Writer) observerable;
            System.out.println(name + "知道" + writer.getName() + "发布了新书《" + writer.getLastNovel() + "》，非要去看！");
        }
    }


    /**
     * 订阅
     *
     * @param name
     */
    public void subscribe(String name) {
        WriterManager.getInstance().getWriter(name).addObserver(this);
    }


    public void unSubscribe(String name) {
        WriterManager.getInstance().getWriter(name).deleteObserver(this);
    }


}
