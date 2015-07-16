package app.legalsoft.ve.definition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.MainCourtModel;
import app.legalsoft.ve.model.SpecialistModel;

/**
 * Created by Syed.Rahman on 15/07/2015.
 */
public class rvMainCourtAdapter extends RecyclerView.Adapter<rvMainCourtHolder> {

    private LayoutInflater layoutInflater;


    List<MainCourtModel> dataList = Collections.emptyList();

    public void setMainCoutList(List<MainCourtModel> list)
    {
        this.dataList = list;
        notifyItemRangeChanged(0, list.size());
    }

    public rvMainCourtAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public rvMainCourtHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.maincourt_rv_row, parent, false);
        rvMainCourtHolder holder = new rvMainCourtHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(rvMainCourtHolder holder, int position) {
        holder.tCode.setText(dataList.get(position).getMainCourtCode());
        holder.tCodeEn.setText(dataList.get(position).getMainCourtCode_EN());
        holder.tSpecialize.setText(dataList.get(position).getMainCourtSpecialist());
        holder.tActive.setText(dataList.get(position).getIsActive() + "");

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
