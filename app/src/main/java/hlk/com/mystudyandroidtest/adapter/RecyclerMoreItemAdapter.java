package hlk.com.mystudyandroidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.MyApplication;
import hlk.com.mystudyandroidtest.bean.MoreItemInfo;

/**
 * more item adapter
 * Created by user on 2017/2/20.
 */

public class RecyclerMoreItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MoreItemInfo> list = getDatas();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(MyApplication.getContext());

        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 1:
                view = inflater.inflate(R.layout.item_more_type1, parent, false);
                viewHolder = new ViewHolder1(view);
                break;
            case 2:
                view = inflater.inflate(R.layout.item_more_type2, parent, false);
                viewHolder = new ViewHolder2(view);
                break;
            case 3:
                view = inflater.inflate(R.layout.item_more_type3, parent, false);
                viewHolder = new ViewHolder3(view);
                break;
            case 4:
                view = inflater.inflate(R.layout.item_more_type4, parent, false);
                viewHolder = new ViewHolder4(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        final int pos = position;
        switch (viewType) {
            case 1:
                ViewHolder1 viewHolder1 = (ViewHolder1) holder;
                viewHolder1.title.setText("类型1");
                break;
            case 2:
                ViewHolder2 viewHolder2 = (ViewHolder2) holder;
                viewHolder2.title.setText("类型2");
                break;
            case 3:
                ViewHolder3 viewHolder3 = (ViewHolder3) holder;
                viewHolder3.title.setText("类型3");
                break;
            case 4:
                ViewHolder4 viewHolder4 = (ViewHolder4) holder;
                viewHolder4.title.setText("类型4");
                break;
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                list.remove(pos);
                notifyItemRemoved(pos);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }


    private class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView title;

        private ViewHolder1(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }


    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {

        private TextView title;

        private ViewHolder2(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }


    }

    private class ViewHolder3 extends RecyclerView.ViewHolder {

        private TextView title;

        private ViewHolder3(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }


    }

    private class ViewHolder4 extends RecyclerView.ViewHolder {

        private TextView title;

        private ViewHolder4(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }


    }


    private ArrayList<MoreItemInfo> getDatas() {
        ArrayList<MoreItemInfo> itemInfos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 40; i++) {
            MoreItemInfo itemInfo = new MoreItemInfo();
            int anInt = random.nextInt(4);
            itemInfo.setType(anInt + 1);
            itemInfos.add(itemInfo);
        }
        return itemInfos;
    }

}
