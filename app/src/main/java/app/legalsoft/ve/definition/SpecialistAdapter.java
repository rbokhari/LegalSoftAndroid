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
import app.legalsoft.ve.model.SpecialistModel;

/**
 * Created by Syed.Rahman on 17/07/2015.
 */
public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.SpecialistHolder> {

    private LayoutInflater layoutInflater;

    List<SpecialistModel> dataList = Collections.emptyList();

    public SpecialistAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setSpecialistList(List<SpecialistModel> list)
    {
        this.dataList = list;
        notifyItemRangeChanged(0, list.size());
    }

    @Override
    public SpecialistHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.specialist_rv_row, parent, false);
        SpecialistHolder holder = new SpecialistHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SpecialistHolder holder, int position) {
        holder.tCode.setText(dataList.get(position).getSpecializeCode());
        holder.tCodeEn.setText(dataList.get(position).getSpecializeCode_EN());
        holder.tArea.setText(dataList.get(position).getSpecializeArea());
        holder.tActive.setText(dataList.get(position).getIsActive() + "");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SpecialistHolder extends RecyclerView.ViewHolder {

        public TextView tCode;
        public TextView tCodeEn;
        public TextView tArea;
        public TextView tActive;

        public SpecialistHolder(View itemView) {
            super(itemView);

            tCode = (TextView) itemView.findViewById(R.id.tSpecialistCode);
            tCodeEn = (TextView) itemView.findViewById(R.id.tSpecialistCodeEn);
            tArea = (TextView) itemView.findViewById(R.id.tSpecialistArea);
            tActive = (TextView) itemView.findViewById(R.id.tSpecialistActive);


        }
    }

}
