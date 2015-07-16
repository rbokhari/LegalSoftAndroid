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
import app.legalsoft.ve.model.SubCourtModel;

/**
 * Created by Syed.Rahman on 16/07/2015.
 */
public class SubCourtAdapter extends RecyclerView.Adapter<SubCourtAdapter.SubcourtHolder> {
    private LayoutInflater layoutInflater;


    List<SubCourtModel> dataList = Collections.emptyList();

    public SubCourtAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setSubCoutList(List<SubCourtModel> list)
    {
        this.dataList = list;
        notifyItemRangeChanged(0, list.size());
    }


    @Override
    public SubcourtHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.subcourt_rv_row, parent, false);
        SubcourtHolder holder = new SubcourtHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(SubcourtHolder holder, int position) {
        holder.tCode.setText(dataList.get(position).getSubCourtCode());
        holder.tCodeEn.setText(dataList.get(position).getSubCourtCode_EN());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class SubcourtHolder extends RecyclerView.ViewHolder {

        TextView tCode;
        TextView tCodeEn;

        public SubcourtHolder(View itemView) {
            super(itemView);

            tCode = (TextView) itemView.findViewById(R.id.tSubCourtCode);
            tCodeEn = (TextView) itemView.findViewById(R.id.tSubCourtCodeEn);

        }
    }


}
