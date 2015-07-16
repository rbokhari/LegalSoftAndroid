package app.legalsoft.ve.definition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.ClientModel;
import app.legalsoft.ve.model.SpecialistModel;
import app.legalsoft.ve.recycler.rvClientHolder;

/**
 * Created by Syed.Rahman on 15/07/2015.
 */
public class rvSpecialistAdapter extends RecyclerView.Adapter<rvSpecialistHolder> {

    private LayoutInflater layoutInflater;

    List<SpecialistModel> dataList = Collections.emptyList();

    public void setSpecialistList(List<SpecialistModel> list)
    {
        this.dataList = list;
        notifyItemRangeChanged(0, list.size());
    }

    public rvSpecialistAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public rvSpecialistHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.specialist_rv_row, parent, false);
        rvSpecialistHolder holder = new rvSpecialistHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(rvSpecialistHolder holder, int position) {
        holder.tCode.setText(dataList.get(position).getSpecializeCode());
        holder.tCodeEn.setText(dataList.get(position).getSpecializeCode_EN());
        holder.tArea.setText(dataList.get(position).getSpecializeArea());
        holder.tActive.setText(dataList.get(position).getIsActive() + "");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
