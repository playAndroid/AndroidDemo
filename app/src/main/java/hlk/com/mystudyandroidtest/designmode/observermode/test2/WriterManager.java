package hlk.com.mystudyandroidtest.designmode.observermode.test2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017/3/16.
 */

public class WriterManager {
    private Map<String, Writer> writerMap = new HashMap<>();


    private WriterManager() {
    }


    public void addWriter(Writer writer) {
        writerMap.put(writer.getName(), writer);
    }


    public Writer getWriter(String name) {
        return writerMap.get(name);
    }

    public static WriterManager getInstance() {
        return SingleWriterManager.instance;
    }

    private static class SingleWriterManager {
        private static WriterManager instance = new WriterManager();
    }

}
