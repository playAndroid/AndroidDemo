package hlk.com.mystudyandroidtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.adapter.MainProjectListAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
//        Array array = Array.newInstance();
//        Collections.synchronizedList(new LinkedList(null));
//        Hashtable hashtable = new Hashtable();
//        HashMap hashMap = new HashMap();
////        hashMap.get()
//        ArrayList arrayList= new ArrayList();
//        Collection coll = new ArrayList();
//        Iterator iterator = coll.iterator();
//        while (iterator.hasNext()){
//            Object next = iterator.next();
//        }
//
//        ArrayList list = (ArrayList) Collections.synchronizedList(arrayList);
//        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//        int memoryClass = manager.getMemoryClass();
//        Log.e("内存",":"+memoryClass);
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);
        MainProjectListAdapter adapter = new MainProjectListAdapter();
        mRecycler.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
