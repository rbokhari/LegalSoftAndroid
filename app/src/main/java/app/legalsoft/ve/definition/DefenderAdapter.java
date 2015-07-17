package app.legalsoft.ve.definition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import app.legalsoft.ve.R;
import app.legalsoft.ve.model.DefenderModel;
import app.legalsoft.ve.model.MainCourtModel;

/**
 * Created by Syed.Rahman on 17/07/2015.
 */
public class DefenderAdapter extends RecyclerView.Adapter<DefenderAdapter.DefenderHolder> {

    private LayoutInflater layoutInflater;

    List<DefenderModel> dataList = Collections.emptyList();

    public void setDefenderList(List<DefenderModel> list)
    {
        this.dataList = list;
        notifyItemRangeChanged(0, list.size());
    }

    public DefenderAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public DefenderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.defender_row, parent, false);
        DefenderHolder holder = new DefenderHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(DefenderHolder holder, int position) {
        holder.tCode.setText(dataList.get(position).getDefenderCode());
        holder.tName.setText(dataList.get(position).getDefenderName());
        holder.tNameEn.setText(dataList.get(position).getDefenderName_EN());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DefenderHolder extends RecyclerView.ViewHolder {

        TextView tCode;
        TextView tName;
        TextView tNameEn;

        public DefenderHolder(View itemView) {
            super(itemView);

            tCode = (TextView) itemView.findViewById(R.id.tDefenderCode);
            tName = (TextView) itemView.findViewById(R.id.tDefenderName);
            tNameEn = (TextView) itemView.findViewById(R.id.tDefenderNameEn);
        }
    }
}
