package hlk.com.mystudyandroidtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
//        assertEquals(5, 2 + 2);
//        abc(8);
        bubbling();

    }

    private void bubbling() {
        boolean isChange = true;
        int[] i = {0, 2, 1, 4, 6, 5, 9, 8, 7, 10, 3};
        for (int j = 1; j < i.length && isChange; j++) {
            isChange = false;
            for (int k = i.length - 2; k >= j; k--) {

                if (i[k] > i[k + 1]) {
                    int tem = i[k + 1];
                    i[k + 1] = i[k];
                    i[k] = tem;
                    isChange = true;
                }
            }

        }
        for (int k = 0; k < i.length; k++) {
            System.out.print(i[k]);
        }
    }


    /**
     * 折半查找
     *
     * @param serchNum
     */
    private void abc(int serchNum) {
        int[] i = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = -1;
        int low = 0;
        int height = i.length;
        while (low <= height) {
            int mid = (low + height) / 2;
            if (serchNum < i[mid]) {
                height = mid - 1;
            } else if (serchNum > i[mid]) {
                low = mid + 1;
            } else {
                sum = mid;
                break;
            }
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("123");
        buffer.append("456");
        buffer.append("789");
        buffer.reverse();
        System.out.print("结果" + buffer.toString());

        TreeMap treeMap = new TreeMap();
        HashMap hashMap = new HashMap();
        int[] ints = new int[3];
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
    }
}