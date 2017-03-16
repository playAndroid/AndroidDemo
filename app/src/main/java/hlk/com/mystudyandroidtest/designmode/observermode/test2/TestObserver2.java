package hlk.com.mystudyandroidtest.designmode.observermode.test2;

/**
 * 测试类
 * Created by user on 2017/3/16.
 */

public class TestObserver2 {
    public void test(){
        Reader reader1 = new Reader("读者1");
        Reader reader2 = new Reader("读者2");
        Reader reader3 = new Reader("读者3");
        Reader reader4 = new Reader("读者4");
        Writer writer1 = new Writer("作者1");
        Writer writer2 = new Writer("作者2");

        reader1.subscribe(writer1.getName());
        reader2.subscribe(writer1.getName());
        reader3.subscribe(writer1.getName());
        reader4.subscribe(writer1.getName());
        reader1.subscribe(writer2.getName());
        reader2.subscribe(writer2.getName());


        writer1.addNovel("java设计");
        writer2.addNovel("颈椎治疗");

        reader2.unSubscribe(writer1.getName());

        writer1.addNovel("新书来了啊");
    }

}
