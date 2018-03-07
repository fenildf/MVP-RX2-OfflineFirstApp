package pw.davor.www.offlinefirstappmvp_rx2.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pw.davor.www.offlinefirstappmvp_rx2.R;
import pw.davor.www.offlinefirstappmvp_rx2.data.models.dataModels.DatePojoDataModel;

/**
 * Created by bnc on 16.2.2018..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.HomeViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<DatePojoDataModel> mList = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public ArrayList<DatePojoDataModel> getList() {
        return mList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.recycler_list_item, parent, false);
        return new HomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, int position) {
        holder.mTime.setText(mList.get(position).getDatePojo().getTime());
        holder.mDate.setText(mList.get(position).getDatePojo().getDate());

        if (mList.get(position).isFresh()) {
            holder.mNew.setVisibility(View.VISIBLE);
        }
        else{
            // due to recycling mechanism we need to reset visibility
            holder.mNew.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        try {
            return mList.size();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void update(DatePojoDataModel datePojo) {
        if (!getList().contains(datePojo)) {
            getList().add(datePojo);
        }
        // We are checking if new items are already in list. If no, new item is added to list.
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView mDate, mTime, mNew;

        HomeViewHolder(View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.home_recycler_date);
            mTime = itemView.findViewById(R.id.home_recycler_time);
            mNew = itemView.findViewById(R.id.home_recycler_fresh);
        }
    }
}

