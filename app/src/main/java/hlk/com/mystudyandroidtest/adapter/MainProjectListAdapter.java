package hlk.com.mystudyandroidtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.MyApplication;
import hlk.com.mystudyandroidtest.ui.BroadcastDemoActivity;
import hlk.com.mystudyandroidtest.ui.CustomerViewActivity;
import hlk.com.mystudyandroidtest.ui.MediaPlayerDemoActivity;
import hlk.com.mystudyandroidtest.ui.OkHttpDemoActivity;
import hlk.com.mystudyandroidtest.ui.RecyclerDemoActivity;
import hlk.com.mystudyandroidtest.ui.RetrofitDemoActivity;
import hlk.com.mystudyandroidtest.ui.RxJavaAndRetrofitDemoActivity;
import hlk.com.mystudyandroidtest.ui.RxJavaDemoActivity;
import hlk.com.mystudyandroidtest.ui.ServiceDemoActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * main project list item
 * Created by user on 2017/2/20.
 */

public class MainProjectListAdapter extends RecyclerView.Adapter<MainProjectListAdapter.ViewHolder> {

    private String[] main_list = {"RxJavaDemo", "RetrofitDemo", "RxJava&RetrofitDemo", "RecyclerDemo", "ActivityDemo"
            , "ServiceDemo", "Broadcast", "MediaPlayerDemo", "ActivityManager"
            , "FragmentDemo", "FrescoDemo", "OkHttpDemo", "WebViewDemo", "友盟统计", "多渠道打包", "代码混淆", "EventBus",
            "otto", "IMDemo", "内存优化与监控", "自定义View"};
    private Context mContext = MyApplication.getContext();

    @Override
    public MainProjectListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_project_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainProjectListAdapter.ViewHolder holder, int position) {
        final String str = main_list[position];
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (str) {
                    case "RecyclerDemo":
                        jumpIntentActivity(RecyclerDemoActivity.class);
                        break;
                    case "ServiceDemo":
                        jumpIntentActivity(ServiceDemoActivity.class);
                        break;
                    case "自定义View":
                        jumpIntentActivity(CustomerViewActivity.class);
                        break;
                    case "OkHttpDemo":
                        jumpIntentActivity(OkHttpDemoActivity.class);
                        break;
                    case "Broadcast":
                        jumpIntentActivity(BroadcastDemoActivity.class);
                        break;
                    case "RxJavaDemo":
                        jumpIntentActivity(RxJavaDemoActivity.class);
                        break;
                    case "RetrofitDemo":
                        jumpIntentActivity(RetrofitDemoActivity.class);
                        break;
                    case "RxJava&RetrofitDemo":
                        jumpIntentActivity(RxJavaAndRetrofitDemoActivity.class);
                        break;
                    case "MediaPlayerDemo":
                        jumpIntentActivity(MediaPlayerDemoActivity.class);
                        break;
                }
            }
        });

        holder.item_title.setText(main_list[position]);
    }

    private void jumpIntentActivity(Class aClass) {
        Intent intent = new Intent(mContext, aClass);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return main_list.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView item_title;

        ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
