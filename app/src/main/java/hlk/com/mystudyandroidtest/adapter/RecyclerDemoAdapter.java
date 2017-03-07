package hlk.com.mystudyandroidtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.base.MyApplication;
import hlk.com.mystudyandroidtest.ui.RecyclerMoreItemActivity;

/**
 * this recycler demo activity adapter
 * Created by user on 2017/2/20.
 */

public class RecyclerDemoAdapter extends RecyclerView.Adapter<RecyclerDemoAdapter.ViewHolder> {

    private String[] recyclerData = {"Recycler more Item", "Recycler other demo", "Recycler other demo", "Recycler other demo"};
    private int[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.GRAY, Color.LTGRAY, Color.BLACK};
    private Context mContext = MyApplication.getContext();

    @Override
    public RecyclerDemoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_project_list, parent, false);
        return new RecyclerDemoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerDemoAdapter.ViewHolder holder,int position) {
        holder.item_title.setText(recyclerData[position]);
        holder.item_title.setTextColor(colors[getRadomNumber()]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (recyclerData[holder.getAdapterPosition()]) {
                    case "Recycler more Item":
                        Intent intent = new Intent(mContext, RecyclerMoreItemActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        break;
                }
            }
        });
    }

    /**
     * get a 0 - 5 random number
     *
     * @return random number
     */
    private int getRadomNumber() {
        Random random = new Random();
        return random.nextInt(6);
    }

    @Override
    public int getItemCount() {
        return recyclerData.length;
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
