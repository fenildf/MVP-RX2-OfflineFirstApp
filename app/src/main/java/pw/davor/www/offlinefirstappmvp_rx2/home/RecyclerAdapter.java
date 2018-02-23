package pw.davor.www.offlinefirstappmvp_rx2.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pw.davor.www.offlinefirstappmvp_rx2.R;
import pw.davor.www.offlinefirstappmvp_rx2.data.dataModels.DatePojo;

/**
 * Created by bnc on 16.2.2018..
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.HomeViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<DatePojo> mList = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public ArrayList<DatePojo> getList() {
        return mList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.recycler_list_item, parent, false);
        return new HomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.mTime.setText(mList.get(position).getTime());
        holder.mDate.setText(mList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        try {
            return mList.size();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public void update(DatePojo datePojo) {
        if (!getList().contains(datePojo)) {
            getList().add(datePojo);
        }
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView mDate, mTime;

        HomeViewHolder(View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.home_recycler_date);
            mTime = itemView.findViewById(R.id.home_recycler_time);
        }
    }
}

