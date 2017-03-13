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
import hlk.com.mystudyandroidtest.base.CommonStrings;
import hlk.com.mystudyandroidtest.base.MainProjectFactory;
import hlk.com.mystudyandroidtest.base.MyApplication;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * main project list item
 * Created by user on 2017/2/20.
 */

public class MainProjectListAdapter extends RecyclerView.Adapter<MainProjectListAdapter.ViewHolder> {

    private Context mContext = MyApplication.getContext();

    @Override
    public MainProjectListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_project_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainProjectListAdapter.ViewHolder holder, int position) {
        final int select = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpIntentActivity(MainProjectFactory.createMainProject(CommonStrings.MAIN_LIST[select]));
            }
        });

        holder.item_title.setText(CommonStrings.MAIN_LIST[position]);
    }

    private void jumpIntentActivity(Class aClass) {
        if (aClass != null) {
            Intent intent = new Intent(mContext, aClass);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return CommonStrings.MAIN_LIST.length;
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
